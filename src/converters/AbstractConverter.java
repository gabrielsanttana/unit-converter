package converters;

import exceptions.ConversionErrorException;
import models.MeasureType;

/**
 * An abstract class that holds the schema that all other converter classes will inherit
 */
public abstract class AbstractConverter {

  public final MeasureType type;
  public final boolean acceptsNegativeNumbers;

  public AbstractConverter(MeasureType type, boolean acceptsNegativeNumbers) {
    this.type = type;
    this.acceptsNegativeNumbers = acceptsNegativeNumbers;
  }

  /**
   *
   * @param baseUnit the number from the base unit to be converted
   * @return the converted number
   * @throws ConversionErrorException
   */
  public abstract double fromBasicUnit(double baseUnit)
    throws ConversionErrorException, IllegalArgumentException;

  /**
   *
   * @param value the number to be converted to the base unit
   * @return the converted number
   * @throws ConversionErrorException
   */
  public abstract double toBasicUnit(double value)
    throws ConversionErrorException, IllegalArgumentException;

  /**
   *
   * @param value the number to be checked
   * @return whether or not the given number is a valid input
   * @throws ConversionErrorException
   * @throws IllegalArgumentException
   */
  public boolean isInputValid(double value) {
    if (!this.acceptsNegativeNumbers) {
      if (value >= 0) return true; else throw new IllegalArgumentException();
    }

    return true;
  }

  /**
   * Returns a string with the unit type of the converter
   */
  @Override
  public String toString() {
    return this.type.getBasicUnit() + " [" + this.type.getType() + "]";
  }
}
