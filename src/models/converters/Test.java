package models.converters;

import models.IConverter;
import models.MeasureType;

public class Test extends IConverter {

  public Test(MeasureType type) {
    super(type);
  }

  public double fromBasicUnit(double baseUnit) {
    return 10.0;
  }

  public double toBasicUnit(double value) {
    return 10.0;
  }
}
