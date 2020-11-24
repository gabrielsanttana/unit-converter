package models;

import utils.lang.Lang;

/**
 * An enumerator that contains all the possible measure types to be converted
 */
public enum MeasureType {
  DISTANCE(Lang.get(Lang.unit_distance), "m"),
  AREA(Lang.get(Lang.unit_area), "m�"),
  VOLUME(Lang.get(Lang.unit_volume), "L"),
  MASS(Lang.get(Lang.unit_mass), "kg"),
  TIME(Lang.get(Lang.unit_time), "s"),
  SPEED(Lang.get(Lang.unit_speed), "m/s"),
  ACCELERATION(Lang.get(Lang.unit_acceleration), "m/s�"),
  FORCE(Lang.get(Lang.unit_force), "N"),
  PRESSURE(Lang.get(Lang.unit_pressure), "Pa"),
  ENERGY(Lang.get(Lang.unit_energy), "J"),
  POWER(Lang.get(Lang.unit_power), "W"),
  VISCOSITY(Lang.get(Lang.unit_viscosity), "Pa-s"),
  TEMPERATURE(Lang.get(Lang.unit_temperature), "K"),
  LUMINOUS_INTENSITY(Lang.get(Lang.unit_luminous_intensity), "cd"),
  AMOUNT_OF_SUBSTANCE(Lang.get(Lang.unit_amount_of_substance), "mole"),
  ELECTRIC_CURRENT(Lang.get(Lang.unit_electric_current), "A"),
  CURRENCY(Lang.get(Lang.unit_currency), "$");

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
