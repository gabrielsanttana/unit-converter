package converters;

import models.MeasureType;

public class DecametreConverter extends BaseUnitConverter {

  public DecametreConverter() {
    super(MeasureType.AREA);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit / 10;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 10;
  }
}
