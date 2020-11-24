package converters;

import models.MeasureType;

public class KilometreHourConverter extends BaseUnitConverter {

  public KilometreHourConverter() {
    super(MeasureType.SPEED, true);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit * 3.6;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value / 3.6;
  }
}
