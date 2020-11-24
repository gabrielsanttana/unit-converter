package converters;

import models.MeasureType;

public class MetersPerSecondConverter extends BaseUnitConverter {

  public MetersPerSecondConverter() {
    super(MeasureType.SPEED, true);
  }
}
