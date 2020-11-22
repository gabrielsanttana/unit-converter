package converters;

import models.MeasureType;

public class InchConverter extends AbstractConverter {

  public InchConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 39.3701;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 0.0254;
  }
}
