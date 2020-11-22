package converters;

import models.MeasureType;

public class HourConverter extends BasicConverter {

  public HourConverter() {
    super(MeasureType.TIME);
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
