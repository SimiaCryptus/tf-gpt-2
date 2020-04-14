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

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * The type Top n wrapper.
 */
public class TopNWrapper extends ModelWrapper {

  private int value;

  /**
   * Instantiates a new Top n wrapper.
   *
   * @param value the value
   * @param child the child
   */
  public TopNWrapper(int value, LanguageCodeModel child) {
    super(child);
    this.value = value;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public int getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public float[] eval(int data_X) {
    LanguageCodeModel child = children[0];
    float[] floats = child.eval(data_X);
    int[] sortedIndices = IntStream.range(0, floats.length)
        .mapToObj(x -> x)
        .sorted(Comparator.comparing(x -> -floats[x]))
        .mapToInt(x -> x)
        .toArray();
    for (int i = value; i < sortedIndices.length; i++) {
      floats[sortedIndices[i]] = 0;
    }
    SumModel.normalize(floats);
    return floats;
  }
}
