package converters;

import models.MeasureType;

public class GramConverter extends AbstractConverter {

  public GramConverter() {
    super(MeasureType.MASS, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit * 1000;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value / 1000;
  }
}
