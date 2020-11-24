package converters;

import models.MeasureType;

public class CentilitreConverter extends BaseUnitConverter {

  public CentilitreConverter() {
    super(MeasureType.VOLUME, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    if (!isInputValid(baseUnit)) return Double.NaN;

    return baseUnit * 100;
  }

  @Override
  public double toBasicUnit(double value) {
    if (!isInputValid(value)) return Double.NaN;

    return value / 100;
  }
}
