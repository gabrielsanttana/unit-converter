package converters;

import models.MeasureType;

public class HourConverter extends AbstractConverter {

  public HourConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit / (60 * 60);
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 60 * 60;
  }
}
