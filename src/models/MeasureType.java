package models;

import utils.lang.Lang;

/**
 * An enumerator that contains all the possible measure types to be converted
 */
public enum MeasureType {
  DISTANCE(Lang.get(Lang.unit_distance), "metre (m)"),
  AREA(Lang.get(Lang.unit_area), "square metre (m²)"),
  VOLUME(Lang.get(Lang.unit_volume), "litre (L)"),
  MASS(Lang.get(Lang.unit_mass), "kilogram (kg)"),
  TIME(Lang.get(Lang.unit_time), "second (s)"),
  SPEED(Lang.get(Lang.unit_speed), "m/s"),
  ACCELERATION(Lang.get(Lang.unit_acceleration), "m/s²"),
  FORCE(Lang.get(Lang.unit_force), "newton (N)"),
  PRESSURE(Lang.get(Lang.unit_pressure), "pascal (Pa)"),
  ENERGY(Lang.get(Lang.unit_energy), "joule (J)"),
  POWER(Lang.get(Lang.unit_power), "watt (W)"),
  VISCOSITY(Lang.get(Lang.unit_viscosity), "pascal-second (Pa-s)"),
  TEMPERATURE(Lang.get(Lang.unit_temperature), "kelvin (K)"),
  LUMINOUS_INTENSITY(Lang.get(Lang.unit_luminous_intensity), "candela (cd)"),
  AMOUNT_OF_SUBSTANCE(Lang.get(Lang.unit_amount_of_substance), "mole (mole)"),
  ELECTRIC_CURRENT(Lang.get(Lang.unit_electric_current), "ampere (A)"),
  CURRENCY(Lang.get(Lang.unit_currency), "dollar ($)");

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
