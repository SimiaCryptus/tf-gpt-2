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

import com.simiacryptus.ref.wrappers.RefString;
import com.simiacryptus.tensorflow.GraphModel;
import org.jetbrains.annotations.NotNull;
import org.tensorflow.framework.AttrValue;
import org.tensorflow.framework.NodeDef;
import org.tensorflow.framework.TensorProto;
import org.tensorflow.framework.TensorShapeProto;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class GraphComparer implements Consumer<GraphModel.DeltaRecord> {
  public final ArrayList<String> nodeDeletes = new ArrayList<String>();
  public final ArrayList<String> newNodes = new ArrayList<String>();
  public final Map<String, ArrayList<String>> nodeEdits = new HashMap<>();

  public static String toString(AttrValue value) {
    switch (value.getValueCase()) {
      case I:
        return RefString.format("AttrValue.newBuilder().setI(%s).build()", value.getI());
      case F:
        return RefString.format("AttrValue.newBuilder().setF(%s).build()", value.getF());
      case B:
        return RefString.format("AttrValue.newBuilder().setB(%s).build()", value.getB());
      case S:
        return RefString.format("AttrValue.newBuilder().setS(%s).build()", value.getS().toStringUtf8());
      case TYPE:
        return RefString.format("AttrValue.newBuilder().setType(DataType.forNumber(%s)).build()", value.getType().getNumber());
      case SHAPE: {
        return RefString.format("AttrValue.newBuilder().setShape(shape(%s)).build()", toString(dims(value.getShape())));
      }
      case TENSOR: {
        TensorProto tensor = value.getTensor();
        TensorShapeProto shape = tensor.getTensorShape();
        switch (tensor.getDtype()) {
          case DT_INT32: {
            String shapeElements = shape.getDimList().stream().map(x -> Long.toString(x.getSize())).reduce((a, b) -> a + ", " + b).orElse("");
            return tensor.getIntValList().stream().map(x -> Integer.toString(x)).reduce((a, b) -> a + ", " + b).map(elements -> {
              return RefString.format("AttrValue.newBuilder().setTensor(tensor1(new int[]{ %s }, new int[] { %s })).build()", shapeElements, elements);
            }).orElseGet(() -> {
              IntBuffer intBuffer = tensor.getTensorContent().asReadOnlyByteBuffer().asIntBuffer();
              int[] dst = new int[intBuffer.remaining()];
              intBuffer.get(dst);
              String elements = Arrays.stream(dst).map(Integer::reverseBytes).mapToObj(Integer::toString).reduce((a, b) -> a + ", " + b).orElse("");
              return RefString.format("AttrValue.newBuilder().setTensor(tensor2(new int[]{ %s }, new int[] { %s })).build()", shapeElements, elements);
            });
          }
          case DT_FLOAT: {
            String shapeElements = shape.getDimList().stream().map(x -> Long.toString(x.getSize())).reduce((a, b) -> a + ", " + b).orElse("");
            return tensor.getFloatValList().stream().map(x -> Float.toString(x)).reduce((a, b) -> a + ", " + b).map(elements -> {
              return RefString.format("AttrValue.newBuilder().setTensor(tensor1(new int[]{ %s }, new int[] { %s })).build()", shapeElements, elements);
            }).orElseGet(() -> {
              FloatBuffer intBuffer = tensor.getTensorContent().asReadOnlyByteBuffer().asFloatBuffer();
              float[] dst = new float[intBuffer.remaining()];
              intBuffer.get(dst);
              String elements = IntStream.range(0, dst.length).mapToDouble(i -> dst[i]).mapToObj(Double::toString).reduce((a, b) -> a + ", " + b).orElse("");
              return RefString.format("AttrValue.newBuilder().setTensor(tensor2(new int[]{ %s }, new float[]{ %s })).build()", shapeElements, elements);
            });
          }
        }
      }
      default:
        return "/* " + value.getType() + " - " + value.toString().trim() + " */";
    }
  }

  @NotNull
  public static String toString(long[] dims) {
    return Arrays.stream(dims).mapToObj(size -> Long.toString(size)).reduce((a, b) -> a + ", " + b).orElse("");
  }

  public static long[] dims(TensorShapeProto shape) {
    return shape.getDimList().stream().mapToLong(TensorShapeProto.Dim::getSize).toArray();
  }

  public void compare(GraphModel left, GraphModel right) {
    left.compare(right).values().stream().forEach(this);
    System.out.println("\n" +
        "  @Override\n" +
        "  public HashSet<String> getDeletes_Init() {\n" +
        "    final HashSet<String> toDelete = new HashSet<>();\n" +
        "\n" + this.nodeDeletes.stream().map(String::trim).reduce((a, b) -> a + "\n" + b).orElse("") +
        "    return toDelete;\n" +
        "  }\n" +
        "\n" +
        "  protected void addNodes(Consumer<NodeDef> add) {\n" +
        "\n" + this.newNodes.stream().map(String::trim).reduce((a, b) -> a + "\n" + b).orElse("") +
        "  }\n" +
        "\n" +
        "  @Override\n" +
        "  public NodeDef.Builder edit(NodeDef.Builder node) {\n" +
        "\n" + nodeEdits.entrySet().stream().sorted(Comparator.comparing(x -> x.getKey())).map(e ->
        RefString.format("if(node.getName().equals(\"%s\")) {\n%s\n}", e.getKey(),
            e.getValue().stream().map(x -> "\t" + x).reduce((a, b) -> a + "\n" + b).orElse("")
        )).map(String::trim).reduce((a, b) -> a + "\nelse " + b).orElse("") +
        "     else {\n" +
        "      return null;\n" +
        "    }\n" +
        "    return node;\n" +
        "  }\n");
  }

  @Override
  public void accept(GraphModel.DeltaRecord delta) {
    if (delta.left == null || delta.right == null) {
      if (delta.left == null) {
        GraphModel.GraphNode node = delta.right;
        this.newNodes.add(RefString.format("add.accept(NodeDef.newBuilder().setName(\"%s\").setOp(\"%s\")%s%s.build());",
            node.name,
            node.getOp(),
            node.getInputKeys().stream().map(s -> '"' + s + '"')
                .reduce((a, b) -> a + ", " + b)
                .map(s -> ".addAllInput(Arrays.asList(" + s + "))").orElse(""),
            node.getNodeDef().getAttrMap().entrySet().stream()
                .map(e -> RefString.format(".putAttr(\"%s\",%s)", e.getKey(), toString(e.getValue())))
                .reduce((a, b) -> a + b).orElse("")
        ).replaceAll("\\)\\.", ")\n\t."));
      } else {
        nodeDeletes.add(RefString.format("toDelete.add(\"%s\");%n", delta.name));
      }
    } else {
      final NodeDef leftNode = null == delta.left ? null : delta.left.getNodeDef();
      final NodeDef rightNode = null == delta.right ? null : delta.right.getNodeDef();
      if (null != leftNode && null != rightNode) {
        if (!leftNode.getOp().equals(rightNode.getOp())) {
          getBuffer(delta.name).add(RefString.format("node.setOp(\"%s\");", rightNode.getOp()));
        }
      }
      compare(delta, leftNode.getAttrMap(), rightNode.getAttrMap());
      compareInputs(delta,
          delta.left.getInputKeys(),
          delta.right.getInputKeys());
    }
  }

  public void compareInputs(GraphModel.DeltaRecord delta, List<String> leftData, List<String> rightData) {
    if (leftData == null || leftData.size() == 0) {
      getBuffer(delta.name).add(rightData.stream().map(input ->
          RefString.format("node.addInput(\"%s\");", input)
      ).reduce((a, b) -> a + "\n" + b).orElse(""));
    } else if (rightData == null || rightData.size() == 0) {
      getBuffer(delta.name).add("node.clearInput();");
    } else if (leftData.size() != rightData.size()) {
      if (leftData.size() + 1 == rightData.size() && leftData.equals(rightData.subList(0, leftData.size()))) {
        getBuffer(delta.name).add(RefString.format("node.addInput(\"%s\");", rightData.get(leftData.size())));
      } else {
        System.out.printf("// %s: Input %s vs %s%n", delta.name,
            leftData.stream().reduce((a, b) -> a + "," + b).orElse("-"),
            rightData.stream().reduce((a, b) -> a + "," + b).orElse("-"));
      }
    } else {
      final int[] mismatchedIndices = IntStream.range(0, leftData.size()).filter(i -> !leftData.get(i).equals(rightData.get(i))).toArray();
      if (1 == mismatchedIndices.length) {
        getBuffer(delta.name).add(RefString.format("node.setInput(%s, \"%s\");", mismatchedIndices[0], rightData.get(mismatchedIndices[0])));
      } else if (0 < mismatchedIndices.length) {
        getBuffer(delta.name).add(RefString.format("node.clearInput();node.addAllInput(Arrays.asList(%s));",
            rightData.stream().map(x -> '"' + x + '"').reduce((a, b) -> a + "," + b).orElseGet(() -> "")));
      }
    }
  }

  private void compare(GraphModel.DeltaRecord delta, Map<String, AttrValue> left, Map<String, AttrValue> right) {
    Stream.concat(
        left.keySet().stream(),
        right.keySet().stream()
    )
        .forEach(key -> {
          AttrValue leftValue = left.get(key);
          AttrValue rightValue = right.get(key);
          if (null == leftValue) {
            getBuffer(delta.name).add(RefString.format("node.putAttr(\"%s\", %s);", key, toString(rightValue).trim()));
          } else if (null == rightValue) {
            getBuffer(delta.name).add(RefString.format("node.removeAttr(\"%s\");", key));
          } else {
            if (!leftValue.toString().equals(rightValue.toString())) {
              getBuffer(delta.name).add(RefString.format("node.putAttr(\"%s\", %s);", key, toString(rightValue).trim()));
            }
          }
        });
  }

  @NotNull
  private ArrayList<String> getBuffer(String name) {
    return nodeEdits.computeIfAbsent(name, k -> new ArrayList<String>());
  }

}
