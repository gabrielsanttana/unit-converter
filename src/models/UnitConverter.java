package models;

import converters.AbstractConverter;

public class UnitConverter {
	
	public String convert(AbstractConverter fromUnitConverter,
			AbstractConverter toUnitConverter, double fromValue) throws Exception {
		
		double returnValue = toUnitConverter.fromBasicUnit(fromUnitConverter.toBasicUnit(fromValue));
		
		NumberFormatter formatter = new NumberFormatter();
		String returnValueFormatted = formatter.formatDouble(returnValue);
		
		return returnValueFormatted;
	}
}
