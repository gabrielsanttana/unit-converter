package converters;

import models.MeasureType;

public class CentiPoiseConverter extends AbstractConverter {

  public CentiPoiseConverter() {
    super(MeasureType.VISCOSITY, true);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    if (!isInputValid(baseUnit)) return Double.NaN;

    return baseUnit * 1000;
  }

  @Override
  public double toBasicUnit(double value) {
    if (!isInputValid(value)) return Double.NaN;

    return value / 1000;
  }
}
