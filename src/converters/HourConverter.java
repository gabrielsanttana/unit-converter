package converters;

import models.MeasureType;

public class HourConverter extends BaseUnitConverter {

  public HourConverter() {
    super(MeasureType.TIME, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit / (60 * 60);
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value * 60 * 60;
  }
}
