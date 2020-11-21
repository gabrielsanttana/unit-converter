package models;

public class UnitConverter {
	
	public void convert(Class<IConverter> fromUnit, Class<IConverter> toUnit,
			double fromValue) throws Exception {
		
		IConverter fromUnitConverter = fromUnit.getDeclaredConstructor().newInstance();
		System.out.println(fromUnitConverter.toString());
	}
}
