/*
 * Copyright (c) 2019 by Andrew Charneski.
 *
 * The author licenses this file to you under the
 * Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance
 * with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.simiacryptus.text.gpt2;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.framework.GraphDef;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class GPT2Model {
  protected static final Logger logger = LoggerFactory.getLogger(GPT2Model.class);

  public final String name;
  protected final byte[] graphDef;
  protected int history_size = 0;
  protected final ArrayList<Integer> code_history = new ArrayList<>();
  protected int topN = 50;
  protected Tensor<Float> tensor_state = null;
  protected double temperature = 1.0;
  protected final GraphModifier graphModifier;

  public GPT2Model(String name, GraphModifier graphModifier, File file) {
    this(name, loadModel(file), graphModifier);
  }

  public GPT2Model(String name, byte[] graphDef, GraphModifier graphModifier) {
    this.name = name;
    this.graphDef = graphDef;
    this.graphModifier = graphModifier;
  }

  public Tensor<Float> accumulateState(GPT2Model.TFContext context, Tensor<Float> outputState) {
    final int dim = 4;
    long[] outputShape = outputState.shape();
    if (null == this.tensor_state) {
      this.history_size = (int) outputShape[dim];
      this.tensor_state = outputState;
    } else {
      this.history_size = this.history_size + 1;
      this.tensor_state = outputState;
    }
    return this.tensor_state;
  }

  public synchronized GPT2Model resetState() {
    logger.debug("Reset Language Model State");
    this.tensor_state = null;
    history_size = 0;
    code_history.clear();
    return this;
  }

  public static byte[] loadModel(File file) {
    try {
      return FileUtils.readFileToByteArray(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public synchronized float[] eval(int data_X) {
    logger.debug(String.format("Eval %d", data_X));
    try {
      SessionAspect sessionAspect = getSession();
      this.code_history.add(data_X);
      final float[] eval;
      if (0 == history_size) {
        eval = eval(sessionAspect, data_X);
      } else {
        final int[] activeCodes = this.code_history
            .subList(this.code_history.size() - 1, this.code_history.size())
            .stream().mapToInt(x -> x).toArray();
        eval = eval(sessionAspect, activeCodes);
      }
      return eval;
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(e);
    }
  }

  public float[] eval(SessionAspect aspect, int... data_X) {
    logger.debug(String.format("Eval(%s,%s)", aspect.context.session, Arrays.toString(data_X)));
    Tensor<Integer> input_X = Tensor.create(new long[]{1, data_X.length}, IntBuffer.wrap(data_X));
    Session.Runner runner = aspect.context.session.runner().feed("input_X", input_X);
    if (null != this.tensor_state) runner = runner.feed(aspect.prefix + "input_past", this.tensor_state);
    logger.debug("Input Codes: " + Arrays.toString(data_X));
    logger.debug("Input State: " + (this.tensor_state == null ? "null" : Arrays.toString(this.tensor_state.shape())));
    final Tensor<Float> prevState = this.tensor_state;
    runner = runner
        .fetch(aspect.prefix + "output/strided_slice_1")
        .fetch((0 == history_size) ? (aspect.prefix + "model/stack") : (aspect.prefix + "output/concat"));
    List<Tensor<?>> run = runner.run();
    Tensor<Float> tensor_next = run.get(0).expect(Float.class);
    final Tensor<Float> outputState = run.get(1).expect(Float.class); // reshape(shape_state, run.get(1).expect(Float.class));
    logger.debug("Output Logits: " + Arrays.toString(tensor_next.shape()));
    logger.debug("Output State: " + Arrays.toString(outputState.shape()));
    accumulateState(aspect.context, outputState);
    float[] logits = new float[tensor_next.numElements()];
    tensor_next.writeTo(FloatBuffer.wrap(logits));
    for (int i = 0; i < logits.length; i++) logits[i] *= 1.0 / getTemperature();
    if (null != prevState) prevState.close();
    input_X.close();
    return asProbabilities(logits, getTopN());
  }

  public static float[] asProbabilities(float[] logits, int topN) {
    int[] sortedIndices = TextGenerator.sortedIndices(logits, topN);

    double[] input = IntStream.range(0, Math.min(topN, logits.length)).mapToDouble(c -> logits[sortedIndices[c]]).toArray();
    assert 1 < input.length : "input.length() = " + input.length;

    @Nullable final double[] exp;
    final DoubleSummaryStatistics summaryStatistics = DoubleStream.of(input).filter(x -> Double.isFinite(x)).summaryStatistics();
    final double max = summaryStatistics.getMax();
    exp = Arrays.stream(input).map(x -> {
      double xx = Math.exp(x - max);
      return Double.isFinite(xx) ? xx : 0;
    }).toArray();
    final double sum = 0 < Arrays.stream(exp).sum() ? Arrays.stream(exp).sum() : 1;
    assert Double.isFinite(sum);
    @Nullable double[] chosen = Arrays.stream(exp).map(x -> x / sum).toArray();

    for (int i = 0; i < logits.length; i++) logits[i] = 0;
    IntStream.range(0,chosen.length).forEach(c->{
      logits[sortedIndices[c]] = (float) chosen[c];

    });
    return logits;
  }

  public double getTemperature() {
    return temperature;
  }

  public GPT2Model setTemperature(double temperature) {
    this.temperature = temperature;
    return this;
  }

  public int getTopN() {
    return topN;
  }

  public GPT2Model setTopN(int topN) {
    this.topN = topN;
    return this;
  }

  protected static class TFContext {
    public final Session session;
    public final Graph graph;
    public final HashSet<String> loadedSubnets;

    protected TFContext() {
      graph = new Graph();
      session = new Session(graph);
      loadedSubnets = new HashSet<>();
    }
  }

  protected static class SessionAspect {
    public final String prefix;
    public final TFContext context;

    protected SessionAspect(TFContext session, String prefix) {
      this.context = session;
      this.prefix = prefix;
    }

  }

  protected TFContext TFContext = null;

  public SessionAspect getSession() throws InvalidProtocolBufferException {
    String prefix;
    if (null == TFContext) {
      TFContext = new TFContext();
    }
    if (!TFContext.loadedSubnets.contains("")) {
      TFContext.loadedSubnets.add("");
      TFContext.graph.importGraphDef(this.graphDef);
    }
    if (null == this.tensor_state) {
      prefix = "init/";
      if (!TFContext.loadedSubnets.contains(prefix)) {
        GraphModifier.importGraphDef(TFContext.graph, this.graphModifier.edit(GraphDef.parseFrom(this.graphDef), prefix, false));
        TFContext.loadedSubnets.add(prefix);
      }
    } else {
      prefix = "";
    }
    return new SessionAspect(TFContext, prefix);
  }
}
