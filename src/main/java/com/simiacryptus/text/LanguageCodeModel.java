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

import org.tensorflow.Tensor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BiFunction;

public interface LanguageCodeModel {
  @Nullable
  BiFunction<String, String, Boolean> getFilterFn();

  @Nonnull
  LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn);

  @Nonnull
  LanguageCodeModel copy();

  @Nonnull
  LanguageCodeModel clear();

  float[] eval(int data_X);

  @Nullable
  Tensor<?> state();
}
