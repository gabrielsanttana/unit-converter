package converters;

import models.MeasureType;

public class SquareDecametreConverter extends AbstractConverter {

  public SquareDecametreConverter() {
    super(MeasureType.AREA, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit / 100;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value * 100;
  }
}
