package converters;

import models.MeasureType;

public class DecilitreConverter extends BaseUnitConverter {

  public DecilitreConverter() {
    super(MeasureType.VOLUME);
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
