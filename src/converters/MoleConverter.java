package converters;

import models.MeasureType;

public class MoleConverter extends BaseUnitConverter {

  public MoleConverter() {
    super(MeasureType.AMOUNT_OF_SUBSTANCE, false);
  }
}
