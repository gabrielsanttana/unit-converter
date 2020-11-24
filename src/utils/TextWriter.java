package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A class that writes text to .txt files
 */
public class TextWriter {

  /**
   *  Writes the given text on the file from the given URL
   * @param text the text to be written on the file
   * @param filePath the URL of the file to be written
   * @throws java.io.IOException
   */
  public void writeFile(String text, String filePath) throws IOException {

    FileWriter fileWriter = new FileWriter(filePath);
    PrintWriter printWriter = new PrintWriter(fileWriter);

    printWriter.write(text);

    printWriter.close();
    fileWriter.close();
  }
}
