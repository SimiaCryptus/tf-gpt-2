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

package com.simiacryptus.text;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.simiacryptus.text.gpt2.GPT2Codec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tensorflow.*;
import org.tensorflow.framework.GraphDef;
import org.tensorflow.framework.NodeDef;
import org.tensorflow.framework.TensorProto;
import org.tensorflow.framework.TensorShapeProto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.tensorflow.framework.DataType.DT_INT32;

/**
 * The type Graph modifier.
 */
public abstract class GraphModifier {
  /**
   * The constant logger.
   */
  protected static final Logger logger = LoggerFactory.getLogger(GPT2Codec.class);

  /**
   * Gets deletes init.
   *
   * @return the deletes init
   */
  @Nonnull
  public abstract HashSet<String> getDeletes_Init();

  /**
   * Import graph def.
   *
   * @param graph    the graph
   * @param graphdef the graphdef
   */
  public static void importGraphDef(@Nonnull Graph graph, @Nonnull GraphDef graphdef) {
    final HashSet<Object> opsPresent = new HashSet<>();
    graph.operations().forEachRemaining(op -> {
      opsPresent.add(op.name());
    });
    while (true) {
      final List<NodeDef> nextToAdd = graphdef.getNodeList().stream()
          .filter(nodeDef -> !opsPresent.contains(nodeDef.getName()))
          .filter(nodeDef -> {
            final ProtocolStringList inputList = nodeDef.getInputList();
            return inputList.isEmpty() || inputList.stream().allMatch(input -> opsPresent.contains(input.split(":")[0]));
          })
          .collect(Collectors.toList());
      if (nextToAdd.isEmpty()) break;
      nextToAdd.forEach(nodeDef -> {
        opsPresent.add(nodeDef.getName());
        if (graph.operation(nodeDef.getName()) == null) {
          try {
            logger.debug("Adding node to graph: " + nodeDef.getName() + " <= [" + nodeDef.getInputList().stream().reduce((a, b) -> a + "," + b).orElse("") + "]");
            // Add new node
            final OperationBuilder operationBuilder = graph.opBuilder(nodeDef.getOp(), nodeDef.getName());
            operationBuilder.setDevice(nodeDef.getDevice());
            nodeDef.getAttrMap().forEach((k, v) -> {
              switch (v.getValueCase()) {
                case TENSOR: {
                  final TensorProto tensorProto = v.getTensor();
                  final long[] shape = tensorProto.getTensorShape().getDimList().stream().mapToLong(x -> x.getSize()).toArray();
                  final Class<?> type;
                  switch (tensorProto.getDtype()) {
                    case DT_FLOAT:
                      type = Float.class;
                      break;
                    case DT_INT32:
                      type = Integer.class;
                      break;
                    default:
                      throw new RuntimeException(tensorProto.getDtype().toString());
                  }
                  if (null != tensorProto.getTensorContent() && !tensorProto.getTensorContent().isEmpty()) {
                    operationBuilder.setAttr(k, Tensor.create(type, shape, tensorProto.getTensorContent().asReadOnlyByteBuffer()));
                  } else if (0 < tensorProto.getIntValCount()) {
                    operationBuilder.setAttr(k, Tensor.create(shape, IntBuffer.wrap(tensorProto.getIntValList().stream().mapToInt(x -> x).toArray())));
                  } else {
                    throw new RuntimeException(tensorProto.toString());
                  }
                  break;
                }
                case SHAPE:
                  final TensorShapeProto shapeProto = v.getShape();
                  final long[] shape = shapeProto.getDimList().stream().mapToLong(x -> x.getSize()).toArray();
                  operationBuilder.setAttr(k, Shape.make(shape[0], Arrays.copyOfRange(shape, 1, shape.length)));
                  break;
                case TYPE:
                  operationBuilder.setAttr(k, DataType.valueOf(v.getType().name().split("_")[1]));
                  break;
                case I:
                  operationBuilder.setAttr(k, v.getI());
                  break;
                case B:
                  operationBuilder.setAttr(k, v.getB());
                  break;
                default:
                  throw new RuntimeException(k + " = " + v.toString());
              }
            });
            final Output[] inputs = nodeDef.getInputList().stream().map(input -> {
              final String[] split = input.split(":");
              final int idx = 1 == split.length ? 0 : Integer.parseInt(split[1]);
              return graph.operation(split[0]).output(idx);
            }).toArray(i -> new Output[i]);
            if (nodeDef.getOp().equals("Pack")) {
              operationBuilder.addInputList(inputs);
            } else if (nodeDef.getOp().equals("ConcatV2")) {
              operationBuilder.addInputList(new Output[]{inputs[0], inputs[1]});
              operationBuilder.addInput(inputs[2]);
              operationBuilder.addControlInput(inputs[2].op());
            } else if (nodeDef.getOp().equals("StridedSlice")) {
              for (int i = 0; i < inputs.length; i++) {
                if (i == 0) {
                  operationBuilder.addInput(inputs[i]);
                } else {
                  operationBuilder.addInput(inputs[i]);
                  operationBuilder.addControlInput(inputs[i].op());
                }
              }
            } else if (inputs.length > 1) {
              for (int i = 0; i < inputs.length; i++) {
                operationBuilder.addInput(inputs[i]);
              }
            } else if (inputs.length > 0) {
              operationBuilder.addInput(inputs[0]);
            }
            try {
              operationBuilder.build();
            } catch (Throwable e) {
              throw new RuntimeException("Error processing " + nodeDef.toString(), e);
            }
          } catch (RuntimeException e) {
            throw e;
          } catch (Throwable e) {
            throw new RuntimeException("Error processing " + nodeDef.toString(), e);
          }
        }
      });
    }
    graphdef.getNodeList().stream()
        .filter(nodeDef -> !opsPresent.contains(nodeDef.getName()))
        .forEach(nodeDef -> {
          logger.warn("Remaining Node: " + nodeDef.toString());
        });
  }

  /**
   * Edit byte buffer.
   *
   * @param srcBuffer the src buffer
   * @param fn        the fn
   * @return the byte buffer
   */
  @Nonnull
  public static ByteBuffer edit(@Nonnull ByteBuffer srcBuffer, @Nonnull Consumer<IntBuffer> fn) {
    final ByteBuffer dstBuffer = copy(srcBuffer);
    final IntBuffer intBuffer = dstBuffer.asIntBuffer();
    fn.accept(intBuffer);
    return dstBuffer;
  }

  /**
   * Copy byte buffer.
   *
   * @param srcBuffer the src buffer
   * @return the byte buffer
   */
  @Nonnull
  public static ByteBuffer copy(@Nonnull ByteBuffer srcBuffer) {
    final ByteBuffer byteBuffer = ByteBuffer.allocate(srcBuffer.capacity());
    byteBuffer.put(srcBuffer);
    byteBuffer.clear();
    return byteBuffer;
  }

  /**
   * Tensor 1 tensor proto.
   *
   * @param shape the shape
   * @param vals  the vals
   * @return the tensor proto
   */
  @Nonnull
  public static TensorProto tensor1(int[] shape, @Nonnull int... vals) {
    TensorProto.Builder builder = TensorProto.newBuilder().setTensorShape(shape(shape)).setDtype(DT_INT32);
    Arrays.stream(vals).forEach(x -> builder.addIntVal(x));
    return builder.build();
  }

  /**
   * Tensor 2 tensor proto.
   *
   * @param shape the shape
   * @param vals  the vals
   * @return the tensor proto
   */
  @Nonnull
  public static TensorProto tensor2(int[] shape, @Nonnull int... vals) {
    TensorProto.Builder builder = TensorProto.newBuilder().setTensorShape(shape(shape));
    byte[] array = new byte[vals.length * 4];
    IntBuffer buffer = ByteBuffer.wrap(array).asIntBuffer();
    for (int val : vals) buffer.put(Integer.reverseBytes(val));
    builder.setTensorContent(ByteString.copyFrom(array)).setDtype(DT_INT32);
    return builder.build();
  }

  /**
   * Shape tensor shape proto.
   *
   * @param dims the dims
   * @return the tensor shape proto
   */
  @Nonnull
  public static TensorShapeProto shape(@Nonnull int... dims) {
    TensorShapeProto.Builder builder = TensorShapeProto.newBuilder();
    Arrays.stream(dims).mapToObj(v -> TensorShapeProto.Dim.newBuilder().setSize(v).build()).forEach(value -> builder.addDim(value));
    return builder.build();
  }

  /**
   * Edit graph def.
   *
   * @param src             the src
   * @param prefix          the prefix
   * @param includeOriginal the include original
   * @return the graph def
   * @throws InvalidProtocolBufferException the invalid protocol buffer exception
   */
  @Nonnull
  public GraphDef edit(@Nonnull GraphDef src, String prefix, boolean includeOriginal) throws InvalidProtocolBufferException {
    final GraphDef srcGraphDef = GraphDef.parseFrom(src.toByteArray());
    final GraphDef.Builder destGraphDef = GraphDef.newBuilder();
    final HashSet<String> deletes = getDeletes_Init();
    final HashSet<String> editedNodes = new HashSet<>();
    for (int index = 0; index < srcGraphDef.getNodeCount(); index++) {
      final NodeDef node = srcGraphDef.getNode(index);
      if (deletes.contains(node.getName())) {
        logger.debug("Omit Node: " + node.getName());
      } else {
        @Nullable NodeDef.Builder nodeBuilder = edit(node.toBuilder());
        if (null != nodeBuilder) {
          logger.debug("Edit Node: " + node.getName());
          destGraphDef.addNode(nodeBuilder.build());
          editedNodes.add(node.getName());
        } else {
          //        logger.debug("Pass-thru Node: " + node.getName());
          destGraphDef.addNode(node);
        }
      }
    }
    addNodes(nodeDef -> {
      destGraphDef.addNode(nodeDef);
      editedNodes.add(nodeDef.getName());
    });
//    return destGraphDef.build();
    return prefixRewrite(destGraphDef.build(), editedNodes, prefix, includeOriginal);
  }

  /**
   * Edit node def . builder.
   *
   * @param node the node
   * @return the node def . builder
   */
  @Nullable
  public abstract NodeDef.Builder edit(NodeDef.Builder node);

  /**
   * Add nodes.
   *
   * @param add the add
   */
  protected abstract void addNodes(Consumer<NodeDef> add);

  /**
   * Prefix rewrite graph def.
   *
   * @param graphDef        the graph def
   * @param editedNodes     the edited nodes
   * @param prefix          the prefix
   * @param includeOriginal the include original
   * @return the graph def
   */
  @Nonnull
  protected GraphDef prefixRewrite(@Nonnull GraphDef graphDef, @Nonnull HashSet<String> editedNodes, String prefix, boolean includeOriginal) {
    while (true) {
      final List<String> newItems = graphDef.getNodeList().stream()
          .filter(nodeDef -> !editedNodes.contains(nodeDef.getName()))
          .filter(nodeDef -> nodeDef.getInputList().stream().filter(input -> editedNodes.contains(input.split(":")[0])).findAny().isPresent())
          .map(x -> x.getName()).collect(Collectors.toList());
      if (newItems.isEmpty()) break;
      for (String newItem : newItems) {
        logger.debug("Item touched by rename: " + newItem);
      }
      editedNodes.addAll(newItems);
    }
    final GraphDef.Builder destGraphDef = GraphDef.newBuilder();
    for (NodeDef nodeDef : graphDef.getNodeList()) {
      NodeDef.Builder builder;
      if (editedNodes.contains(nodeDef.getName())) {
        builder = nodeDef.toBuilder();
        builder.setName(prefix + nodeDef.getName());
      } else {
        builder = null;
      }
      final ArrayList<String> inputs = new ArrayList<>(nodeDef.getInputList());
      if (inputs.stream().filter(o -> editedNodes.contains(o.split(":")[0])).findAny().isPresent()) {
        if (null == builder) builder = nodeDef.toBuilder();
        builder.clearInput();
        for (String input : inputs) {
          if (editedNodes.contains(input.split(":")[0])) {
            logger.debug(nodeDef.getName() + " [ " + input + " ] += " + prefix);
            builder.addInput(prefix + input);
          } else {
            builder.addInput(input);
          }
        }
      }
      if (null != builder) {
        logger.debug("Edit in renaming: " + builder.getName());
        destGraphDef.addNode(builder.build());
      } else {
        if (includeOriginal) destGraphDef.addNode(nodeDef);
      }
    }
    return destGraphDef.build();
  }
}
