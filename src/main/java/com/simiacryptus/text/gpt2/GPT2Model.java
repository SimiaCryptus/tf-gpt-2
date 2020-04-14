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
import com.simiacryptus.ref.wrappers.RefString;
import com.simiacryptus.text.GraphModifier;
import com.simiacryptus.text.LanguageCodeModel;
import com.simiacryptus.text.TextGenerator;
import com.simiacryptus.util.Util;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.framework.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * The type Gpt 2 model.
 */
public class GPT2Model implements LanguageCodeModel {
  /**
   * The constant logger.
   */
  protected static final Logger logger = LoggerFactory.getLogger(GPT2Model.class);

  /**
   * The Name.
   */
  public final String name;
  /**
   * The Graph def.
   */
  protected final byte[] graphDef;
  /**
   * The Code history.
   */
  protected final ArrayList<Integer> code_history = new ArrayList<>();
  /**
   * The Graph modifier.
   */
  protected final GraphModifier graphModifier;
  /**
   * The Codec.
   */
  protected final GPT2Codec codec;
  /**
   * The Loaded subnets.
   */
  public HashSet<String> loadedSubnets;
  /**
   * The Graph.
   */
  public Graph graph;
  /**
   * The Session.
   */
  public Session session;
  /**
   * The History size.
   */
  protected int history_size = 0;
  /**
   * The Tensor state.
   */
  @Nullable
  protected Tensor<Float> tensor_state = null;
  private BiFunction<String, String, Boolean> filterFn = (a, b) -> true;

  /**
   * Instantiates a new Gpt 2 model.
   *
   * @param name          the name
   * @param graphModifier the graph modifier
   * @param file          the file
   * @param codec         the codec
   */
  public GPT2Model(String name, GraphModifier graphModifier, @Nonnull File file, GPT2Codec codec) {
    this(name, loadModel(file), graphModifier, codec);
  }

  /**
   * Instantiates a new Gpt 2 model.
   *
   * @param name          the name
   * @param graphDef      the graph def
   * @param graphModifier the graph modifier
   * @param codec         the codec
   */
  public GPT2Model(String name, byte[] graphDef, GraphModifier graphModifier, GPT2Codec codec) {
    this(name, graphDef, graphModifier, codec, new Graph());
  }

  /**
   * Instantiates a new Gpt 2 model.
   *
   * @param name          the name
   * @param graphDef      the graph def
   * @param graphModifier the graph modifier
   * @param codec         the codec
   * @param graph         the graph
   */
  public GPT2Model(String name, byte[] graphDef, GraphModifier graphModifier, GPT2Codec codec, @Nonnull Graph graph) {
    this(name, graphDef, graphModifier, codec, graph, new Session(graph, ConfigProto.newBuilder()
        //.setLogDevicePlacement(true)
//        .setUsePerSessionThreads(true)
//        .setInterOpParallelismThreads(8)
//        .setIntraOpParallelismThreads(8)
//        .setIsolateSessionState(false)
        .setGraphOptions(GraphOptions.newBuilder()
            .setOptimizerOptions(OptimizerOptions.newBuilder()
                .setDoConstantFolding(true)
                .setDoFunctionInlining(true)
                .setDoCommonSubexpressionElimination(true)
                .build())
            .build())
        .setGpuOptions(GPUOptions.newBuilder()
            .setForceGpuCompatible(true)
            .setAllowGrowth(true)
            .setPerProcessGpuMemoryFraction(0.5)
            .build())
        .build().toByteArray()));
  }

  /**
   * Instantiates a new Gpt 2 model.
   *
   * @param name          the name
   * @param graphDef      the graph def
   * @param graphModifier the graph modifier
   * @param codec         the codec
   * @param graph         the graph
   * @param session       the session
   */
  public GPT2Model(String name, byte[] graphDef, GraphModifier graphModifier, GPT2Codec codec, Graph graph, Session session) {
    this.name = name;
    this.graphDef = graphDef;
    this.graphModifier = graphModifier;
    this.codec = codec;
    this.graph = graph;
    this.session = session;
    loadedSubnets = new HashSet<>();
  }

  @Override
  public BiFunction<String, String, Boolean> getFilterFn() {
    return filterFn;
  }

  /**
   * Load model byte [ ].
   *
   * @param file the file
   * @return the byte [ ]
   */
  public static byte[] loadModel(@Nonnull File file) {
    try {
      return FileUtils.readFileToByteArray(file);
    } catch (IOException e) {
      throw Util.throwException(e);
    }
  }

  /**
   * Copy tensor.
   *
   * @param toCopy the to copy
   * @return the tensor
   */
  @Nonnull
  public static Tensor<Float> copy(@Nonnull Tensor<Float> toCopy) {
    FloatBuffer floatBuffer = FloatBuffer.allocate(toCopy.numElements());
    toCopy.writeTo(floatBuffer);
    floatBuffer.flip();
    return Tensor.create(toCopy.shape(), floatBuffer);
  }

  @Nonnull
  @Override
  public LanguageCodeModel copy() {
    GPT2Model copy = new GPT2Model(name, graphDef, graphModifier, this.codec, this.graph, this.session);
    if (null == this.tensor_state) {
      copy.tensor_state = null;
    } else {
      copy.tensor_state = copy(this.tensor_state);
    }
    copy.history_size = this.history_size;
    copy.loadedSubnets = this.loadedSubnets;
    copy.code_history.addAll(this.code_history);
    copy.filterFn = this.filterFn;
    return copy;
  }

  /**
   * Logits to probabilities float [ ].
   *
   * @param logits the logits
   * @return the float [ ]
   */
  @Nonnull
  public float[] logitsToProbabilities(@Nonnull float[] logits) {
    String prefix = codec.decode(code_history.stream().toArray(i -> new Integer[i]));
    int[] sortedIndices = Arrays.stream(TextGenerator.sortedIndices(logits, Integer.MAX_VALUE))
        .filter(item -> {
          if (item == logits.length - 1) return true;
          String thisStr = codec.decode(item);
          assert getFilterFn() != null;
          return getFilterFn().apply(prefix, thisStr);
        })
        .toArray();
    double[] input = IntStream.range(0, sortedIndices.length).mapToDouble(c -> logits[sortedIndices[c]]).toArray();
    assert 1 < input.length : "input.length() = " + input.length;

    final DoubleSummaryStatistics summaryStatistics = DoubleStream.of(input).filter(x -> Double.isFinite(x)).summaryStatistics();
    final double max = summaryStatistics.getMax();
    @Nullable final double[] exp = Arrays.stream(input).map(x -> {
      double xx = Math.exp(x - max);
      return Double.isFinite(xx) ? xx : 0;
    }).toArray();
    final double sum = 0 < Arrays.stream(exp).sum() ? Arrays.stream(exp).sum() : 1;
    assert Double.isFinite(sum);
    @Nullable double[] chosen = Arrays.stream(exp).map(x -> x / sum).toArray();

    for (int i = 0; i < logits.length; i++) logits[i] = 0;
    assert chosen != null;
    IntStream.range(0, chosen.length).forEach(c -> {
      logits[sortedIndices[c]] = (float) chosen[c];
    });
    return logits;
  }

  @Nonnull
  @Override
  public synchronized LanguageCodeModel clear() {
    logger.debug("Reset Language Model State");
    if (null != this.tensor_state) this.tensor_state.close();
    this.tensor_state = null;
    history_size = 0;
    code_history.clear();
    return this;
  }

  @Nonnull
  @Override
  public synchronized float[] eval(int data_X) {
    logger.debug(RefString.format("Eval %d", data_X));
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
      throw Util.throwException(e);
    }
  }

  /**
   * Eval float [ ].
   *
   * @param prefix the prefix
   * @param data_X the data x
   * @return the float [ ]
   */
  @Nonnull
  public synchronized float[] eval(String prefix, @Nonnull int... data_X) {
    synchronized (session) {
      logger.debug(RefString.format("Eval(%s,%s)", session, Arrays.toString(data_X)));
      Tensor<Integer> input_X = Tensor.create(new long[]{1, data_X.length}, IntBuffer.wrap(data_X));
      Session.Runner runner = session.runner().feed("input_X", input_X);
      if (null != this.tensor_state) runner = runner.feed(prefix + "input_past", this.tensor_state);
      logger.debug("Input Codes: " + Arrays.toString(data_X));
      logger.debug("Input State: " + (this.tensor_state == null ? "null" : Arrays.toString(this.tensor_state.shape())));
      final Tensor<Float> prevState = this.tensor_state;
      runner = runner
          .fetch(prefix + "output/strided_slice_1")
          .fetch(0 == history_size ? prefix + "model/stack" : prefix + "output/concat");
      List<Tensor<?>> run = runner.run();
      Tensor<Float> tensor_next = run.get(0).expect(Float.class);
      final Tensor<Float> outputState = run.get(1).expect(Float.class); // reshape(shape_state, run.get(1).expect(Float.class));
      logger.debug("Output Logits: " + Arrays.toString(tensor_next.shape()));
      logger.debug("Output State: " + Arrays.toString(outputState.shape()));
      if (null == this.tensor_state) {
        this.history_size = (int) outputState.shape()[4];
        this.tensor_state = outputState;
      } else {
        this.history_size = this.history_size + 1;
        this.tensor_state.close();
        this.tensor_state = outputState;
      }
      float[] logits = new float[tensor_next.numElements()];
      tensor_next.writeTo(FloatBuffer.wrap(logits));
      tensor_next.close();
      if (null != prevState) prevState.close();
      input_X.close();
      return logitsToProbabilities(logits);
    }
  }

  @Nonnull
  @Override
  public LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn) {
    this.filterFn = filterFn;
    return this;
  }

  @Nullable
  @Override
  public Tensor<?> state() {
    return this.tensor_state;
  }

}
