package converters;

import exceptions.ConversionErrorException;
import models.MeasureType;

public class CelsiusConverter extends AbstractConverter {

  public CelsiusConverter() {
    super(MeasureType.TEMPERATURE, true);
  }

  @Override
  public double fromBasicUnit(double baseUnit)
    throws ConversionErrorException, IllegalArgumentException {
    return baseUnit - 273.15;
  }

  @Override
  public double toBasicUnit(double value)
    throws ConversionErrorException, IllegalArgumentException {
    return value + 273.15;
  }
}
