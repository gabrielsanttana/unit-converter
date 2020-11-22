package converters;

import models.MeasureType;

public class DecimetreConveter extends AbstractConverter {

  public DecimetreConveter(MeasureType type) {
    super(type);
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
