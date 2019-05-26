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

import com.simiacryptus.util.Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.URI;
import java.util.zip.ZipFile;

public class GPT2Util {

  @NotNull
  public static TextGenerator get345M() {
    return new TextGenerator(50257, getModel_345M(getGraphFile_345M()), getCodec_345M());
  }

  @NotNull
  protected static GPT2Codec getCodec_345M() {
    return new GPT2Codec(getEncoderFile_345M());
  }

  @NotNull
  public static File getEncoderFile_345M() {
    return loadZippedInternetFile("https://s3-us-west-2.amazonaws.com/simiacryptus/gpt2/encoder_345M.zip", "encoder_345M.json");
  }

  @NotNull
  public static File getGraphFile_345M() {
    return loadRawInternetFile("https://s3-us-west-2.amazonaws.com/simiacryptus/gpt2/", "345M.pb");
  }

  public @NotNull
  static File loadZippedInternetFile(String zipUrl, String pathname) {
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

  public @NotNull
  static File loadRawInternetFile(String urlBase, String fileName) {
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

  @NotNull
  public static GPT2Model getModel_345M(File file) {
    return getModel_345M("345M", file);
  }

  @NotNull
  public static GPT2Model getModel_345M(String name, File file) {
    return new GPT2Model(name, new GPT2Edit_345M(), file, getCodec_345M());
  }
}
