package converters;

import models.MeasureType;

public class BaseUnitConverter extends AbstractConverter {

  public BaseUnitConverter(MeasureType type, boolean acceptsNegativeNumbers) {
    super(type, acceptsNegativeNumbers);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value;
  }
}
