package converters;

import exceptions.ConversionErrorException;
import models.MeasureType;

public class MillicandelaConverter extends AbstractConverter {

  public MillicandelaConverter() {
    super(MeasureType.LUMINOUS_INTENSITY, false);
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
