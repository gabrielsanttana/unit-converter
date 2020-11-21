package converters;

import models.MeasureType;

public class HectometreConverter extends AbstractConverter {

  public HectometreConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit / 100;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 100;
  }
}
