package converters;

import models.MeasureType;

/**
 * A class that, differently from the AbstractConverter, converts (returns) its base unit value,
 * since the class is the actual base unit
 */
public class BaseUnitConverter extends AbstractConverter {

  public BaseUnitConverter(MeasureType type) {
    super(type);
  }

  /**
   *
   * @param value the baseUnit itself
   * @return its baseUnit parameter
   */
  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit;
  }

  /**
   *
   * @param value the value itself
   * @return its value parameter
   */
  @Override
  public double toBasicUnit(double value) {
    return value;
  }
}
