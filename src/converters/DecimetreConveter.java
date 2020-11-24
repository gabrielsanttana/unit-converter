package converters;

import models.MeasureType;

public class DecimetreConveter extends BaseUnitConverter {

  public DecimetreConveter() {
    super(MeasureType.AREA, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    if (!isInputValid(baseUnit)) return Double.NaN;

    return baseUnit * 10;
  }

  @Override
  public double toBasicUnit(double value) {
    if (!isInputValid(value)) return Double.NaN;

    return value / 10;
  }
}
