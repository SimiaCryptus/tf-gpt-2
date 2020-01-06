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

import com.simiacryptus.ref.wrappers.RefString;
import com.simiacryptus.text.gpt2.GPT2Codec;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TextGenerator {
  protected static final Logger logger = LoggerFactory.getLogger(TextGenerator.class);
  protected final int vocabularySize;
  protected final GPT2Codec codec;
  protected boolean verbose = false;
  protected int choicesToLog = 10;
  List<Integer> codes = new ArrayList<>();
  float[] nextSelections;
  private LanguageCodeModel model;

  public TextGenerator(int vocabularySize, LanguageCodeModel model, GPT2Codec codec) {
    this.setModel(model);
    this.vocabularySize = vocabularySize;
    this.codec = codec;
  }

  public int getChoicesToLog() {
    return choicesToLog;
  }

  public TextGenerator setChoicesToLog(int choicesToLog) {
    this.choicesToLog = choicesToLog;
    return this;
  }

  public LanguageCodeModel getModel() {
    return model;
  }

  public TextGenerator setModel(LanguageCodeModel model) {
    if (this.model == model) return this;
    if (null != this.model) this.model.clear();
    this.model = model;
    return this;
  }

  public String getText() {
    return codec.decode(codes.toArray(new Integer[]{}));
  }

  public int getVocabularySize() {
    return vocabularySize;
  }

  public boolean isVerbose() {
    return verbose;
  }

  public TextGenerator setVerbose(boolean verbose) {
    this.verbose = verbose;
    return this;
  }

  public static int[] sortedIndices(float[] chosen, int limit) {
    return IntStream.range(0, chosen.length)
        .mapToObj(x -> x)
        .sorted(Comparator.comparing(c -> -chosen[c]))
        .limit(limit)
        .mapToInt(x -> x)
        .toArray();
  }

  public TextGenerator copy() {
    TextGenerator copy = new TextGenerator(vocabularySize, getModel().copy(), codec);
    copy.codes.addAll(this.codes);
    copy.verbose = this.verbose;
    copy.choicesToLog = this.choicesToLog;
    copy.nextSelections = null == this.nextSelections ? null : Arrays.copyOf(this.nextSelections, this.nextSelections.length);
    return copy;
  }

  @NotNull
  public String generateText(Predicate<String> terminator) {
    return generateText(terminator, null);
  }

  @NotNull
  public String generateText(int numberOfWords) {
    return generateText(numberOfWords, null);
  }

  @NotNull
  public String generateText(Predicate<String> terminator, String prefix) {
    reset();
    feed(prefix);
    generate(terminator);
    return getText();
  }

  @NotNull
  public String generateText(int numberOfTokens, String prefix) {
    reset();
    feed(prefix);
    generate(numberOfTokens);
    return getText();
  }

  public String generate(Predicate<String> fn) {
    init();
    ArrayList<Integer> theseCodes = new ArrayList<>();
    try {
      for (int wordIndex = 0; wordIndex == 0 || fn.test(codec.decode(theseCodes.toArray(new Integer[]{}))); wordIndex++) {
        int selected = select(nextSelections);
        if (isVerbose()) {
          if (wordIndex != 0) log(nextSelections, codec, getChoicesToLog());
          logger.info(RefString.format("Selected New Text: '%s'", codec.decode(selected)));
        }
        if (selected == getVocabularySize() - 1) break;
        codes.add(selected);
        theseCodes.add(selected);
        nextSelections = getModel().eval(selected);
      }
    } catch (Throwable e) {
      //logger.warn("Error generating text", e);
      throw new RuntimeException("Error generating text: " + codec.decode(theseCodes.toArray(new Integer[]{})), e);
    }
    return codec.decode(theseCodes.toArray(new Integer[]{}));
  }

  public void generate(int numberOfWords) {
    init();
    try {
      for (int wordIndex = 0; wordIndex < numberOfWords; wordIndex++) {
        int selected = select(nextSelections);
        if (isVerbose()) {
          if (wordIndex != 0) log(nextSelections, codec, getChoicesToLog());
          logger.info(RefString.format("Selected New Text: '%s'", codec.decode(selected)));
        }
        if (selected == getVocabularySize() - 1) break;
        codes.add(selected);
        nextSelections = getModel().eval(selected);
      }
    } catch (Throwable e) {
      logger.warn("Error generating text", e);
    }
  }

  public TextGenerator init() {
    if (nextSelections == null) feed("");
    return this;
  }

  public double feed(String text) {
    double entropy = 0.0;
    List<Integer> codeList = new ArrayList<>();
    codeList.addAll(codec.encode(text));
    if (codeList.isEmpty()) codeList.add(getVocabularySize() - 1);
    for (Integer code : codeList) {
      if (null != nextSelections) {
        float p = nextSelections[code];
        entropy += (p != 0) ? -Math.log(p) : Math.log(getVocabularySize());
      }
      codes.add(code);
      nextSelections = getModel().eval(code);
      if (isVerbose()) {
        logger.info(RefString.format("Feed token: '%s'", codec.decode(code)));
        log(nextSelections, codec, getChoicesToLog());
      }
    }
    return entropy / Math.log(2);
  }

  public TextGenerator reset() {
    codes.clear();
    getModel().clear();
    return this;
  }

  protected int select(float[] chosen) {
    double originalFate = Math.random() * (1);
    double fate = originalFate;
    int j = 0;
    int[] topCandidates = sortedIndices(chosen, chosen.length);
    while (j < topCandidates.length && (fate > chosen[topCandidates[j]])) {
      int topCandidate = topCandidates[j++];
      fate -= chosen[topCandidate];
    }
    int topCandidate = topCandidates[j];
    logger.debug(RefString.format("Chose #%s with fate %s", topCandidate, originalFate));
    return topCandidate;
  }

  protected void log(float[] chosen, GPT2Codec codec, int count) {
    Arrays.stream(sortedIndices(chosen, count))
        .forEach(candidate -> logger.info(RefString.format("\t#%d %.4f%% '%s'", candidate, chosen[candidate] * 100, codec.decode(candidate))));
  }
}
