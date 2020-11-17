import java.util.List;
import controllers.Controller;
import models.IConverter;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller();
    
    List<Class<IConverter>> classes = null;
    try {
      classes = controller.lookForConverterClasses();
    } catch (Exception e) {
    }
    
    if (classes != null) {
      for (Class<IConverter> cls : classes) {
        System.out.println(cls.getName());
      }
    }
  }
}
