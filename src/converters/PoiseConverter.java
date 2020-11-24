package converters;

import models.MeasureType;

public class PoiseConverter extends AbstractConverter {

  public PoiseConverter() {
    super(MeasureType.VISCOSITY, true);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit * 10;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value / 10;
  }
}
