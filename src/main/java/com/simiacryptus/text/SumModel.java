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

import com.simiacryptus.ref.lang.RefUtil;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The type Sum model.
 */
public class SumModel extends ModelWrapper {

  /**
   * Instantiates a new Sum model.
   *
   * @param children the children
   */
  public SumModel(LanguageCodeModel... children) {
    super(children);
  }

  /**
   * Normalize.
   *
   * @param sums the sums
   */
  public static void normalize(@Nonnull float[] sums) {
    double sum = IntStream.range(0, sums.length).mapToDouble(x -> sums[x]).sum();
    for (int i = 0; i < sums.length; i++) sums[i] /= sum;
  }

  @Nonnull
  @Override
  public float[] eval(int data_X) {
    float[] sums = RefUtil.get(Arrays.stream(children).map(c -> c.eval(data_X)).reduce((a, b) -> {
      for (int i = 0; i < a.length; i++) a[i] *= b[i];
      return a;
    }));
    normalize(sums);
    return sums;
  }

}
