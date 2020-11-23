package converters;

import models.MeasureType;

public class DecaNewtonConverter extends AbstractConverter {

  public DecaNewtonConverter() {
    super(MeasureType.FORCE);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit / 10;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 10;
  }
}
