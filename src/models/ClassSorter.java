package models;

import converters.AbstractConverter;
import java.util.List;
import utils.MultiMap;

public class ClassSorter {

  public MultiMap<MeasureType, AbstractConverter> getClassesOrderedByUnitType() {
    ClassSeeker classSeeker = new ClassSeeker();
    MultiMap<MeasureType, AbstractConverter> sortedClasses = new MultiMap<>();

    try {
      List<Class<AbstractConverter>> converterClasses = classSeeker.lookForConverterClasses();

      for (Class<AbstractConverter> converterClass : converterClasses) {
        AbstractConverter converterClassInstance = converterClass
          .getDeclaredConstructor()
          .newInstance();
        sortedClasses.put(converterClassInstance.type, converterClassInstance);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }

    return sortedClasses;
  }
}
