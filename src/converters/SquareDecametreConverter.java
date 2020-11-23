package converters;

import models.MeasureType;

public class SquareDecametreConverter extends AbstractConverter {

  public SquareDecametreConverter() {
    super(MeasureType.AREA);
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
