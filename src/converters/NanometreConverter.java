package converters;

import models.MeasureType;

public class NanometreConverter extends BaseUnitConverter {

  public NanometreConverter() {
    super(MeasureType.AREA);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 1000 * 1000 * 1000;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / (1000 * 1000 * 1000);
  }
}
