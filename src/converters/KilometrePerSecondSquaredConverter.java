package converters;

import models.MeasureType;

public class KilometrePerSecondSquaredConverter extends AbstractConverter {

  public KilometrePerSecondSquaredConverter() {
    super(MeasureType.ACCELERATION);
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
