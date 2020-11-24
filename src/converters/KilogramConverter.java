package converters;

import models.MeasureType;

public class KilogramConverter extends BaseUnitConverter {

  public KilogramConverter() {
    super(MeasureType.MASS, false);
  }
}
