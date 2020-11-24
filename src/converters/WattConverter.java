package converters;

import models.MeasureType;

public class WattConverter extends BaseUnitConverter {

  public WattConverter() {
    super(MeasureType.POWER, false);
  }
}
