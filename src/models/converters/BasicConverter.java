package models.converters;

import models.IConverter;
import models.MeasureType;

public class BasicConverter extends IConverter {
	
	public BasicConverter(MeasureType type) {
		super(type);
	}

	@Override
	public double fromBasicUnit(double baseUnit) {
		return baseUnit;
	}

	@Override
	public double toBasicUnit(double value) {
		return value;
	}
}
