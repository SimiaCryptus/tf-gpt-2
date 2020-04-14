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

import com.simiacryptus.text.GraphModifier;
import org.tensorflow.framework.AttrValue;
import org.tensorflow.framework.DataType;
import org.tensorflow.framework.NodeDef;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * The type Gpt 2 edit 345 m.
 */
public class GPT2Edit_345M extends GraphModifier {

  @Nonnull
  @Override
  public HashSet<String> getDeletes_Init() {
    final HashSet<String> toDelete = new HashSet<>();

    toDelete.add("model/h14/attn/concat_1");
    toDelete.add("model/h12/attn/Reshape_4/shape/0");
    toDelete.add("model/h3/attn/Reshape_4/shape/0");
    toDelete.add("model/h14/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h8/attn/strided_slice_6");
    toDelete.add("model/h16/attn/strided_slice_6/stack_1");
    toDelete.add("model/h16/attn/strided_slice_6/stack_2");
    toDelete.add("model/h17/attn/strided_slice_6/stack");
    toDelete.add("model/h23/attn/concat_1/axis");
    toDelete.add("model/h19/attn/concat_1/axis");
    toDelete.add("model/h8/attn/strided_slice_6/stack");
    toDelete.add("model/h15/attn/concat_1");
    toDelete.add("model/h11/attn/strided_slice_6");
    toDelete.add("model/h13/attn/concat_1");
    toDelete.add("model/h6/attn/Reshape_4/shape/0");
    toDelete.add("model/h22/attn/strided_slice_6/stack_1");
    toDelete.add("model/h22/attn/strided_slice_6/stack_2");
    toDelete.add("model/h7/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h13/attn/strided_slice_6");
    toDelete.add("model/h4/attn/strided_slice_6/stack_1");
    toDelete.add("model/h19/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h4/attn/strided_slice_6/stack_2");
    toDelete.add("model/strided_slice_3/stack_2");
    toDelete.add("model/h2/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/strided_slice_3/stack_1");
    toDelete.add("model/h15/attn/strided_slice_6");
    toDelete.add("model/h0/attn/strided_slice_6");
    toDelete.add("model/h22/attn/Reshape_4/shape/0");
    toDelete.add("model/h19/attn/strided_slice_6");
    toDelete.add("model/h22/attn/concat");
    toDelete.add("model/h9/attn/strided_slice_6/stack_1");
    toDelete.add("model/h9/attn/strided_slice_6/stack_2");
    toDelete.add("model/h11/attn/concat/axis");
    toDelete.add("model/h21/attn/concat");
    toDelete.add("model/h0/attn/concat/axis");
    toDelete.add("model/h13/attn/strided_slice_6/stack_2");
    toDelete.add("model/h13/attn/strided_slice_6/stack_1");
    toDelete.add("model/h16/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h2/attn/strided_slice_6");
    toDelete.add("model/h23/attn/strided_slice_6/stack");
    toDelete.add("model/h23/attn/strided_slice_6");
    toDelete.add("model/h0/attn/Reshape_4/shape/0");
    toDelete.add("model/h13/attn/concat_1/axis");
    toDelete.add("model/h2/attn/concat_1/axis");
    toDelete.add("model/h11/attn/strided_slice_6/stack_2");
    toDelete.add("model/h9/attn/strided_slice_6/stack");
    toDelete.add("model/h11/attn/strided_slice_6/stack_1");
    toDelete.add("input_past");
    toDelete.add("model/h20/attn/unstack");
    toDelete.add("model/h17/attn/Reshape_4/shape/0");
    toDelete.add("model/h11/attn/concat");
    toDelete.add("model/h6/attn/strided_slice_6");
    toDelete.add("model/h10/attn/unstack");
    toDelete.add("model/h19/attn/concat");
    toDelete.add("model/h14/attn/concat/axis");
    toDelete.add("model/h8/attn/concat_1/axis");
    toDelete.add("model/h7/attn/unstack");
    toDelete.add("model/h15/attn/concat");
    toDelete.add("model/h7/attn/strided_slice_6/stack_2");
    toDelete.add("model/h7/attn/strided_slice_6/stack_1");
    toDelete.add("model/h17/attn/concat/axis");
    toDelete.add("model/h19/attn/concat_1");
    toDelete.add("model/h11/attn/unstack");
    toDelete.add("model/h0/attn/concat_1/axis");
    toDelete.add("model/h4/attn/strided_slice_6/stack");
    toDelete.add("model/h17/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h18/attn/concat/axis");
    toDelete.add("model/h11/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h13/attn/concat/axis");
    toDelete.add("model/h6/attn/strided_slice_6/stack_1");
    toDelete.add("model/h20/attn/strided_slice_6/stack_1");
    toDelete.add("model/h6/attn/strided_slice_6/stack_2");
    toDelete.add("model/h20/attn/strided_slice_6/stack_2");
    toDelete.add("model/h6/attn/concat/axis");
    toDelete.add("model/h5/attn/Reshape_4/shape/0");
    toDelete.add("model/h23/attn/concat/axis");
    toDelete.add("model/h4/attn/unstack");
    toDelete.add("model/h5/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h6/attn/unstack");
    toDelete.add("model/h10/attn/strided_slice_6/stack_1");
    toDelete.add("model/h10/attn/strided_slice_6/stack_2");
    toDelete.add("model/h17/attn/concat_1/axis");
    toDelete.add("model/h14/attn/Reshape_4/shape/0");
    toDelete.add("model/h2/attn/strided_slice_6/stack_1");
    toDelete.add("output/concat");
    toDelete.add("model/h9/attn/concat_1");
    toDelete.add("model/h2/attn/strided_slice_6/stack_2");
    toDelete.add("model/h20/attn/strided_slice_6/stack");
    toDelete.add("model/h22/attn/strided_slice_6/stack");
    toDelete.add("model/h7/attn/strided_slice_6/stack");
    toDelete.add("model/h4/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h22/attn/unstack");
    toDelete.add("model/h8/attn/concat/axis");
    toDelete.add("model/h12/attn/concat");
    toDelete.add("model/h15/attn/strided_slice_6/stack_2");
    toDelete.add("model/h15/attn/strided_slice_6/stack_1");
    toDelete.add("model/h9/attn/unstack");
    toDelete.add("model/h11/attn/concat_1");
    toDelete.add("model/h8/attn/Reshape_4/shape/0");
    toDelete.add("model/h11/attn/Reshape_4/shape/0");
    toDelete.add("model/h14/attn/concat");
    toDelete.add("model/h19/attn/strided_slice_6/stack_1");
    toDelete.add("model/h20/attn/concat");
    toDelete.add("model/h19/attn/strided_slice_6/stack_2");
    toDelete.add("model/h23/attn/concat");
    toDelete.add("model/h7/attn/concat_1");
    toDelete.add("model/strided_slice_3");
    toDelete.add("model/h15/attn/unstack");
    toDelete.add("model/h2/attn/Reshape_4/shape/0");
    toDelete.add("model/h20/attn/Reshape_4/shape/0");
    toDelete.add("model/h2/attn/strided_slice_6/stack");
    toDelete.add("model/h1/attn/concat");
    toDelete.add("model/h12/attn/concat_1/axis");
    toDelete.add("model/h19/attn/concat/axis");
    toDelete.add("model/h2/attn/unstack");
    toDelete.add("model/h9/attn/concat");
    toDelete.add("model/h3/attn/strided_slice_6/stack");
    toDelete.add("model/h17/attn/strided_slice_6/stack_1");
    toDelete.add("model/h4/attn/concat");
    toDelete.add("model/h17/attn/strided_slice_6/stack_2");
    toDelete.add("model/h4/attn/strided_slice_6");
    toDelete.add("model/h1/attn/concat_1");
    toDelete.add("model/h0/attn/strided_slice_6/stack_1");
    toDelete.add("model/h14/attn/strided_slice_6");
    toDelete.add("model/h13/attn/unstack");
    toDelete.add("model/h17/attn/concat_1");
    toDelete.add("model/h3/attn/concat_1");
    toDelete.add("model/h1/attn/strided_slice_6/stack");
    toDelete.add("model/h5/attn/concat_1/axis");
    toDelete.add("model/h7/attn/concat/axis");
    toDelete.add("model/h23/attn/Reshape_4/shape/0");
    toDelete.add("model/h21/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h1/attn/concat_1/axis");
    toDelete.add("model/h17/attn/concat");
    toDelete.add("model/h9/attn/concat_1/axis");
    toDelete.add("model/h0/attn/strided_slice_6/stack");
    toDelete.add("model/h22/attn/concat/axis");
    toDelete.add("model/h21/attn/strided_slice_6");
    toDelete.add("model/h0/attn/strided_slice_6/stack_2");
    toDelete.add("model/h5/attn/concat_1");
    toDelete.add("model/h1/attn/concat/axis");
    toDelete.add("model/h9/attn/strided_slice_6");
    toDelete.add("model/h19/attn/Reshape_4/shape/0");
    toDelete.add("model/h2/attn/concat/axis");
    toDelete.add("model/h21/attn/strided_slice_6/stack");
    toDelete.add("model/h8/attn/strided_slice_6/stack_1");
    toDelete.add("model/h8/attn/strided_slice_6/stack_2");
    toDelete.add("model/h23/attn/concat_1");
    toDelete.add("model/h19/attn/unstack");
    toDelete.add("model/h16/attn/concat_1/axis");
    toDelete.add("model/h10/attn/strided_slice_6");
    toDelete.add("model/h12/attn/strided_slice_6");
    toDelete.add("model/h20/attn/concat_1/axis");
    toDelete.add("model/h12/attn/concat/axis");
    toDelete.add("model/strided_slice_3/stack");
    toDelete.add("model/h22/attn/concat_1");
    toDelete.add("model/h22/attn/strided_slice_6");
    toDelete.add("model/h5/attn/strided_slice_6/stack");
    toDelete.add("model/h16/attn/Reshape_4/shape/0");
    toDelete.add("model/h5/attn/strided_slice_6");
    toDelete.add("model/h5/attn/concat/axis");
    toDelete.add("model/h20/attn/strided_slice_6");
    toDelete.add("model/h7/attn/strided_slice_6");
    toDelete.add("model/h21/attn/strided_slice_6/stack_2");
    toDelete.add("model/h21/attn/strided_slice_6/stack_1");
    toDelete.add("model/h1/attn/unstack");
    toDelete.add("model/Shape_3");
    toDelete.add("model/h6/attn/strided_slice_6/stack");
    toDelete.add("model/h15/attn/concat_1/axis");
    toDelete.add("model/h4/attn/concat_1/axis");
    toDelete.add("model/h16/attn/unstack");
    toDelete.add("model/h21/attn/concat/axis");
    toDelete.add("model/h10/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h20/attn/concat_1");
    toDelete.add("model/h13/attn/Reshape_4/shape/0");
    toDelete.add("model/h5/attn/strided_slice_6/stack_2");
    toDelete.add("model/h5/attn/strided_slice_6/stack_1");
    toDelete.add("model/h9/attn/concat/axis");
    toDelete.add("model/h7/attn/concat");
    toDelete.add("model/h21/attn/concat_1");
    toDelete.add("model/h4/attn/Reshape_4/shape/0");
    toDelete.add("model/h6/attn/concat");
    toDelete.add("model/h2/attn/concat");
    toDelete.add("model/h3/attn/concat");
    toDelete.add("model/h3/attn/strided_slice_6");
    toDelete.add("model/h0/attn/unstack");
    toDelete.add("model/h7/attn/Reshape_4/shape/0");
    toDelete.add("model/h23/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h17/attn/unstack");
    toDelete.add("output/concat/axis");
    toDelete.add("model/h18/attn/unstack");
    toDelete.add("model/h1/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h16/attn/strided_slice_6");
    toDelete.add("model/h10/attn/Reshape_4/shape/0");
    toDelete.add("model/h13/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h8/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h6/attn/concat_1/axis");
    toDelete.add("model/h12/attn/strided_slice_6/stack_2");
    toDelete.add("model/h12/attn/strided_slice_6/stack_1");
    toDelete.add("model/h18/attn/strided_slice_6/stack_2");
    toDelete.add("model/h23/attn/unstack");
    toDelete.add("model/h18/attn/strided_slice_6/stack_1");
    toDelete.add("model/h11/attn/concat_1/axis");
    toDelete.add("model/h13/attn/strided_slice_6/stack");
    toDelete.add("model/h21/attn/Reshape_4/shape/0");
    toDelete.add("model/h12/attn/unstack");
    toDelete.add("model/h14/attn/concat_1/axis");
    toDelete.add("model/h14/attn/strided_slice_6/stack_1");
    toDelete.add("model/h14/attn/strided_slice_6/stack_2");
    toDelete.add("model/h22/attn/concat_1/axis");
    toDelete.add("model/unstack");
    toDelete.add("model/h0/attn/concat_1");
    toDelete.add("model/h20/attn/concat/axis");
    toDelete.add("model/h21/attn/unstack");
    toDelete.add("model/h3/attn/concat/axis");
    toDelete.add("model/h10/attn/concat/axis");
    toDelete.add("model/h8/attn/unstack");
    toDelete.add("model/h19/attn/strided_slice_6/stack");
    toDelete.add("model/h3/attn/strided_slice_6/stack_1");
    toDelete.add("model/h1/attn/Reshape_4/shape/0");
    toDelete.add("model/h3/attn/strided_slice_6/stack_2");
    toDelete.add("model/h20/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h10/attn/strided_slice_6/stack");
    toDelete.add("model/h10/attn/concat");
    toDelete.add("model/h22/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h16/attn/concat");
    toDelete.add("model/h18/attn/Reshape_4/shape/0");
    toDelete.add("model/h5/attn/unstack");
    toDelete.add("model/h12/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h10/attn/concat_1");
    toDelete.add("model/h18/attn/concat");
    toDelete.add("model/h6/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h9/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h3/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h17/attn/strided_slice_6");
    toDelete.add("model/h11/attn/strided_slice_6/stack");
    toDelete.add("model/h2/attn/concat_1");
    toDelete.add("model/h16/attn/concat_1");
    toDelete.add("model/h1/attn/strided_slice_6");
    toDelete.add("model/h12/attn/concat_1");
    toDelete.add("model/h10/attn/concat_1/axis");
    toDelete.add("model/h8/attn/concat_1");
    toDelete.add("model/h16/attn/concat/axis");
    toDelete.add("model/h0/attn/concat");
    toDelete.add("model/h15/attn/concat/axis");
    toDelete.add("model/h18/attn/strided_slice_6/stack");
    toDelete.add("model/h23/attn/strided_slice_6/stack_1");
    toDelete.add("model/h23/attn/strided_slice_6/stack_2");
    toDelete.add("model/h0/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h18/attn/concat_1/axis");
    toDelete.add("model/h8/attn/concat");
    toDelete.add("model/h5/attn/concat");
    toDelete.add("model/h21/attn/concat_1/axis");
    toDelete.add("model/h18/attn/strided_slice_6");
    toDelete.add("model/h12/attn/strided_slice_6/stack");
    toDelete.add("model/h1/attn/strided_slice_6/stack_2");
    toDelete.add("model/h1/attn/strided_slice_6/stack_1");
    toDelete.add("model/h18/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h15/attn/c_proj/Reshape_2/shape/0");
    toDelete.add("model/h15/attn/Reshape_4/shape/0");
    toDelete.add("model/h14/attn/strided_slice_6/stack");
    toDelete.add("model/h6/attn/concat_1");
    toDelete.add("model/h14/attn/unstack");
    toDelete.add("model/h16/attn/strided_slice_6/stack");
    toDelete.add("model/h9/attn/Reshape_4/shape/0");
    toDelete.add("model/h13/attn/concat");
    toDelete.add("model/h4/attn/concat_1");
    toDelete.add("model/h3/attn/concat_1/axis");
    toDelete.add("model/h15/attn/strided_slice_6/stack");
    toDelete.add("model/h7/attn/concat_1/axis");
    toDelete.add("model/h3/attn/unstack");
    toDelete.add("model/h18/attn/concat_1");
    toDelete.add("model/h4/attn/concat/axis");
    return toDelete;
  }

  @Nullable
  @Override
  public NodeDef.Builder edit(@Nonnull NodeDef.Builder node) {

    if (node.getName().equals("model/Shape_1")) {
      node.putAttr("T", AttrValue.newBuilder().setType(DataType.forNumber(3)).build());
      node.putAttr("T", AttrValue.newBuilder().setType(DataType.forNumber(3)).build());
      node.setInput(0, "input_X");
    } else if (node.getName().equals("model/Tile/multiples")) {
      node.setInput(0, "model/strided_slice_1");
    } else if (node.getName().equals("model/add")) {
      node.setInput(0, "model/add/x");
    } else if (node.getName().equals("model/h0/attn/GreaterEqual")) {
      node.setInput(0, "model/h0/attn/strided_slice_9");
    } else if (node.getName().equals("model/h0/attn/MatMul")) {
      node.setInput(1, "model/h0/attn/transpose_1");
    } else if (node.getName().equals("model/h0/attn/MatMul_1")) {
      node.setInput(1, "model/h0/attn/transpose_2");
    } else if (node.getName().equals("model/h0/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h0/attn/Reshape_3/shape/0", "model/h0/attn/Reshape_3/shape/1", "model/h0/attn/strided_slice_7", "model/h0/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h0/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h0/attn/strided_slice_10", "model/h0/attn/strided_slice_11", "model/h0/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h0/attn/add")) {
      node.setInput(1, "model/h0/attn/strided_slice_7");
    } else if (node.getName().equals("model/h0/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h0/attn/c_proj/strided_slice", "model/h0/attn/c_proj/strided_slice_1", "model/h0/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h0/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h0/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h0/attn/range")) {
      node.setInput(1, "model/h0/attn/strided_slice_7");
    } else if (node.getName().equals("model/h0/attn/range_1")) {
      node.setInput(1, "model/h0/attn/strided_slice_8");
    } else if (node.getName().equals("model/h0/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h0/attn/Shape_3");
    } else if (node.getName().equals("model/h0/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h0/attn/range");
    } else if (node.getName().equals("model/h0/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h0/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h0/attn/sub")) {
      node.setInput(1, "model/h0/attn/strided_slice_8");
    } else if (node.getName().equals("model/h1/attn/GreaterEqual")) {
      node.setInput(0, "model/h1/attn/strided_slice_9");
    } else if (node.getName().equals("model/h1/attn/MatMul")) {
      node.setInput(1, "model/h1/attn/transpose_1");
    } else if (node.getName().equals("model/h1/attn/MatMul_1")) {
      node.setInput(1, "model/h1/attn/transpose_2");
    } else if (node.getName().equals("model/h1/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h1/attn/Reshape_3/shape/0", "model/h1/attn/Reshape_3/shape/1", "model/h1/attn/strided_slice_7", "model/h1/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h1/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h1/attn/strided_slice_10", "model/h1/attn/strided_slice_11", "model/h1/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h1/attn/add")) {
      node.setInput(1, "model/h1/attn/strided_slice_7");
    } else if (node.getName().equals("model/h1/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h1/attn/c_proj/strided_slice", "model/h1/attn/c_proj/strided_slice_1", "model/h1/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h1/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h1/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h1/attn/range")) {
      node.setInput(1, "model/h1/attn/strided_slice_7");
    } else if (node.getName().equals("model/h1/attn/range_1")) {
      node.setInput(1, "model/h1/attn/strided_slice_8");
    } else if (node.getName().equals("model/h1/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h1/attn/Shape_3");
    } else if (node.getName().equals("model/h1/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h1/attn/range");
    } else if (node.getName().equals("model/h1/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h1/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h1/attn/sub")) {
      node.setInput(1, "model/h1/attn/strided_slice_8");
    } else if (node.getName().equals("model/h10/attn/GreaterEqual")) {
      node.setInput(0, "model/h10/attn/strided_slice_9");
    } else if (node.getName().equals("model/h10/attn/MatMul")) {
      node.setInput(1, "model/h10/attn/transpose_1");
    } else if (node.getName().equals("model/h10/attn/MatMul_1")) {
      node.setInput(1, "model/h10/attn/transpose_2");
    } else if (node.getName().equals("model/h10/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h10/attn/Reshape_3/shape/0", "model/h10/attn/Reshape_3/shape/1", "model/h10/attn/strided_slice_7", "model/h10/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h10/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h10/attn/strided_slice_10", "model/h10/attn/strided_slice_11", "model/h10/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h10/attn/add")) {
      node.setInput(1, "model/h10/attn/strided_slice_7");
    } else if (node.getName().equals("model/h10/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h10/attn/c_proj/strided_slice", "model/h10/attn/c_proj/strided_slice_1", "model/h10/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h10/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h10/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h10/attn/range")) {
      node.setInput(1, "model/h10/attn/strided_slice_7");
    } else if (node.getName().equals("model/h10/attn/range_1")) {
      node.setInput(1, "model/h10/attn/strided_slice_8");
    } else if (node.getName().equals("model/h10/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h10/attn/Shape_3");
    } else if (node.getName().equals("model/h10/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h10/attn/range");
    } else if (node.getName().equals("model/h10/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h10/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h10/attn/sub")) {
      node.setInput(1, "model/h10/attn/strided_slice_8");
    } else if (node.getName().equals("model/h11/attn/GreaterEqual")) {
      node.setInput(0, "model/h11/attn/strided_slice_9");
    } else if (node.getName().equals("model/h11/attn/MatMul")) {
      node.setInput(1, "model/h11/attn/transpose_1");
    } else if (node.getName().equals("model/h11/attn/MatMul_1")) {
      node.setInput(1, "model/h11/attn/transpose_2");
    } else if (node.getName().equals("model/h11/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h11/attn/Reshape_3/shape/0", "model/h11/attn/Reshape_3/shape/1", "model/h11/attn/strided_slice_7", "model/h11/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h11/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h11/attn/strided_slice_10", "model/h11/attn/strided_slice_11", "model/h11/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h11/attn/add")) {
      node.setInput(1, "model/h11/attn/strided_slice_7");
    } else if (node.getName().equals("model/h11/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h11/attn/c_proj/strided_slice", "model/h11/attn/c_proj/strided_slice_1", "model/h11/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h11/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h11/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h11/attn/range")) {
      node.setInput(1, "model/h11/attn/strided_slice_7");
    } else if (node.getName().equals("model/h11/attn/range_1")) {
      node.setInput(1, "model/h11/attn/strided_slice_8");
    } else if (node.getName().equals("model/h11/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h11/attn/Shape_3");
    } else if (node.getName().equals("model/h11/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h11/attn/range");
    } else if (node.getName().equals("model/h11/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h11/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h11/attn/sub")) {
      node.setInput(1, "model/h11/attn/strided_slice_8");
    } else if (node.getName().equals("model/h12/attn/GreaterEqual")) {
      node.setInput(0, "model/h12/attn/strided_slice_9");
    } else if (node.getName().equals("model/h12/attn/MatMul")) {
      node.setInput(1, "model/h12/attn/transpose_1");
    } else if (node.getName().equals("model/h12/attn/MatMul_1")) {
      node.setInput(1, "model/h12/attn/transpose_2");
    } else if (node.getName().equals("model/h12/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h12/attn/Reshape_3/shape/0", "model/h12/attn/Reshape_3/shape/1", "model/h12/attn/strided_slice_7", "model/h12/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h12/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h12/attn/strided_slice_10", "model/h12/attn/strided_slice_11", "model/h12/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h12/attn/add")) {
      node.setInput(1, "model/h12/attn/strided_slice_7");
    } else if (node.getName().equals("model/h12/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h12/attn/c_proj/strided_slice", "model/h12/attn/c_proj/strided_slice_1", "model/h12/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h12/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h12/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h12/attn/range")) {
      node.setInput(1, "model/h12/attn/strided_slice_7");
    } else if (node.getName().equals("model/h12/attn/range_1")) {
      node.setInput(1, "model/h12/attn/strided_slice_8");
    } else if (node.getName().equals("model/h12/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h12/attn/Shape_3");
    } else if (node.getName().equals("model/h12/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h12/attn/range");
    } else if (node.getName().equals("model/h12/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h12/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h12/attn/sub")) {
      node.setInput(1, "model/h12/attn/strided_slice_8");
    } else if (node.getName().equals("model/h13/attn/GreaterEqual")) {
      node.setInput(0, "model/h13/attn/strided_slice_9");
    } else if (node.getName().equals("model/h13/attn/MatMul")) {
      node.setInput(1, "model/h13/attn/transpose_1");
    } else if (node.getName().equals("model/h13/attn/MatMul_1")) {
      node.setInput(1, "model/h13/attn/transpose_2");
    } else if (node.getName().equals("model/h13/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h13/attn/Reshape_3/shape/0", "model/h13/attn/Reshape_3/shape/1", "model/h13/attn/strided_slice_7", "model/h13/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h13/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h13/attn/strided_slice_10", "model/h13/attn/strided_slice_11", "model/h13/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h13/attn/add")) {
      node.setInput(1, "model/h13/attn/strided_slice_7");
    } else if (node.getName().equals("model/h13/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h13/attn/c_proj/strided_slice", "model/h13/attn/c_proj/strided_slice_1", "model/h13/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h13/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h13/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h13/attn/range")) {
      node.setInput(1, "model/h13/attn/strided_slice_7");
    } else if (node.getName().equals("model/h13/attn/range_1")) {
      node.setInput(1, "model/h13/attn/strided_slice_8");
    } else if (node.getName().equals("model/h13/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h13/attn/Shape_3");
    } else if (node.getName().equals("model/h13/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h13/attn/range");
    } else if (node.getName().equals("model/h13/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h13/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h13/attn/sub")) {
      node.setInput(1, "model/h13/attn/strided_slice_8");
    } else if (node.getName().equals("model/h14/attn/GreaterEqual")) {
      node.setInput(0, "model/h14/attn/strided_slice_9");
    } else if (node.getName().equals("model/h14/attn/MatMul")) {
      node.setInput(1, "model/h14/attn/transpose_1");
    } else if (node.getName().equals("model/h14/attn/MatMul_1")) {
      node.setInput(1, "model/h14/attn/transpose_2");
    } else if (node.getName().equals("model/h14/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h14/attn/Reshape_3/shape/0", "model/h14/attn/Reshape_3/shape/1", "model/h14/attn/strided_slice_7", "model/h14/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h14/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h14/attn/strided_slice_10", "model/h14/attn/strided_slice_11", "model/h14/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h14/attn/add")) {
      node.setInput(1, "model/h14/attn/strided_slice_7");
    } else if (node.getName().equals("model/h14/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h14/attn/c_proj/strided_slice", "model/h14/attn/c_proj/strided_slice_1", "model/h14/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h14/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h14/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h14/attn/range")) {
      node.setInput(1, "model/h14/attn/strided_slice_7");
    } else if (node.getName().equals("model/h14/attn/range_1")) {
      node.setInput(1, "model/h14/attn/strided_slice_8");
    } else if (node.getName().equals("model/h14/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h14/attn/Shape_3");
    } else if (node.getName().equals("model/h14/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h14/attn/range");
    } else if (node.getName().equals("model/h14/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h14/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h14/attn/sub")) {
      node.setInput(1, "model/h14/attn/strided_slice_8");
    } else if (node.getName().equals("model/h15/attn/GreaterEqual")) {
      node.setInput(0, "model/h15/attn/strided_slice_9");
    } else if (node.getName().equals("model/h15/attn/MatMul")) {
      node.setInput(1, "model/h15/attn/transpose_1");
    } else if (node.getName().equals("model/h15/attn/MatMul_1")) {
      node.setInput(1, "model/h15/attn/transpose_2");
    } else if (node.getName().equals("model/h15/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h15/attn/Reshape_3/shape/0", "model/h15/attn/Reshape_3/shape/1", "model/h15/attn/strided_slice_7", "model/h15/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h15/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h15/attn/strided_slice_10", "model/h15/attn/strided_slice_11", "model/h15/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h15/attn/add")) {
      node.setInput(1, "model/h15/attn/strided_slice_7");
    } else if (node.getName().equals("model/h15/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h15/attn/c_proj/strided_slice", "model/h15/attn/c_proj/strided_slice_1", "model/h15/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h15/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h15/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h15/attn/range")) {
      node.setInput(1, "model/h15/attn/strided_slice_7");
    } else if (node.getName().equals("model/h15/attn/range_1")) {
      node.setInput(1, "model/h15/attn/strided_slice_8");
    } else if (node.getName().equals("model/h15/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h15/attn/Shape_3");
    } else if (node.getName().equals("model/h15/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h15/attn/range");
    } else if (node.getName().equals("model/h15/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h15/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h15/attn/sub")) {
      node.setInput(1, "model/h15/attn/strided_slice_8");
    } else if (node.getName().equals("model/h16/attn/GreaterEqual")) {
      node.setInput(0, "model/h16/attn/strided_slice_9");
    } else if (node.getName().equals("model/h16/attn/MatMul")) {
      node.setInput(1, "model/h16/attn/transpose_1");
    } else if (node.getName().equals("model/h16/attn/MatMul_1")) {
      node.setInput(1, "model/h16/attn/transpose_2");
    } else if (node.getName().equals("model/h16/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h16/attn/Reshape_3/shape/0", "model/h16/attn/Reshape_3/shape/1", "model/h16/attn/strided_slice_7", "model/h16/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h16/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h16/attn/strided_slice_10", "model/h16/attn/strided_slice_11", "model/h16/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h16/attn/add")) {
      node.setInput(1, "model/h16/attn/strided_slice_7");
    } else if (node.getName().equals("model/h16/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h16/attn/c_proj/strided_slice", "model/h16/attn/c_proj/strided_slice_1", "model/h16/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h16/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h16/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h16/attn/range")) {
      node.setInput(1, "model/h16/attn/strided_slice_7");
    } else if (node.getName().equals("model/h16/attn/range_1")) {
      node.setInput(1, "model/h16/attn/strided_slice_8");
    } else if (node.getName().equals("model/h16/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h16/attn/Shape_3");
    } else if (node.getName().equals("model/h16/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h16/attn/range");
    } else if (node.getName().equals("model/h16/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h16/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h16/attn/sub")) {
      node.setInput(1, "model/h16/attn/strided_slice_8");
    } else if (node.getName().equals("model/h17/attn/GreaterEqual")) {
      node.setInput(0, "model/h17/attn/strided_slice_9");
    } else if (node.getName().equals("model/h17/attn/MatMul")) {
      node.setInput(1, "model/h17/attn/transpose_1");
    } else if (node.getName().equals("model/h17/attn/MatMul_1")) {
      node.setInput(1, "model/h17/attn/transpose_2");
    } else if (node.getName().equals("model/h17/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h17/attn/Reshape_3/shape/0", "model/h17/attn/Reshape_3/shape/1", "model/h17/attn/strided_slice_7", "model/h17/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h17/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h17/attn/strided_slice_10", "model/h17/attn/strided_slice_11", "model/h17/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h17/attn/add")) {
      node.setInput(1, "model/h17/attn/strided_slice_7");
    } else if (node.getName().equals("model/h17/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h17/attn/c_proj/strided_slice", "model/h17/attn/c_proj/strided_slice_1", "model/h17/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h17/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h17/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h17/attn/range")) {
      node.setInput(1, "model/h17/attn/strided_slice_7");
    } else if (node.getName().equals("model/h17/attn/range_1")) {
      node.setInput(1, "model/h17/attn/strided_slice_8");
    } else if (node.getName().equals("model/h17/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h17/attn/Shape_3");
    } else if (node.getName().equals("model/h17/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h17/attn/range");
    } else if (node.getName().equals("model/h17/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h17/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h17/attn/sub")) {
      node.setInput(1, "model/h17/attn/strided_slice_8");
    } else if (node.getName().equals("model/h18/attn/GreaterEqual")) {
      node.setInput(0, "model/h18/attn/strided_slice_9");
    } else if (node.getName().equals("model/h18/attn/MatMul")) {
      node.setInput(1, "model/h18/attn/transpose_1");
    } else if (node.getName().equals("model/h18/attn/MatMul_1")) {
      node.setInput(1, "model/h18/attn/transpose_2");
    } else if (node.getName().equals("model/h18/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h18/attn/Reshape_3/shape/0", "model/h18/attn/Reshape_3/shape/1", "model/h18/attn/strided_slice_7", "model/h18/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h18/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h18/attn/strided_slice_10", "model/h18/attn/strided_slice_11", "model/h18/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h18/attn/add")) {
      node.setInput(1, "model/h18/attn/strided_slice_7");
    } else if (node.getName().equals("model/h18/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h18/attn/c_proj/strided_slice", "model/h18/attn/c_proj/strided_slice_1", "model/h18/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h18/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h18/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h18/attn/range")) {
      node.setInput(1, "model/h18/attn/strided_slice_7");
    } else if (node.getName().equals("model/h18/attn/range_1")) {
      node.setInput(1, "model/h18/attn/strided_slice_8");
    } else if (node.getName().equals("model/h18/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h18/attn/Shape_3");
    } else if (node.getName().equals("model/h18/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h18/attn/range");
    } else if (node.getName().equals("model/h18/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h18/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h18/attn/sub")) {
      node.setInput(1, "model/h18/attn/strided_slice_8");
    } else if (node.getName().equals("model/h19/attn/GreaterEqual")) {
      node.setInput(0, "model/h19/attn/strided_slice_9");
    } else if (node.getName().equals("model/h19/attn/MatMul")) {
      node.setInput(1, "model/h19/attn/transpose_1");
    } else if (node.getName().equals("model/h19/attn/MatMul_1")) {
      node.setInput(1, "model/h19/attn/transpose_2");
    } else if (node.getName().equals("model/h19/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h19/attn/Reshape_3/shape/0", "model/h19/attn/Reshape_3/shape/1", "model/h19/attn/strided_slice_7", "model/h19/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h19/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h19/attn/strided_slice_10", "model/h19/attn/strided_slice_11", "model/h19/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h19/attn/add")) {
      node.setInput(1, "model/h19/attn/strided_slice_7");
    } else if (node.getName().equals("model/h19/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h19/attn/c_proj/strided_slice", "model/h19/attn/c_proj/strided_slice_1", "model/h19/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h19/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h19/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h19/attn/range")) {
      node.setInput(1, "model/h19/attn/strided_slice_7");
    } else if (node.getName().equals("model/h19/attn/range_1")) {
      node.setInput(1, "model/h19/attn/strided_slice_8");
    } else if (node.getName().equals("model/h19/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h19/attn/Shape_3");
    } else if (node.getName().equals("model/h19/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h19/attn/range");
    } else if (node.getName().equals("model/h19/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h19/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h19/attn/sub")) {
      node.setInput(1, "model/h19/attn/strided_slice_8");
    } else if (node.getName().equals("model/h2/attn/GreaterEqual")) {
      node.setInput(0, "model/h2/attn/strided_slice_9");
    } else if (node.getName().equals("model/h2/attn/MatMul")) {
      node.setInput(1, "model/h2/attn/transpose_1");
    } else if (node.getName().equals("model/h2/attn/MatMul_1")) {
      node.setInput(1, "model/h2/attn/transpose_2");
    } else if (node.getName().equals("model/h2/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h2/attn/Reshape_3/shape/0", "model/h2/attn/Reshape_3/shape/1", "model/h2/attn/strided_slice_7", "model/h2/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h2/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h2/attn/strided_slice_10", "model/h2/attn/strided_slice_11", "model/h2/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h2/attn/add")) {
      node.setInput(1, "model/h2/attn/strided_slice_7");
    } else if (node.getName().equals("model/h2/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h2/attn/c_proj/strided_slice", "model/h2/attn/c_proj/strided_slice_1", "model/h2/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h2/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h2/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h2/attn/range")) {
      node.setInput(1, "model/h2/attn/strided_slice_7");
    } else if (node.getName().equals("model/h2/attn/range_1")) {
      node.setInput(1, "model/h2/attn/strided_slice_8");
    } else if (node.getName().equals("model/h2/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h2/attn/Shape_3");
    } else if (node.getName().equals("model/h2/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h2/attn/range");
    } else if (node.getName().equals("model/h2/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h2/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h2/attn/sub")) {
      node.setInput(1, "model/h2/attn/strided_slice_8");
    } else if (node.getName().equals("model/h20/attn/GreaterEqual")) {
      node.setInput(0, "model/h20/attn/strided_slice_9");
    } else if (node.getName().equals("model/h20/attn/MatMul")) {
      node.setInput(1, "model/h20/attn/transpose_1");
    } else if (node.getName().equals("model/h20/attn/MatMul_1")) {
      node.setInput(1, "model/h20/attn/transpose_2");
    } else if (node.getName().equals("model/h20/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h20/attn/Reshape_3/shape/0", "model/h20/attn/Reshape_3/shape/1", "model/h20/attn/strided_slice_7", "model/h20/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h20/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h20/attn/strided_slice_10", "model/h20/attn/strided_slice_11", "model/h20/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h20/attn/add")) {
      node.setInput(1, "model/h20/attn/strided_slice_7");
    } else if (node.getName().equals("model/h20/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h20/attn/c_proj/strided_slice", "model/h20/attn/c_proj/strided_slice_1", "model/h20/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h20/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h20/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h20/attn/range")) {
      node.setInput(1, "model/h20/attn/strided_slice_7");
    } else if (node.getName().equals("model/h20/attn/range_1")) {
      node.setInput(1, "model/h20/attn/strided_slice_8");
    } else if (node.getName().equals("model/h20/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h20/attn/Shape_3");
    } else if (node.getName().equals("model/h20/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h20/attn/range");
    } else if (node.getName().equals("model/h20/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h20/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h20/attn/sub")) {
      node.setInput(1, "model/h20/attn/strided_slice_8");
    } else if (node.getName().equals("model/h21/attn/GreaterEqual")) {
      node.setInput(0, "model/h21/attn/strided_slice_9");
    } else if (node.getName().equals("model/h21/attn/MatMul")) {
      node.setInput(1, "model/h21/attn/transpose_1");
    } else if (node.getName().equals("model/h21/attn/MatMul_1")) {
      node.setInput(1, "model/h21/attn/transpose_2");
    } else if (node.getName().equals("model/h21/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h21/attn/Reshape_3/shape/0", "model/h21/attn/Reshape_3/shape/1", "model/h21/attn/strided_slice_7", "model/h21/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h21/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h21/attn/strided_slice_10", "model/h21/attn/strided_slice_11", "model/h21/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h21/attn/add")) {
      node.setInput(1, "model/h21/attn/strided_slice_7");
    } else if (node.getName().equals("model/h21/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h21/attn/c_proj/strided_slice", "model/h21/attn/c_proj/strided_slice_1", "model/h21/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h21/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h21/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h21/attn/range")) {
      node.setInput(1, "model/h21/attn/strided_slice_7");
    } else if (node.getName().equals("model/h21/attn/range_1")) {
      node.setInput(1, "model/h21/attn/strided_slice_8");
    } else if (node.getName().equals("model/h21/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h21/attn/Shape_3");
    } else if (node.getName().equals("model/h21/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h21/attn/range");
    } else if (node.getName().equals("model/h21/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h21/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h21/attn/sub")) {
      node.setInput(1, "model/h21/attn/strided_slice_8");
    } else if (node.getName().equals("model/h22/attn/GreaterEqual")) {
      node.setInput(0, "model/h22/attn/strided_slice_9");
    } else if (node.getName().equals("model/h22/attn/MatMul")) {
      node.setInput(1, "model/h22/attn/transpose_1");
    } else if (node.getName().equals("model/h22/attn/MatMul_1")) {
      node.setInput(1, "model/h22/attn/transpose_2");
    } else if (node.getName().equals("model/h22/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h22/attn/Reshape_3/shape/0", "model/h22/attn/Reshape_3/shape/1", "model/h22/attn/strided_slice_7", "model/h22/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h22/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h22/attn/strided_slice_10", "model/h22/attn/strided_slice_11", "model/h22/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h22/attn/add")) {
      node.setInput(1, "model/h22/attn/strided_slice_7");
    } else if (node.getName().equals("model/h22/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h22/attn/c_proj/strided_slice", "model/h22/attn/c_proj/strided_slice_1", "model/h22/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h22/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h22/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h22/attn/range")) {
      node.setInput(1, "model/h22/attn/strided_slice_7");
    } else if (node.getName().equals("model/h22/attn/range_1")) {
      node.setInput(1, "model/h22/attn/strided_slice_8");
    } else if (node.getName().equals("model/h22/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h22/attn/Shape_3");
    } else if (node.getName().equals("model/h22/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h22/attn/range");
    } else if (node.getName().equals("model/h22/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h22/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h22/attn/sub")) {
      node.setInput(1, "model/h22/attn/strided_slice_8");
    } else if (node.getName().equals("model/h23/attn/GreaterEqual")) {
      node.setInput(0, "model/h23/attn/strided_slice_9");
    } else if (node.getName().equals("model/h23/attn/MatMul")) {
      node.setInput(1, "model/h23/attn/transpose_1");
    } else if (node.getName().equals("model/h23/attn/MatMul_1")) {
      node.setInput(1, "model/h23/attn/transpose_2");
    } else if (node.getName().equals("model/h23/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h23/attn/Reshape_3/shape/0", "model/h23/attn/Reshape_3/shape/1", "model/h23/attn/strided_slice_7", "model/h23/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h23/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h23/attn/strided_slice_10", "model/h23/attn/strided_slice_11", "model/h23/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h23/attn/add")) {
      node.setInput(1, "model/h23/attn/strided_slice_7");
    } else if (node.getName().equals("model/h23/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h23/attn/c_proj/strided_slice", "model/h23/attn/c_proj/strided_slice_1", "model/h23/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h23/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h23/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h23/attn/range")) {
      node.setInput(1, "model/h23/attn/strided_slice_7");
    } else if (node.getName().equals("model/h23/attn/range_1")) {
      node.setInput(1, "model/h23/attn/strided_slice_8");
    } else if (node.getName().equals("model/h23/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h23/attn/Shape_3");
    } else if (node.getName().equals("model/h23/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h23/attn/range");
    } else if (node.getName().equals("model/h23/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h23/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h23/attn/sub")) {
      node.setInput(1, "model/h23/attn/strided_slice_8");
    } else if (node.getName().equals("model/h3/attn/GreaterEqual")) {
      node.setInput(0, "model/h3/attn/strided_slice_9");
    } else if (node.getName().equals("model/h3/attn/MatMul")) {
      node.setInput(1, "model/h3/attn/transpose_1");
    } else if (node.getName().equals("model/h3/attn/MatMul_1")) {
      node.setInput(1, "model/h3/attn/transpose_2");
    } else if (node.getName().equals("model/h3/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h3/attn/Reshape_3/shape/0", "model/h3/attn/Reshape_3/shape/1", "model/h3/attn/strided_slice_7", "model/h3/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h3/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h3/attn/strided_slice_10", "model/h3/attn/strided_slice_11", "model/h3/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h3/attn/add")) {
      node.setInput(1, "model/h3/attn/strided_slice_7");
    } else if (node.getName().equals("model/h3/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h3/attn/c_proj/strided_slice", "model/h3/attn/c_proj/strided_slice_1", "model/h3/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h3/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h3/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h3/attn/range")) {
      node.setInput(1, "model/h3/attn/strided_slice_7");
    } else if (node.getName().equals("model/h3/attn/range_1")) {
      node.setInput(1, "model/h3/attn/strided_slice_8");
    } else if (node.getName().equals("model/h3/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h3/attn/Shape_3");
    } else if (node.getName().equals("model/h3/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h3/attn/range");
    } else if (node.getName().equals("model/h3/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h3/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h3/attn/sub")) {
      node.setInput(1, "model/h3/attn/strided_slice_8");
    } else if (node.getName().equals("model/h4/attn/GreaterEqual")) {
      node.setInput(0, "model/h4/attn/strided_slice_9");
    } else if (node.getName().equals("model/h4/attn/MatMul")) {
      node.setInput(1, "model/h4/attn/transpose_1");
    } else if (node.getName().equals("model/h4/attn/MatMul_1")) {
      node.setInput(1, "model/h4/attn/transpose_2");
    } else if (node.getName().equals("model/h4/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h4/attn/Reshape_3/shape/0", "model/h4/attn/Reshape_3/shape/1", "model/h4/attn/strided_slice_7", "model/h4/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h4/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h4/attn/strided_slice_10", "model/h4/attn/strided_slice_11", "model/h4/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h4/attn/add")) {
      node.setInput(1, "model/h4/attn/strided_slice_7");
    } else if (node.getName().equals("model/h4/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h4/attn/c_proj/strided_slice", "model/h4/attn/c_proj/strided_slice_1", "model/h4/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h4/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h4/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h4/attn/range")) {
      node.setInput(1, "model/h4/attn/strided_slice_7");
    } else if (node.getName().equals("model/h4/attn/range_1")) {
      node.setInput(1, "model/h4/attn/strided_slice_8");
    } else if (node.getName().equals("model/h4/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h4/attn/Shape_3");
    } else if (node.getName().equals("model/h4/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h4/attn/range");
    } else if (node.getName().equals("model/h4/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h4/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h4/attn/sub")) {
      node.setInput(1, "model/h4/attn/strided_slice_8");
    } else if (node.getName().equals("model/h5/attn/GreaterEqual")) {
      node.setInput(0, "model/h5/attn/strided_slice_9");
    } else if (node.getName().equals("model/h5/attn/MatMul")) {
      node.setInput(1, "model/h5/attn/transpose_1");
    } else if (node.getName().equals("model/h5/attn/MatMul_1")) {
      node.setInput(1, "model/h5/attn/transpose_2");
    } else if (node.getName().equals("model/h5/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h5/attn/Reshape_3/shape/0", "model/h5/attn/Reshape_3/shape/1", "model/h5/attn/strided_slice_7", "model/h5/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h5/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h5/attn/strided_slice_10", "model/h5/attn/strided_slice_11", "model/h5/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h5/attn/add")) {
      node.setInput(1, "model/h5/attn/strided_slice_7");
    } else if (node.getName().equals("model/h5/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h5/attn/c_proj/strided_slice", "model/h5/attn/c_proj/strided_slice_1", "model/h5/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h5/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h5/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h5/attn/range")) {
      node.setInput(1, "model/h5/attn/strided_slice_7");
    } else if (node.getName().equals("model/h5/attn/range_1")) {
      node.setInput(1, "model/h5/attn/strided_slice_8");
    } else if (node.getName().equals("model/h5/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h5/attn/Shape_3");
    } else if (node.getName().equals("model/h5/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h5/attn/range");
    } else if (node.getName().equals("model/h5/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h5/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h5/attn/sub")) {
      node.setInput(1, "model/h5/attn/strided_slice_8");
    } else if (node.getName().equals("model/h6/attn/GreaterEqual")) {
      node.setInput(0, "model/h6/attn/strided_slice_9");
    } else if (node.getName().equals("model/h6/attn/MatMul")) {
      node.setInput(1, "model/h6/attn/transpose_1");
    } else if (node.getName().equals("model/h6/attn/MatMul_1")) {
      node.setInput(1, "model/h6/attn/transpose_2");
    } else if (node.getName().equals("model/h6/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h6/attn/Reshape_3/shape/0", "model/h6/attn/Reshape_3/shape/1", "model/h6/attn/strided_slice_7", "model/h6/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h6/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h6/attn/strided_slice_10", "model/h6/attn/strided_slice_11", "model/h6/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h6/attn/add")) {
      node.setInput(1, "model/h6/attn/strided_slice_7");
    } else if (node.getName().equals("model/h6/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h6/attn/c_proj/strided_slice", "model/h6/attn/c_proj/strided_slice_1", "model/h6/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h6/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h6/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h6/attn/range")) {
      node.setInput(1, "model/h6/attn/strided_slice_7");
    } else if (node.getName().equals("model/h6/attn/range_1")) {
      node.setInput(1, "model/h6/attn/strided_slice_8");
    } else if (node.getName().equals("model/h6/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h6/attn/Shape_3");
    } else if (node.getName().equals("model/h6/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h6/attn/range");
    } else if (node.getName().equals("model/h6/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h6/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h6/attn/sub")) {
      node.setInput(1, "model/h6/attn/strided_slice_8");
    } else if (node.getName().equals("model/h7/attn/GreaterEqual")) {
      node.setInput(0, "model/h7/attn/strided_slice_9");
    } else if (node.getName().equals("model/h7/attn/MatMul")) {
      node.setInput(1, "model/h7/attn/transpose_1");
    } else if (node.getName().equals("model/h7/attn/MatMul_1")) {
      node.setInput(1, "model/h7/attn/transpose_2");
    } else if (node.getName().equals("model/h7/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h7/attn/Reshape_3/shape/0", "model/h7/attn/Reshape_3/shape/1", "model/h7/attn/strided_slice_7", "model/h7/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h7/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h7/attn/strided_slice_10", "model/h7/attn/strided_slice_11", "model/h7/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h7/attn/add")) {
      node.setInput(1, "model/h7/attn/strided_slice_7");
    } else if (node.getName().equals("model/h7/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h7/attn/c_proj/strided_slice", "model/h7/attn/c_proj/strided_slice_1", "model/h7/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h7/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h7/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h7/attn/range")) {
      node.setInput(1, "model/h7/attn/strided_slice_7");
    } else if (node.getName().equals("model/h7/attn/range_1")) {
      node.setInput(1, "model/h7/attn/strided_slice_8");
    } else if (node.getName().equals("model/h7/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h7/attn/Shape_3");
    } else if (node.getName().equals("model/h7/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h7/attn/range");
    } else if (node.getName().equals("model/h7/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h7/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h7/attn/sub")) {
      node.setInput(1, "model/h7/attn/strided_slice_8");
    } else if (node.getName().equals("model/h8/attn/GreaterEqual")) {
      node.setInput(0, "model/h8/attn/strided_slice_9");
    } else if (node.getName().equals("model/h8/attn/MatMul")) {
      node.setInput(1, "model/h8/attn/transpose_1");
    } else if (node.getName().equals("model/h8/attn/MatMul_1")) {
      node.setInput(1, "model/h8/attn/transpose_2");
    } else if (node.getName().equals("model/h8/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h8/attn/Reshape_3/shape/0", "model/h8/attn/Reshape_3/shape/1", "model/h8/attn/strided_slice_7", "model/h8/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h8/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h8/attn/strided_slice_10", "model/h8/attn/strided_slice_11", "model/h8/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h8/attn/add")) {
      node.setInput(1, "model/h8/attn/strided_slice_7");
    } else if (node.getName().equals("model/h8/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h8/attn/c_proj/strided_slice", "model/h8/attn/c_proj/strided_slice_1", "model/h8/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h8/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h8/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h8/attn/range")) {
      node.setInput(1, "model/h8/attn/strided_slice_7");
    } else if (node.getName().equals("model/h8/attn/range_1")) {
      node.setInput(1, "model/h8/attn/strided_slice_8");
    } else if (node.getName().equals("model/h8/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h8/attn/Shape_3");
    } else if (node.getName().equals("model/h8/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h8/attn/range");
    } else if (node.getName().equals("model/h8/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h8/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h8/attn/sub")) {
      node.setInput(1, "model/h8/attn/strided_slice_8");
    } else if (node.getName().equals("model/h9/attn/GreaterEqual")) {
      node.setInput(0, "model/h9/attn/strided_slice_9");
    } else if (node.getName().equals("model/h9/attn/MatMul")) {
      node.setInput(1, "model/h9/attn/transpose_1");
    } else if (node.getName().equals("model/h9/attn/MatMul_1")) {
      node.setInput(1, "model/h9/attn/transpose_2");
    } else if (node.getName().equals("model/h9/attn/Reshape_3/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h9/attn/Reshape_3/shape/0", "model/h9/attn/Reshape_3/shape/1", "model/h9/attn/strided_slice_7", "model/h9/attn/strided_slice_8"));
    } else if (node.getName().equals("model/h9/attn/Reshape_4/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h9/attn/strided_slice_10", "model/h9/attn/strided_slice_11", "model/h9/attn/Reshape_4/shape/2"));
    } else if (node.getName().equals("model/h9/attn/add")) {
      node.setInput(1, "model/h9/attn/strided_slice_7");
    } else if (node.getName().equals("model/h9/attn/c_proj/Reshape_2/shape")) {
      node.clearInput();
      node.addAllInput(Arrays.asList("model/h9/attn/c_proj/strided_slice", "model/h9/attn/c_proj/strided_slice_1", "model/h9/attn/c_proj/Reshape_2/shape/2"));
    } else if (node.getName().equals("model/h9/attn/c_proj/strided_slice/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/h9/attn/c_proj/strided_slice/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h9/attn/range")) {
      node.setInput(1, "model/h9/attn/strided_slice_7");
    } else if (node.getName().equals("model/h9/attn/range_1")) {
      node.setInput(1, "model/h9/attn/strided_slice_8");
    } else if (node.getName().equals("model/h9/attn/strided_slice_7/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_7/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_8")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(0).build());
      node.setInput(0, "model/h9/attn/Shape_3");
    } else if (node.getName().equals("model/h9/attn/strided_slice_8/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 3)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_8/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 4)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_8/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_9")) {
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("end_mask", AttrValue.newBuilder().setI(1).build());
      node.putAttr("shrink_axis_mask", AttrValue.newBuilder().setI(0).build());
      node.putAttr("new_axis_mask", AttrValue.newBuilder().setI(2).build());
      node.putAttr("begin_mask", AttrValue.newBuilder().setI(1).build());
      node.setInput(0, "model/h9/attn/range");
    } else if (node.getName().equals("model/h9/attn/strided_slice_9/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_9/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 0, 0)).build());
    } else if (node.getName().equals("model/h9/attn/strided_slice_9/stack_2")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor2(new int[]{2}, 1, 1)).build());
    } else if (node.getName().equals("model/h9/attn/sub")) {
      node.setInput(1, "model/h9/attn/strided_slice_8");
    } else if (node.getName().equals("model/range")) {
      node.setInput(1, "model/strided_slice_2");
    } else if (node.getName().equals("model/strided_slice_1/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 0)).build());
    } else if (node.getName().equals("model/strided_slice_1/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/strided_slice_2/stack")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 1)).build());
    } else if (node.getName().equals("model/strided_slice_2/stack_1")) {
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
      node.putAttr("value", AttrValue.newBuilder().setTensor(tensor1(new int[]{1}, 2)).build());
    } else {
      return null;
    }
    return node;
  }

  protected void addNodes(@Nonnull Consumer<NodeDef> add) {

    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h4/attn/Shape_4", "model/h4/attn/strided_slice_10/stack", "model/h4/attn/strided_slice_10/stack_1", "model/h4/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h4/attn/Shape_4", "model/h4/attn/strided_slice_11/stack", "model/h4/attn/strided_slice_11/stack_1", "model/h4/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h11/attn/Shape_4", "model/h11/attn/strided_slice_11/stack", "model/h11/attn/strided_slice_11/stack_1", "model/h11/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h11/attn/Shape_4", "model/h11/attn/strided_slice_10/stack", "model/h11/attn/strided_slice_10/stack_1", "model/h11/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h23/attn/c_proj/Shape", "model/h23/attn/c_proj/strided_slice_1/stack", "model/h23/attn/c_proj/strided_slice_1/stack_1", "model/h23/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h3/attn/Shape_4", "model/h3/attn/strided_slice_11/stack", "model/h3/attn/strided_slice_11/stack_1", "model/h3/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h3/attn/Shape_4", "model/h3/attn/strided_slice_10/stack", "model/h3/attn/strided_slice_10/stack_1", "model/h3/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h14/attn/c_proj/Shape", "model/h14/attn/c_proj/strided_slice_1/stack", "model/h14/attn/c_proj/strided_slice_1/stack_1", "model/h14/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h10/attn/Shape_4", "model/h10/attn/strided_slice_11/stack", "model/h10/attn/strided_slice_11/stack_1", "model/h10/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h10/attn/Shape_4", "model/h10/attn/strided_slice_10/stack", "model/h10/attn/strided_slice_10/stack_1", "model/h10/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h6/attn/c_proj/Shape", "model/h6/attn/c_proj/strided_slice_1/stack", "model/h6/attn/c_proj/strided_slice_1/stack_1", "model/h6/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h18/attn/Shape_4", "model/h18/attn/strided_slice_10/stack", "model/h18/attn/strided_slice_10/stack_1", "model/h18/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h18/attn/Shape_4", "model/h18/attn/strided_slice_11/stack", "model/h18/attn/strided_slice_11/stack_1", "model/h18/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h19/attn/Shape_4", "model/h19/attn/strided_slice_11/stack", "model/h19/attn/strided_slice_11/stack_1", "model/h19/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h19/attn/Shape_4", "model/h19/attn/strided_slice_10/stack", "model/h19/attn/strided_slice_10/stack_1", "model/h19/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h1/attn/c_proj/Shape", "model/h1/attn/c_proj/strided_slice_1/stack", "model/h1/attn/c_proj/strided_slice_1/stack_1", "model/h1/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h20/attn/c_proj/Shape", "model/h20/attn/c_proj/strided_slice_1/stack", "model/h20/attn/c_proj/strided_slice_1/stack_1", "model/h20/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h12/attn/Shape_4", "model/h12/attn/strided_slice_10/stack", "model/h12/attn/strided_slice_10/stack_1", "model/h12/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h12/attn/Shape_4", "model/h12/attn/strided_slice_11/stack", "model/h12/attn/strided_slice_11/stack_1", "model/h12/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h19/attn/c_proj/Shape", "model/h19/attn/c_proj/strided_slice_1/stack", "model/h19/attn/c_proj/strided_slice_1/stack_1", "model/h19/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h13/attn/Shape_4", "model/h13/attn/strided_slice_11/stack", "model/h13/attn/strided_slice_11/stack_1", "model/h13/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h13/attn/Shape_4", "model/h13/attn/strided_slice_10/stack", "model/h13/attn/strided_slice_10/stack_1", "model/h13/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h21/attn/c_proj/Shape", "model/h21/attn/c_proj/strided_slice_1/stack", "model/h21/attn/c_proj/strided_slice_1/stack_1", "model/h21/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h17/attn/Shape_4", "model/h17/attn/strided_slice_10/stack", "model/h17/attn/strided_slice_10/stack_1", "model/h17/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h17/attn/Shape_4", "model/h17/attn/strided_slice_11/stack", "model/h17/attn/strided_slice_11/stack_1", "model/h17/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h17/attn/c_proj/Shape", "model/h17/attn/c_proj/strided_slice_1/stack", "model/h17/attn/c_proj/strided_slice_1/stack_1", "model/h17/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h13/attn/c_proj/Shape", "model/h13/attn/c_proj/strided_slice_1/stack", "model/h13/attn/c_proj/strided_slice_1/stack_1", "model/h13/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h12/attn/c_proj/Shape", "model/h12/attn/c_proj/strided_slice_1/stack", "model/h12/attn/c_proj/strided_slice_1/stack_1", "model/h12/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h22/attn/Shape_4", "model/h22/attn/strided_slice_11/stack", "model/h22/attn/strided_slice_11/stack_1", "model/h22/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h22/attn/Shape_4", "model/h22/attn/strided_slice_10/stack", "model/h22/attn/strided_slice_10/stack_1", "model/h22/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h5/attn/Shape_4", "model/h5/attn/strided_slice_10/stack", "model/h5/attn/strided_slice_10/stack_1", "model/h5/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h5/attn/Shape_4", "model/h5/attn/strided_slice_11/stack", "model/h5/attn/strided_slice_11/stack_1", "model/h5/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h9/attn/c_proj/Shape", "model/h9/attn/c_proj/strided_slice_1/stack", "model/h9/attn/c_proj/strided_slice_1/stack_1", "model/h9/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h16/attn/c_proj/Shape", "model/h16/attn/c_proj/strided_slice_1/stack", "model/h16/attn/c_proj/strided_slice_1/stack_1", "model/h16/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h2/attn/c_proj/Shape", "model/h2/attn/c_proj/strided_slice_1/stack", "model/h2/attn/c_proj/strided_slice_1/stack_1", "model/h2/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h10/attn/c_proj/Shape", "model/h10/attn/c_proj/strided_slice_1/stack", "model/h10/attn/c_proj/strided_slice_1/stack_1", "model/h10/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h5/attn/c_proj/Shape", "model/h5/attn/c_proj/strided_slice_1/stack", "model/h5/attn/c_proj/strided_slice_1/stack_1", "model/h5/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h15/attn/Shape_4", "model/h15/attn/strided_slice_10/stack", "model/h15/attn/strided_slice_10/stack_1", "model/h15/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h15/attn/Shape_4", "model/h15/attn/strided_slice_11/stack", "model/h15/attn/strided_slice_11/stack_1", "model/h15/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h15/attn/c_proj/Shape", "model/h15/attn/c_proj/strided_slice_1/stack", "model/h15/attn/c_proj/strided_slice_1/stack_1", "model/h15/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h0/attn/Shape_4", "model/h0/attn/strided_slice_11/stack", "model/h0/attn/strided_slice_11/stack_1", "model/h0/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h0/attn/Shape_4", "model/h0/attn/strided_slice_10/stack", "model/h0/attn/strided_slice_10/stack_1", "model/h0/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h7/attn/Shape_4", "model/h7/attn/strided_slice_11/stack", "model/h7/attn/strided_slice_11/stack_1", "model/h7/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h7/attn/Shape_4", "model/h7/attn/strided_slice_10/stack", "model/h7/attn/strided_slice_10/stack_1", "model/h7/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h22/attn/c_proj/Shape", "model/h22/attn/c_proj/strided_slice_1/stack", "model/h22/attn/c_proj/strided_slice_1/stack_1", "model/h22/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h21/attn/Shape_4", "model/h21/attn/strided_slice_10/stack", "model/h21/attn/strided_slice_10/stack_1", "model/h21/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h21/attn/Shape_4", "model/h21/attn/strided_slice_11/stack", "model/h21/attn/strided_slice_11/stack_1", "model/h21/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h9/attn/Shape_4", "model/h9/attn/strided_slice_10/stack", "model/h9/attn/strided_slice_10/stack_1", "model/h9/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h9/attn/Shape_4", "model/h9/attn/strided_slice_11/stack", "model/h9/attn/strided_slice_11/stack_1", "model/h9/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h9/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h1/attn/Shape_4", "model/h1/attn/strided_slice_10/stack", "model/h1/attn/strided_slice_10/stack_1", "model/h1/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h1/attn/Shape_4", "model/h1/attn/strided_slice_11/stack", "model/h1/attn/strided_slice_11/stack_1", "model/h1/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h20/attn/Shape_4", "model/h20/attn/strided_slice_11/stack", "model/h20/attn/strided_slice_11/stack_1", "model/h20/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h20/attn/Shape_4", "model/h20/attn/strided_slice_10/stack", "model/h20/attn/strided_slice_10/stack_1", "model/h20/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h8/attn/Shape_4", "model/h8/attn/strided_slice_11/stack", "model/h8/attn/strided_slice_11/stack_1", "model/h8/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h8/attn/Shape_4", "model/h8/attn/strided_slice_10/stack", "model/h8/attn/strided_slice_10/stack_1", "model/h8/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h6/attn/Shape_4", "model/h6/attn/strided_slice_11/stack", "model/h6/attn/strided_slice_11/stack_1", "model/h6/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h6/attn/Shape_4", "model/h6/attn/strided_slice_10/stack", "model/h6/attn/strided_slice_10/stack_1", "model/h6/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h8/attn/c_proj/Shape", "model/h8/attn/c_proj/strided_slice_1/stack", "model/h8/attn/c_proj/strided_slice_1/stack_1", "model/h8/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h2/attn/Shape_4", "model/h2/attn/strided_slice_11/stack", "model/h2/attn/strided_slice_11/stack_1", "model/h2/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h2/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h2/attn/Shape_4", "model/h2/attn/strided_slice_10/stack", "model/h2/attn/strided_slice_10/stack_1", "model/h2/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h17/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h3/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h3/attn/c_proj/Shape", "model/h3/attn/c_proj/strided_slice_1/stack", "model/h3/attn/c_proj/strided_slice_1/stack_1", "model/h3/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h7/attn/c_proj/Shape", "model/h7/attn/c_proj/strided_slice_1/stack", "model/h7/attn/c_proj/strided_slice_1/stack_1", "model/h7/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/add/x")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h8/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h19/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h1/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h15/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h5/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h13/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h14/attn/Shape_4", "model/h14/attn/strided_slice_11/stack", "model/h14/attn/strided_slice_11/stack_1", "model/h14/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h14/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h14/attn/Shape_4", "model/h14/attn/strided_slice_10/stack", "model/h14/attn/strided_slice_10/stack_1", "model/h14/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h23/attn/Shape_4", "model/h23/attn/strided_slice_11/stack", "model/h23/attn/strided_slice_11/stack_1", "model/h23/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h4/attn/c_proj/Shape", "model/h4/attn/c_proj/strided_slice_1/stack", "model/h4/attn/c_proj/strided_slice_1/stack_1", "model/h4/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h23/attn/Shape_4", "model/h23/attn/strided_slice_10/stack", "model/h23/attn/strided_slice_10/stack_1", "model/h23/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_10")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h16/attn/Shape_4", "model/h16/attn/strided_slice_10/stack", "model/h16/attn/strided_slice_10/stack_1", "model/h16/attn/strided_slice_10/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h16/attn/strided_slice_11")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h16/attn/Shape_4", "model/h16/attn/strided_slice_11/stack", "model/h16/attn/strided_slice_11/stack_1", "model/h16/attn/strided_slice_11/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h21/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h4/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h11/attn/c_proj/Shape", "model/h11/attn/c_proj/strided_slice_1/stack", "model/h11/attn/c_proj/strided_slice_1/stack_1", "model/h11/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h11/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h23/attn/strided_slice_11/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h18/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h18/attn/c_proj/Shape", "model/h18/attn/c_proj/strided_slice_1/stack", "model/h18/attn/c_proj/strided_slice_1/stack_1", "model/h18/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h20/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/c_proj/strided_slice_1/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h10/attn/c_proj/strided_slice_1/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h12/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_11/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h22/attn/strided_slice_11/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 2))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/strided_slice_10/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 0))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h6/attn/c_proj/strided_slice_1/stack")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_10/stack_2")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h7/attn/strided_slice_10/stack_1")
        .setOp("Const")
        .putAttr("value", AttrValue.newBuilder()
            .setTensor(tensor1(new int[]{1}, 1))
            .build())
        .putAttr("dtype", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .build());
    add.accept(NodeDef.newBuilder()
        .setName("model/h0/attn/c_proj/strided_slice_1")
        .setOp("StridedSlice")
        .addAllInput(Arrays.asList("model/h0/attn/c_proj/Shape", "model/h0/attn/c_proj/strided_slice_1/stack", "model/h0/attn/c_proj/strided_slice_1/stack_1", "model/h0/attn/c_proj/strided_slice_1/stack_2"))
        .putAttr("Index", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("end_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("T", AttrValue.newBuilder()
            .setType(DataType.forNumber(3))
            .build())
        .putAttr("shrink_axis_mask", AttrValue.newBuilder()
            .setI(1)
            .build())
        .putAttr("new_axis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("begin_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .putAttr("ellipsis_mask", AttrValue.newBuilder()
            .setI(0)
            .build())
        .build());
  }

}
