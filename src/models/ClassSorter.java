package models;

import converters.AbstractConverter;
import java.util.List;
import utils.MultiMap;

/**
 * A class the sorts and returns all converter classes in unit type order
 */
public class ClassSorter {

  /**
   * Returns all the converter classes in unit type order
   * @return a MultiMap with the keys being the unit types and their values the classes from these unit types
   */
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
