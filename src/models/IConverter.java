package models;

public abstract class IConverter {
	
	public final MeasureType type;
	
	public IConverter(MeasureType type) {
		this.type = type;
	}
	
	public abstract double fromBasicUnit(double baseUnit);
	
	public abstract double toBasicUnit(double value);
}
