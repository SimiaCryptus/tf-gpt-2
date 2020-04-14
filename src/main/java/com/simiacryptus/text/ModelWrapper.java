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
import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * The type Model wrapper.
 */
public abstract class ModelWrapper implements LanguageCodeModel {
  /**
   * The Children.
   */
  protected final LanguageCodeModel[] children;

  /**
   * Instantiates a new Model wrapper.
   *
   * @param children the children
   */
  public ModelWrapper(LanguageCodeModel... children) {
    this.children = children;
  }

  @Override
  public BiFunction<String, String, Boolean> getFilterFn() {
    return children[0].getFilterFn();
  }

  @Nonnull
  @Override
  public LanguageCodeModel copy() {
    return new SumModel(Arrays.stream(children)
        .map(languageCodeModel -> languageCodeModel.copy())
        .toArray(i -> new LanguageCodeModel[i]));
  }

  @Nonnull
  @Override
  public LanguageCodeModel clear() {
    for (LanguageCodeModel child : children) {
      child.clear();
    }
    return this;
  }

  @Override
  public abstract float[] eval(int data_X);

  @Nonnull
  @Override
  public LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn) {
    for (LanguageCodeModel child : children) {
      child.setFilterFn(filterFn);
    }
    return this;
  }

  @Override
  public Tensor<?> state() {
    assert 1 == children.length;
    return children[0].state();
  }
}
