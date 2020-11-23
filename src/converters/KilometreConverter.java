package converters;

import models.MeasureType;

public class KilometreConverter extends BaseUnitConverter {

  public KilometreConverter() {
    super(MeasureType.DISTANCE);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 1000;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 1000;
  }
}
