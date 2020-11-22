package models;

import converters.AbstractConverter;
import java.util.List;
import utils.MultiMap;

public class ClassSorter {

  public MultiMap<MeasureType, Class<AbstractConverter>> getClassesOrderedByUnitType() {
    ClassSeeker classSeeker = new ClassSeeker();
    MultiMap<MeasureType, Class<AbstractConverter>> sortedClasses = new MultiMap<>();

    try {
      List<Class<AbstractConverter>> converterClasses = classSeeker.lookForConverterClasses();

      for (Class<AbstractConverter> converterClass : converterClasses) {
        AbstractConverter converterClassInstance = converterClass
          .getDeclaredConstructor()
          .newInstance();
        sortedClasses.put(converterClassInstance.type, converterClass);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }

    return sortedClasses;
  }
}
