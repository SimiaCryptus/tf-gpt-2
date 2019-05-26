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

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TextGenerator {
  protected static final Logger logger = LoggerFactory.getLogger(TextGenerator.class);

  protected final GPT2Model model;
  protected final int vocabularySize;
  protected final GPT2Codec codec;
  protected boolean verbose = false;
  protected int choicesToLog = 10;
  List<Integer> codes = new ArrayList<>();
  float[] nextSelections;

  public TextGenerator copy() {
    TextGenerator copy = new TextGenerator(vocabularySize, model.copy(), codec);
    copy.codes.addAll(this.codes);
    copy.verbose = this.verbose;
    copy.choicesToLog = this.choicesToLog;
    copy.nextSelections = this.nextSelections;
    return copy;
  }

  TextGenerator(int vocabularySize, GPT2Model model, GPT2Codec codec) {
    this.model = model;
    this.vocabularySize = vocabularySize;
    this.codec = codec;
  }

  public static int[] sortedIndices(float[] chosen, int limit) {
    return IntStream.range(0, chosen.length)
        .mapToObj(x -> x)
        .sorted(Comparator.comparing(c -> -chosen[c]))
        .limit(limit)
        .mapToInt(x -> x)
        .toArray();
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

  public String getText() {
    return codec.decode(codes.toArray(new Integer[]{}));
  }

  public void generate(Predicate<String> fn) {
    init();
    try {
      for (int wordIndex = 0; fn.test(codec.decode(codes.toArray(new Integer[]{}))); wordIndex++) {
        int selected = select(nextSelections);
        if (isVerbose()) {
          if (wordIndex != 0) log(nextSelections, codec, getChoicesToLog());
          logger.info(String.format("Selected New Text: '%s'", codec.decode(selected)));
        }
        if (selected == getVocabularySize() - 1) break;
        codes.add(selected);
        nextSelections = model.eval(selected);
      }
    } catch (Throwable e) {
      logger.warn("Error generating text", e);
    }
  }

  public void generate(int numberOfWords) {
    init();
    try {
      for (int wordIndex = 0; wordIndex < numberOfWords; wordIndex++) {
        int selected = select(nextSelections);
        if (isVerbose()) {
          if (wordIndex != 0) log(nextSelections, codec, getChoicesToLog());
          logger.info(String.format("Selected New Text: '%s'", codec.decode(selected)));
        }
        if (selected == getVocabularySize() - 1) break;
        codes.add(selected);
        nextSelections = model.eval(selected);
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
      if(null != nextSelections) {
        float p = nextSelections[code];
        entropy += Math.log(p);
      }
      codes.add(code);
      nextSelections = model.eval(code);
      if (isVerbose()) {
        logger.info(String.format("Feed token: '%s'", codec.decode(code)));
        log(nextSelections, codec, getChoicesToLog());
      }
    }
    return entropy;
  }

  public TextGenerator reset() {
    codes.clear();
    getModel().resetState();
    return this;
  }

  protected int select(float[] chosen) {
    double originalFate = Math.random() * (1);
    double fate = originalFate;
    int j = 0;
    int[] topCandidates = sortedIndices(chosen, model.getTopN());
    while (j < topCandidates.length && (fate > chosen[topCandidates[j]])) {
      int topCandidate = topCandidates[j++];
      fate -= chosen[topCandidate];
    }
    int topCandidate = topCandidates[j];
    logger.debug(String.format("Chose #%s with fate %s", topCandidate, originalFate));
    return topCandidate;
  }

  protected void log(float[] chosen, GPT2Codec codec, int count) {
    Arrays.stream(sortedIndices(chosen, count))
        .forEach(candidate -> logger.info(String.format("\t#%d %.4f%% '%s'", candidate, chosen[candidate] * 100, codec.decode(candidate))));
  }

  public boolean isVerbose() {
    return verbose;
  }

  public TextGenerator setVerbose(boolean verbose) {
    this.verbose = verbose;
    return this;
  }

  public GPT2Model getModel() {
    return model;
  }

  public int getVocabularySize() {
    return vocabularySize;
  }

  public int getChoicesToLog() {
    return choicesToLog;
  }

  public TextGenerator setChoicesToLog(int choicesToLog) {
    this.choicesToLog = choicesToLog;
    return this;
  }
}
