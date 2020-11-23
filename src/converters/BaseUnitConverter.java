package converters;

import models.MeasureType;

public class BaseUnitConverter extends AbstractConverter {

  public BaseUnitConverter(MeasureType type) {
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
