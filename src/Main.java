import controllers.Controller;
import converters.AbstractConverter;
import java.util.List;
import models.ClassSorter;
import models.MeasureType;
import utils.MultiMap;

public class Main {

  public static void main(String[] args) {
    Controller controller = new Controller();

    // List<Class<AbstractConverter>> classes = null;

    // try {
    //   classes = controller.lookForConverterClasses();
    // } catch (Exception e) {}

    // if (classes != null) {
    //   for (Class<AbstractConverter> cls : classes) {
    //     System.out.println(cls.getName());
    //   }
    // }

    ClassSorter classSorter = new ClassSorter();

    classSorter.getClassesOrderedByUnitType();
    // for(MeasureType classes : sortedClasses.getKeySet()) {
    //   System.out.println(sortedClasses.get(classes));
    // }
  }
}
