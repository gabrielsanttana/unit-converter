package converters;

import models.MeasureType;

public class InchConverter extends BaseUnitConverter {

  public InchConverter() {
    super(MeasureType.AREA, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
  	if (!isInputValid(baseUnit))
  		return Double.NaN;
  	
    return baseUnit * 39.3701;
  }

  @Override
  public double toBasicUnit(double value) {
  	if (!isInputValid(value))
  		return Double.NaN;
  	
    return value * 0.0254;
  }
}
