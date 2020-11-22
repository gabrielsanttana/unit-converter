package converters;

import models.MeasureType;

public class DecilitreConverter extends AbstractConverter {

  public DecilitreConverter(MeasureType type) {
    super(type);
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
