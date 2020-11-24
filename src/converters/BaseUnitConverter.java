package converters;

import models.MeasureType;

/**
 * A class that, differently from the AbstractConverter, converts (returns) its base unit value,
 * since the class is the actual base unit
 */
public class BaseUnitConverter extends AbstractConverter {

  public BaseUnitConverter(MeasureType type, boolean acceptsNegativeNumbers) {
    super(type, acceptsNegativeNumbers);
  }

  /**
   *
   * @param value the baseUnit itself
   * @return its baseUnit parameter
   */
  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit;
  }

  /**
   *
   * @param value the value itself
   * @return its value parameter
   */
  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value;
  }
}
