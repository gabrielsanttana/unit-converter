package converters;

import models.MeasureType;

public class PoiseConverter extends AbstractConverter {

  public PoiseConverter() {
    super(MeasureType.VISCOSITY);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 10;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 10;
  }
}
