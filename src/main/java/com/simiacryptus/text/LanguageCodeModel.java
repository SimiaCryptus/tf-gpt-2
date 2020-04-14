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

/**
 * The interface Language code model.
 */
public interface LanguageCodeModel {
  /**
   * Gets filter fn.
   *
   * @return the filter fn
   */
  @Nullable
  BiFunction<String, String, Boolean> getFilterFn();

  /**
   * Sets filter fn.
   *
   * @param filterFn the filter fn
   * @return the filter fn
   */
  @Nonnull
  LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn);

  /**
   * Copy language code model.
   *
   * @return the language code model
   */
  @Nonnull
  LanguageCodeModel copy();

  /**
   * Clear language code model.
   *
   * @return the language code model
   */
  @Nonnull
  LanguageCodeModel clear();

  /**
   * Eval float [ ].
   *
   * @param data_X the data x
   * @return the float [ ]
   */
  float[] eval(int data_X);

  /**
   * State tensor.
   *
   * @return the tensor
   */
  @Nullable
  Tensor<?> state();
}
