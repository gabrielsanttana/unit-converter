package converters;

import models.MeasureType;

public class KilometreHourConverter extends AbstractConverter {

  public KilometreHourConverter(MeasureType type) {
    super(type);
  }

  @Override
  public double fromBasicUnit(double baseUnit) {
    return baseUnit * 3.6;
  }

  @Override
  public double toBasicUnit(double value) {
    return value / 3.6;
  }
}
