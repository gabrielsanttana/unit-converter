package converters;

import models.MeasureType;

public class CentilitreConverter extends BasicConverter {

  public CentilitreConverter() {
    super(MeasureType.VOLUME);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 100;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 100;
  }
}
