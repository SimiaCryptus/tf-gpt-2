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

import com.simiacryptus.text.LanguageCodeModel;
import com.simiacryptus.text.SumModel;
import com.simiacryptus.text.TextGenerator;
import com.simiacryptus.util.Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipFile;

public class GPT2Util {

  private static final String MODEL_URL_BASE = System.getProperty(
      "GPT2_MODEL_URL",
      "https://s3-us-west-2.amazonaws.com/simiacryptus/gpt2/");
  private static final TextGenerator prototype = get345M().setVerbose(false);

  @Nonnull
  public static TextGenerator get345M() {
    return new TextGenerator(50257, getModel_345M(), getCodec_345M());
  }

  @Nonnull
  public static GPT2Codec getCodec_345M() {
    return new GPT2Codec(getEncoderFile_345M(), 50257);
  }

  @Nonnull
  public static File getEncoderFile_345M() {
    return loadZippedInternetFile(MODEL_URL_BASE + "encoder_345M.zip", "encoder_345M.json");
  }

  @Nonnull
  public static File getGraphFile_345M() {
    return loadRawInternetFile(MODEL_URL_BASE, "345M.pb");
  }

  @Nonnull
  public static GPT2Model getModel_345M() {
    return getModel_345M(getGraphFile_345M());
  }

  @Nonnull
  public static TextGenerator getTextGenerator() {
    return prototype.copy();
  }

  public @Nonnull
  static File loadZippedInternetFile(@Nonnull String zipUrl, @Nonnull String pathname) {
    File encoderFile = new File(pathname);
    if (new File(encoderFile.getName()).exists()) {
      encoderFile = new File(encoderFile.getName());
    } else {
      try {
        try (ZipFile zipFile = new ZipFile(Util.cacheFile(new URI(zipUrl)))) {
          byte[] graphDefBytes = IOUtils.toByteArray(zipFile.getInputStream(zipFile.getEntry(pathname)));
          encoderFile = new File(encoderFile.getName());
          FileUtils.writeByteArrayToFile(encoderFile, graphDefBytes);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return encoderFile;
  }

  public @Nonnull
  static File loadRawInternetFile(String urlBase, @Nonnull String fileName) {
    File graphFile = new File(fileName);
    if (new File(graphFile.getName()).exists()) {
      graphFile = new File(graphFile.getName());
    } else {
      try {
        graphFile = Util.cacheFile(new URI(urlBase + fileName));
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return graphFile;
  }

  @Nonnull
  public static GPT2Model getModel_345M(@Nonnull File file) {
    return getModel_345M("345M", file);
  }

  @Nonnull
  public static GPT2Model getModel_345M(String name, @Nonnull File file) {
    return new GPT2Model(name, new GPT2Edit_345M(), file, getCodec_345M());
  }

  @Nonnull
  public static TextGenerator getTextGenerator(@Nonnull TextGenerator textGenerator, @Nullable String characterWhitelist, @Nullable URI wordlist) throws IOException, NoSuchAlgorithmException, KeyManagementException {
    TreeSet<String> wordList = null == wordlist ? null : new TreeSet<>(
        Arrays.stream(FileUtils.readFileToString(Util.cacheFile(wordlist), "UTF-8").split("\\s+"))
            .map(x -> x.trim().toLowerCase()).collect(Collectors.toSet())
    );
    textGenerator.getModel().setFilterFn((prefix, txt) -> {
      if (null != characterWhitelist && !characterWhitelist.isEmpty() &&
          txt.matches(".*[^" + characterWhitelist + "].*")) return false;
      String[] words = txt.split("[^\\w]+");
      if (null != wordList && !wordList.isEmpty())
        for (int i = 0; i < words.length; i++) {
          String word = words[i].toLowerCase();
          if (word.isEmpty()) continue;
          if (i < words.length - 1 && !wordList.contains(word)) return false;
          else {
            if (wordList.contains(word)) continue;
            String floor = wordList.floor(word);
            if (null != floor && floor.startsWith(word)) continue;
            String ceiling = wordList.ceiling(word);
            if (null != ceiling && ceiling.startsWith(word)) continue;
            return false;
          }
        }
      return true;
    });
    return textGenerator;
  }

  @Nonnull
  public static TextGenerator getTextGenerator(String... seeds) {
    return getTextGenerator(get345M().setVerbose(false), seeds);
  }

  @Nonnull
  public static TextGenerator getTextGenerator(@Nonnull TextGenerator base, String... seeds) {
    ArrayList<LanguageCodeModel> languageCodeModels = new ArrayList<>();
    return getTextGenerator(base, languageCodeModels, seeds);
  }

  @Nonnull
  public static TextGenerator getTextGenerator(@Nonnull TextGenerator base, @Nonnull List<LanguageCodeModel> languageCodeModels, @Nonnull String... seeds) {
    base.setModel(new SumModel(Stream.concat(
        Arrays.stream(seeds).map(seed -> {
          TextGenerator copy = base.copy();
          copy.feed(seed);
          return copy.getModel();
        }),
        languageCodeModels.stream()
    ).toArray(i -> new LanguageCodeModel[i])));
    return base;
  }

  @Nonnull
  protected static TextGenerator getTextGenerator(String characterWhitelist, URI wordlist) throws IOException, NoSuchAlgorithmException, KeyManagementException {
    return getTextGenerator(getTextGenerator(), characterWhitelist, wordlist);
  }
}
