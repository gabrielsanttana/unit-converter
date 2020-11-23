package models;

import converters.AbstractConverter;

/**
 * A class that converts values from a unit into another
 */
public class UnitConverter {

  /**
   * Converts and returns a value from a given unit type into another
   * @param fromUnitConverter the unit type to be converted
   * @param toUnitConverter the unit type to be returned
   * @param fromValue the value to be converted
   * @return the converted value
   * @throws Exception
   */
  public String convert(
    AbstractConverter fromUnitConverter,
    AbstractConverter toUnitConverter,
    double fromValue
  ) throws Exception {
    double returnValue = toUnitConverter.fromBasicUnit(
      fromUnitConverter.toBasicUnit(fromValue)
    );

    NumberFormatter formatter = new NumberFormatter();
    String returnValueFormatted = formatter.formatDouble(returnValue);

    return returnValueFormatted;
  }
}
