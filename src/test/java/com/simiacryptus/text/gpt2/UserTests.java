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

import com.simiacryptus.text.TextGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * The type User tests.
 */
public class UserTests {

//  /**
//   * Tensorboard graph.
//   */
//  @Test
//  public void tensorboardGraph() {
//    String now = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//    try {
//      String id = UUID.randomUUID().toString();
//      File location = new File("target/" + now + "/tensorboard/" + id);
//      File graphFile = GPT2Util.getGraphFile_345M();
//      TestUtil.launchTensorboard(TestUtil.writeGraph(GraphDef.parseFrom(GPT2Model.loadModel(graphFile)), location, id));
//    } catch (IOException e) {
//      throw Util.throwException(e);
//    } catch (URISyntaxException e) {
//      throw Util.throwException(e);
//    }
//  }

  /**
   * Generate unconditional text.
   */
  @Test
  public void generateUnconditionalText() {
    TextGenerator textGenerator = GPT2Util.get345M().setVerbose(false);
    for (double t = 1.0; t < 3; t *= 1.1) {
      textGenerator.getModel();
      System.out.println("Temperature=" + t);
      System.out.println(textGenerator.generateText(150));
    }
  }

  /**
   * Generate conditional text.
   */
  @Test
  public void generateConditionalText() {
    TextGenerator textGenerator = GPT2Util.get345M().setVerbose(false);
    for (double t = 1.0; t < 3; t *= 1.1) {
      textGenerator.getModel();
      System.out.println("Temperature=" + t);
      for (String seed : Arrays.asList(
          "Hello World",
          "The opposite of up is",
          "English: Thank You\nSpanish:",
          "public void main(",
          "The problem with the world is",
          "I love",
          "You people are"
      )) {
        System.out.println(textGenerator.generateText(150, seed));
      }
    }
  }


}


