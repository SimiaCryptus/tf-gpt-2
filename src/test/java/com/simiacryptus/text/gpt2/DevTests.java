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

import com.simiacryptus.ref.lang.RefUtil;
import com.simiacryptus.tensorflow.GraphModel;
import com.simiacryptus.tensorflow.TFUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tensorflow.Output;
import org.tensorflow.TensorFlowException;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Arrays;
import java.util.Map;

import static com.simiacryptus.tensorflow.TFUtil.find;

/**
 * The type Dev tests.
 */
public class DevTests {

  /**
   * Model home file.
   *
   * @return the file
   */
  @Nonnull
  public static File modelHome() {
    return new File(System.getProperty("MODEL_HOME", "H:\\SimiaCryptus\\data-science-tools\\gpt-2\\models"));
  }

  /**
   * Summary json.
   *
   * @throws Exception the exception
   */
  @Test
  public void summaryJson() throws Exception {
    TestUtil.open("345M.", new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M" + ".pb"))));
    TestUtil.open("345M_Init.", new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M_Init" + ".pb"))));
  }

  /**
   * Compare init.
   */
  @Test
  public void compare_init() {
    final GraphModel a = new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M" + ".pb")));
    final GraphModel b = new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M_Init" + ".pb")));
//    TestUtil.open("345M.", a);
//    TestUtil.open("345M_Init.", b);
//    TestUtil.open("345M_cmp.", b.compare(a));
    new GraphComparer().compare(a, b);
  }

  /**
   * Test init.
   *
   * @throws Exception the exception
   */
  @Test
  public void test_init() throws Exception {
    final GraphModel a = new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M" + ".pb")));
    final GraphModel b = new GraphModel(GPT2Model.loadModel(new File(modelHome(), "345M_Init" + ".pb")));
    final GraphModel edited = new GraphModel(new GPT2Edit_345M().edit(a.graphDef, "", true).toByteArray());
    TestUtil.open("345M_edit.", edited);
    final Map<String, GraphModel.DeltaRecord> compare = b.compare(edited);
    TestUtil.open("345M_test.", compare);
    compare.values().forEach(deltaRecord -> {
      System.out.println("left=" + (null == deltaRecord.left ? "null" : deltaRecord.left.getNodeDef()));
      System.out.println("right=" + (null == deltaRecord.right ? "null" : deltaRecord.right.getNodeDef()));
    });
  }

  /**
   * Add gradient.
   *
   * @throws Exception the exception
   */
  @Test
  public void addGradient() throws Exception {
    Assertions.assertThrows(TensorFlowException.class, () -> {
      try {
        byte[] originalGraphDef = GPT2Model.loadModel(new File(modelHome(), "345M" + ".pb"));
        byte[] newGraphDef = TFUtil.editGraph(originalGraphDef, graph -> {
          graph.addGradients("gradient_", new Output[]{
              find(graph, "model/Reshape_1").output(0),
              find(graph, "model/stack").output(0)
          }, new Output[]{
              find(graph, "input_past").output(0)
          }, null);
        });
        System.out.println("GPT2Model: " + TFUtil.toJson(new GraphModel(newGraphDef)));
      } catch (Throwable e) {
        e.printStackTrace();
        throw e;
      }
    });
  }

  /**
   * Encode.
   */
  @Test
  public void encode() {
    GPT2Codec encoder = new GPT2Codec(new File(modelHome(), "345M" + "\\encoder.json"), 50257);
    for (String text : Arrays.asList(
        "This is a test",
        "<|endoftext|>"
    )) {
      System.out.println(text + " => " + RefUtil.get(encoder.encode(text).stream().map(x -> x.toString()).reduce((a, b) -> a + ", " + b)));
    }
  }

}
