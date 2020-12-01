package models;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A class that formats double numbers to strings
 */
public class NumberFormatter {

  private static final double UPPER_BOUND = Math.pow(10, 7);
  private static final double LOWER_BOUND = Math.pow(10, -7);

  /**
   * Formats and returns a string from a double
   * @param number the number to be formatted
   * @return the string with the formatted number
   */
  public String formatDouble(double number) {
    if (number >= UPPER_BOUND || (number <= LOWER_BOUND && number > 0)) {
      NumberFormat formatter = new DecimalFormat("0.########E0");

      return formatter.format(number).replaceAll(",", ".");
    } else {
      String formattedNumber = String
        .format("%,.7f", number)
        .replaceAll("[,]", "a");

      formattedNumber =
        formattedNumber.replaceAll("[.]", ",").replaceAll("[a]", ".");

      return formattedNumber.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
    }
  }
}
