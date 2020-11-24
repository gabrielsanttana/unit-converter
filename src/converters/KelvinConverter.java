package converters;

import models.MeasureType;

public class KelvinConverter extends BaseUnitConverter {

  public KelvinConverter() {
    super(MeasureType.TEMPERATURE, false);
  }
}
