package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * A class the reads and returns a string with the text contained in a given file
 */
public class TextReader {

  /**
   *
   * @param filePath the URL of the file to be read
   * @return a single string with the text from the given file
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   */
  public String readFile(String filePath)
    throws IOException, FileNotFoundException {
    File file = new File(filePath);

    if (file.exists()) {
      BufferedReader bufferedReader = Files.newBufferedReader(
        file.toPath(),
        Charset.forName("UTF-8")
      );

      String fileString;
      StringBuilder stringBuilder = new StringBuilder();

      while ((fileString = bufferedReader.readLine()) != null) {
        stringBuilder.append(fileString);
        stringBuilder.append("\n");
      }

      bufferedReader.close();

      return stringBuilder.toString();
    } else {
      throw new FileNotFoundException();
    }
  }
}
