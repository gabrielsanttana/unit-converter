package converters;

import exceptions.ConversionErrorException;
import models.MeasureType;

public class RealConverter extends AbstractConverter {

  public RealConverter() {
    super(MeasureType.CURRENCY, true);
  }

  @Override
  public double fromBasicUnit(double baseUnit)
    throws ConversionErrorException, IllegalArgumentException {
    return baseUnit * 6;
  }

  @Override
  public double toBasicUnit(double value)
    throws ConversionErrorException, IllegalArgumentException {
    return value / 6;
  }
}
