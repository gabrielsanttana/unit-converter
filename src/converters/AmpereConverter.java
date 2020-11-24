package converters;

import models.MeasureType;

public class AmpereConverter extends BaseUnitConverter {

  public AmpereConverter() {
    super(MeasureType.ELECTRIC_CURRENT, true);
  }
}
