package models;

public enum MeasureType {
	
	DISTANCE("distance", "metre (m)"),
	AREA("area", "square metre (m²)"),
	VOLUME("volume", "litre (L)"),
	MASS("mass", "kilogram (kg)"),
	TIME("time", "second (s)"),
	SPEED("speed", "m/s"),
	ACCELERATION("acceleration", "m/s²"),
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
	
	private MeasureType(String type, String basicUnit) {
		this.type = type;
		this.basicUnit = basicUnit;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getBasicUnit() {
		return this.basicUnit;
	}
}
