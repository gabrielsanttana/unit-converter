package converters;

import models.MeasureType;

public class DecalitreConverter extends AbstractConverter {

  public DecalitreConverter(MeasureType type) {
    super(type);
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
