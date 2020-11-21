package converters;

import models.MeasureType;

public class BasicConverter extends AbstractConverter {

  public BasicConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit;
  }

  @Override
  public double toBasicUnit(double value) {
    return value;
  }
}
