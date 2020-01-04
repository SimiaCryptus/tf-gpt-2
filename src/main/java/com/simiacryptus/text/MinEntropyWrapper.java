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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MinEntropyWrapper extends ModelWrapper {
  protected static final Logger logger = LoggerFactory.getLogger(MinEntropyWrapper.class);
  private final ArrayList<Double> entropyHistory = new ArrayList<>();
  private double value;

  public MinEntropyWrapper(double value, LanguageCodeModel child) {
    super(child);
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public static double entropy(float[] floats) {
    return IntStream.range(0, floats.length).mapToDouble(i -> {
      float p = floats[i];
      return p <= 0 ? 0 : -p * Math.log(p);
    }).sum() / Math.log(2);
  }

  public static float[] powCopy(float[] floats, double value) {
    float[] copy = Arrays.copyOf(floats, floats.length);
    pow(copy, value);
    return copy;
  }

  public static void pow(float[] floats, double value) {
    for (int i = 0; i < floats.length; i++) {
      floats[i] = (float) Math.pow(floats[i], value);
    }
  }

  @Override
  public float[] eval(int data_X) {
    LanguageCodeModel child = children[0];
    float[] floats = child.eval(data_X);
    double entropy = entropy(floats);
    entropyHistory.add(entropy);
    double[] schedule = DoubleStream.iterate(1.0, x -> x * 0.9).limit(1000).toArray();
    for (int i = 0; i < schedule.length; i++) {
      float[] copy = powCopy(floats, schedule[i]);
      SumModel.normalize(copy);
      if (entropy(copy) > value) {
        floats = copy;
        break;
      }
    }
    logger.debug(String.format("Entropy = %s => %s", entropy, entropy(floats)));
    //SumModel.normalize(floats);
    return floats;
  }
}
