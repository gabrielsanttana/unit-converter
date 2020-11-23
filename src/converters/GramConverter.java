package converters;

import models.MeasureType;

public class GramConverter extends AbstractConverter {

  public GramConverter() {
    super(MeasureType.MASS);
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
