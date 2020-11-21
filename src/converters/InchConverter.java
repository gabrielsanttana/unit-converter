package converters;

import models.MeasureType;

public class InchConverter extends AbstractConverter {

  public InchConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 0.0254;
  }

  @Override
  public double toBasicUnit(double value) {
    return value * 39.3701;
  }
}
