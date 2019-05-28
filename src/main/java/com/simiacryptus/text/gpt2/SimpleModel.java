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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SimpleModel implements LanguageCodeModel {

  private final float[] result;

  public SimpleModel(float... result) {
    this.result = Arrays.copyOf(result, result.length);
  }

  public static SimpleModel build(GPT2Codec codec, String text) {
    List<Integer> encode = codec.encode(text);
    Map<Integer, Long> counts = encode.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    float[] result = new float[codec.getVocabSize()];
    for (int i = 0; i < result.length; i++) {
      result[i] = ((float) counts.getOrDefault(i, 0l)) / encode.size();
    }
    return new SimpleModel(result);
  }

  @Override
  public LanguageCodeModel copy() {
    return new SimpleModel(result);
  }

  @Override
  public LanguageCodeModel resetState() {
    return this;
  }

  @Override
  public float[] eval(int data_X) {
    return Arrays.copyOf(result, result.length);
  }

  @Override
  public BiFunction<String, String, Boolean> getFilterFn() {
    return null;
  }

  @Override
  public LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn) {
    return this;
  }

  public LanguageCodeModel setTemperature(double temperature) {
    return this;
  }

}
