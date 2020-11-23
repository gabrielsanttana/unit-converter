package controllers;

import converters.AbstractConverter;
import java.util.List;
import models.ClassSeeker;
import models.NumberFormatter;
import models.UnitConverter;

/**
 * A class the servers as an interface between the views and the methods of the models
 */
public class Controller {

  /**
   * Looks for and returns a list with the converter classes
   * @return a list with the converter classes
   * @throws ClassNotFoundException
   */
  public List<Class<AbstractConverter>> lookForConverterClasses()
    throws ClassNotFoundException {
    try {
      ClassSeeker classSeeker = new ClassSeeker();

      return classSeeker.lookForConverterClasses();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Formats and returns doubles
   * @param number
   * @return a string with the formatted number
   */
  public String formatDouble(double number) {
    NumberFormatter formatter = new NumberFormatter();

    return formatter.formatDouble(number);
  }

  /**
   * Converts and returns a value from a given unit type into another
   * @param fromUnitConverter the unit type to be converted
   * @param toUnitConverter the unit type to be returned
   * @param fromValue the value to be converted
   * @return the converted value
   * @throws Exception
   */
  public String convert(
    AbstractConverter fromUnit,
    AbstractConverter toUnit,
    double fromValue
  ) throws Exception {
    UnitConverter unitConverter = new UnitConverter();

    return unitConverter.convert(fromUnit, toUnit, fromValue);
  }
}
