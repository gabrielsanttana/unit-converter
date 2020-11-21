package converters;

import models.MeasureType;

public class MilliSecondConverter extends AbstractConverter {

  public MilliSecondConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit / 1000;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 1000;
  }
}
