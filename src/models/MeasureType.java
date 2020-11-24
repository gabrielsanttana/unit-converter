package models;

/**
 * An enumerator that contains all the possible measure types to be converted
 */
public enum MeasureType {
  DISTANCE("distance", "metre (m)"),
  AREA("area", "square metre (m�)"),
  VOLUME("volume", "litre (L)"),
  MASS("mass", "kilogram (kg)"),
  TIME("time", "second (s)"),
  SPEED("speed", "m/s"),
  ACCELERATION("acceleration", "m/s�"),
  FORCE("force", "newton (N)"),
  PRESSURE("pressure", "pascal (Pa)"),
  ENERGY("energy", "joule (J)"),
  POWER("power", "watt (W)"),
  VISCOSITY("viscosity", "pascal-second (Pa-s)"),
  TEMPERATURE("temperature", "kelvin (K)"),
  LUMINOUS_INTENSITY("luminous intensity", "candela (cd)"),
  AMOUNT_OF_SUBSTANCE("amount of substance", "mole (mole)"),
  ELECTRIC_CURRENT("electric current", "ampere (A)"),
  CURRENCY("currency", "dollar ($)");

  private String type;
  private String basicUnit;

  /**
   * Constructs the enum
   * @param type the measurement type
   * @param basicUnit the basic unit of the given measurement type
   */
  private MeasureType(String type, String basicUnit) {
    this.type = type;
    this.basicUnit = basicUnit;
  }

  /**
   * Returns the measure type
   * @return the measure type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Returns the basic unit of the measure type
   * @return the basic unit of the measure type
   */
  public String getBasicUnit() {
    return this.basicUnit;
  }
}
