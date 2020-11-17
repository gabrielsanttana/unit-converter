package controllers;

import java.util.List;

import models.ClassSeeker;
import models.IConverter;
import models.NumberFormatter;

public class Controller {
	
	public List<Class<IConverter>> lookForConverterClasses() throws ClassNotFoundException {
		
		try {
			ClassSeeker classSeeker = new ClassSeeker();
			
			return classSeeker.lookForConverterClasses();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
  }

public String formatDouble(double number) {
  NumberFormatter formatter = new NumberFormatter();
  
  return formatter.formatDouble(number);
}
  }
