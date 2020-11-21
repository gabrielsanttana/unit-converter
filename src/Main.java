import controllers.Controller;
import converters.AbstractConverter;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller();

<<<<<<< HEAD
    Class<IConverter> fromUnit = null, toUnit = null;
    List<Class<IConverter>> classes = null;
=======
    List<Class<AbstractConverter>> classes = null;
>>>>>>> master

    try {
      classes = controller.lookForConverterClasses();
    } catch (Exception e) {}

    if (classes != null) {
<<<<<<< HEAD
      for (Class<IConverter> cls : classes) {
        if (cls.getName().contains("Meter")) {
        	fromUnit = cls;
        } else if (cls.getName().contains("Liter")) {
        	toUnit = cls;
        }
=======
      for (Class<AbstractConverter> cls : classes) {
        System.out.println(cls.getName());
>>>>>>> master
      }
    }
    
    try {
    	controller.convert(fromUnit, toUnit, 10.0);
    } catch(Exception e) {}
  }
}
