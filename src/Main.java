import controllers.Controller;
import java.util.List;
import models.IConverter;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller();

    Class<IConverter> fromUnit = null, toUnit = null;
    List<Class<IConverter>> classes = null;

    try {
      classes = controller.lookForConverterClasses();
    } catch (Exception e) {}

    if (classes != null) {
      for (Class<IConverter> cls : classes) {
        if (cls.getName().contains("Meter")) {
        	fromUnit = cls;
        } else if (cls.getName().contains("Liter")) {
        	toUnit = cls;
        }
      }
    }
    
    try {
    	controller.convert(fromUnit, toUnit, 10.0);
    } catch(Exception e) {}
  }
}
