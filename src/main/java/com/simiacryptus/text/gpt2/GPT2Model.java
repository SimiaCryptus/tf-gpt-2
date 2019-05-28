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
import java.util.function.BiFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class GPT2Model implements LanguageCodeModel {
  protected static final Logger logger = LoggerFactory.getLogger(GPT2Model.class);

  public final String name;
  protected final byte[] graphDef;
  protected final ArrayList<Integer> code_history = new ArrayList<>();
  protected final GraphModifier graphModifier;
  protected final GPT2Codec codec;
  public HashSet<String> loadedSubnets;
  public Graph graph;
  public Session session;
  protected int history_size = 0;
  protected Tensor<Float> tensor_state = null;
  private BiFunction<String, String, Boolean> filterFn = (a, b) -> true;

  public GPT2Model(String name, GraphModifier graphModifier, File file, GPT2Codec codec) {
    this(name, loadModel(file), graphModifier, codec);
  }

  public GPT2Model(String name, byte[] graphDef, GraphModifier graphModifier, GPT2Codec codec) {
    this.name = name;
    this.graphDef = graphDef;
    this.graphModifier = graphModifier;
    this.codec = codec;
    graph = new Graph();
    session = new Session(graph);
    loadedSubnets = new HashSet<>();
  }

  public static byte[] loadModel(File file) {
    try {
      return FileUtils.readFileToByteArray(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public LanguageCodeModel copy() {
    GPT2Model copy = new GPT2Model(name, graphDef, graphModifier, this.codec);
    if (null == this.tensor_state) {
      copy.tensor_state = null;
    } else {
      FloatBuffer floatBuffer = FloatBuffer.allocate(this.tensor_state.numElements());
      this.tensor_state.writeTo(floatBuffer);
      floatBuffer.flip();
      copy.tensor_state = Tensor.create(this.tensor_state.shape(), floatBuffer);
    }
    copy.history_size = this.history_size;
    copy.session = this.session;
    copy.graph = this.graph;
    copy.loadedSubnets = this.loadedSubnets;
    copy.code_history.addAll(this.code_history);
    copy.filterFn = this.filterFn;
    return copy;
  }

  public float[] logitsToProbabilities(float[] logits) {
    String prefix = codec.decode(code_history.stream().toArray(i -> new Integer[i]));
    int[] sortedIndices = Arrays.stream(TextGenerator.sortedIndices(logits, Integer.MAX_VALUE))
        .filter(item -> {
          if (item == logits.length - 1) return true;
          String thisStr = codec.decode(item);
          return getFilterFn().apply(prefix, thisStr);
        })
        .toArray();
    double[] input = IntStream.range(0, sortedIndices.length).mapToDouble(c -> logits[sortedIndices[c]]).toArray();
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
    IntStream.range(0, chosen.length).forEach(c -> {
      logits[sortedIndices[c]] = (float) chosen[c];

    });
    return logits;
  }

  public Tensor<Float> accumulateState(Tensor<Float> outputState) {
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

  @Override
  public synchronized LanguageCodeModel resetState() {
    logger.debug("Reset Language Model State");
    if (null != this.tensor_state) this.tensor_state.close();
    this.tensor_state = null;
    history_size = 0;
    code_history.clear();
    return this;
  }

  @Override
  public synchronized float[] eval(int data_X) {
    logger.debug(String.format("Eval %d", data_X));
    try {
      String prefix;
      if (!loadedSubnets.contains("")) {
        loadedSubnets.add("");
        graph.importGraphDef(this.graphDef);
      }
      if (null == this.tensor_state) {
        prefix = "init/";
        if (!loadedSubnets.contains(prefix)) {
          GraphModifier.importGraphDef(graph, this.graphModifier.edit(GraphDef.parseFrom(this.graphDef), prefix, false));
          loadedSubnets.add(prefix);
        }
      } else {
        prefix = "";
      }
      this.code_history.add(data_X);
      final float[] eval;
      if (0 == history_size) {
        eval = eval(prefix, data_X);
      } else {
        final int[] activeCodes = this.code_history
            .subList(this.code_history.size() - 1, this.code_history.size())
            .stream().mapToInt(x -> x).toArray();
        eval = eval(prefix, activeCodes);
      }
      return eval;
    } catch (InvalidProtocolBufferException e) {
      throw new RuntimeException(e);
    }
  }

  public float[] eval(String prefix, int... data_X) {
    logger.debug(String.format("Eval(%s,%s)", session, Arrays.toString(data_X)));
    Tensor<Integer> input_X = Tensor.create(new long[]{1, data_X.length}, IntBuffer.wrap(data_X));
    Session.Runner runner = session.runner().feed("input_X", input_X);
    if (null != this.tensor_state) runner = runner.feed(prefix + "input_past", this.tensor_state);
    logger.debug("Input Codes: " + Arrays.toString(data_X));
    logger.debug("Input State: " + (this.tensor_state == null ? "null" : Arrays.toString(this.tensor_state.shape())));
    final Tensor<Float> prevState = this.tensor_state;
    runner = runner
        .fetch(prefix + "output/strided_slice_1")
        .fetch((0 == history_size) ? (prefix + "model/stack") : (prefix + "output/concat"));
    List<Tensor<?>> run = runner.run();
    Tensor<Float> tensor_next = run.get(0).expect(Float.class);
    final Tensor<Float> outputState = run.get(1).expect(Float.class); // reshape(shape_state, run.get(1).expect(Float.class));
    logger.debug("Output Logits: " + Arrays.toString(tensor_next.shape()));
    logger.debug("Output State: " + Arrays.toString(outputState.shape()));
    accumulateState(outputState);
    float[] logits = new float[tensor_next.numElements()];
    tensor_next.writeTo(FloatBuffer.wrap(logits));
    if (null != prevState) prevState.close();
    input_X.close();
    return logitsToProbabilities(logits);
  }

  @Override
  public BiFunction<String, String, Boolean> getFilterFn() {
    return filterFn;
  }

  @Override
  public LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn) {
    this.filterFn = filterFn;
    return this;
  }

}
