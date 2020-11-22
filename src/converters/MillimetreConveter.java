package converters;

import models.MeasureType;

public class MillimetreConveter extends AbstractConverter {

  public MillimetreConveter(MeasureType type) {
    super(type);
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
