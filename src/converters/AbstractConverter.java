package converters;

import models.MeasureType;

public abstract class AbstractConverter {

  public final MeasureType type;

  public AbstractConverter(MeasureType type) {
    this.type = type;
  }

  public abstract double fromBasicUnit(double baseUnit);

  public abstract double toBasicUnit(double value);

  @Override
  public String toString() {
    return this.type.getBasicUnit() + " [" + this.type.getType() + "]";
  }
}
