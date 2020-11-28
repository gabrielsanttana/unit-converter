package converters;

import exceptions.ConversionErrorException;
import models.MeasureType;

public class MillijouleConverter extends AbstractConverter {

  public MillijouleConverter() {
    super(MeasureType.ENERGY, false);
  }

  @Override
  public double fromBasicUnit(double baseUnit)
    throws ConversionErrorException, IllegalArgumentException {
    return baseUnit / 1000;
  }

  @Override
  public double toBasicUnit(double value)
    throws ConversionErrorException, IllegalArgumentException {
    return value * 1000;
  }
}
