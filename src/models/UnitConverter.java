package models;

import java.lang.reflect.InvocationTargetException;

public class UnitConverter {
	
	public void convert(Class<IConverter> fromUnit, Class<IConverter> toUnit,
			double fromValue) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		IConverter fromUnitConverter = fromUnit.getDeclaredConstructor().newInstance();
		System.out.println(fromUnitConverter.toString());
	}
}
