import controllers.Controller;
import converters.AbstractConverter;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller();

    List<Class<AbstractConverter>> classes = null;

    try {
      classes = controller.lookForConverterClasses();
    } catch (Exception e) {}

    if (classes != null) {
      for (Class<AbstractConverter> cls : classes) {
        System.out.println(cls.getName());
      }
    }
  }
}
