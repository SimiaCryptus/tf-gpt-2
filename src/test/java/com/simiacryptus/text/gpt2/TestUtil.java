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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.simiacryptus.tensorflow.TFUtil;
import com.simiacryptus.tensorflow.TensorboardEventWriter;
import com.simiacryptus.util.Util;
import org.tensorflow.framework.GraphDef;

import javax.annotation.Nonnull;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * The type Test util.
 */
public class TestUtil {
  /**
   * Launch tensorboard.
   *
   * @param tensorboardDir the tensorboard dir
   * @throws IOException        the io exception
   * @throws URISyntaxException the uri syntax exception
   */
  public static void launchTensorboard(@Nonnull File tensorboardDir) throws IOException, URISyntaxException {
    TFUtil.launchTensorboard(tensorboardDir.getAbsolutePath(), tensorboard -> {
      try {
        JOptionPane.showConfirmDialog(null, "Press OK to close");
        tensorboard.destroyForcibly();
      } catch (Exception e) {
        throw Util.throwException(e);
      }
    });
  }

  /**
   * Write graph file.
   *
   * @param graphDef the graph def
   * @param location the location
   * @param name     the name
   * @return the file
   * @throws IOException the io exception
   */
  public static File writeGraph(@Nonnull GraphDef graphDef, File location, @Nonnull String name) throws IOException {
    TensorboardEventWriter eventWriter = new TensorboardEventWriter(new File(location, name), graphDef);
    eventWriter.write(graphDef);
    eventWriter.close();
    return location;
  }

  /**
   * Open.
   *
   * @param prefix the prefix
   * @param model  the model
   * @throws IOException the io exception
   */
  public static void open(@Nonnull String prefix, Object model) throws IOException {
    File tempFile = File.createTempFile(prefix, ".json");
    FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
    new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValue(fileOutputStream, model);
    fileOutputStream.close();
    Desktop.getDesktop().open(tempFile);
  }
}
