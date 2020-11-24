package converters;

import models.MeasureType;

public class CentimetreConverter extends AbstractConverter {

  public CentimetreConverter() {
    super(MeasureType.DISTANCE, false);
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
