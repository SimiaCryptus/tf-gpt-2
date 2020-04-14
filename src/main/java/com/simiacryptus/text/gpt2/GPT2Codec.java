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

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.simiacryptus.ref.lang.RefUtil;
import com.simiacryptus.ref.wrappers.RefStringBuilder;
import com.simiacryptus.util.Util;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Gpt 2 codec.
 */
public class GPT2Codec {
  /**
   * The constant logger.
   */
  protected static final Logger logger = LoggerFactory.getLogger(GPT2Codec.class);

  /**
   * The Encoder.
   */
  protected final TreeMap<String, Integer> encoder;
  /**
   * The Decoder.
   */
  @Nonnull
  protected final TreeMap<Integer, String> decoder;
  private final int vocabSize;

  /**
   * Instantiates a new Gpt 2 codec.
   *
   * @param encoder   the encoder
   * @param vocabSize the vocab size
   */
  public GPT2Codec(TreeMap<String, Integer> encoder, int vocabSize) {
    this.encoder = encoder;
    this.vocabSize = vocabSize;
    this.decoder = buildDecoder(this.encoder);
  }

  /**
   * Instantiates a new Gpt 2 codec.
   *
   * @param file      the file
   * @param vocabSize the vocab size
   */
  public GPT2Codec(@Nonnull File file, int vocabSize) {
    this(GPT2Codec.loadEncoder(file), vocabSize);
  }

  /**
   * Gets character transformer.
   *
   * @return the character transformer
   */
  @Nonnull
  public static Function<String, String> getCharacterTransformer() {
    Map<Character, Character> byteEncoder = byteEncoder();
    return x -> {
      char[] chars = x.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        chars[i] = byteEncoder.getOrDefault(chars[i], chars[i]);
      }
      return new String(chars);
    };
  }

  /**
   * Gets vocab size.
   *
   * @return the vocab size
   */
  public int getVocabSize() {
    return vocabSize;
  }

  /**
   * Build decoder tree map.
   *
   * @param encoder the encoder
   * @return the tree map
   */
  @Nonnull
  public static TreeMap<Integer, String> buildDecoder(@Nonnull TreeMap<String, Integer> encoder) {
    Stream<Map.Entry<String, Integer>> stream = encoder.entrySet().stream();
    return new TreeMap<>(stream.collect(Collectors.toMap(
        (Map.Entry<String, Integer> e) -> e.getValue(),
        (Map.Entry<String, Integer> e) -> e.getKey()
    )));
  }

  /**
   * Load encoder tree map.
   *
   * @param file the file
   * @return the tree map
   */
  @Nonnull
  public static TreeMap<String, Integer> loadEncoder(@Nonnull File file) {
    try {
      return toMap(FileUtils.readFileToString(file, "UTF-8"), getCharacterTransformer());
    } catch (IOException e) {
      throw Util.throwException(e);
    }
  }

  /**
   * To map tree map.
   *
   * @param jsonTxt    the json txt
   * @param keyEncoder the key encoder
   * @return the tree map
   */
  @Nonnull
  public static TreeMap<String, Integer> toMap(String jsonTxt, @Nonnull Function<String, String> keyEncoder) {
    JsonObject json = new GsonBuilder().create().fromJson(jsonTxt, JsonObject.class);
    return new TreeMap<>(json.keySet().stream().collect(Collectors.toMap(keyEncoder, x -> json.get(x).getAsInt(), (a, b) -> a)));
  }

  /**
   * Byte encoder map.
   *
   * @return the map
   */
  @Nonnull
  public static Map<Character, Character> byteEncoder() {
    try {
      HashMap<Character, Character> characterMap = new HashMap<>();
      for (int c = 0; c < 256; c++) {
        characterMap.put((char) (c + 256), (char) c);
      }
      for (char i = '!'; i < '~'; i++) {
        characterMap.put(i, i);
      }
      for (char i = '¡'; i < '¬'; i++) {
        characterMap.put(i, i);
      }
      for (char i = '®'; i < 'ÿ'; i++) {
        characterMap.put(i, i);
      }
      return characterMap;
    } catch (Throwable e) {
      throw Util.throwException(e);
    }
  }

  /**
   * Decode string.
   *
   * @param msg the msg
   * @return the string
   */
  public String decode(@Nonnull Integer... msg) {
    return Arrays.stream(msg).map(i -> decoder.getOrDefault(i, "<Not Found: " + i + ">")).reduce((a, b) -> a + b).orElseGet(() -> "");
  }

  /**
   * Encode list.
   *
   * @param msg the msg
   * @return the list
   */
  @Nonnull
  public List<Integer> encode(@Nullable String msg) {
    ArrayList<Integer> list = new ArrayList<>();
    if (null != msg && !msg.isEmpty()) {
      RefStringBuilder stringBuffer = new RefStringBuilder(msg);
      while (stringBuffer.length() > 0) {
        Optional<String> codeString = lookup(stringBuffer.toString());
        if (codeString.isPresent()) {
          String key = RefUtil.get(codeString);
          stringBuffer.delete(0, key.length());
          list.add(encoder.get(key));
        } else {
          stringBuffer.delete(0, 1);
        }
      }
    }
    return list;
  }

  /**
   * Lookup optional.
   *
   * @param searchStr the search str
   * @return the optional
   */
  protected Optional<String> lookup(@Nullable String searchStr) {
    if (null == searchStr || searchStr.isEmpty()) return Optional.empty();
    String ceilingKey = encoder.ceilingKey(searchStr);
    String floorKey = encoder.floorKey(searchStr);
    if (null != ceilingKey && !searchStr.startsWith(ceilingKey)) ceilingKey = null;
    if (null != floorKey && !searchStr.startsWith(floorKey)) floorKey = null;
    Optional<String> codeString;
    if (null != ceilingKey || null != floorKey) {
      if (null != ceilingKey && null != floorKey) {
        if (floorKey.length() < ceilingKey.length()) {
          codeString = Optional.of(ceilingKey);
        } else {
          codeString = Optional.of(floorKey);
        }
      } else if (null != ceilingKey) {
        codeString = Optional.of(ceilingKey);
      } else {
        codeString = Optional.of(floorKey);
      }
    } else {
      codeString = Optional.empty();
    }
//        codeString = encoder.keySet().stream()
//            .filter(x -> x.equals(searchStr.substring(0, Math.min(searchStr.length(), x.length()))))
//            .sorted(Comparator.comparing(x -> -x.length()))
//            .findFirst();
    return codeString;
  }
}
