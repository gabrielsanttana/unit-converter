package converters;

import models.MeasureType;

public class PoiseuilleConverter extends AbstractConverter {

  public PoiseuilleConverter() {
    super(MeasureType.VISCOSITY);
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
