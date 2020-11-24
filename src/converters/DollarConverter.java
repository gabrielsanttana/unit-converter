package converters;

import models.MeasureType;

public class DollarConverter extends BaseUnitConverter {

  public DollarConverter() {
    super(MeasureType.CURRENCY, false);
  }
}
