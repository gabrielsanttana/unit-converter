package converters;

import models.MeasureType;

/**
 * An abstract class that holds the schema that all other converter classes will inherit
 */
public abstract class AbstractConverter {

  public final MeasureType type;

  public AbstractConverter(MeasureType type) {
    this.type = type;
  }

  /**
   *
   * @param baseUnit the number from the base unit to be converted
   * @return the converted number
   */
  public abstract double fromBasicUnit(double baseUnit);

  /**
   *
   * @param value the number to be converted to the base unit
   * @return the converted number
   */
  public abstract double toBasicUnit(double value);

  /**
   * Returns a string with the unit type of the converter
   */
  @Override
  public String toString() {
    return this.type.getBasicUnit() + " [" + this.type.getType() + "]";
  }
}
