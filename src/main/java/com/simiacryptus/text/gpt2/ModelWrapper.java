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
import java.util.function.BiFunction;

public abstract class ModelWrapper implements LanguageCodeModel {
  protected final LanguageCodeModel[] children;

  public ModelWrapper(LanguageCodeModel... children) {
    this.children = children;
  }

  @Override
  public LanguageCodeModel copy() {
    return new SumModel(Arrays.stream(children)
        .map(LanguageCodeModel::copy)
        .toArray(i -> new LanguageCodeModel[i]));
  }

  @Override
  public LanguageCodeModel resetState() {
    for (LanguageCodeModel child : children) {
      child.resetState();
    }
    return this;
  }

  @Override
  public abstract float[] eval(int data_X);

  @Override
  public BiFunction<String, String, Boolean> getFilterFn() {
    return children[0].getFilterFn();
  }

  @Override
  public LanguageCodeModel setFilterFn(BiFunction<String, String, Boolean> filterFn) {
    for (LanguageCodeModel child : children) {
      child.setFilterFn(filterFn);
    }
    return this;
  }
}
