package converters;

import models.MeasureType;

public class CentiPoiseConverter extends AbstractConverter {

  public CentiPoiseConverter() {
    super(MeasureType.VISCOSITY);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 1000;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 1000;
  }
}
