package converters;

import models.MeasureType;

public class CentimetrePerSecondSquaredConverter extends AbstractConverter {

  public CentimetrePerSecondSquaredConverter() {
    super(MeasureType.ACCELERATION);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 100;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 100;
  }
}
