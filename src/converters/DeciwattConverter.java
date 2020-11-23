package converters;

import models.MeasureType;

public class DeciwattConverter extends AbstractConverter {

  public DeciwattConverter() {
    super(MeasureType.POWER);
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
