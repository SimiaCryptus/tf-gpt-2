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

/**
 * The type Temperature wrapper.
 */
public class TemperatureWrapper extends ModelWrapper {

  private double value;

  /**
   * Instantiates a new Temperature wrapper.
   *
   * @param value the value
   * @param child the child
   */
  public TemperatureWrapper(double value, LanguageCodeModel child) {
    super(child);
    this.value = value;
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  public double getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(double value) {
    this.value = value;
  }

  @Override
  public float[] eval(int data_X) {
    LanguageCodeModel child = children[0];
    float[] floats = child.eval(data_X);
    for (int i = 0; i < floats.length; i++) {
      floats[i] = (float) Math.pow(floats[i], getValue());
    }
    SumModel.normalize(floats);
    return floats;
  }
}
