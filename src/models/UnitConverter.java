package models;

import converters.AbstractConverter;
import exceptions.ConversionErrorException;

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
   * @throws ConversionErrorException
   * @throws Exception
   */
  public double convert(
    AbstractConverter fromUnitConverter,
    AbstractConverter toUnitConverter,
    double fromValue
  ) throws ConversionErrorException, Exception {
    double returnValue = toUnitConverter.fromBasicUnit(
      fromUnitConverter.toBasicUnit(fromValue)
    );

    return returnValue;
  }
}
