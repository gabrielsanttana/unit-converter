package converters;

import models.MeasureType;

public class CentimetreConverter extends AbstractConverter {

  public CentimetreConverter() {
    super(MeasureType.DISTANCE);
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
