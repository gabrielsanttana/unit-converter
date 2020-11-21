package models;

import converters.AbstractConverter;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassSeeker {

  public static final String packagePath = "models.converters";
  public static final String classSuffix = ".class";
  public static final String classSuffixRegex = classSuffix + "$";
  public static final String[] exceptions = new String[] { "BasicConverter" };

  // Returns a list of classes which implement AbstractConverter
  public List<Class<AbstractConverter>> lookForConverterClasses()
    throws ClassNotFoundException {
    List<Class<AbstractConverter>> convertersFound = new ArrayList<>();

    URL root = getRootUrl(packagePath.replace(".", "/"));
    File[] classFiles = getFilesInDirectory(root);

    for (File classFile : classFiles) {
      Class<?> cls = getClassFromFile(classFile);

      if (doesClassInheritFromConverter(cls)) {
        if (!isClassAnException(cls)) {
          convertersFound.add((Class<AbstractConverter>) cls);
        }
      }
    }

    return convertersFound;
  }

  // Returns the root URL
  private URL getRootUrl(String path) {
    return Thread.currentThread().getContextClassLoader().getResource(path);
  }

  // Returns all the files inside a given directory
  private File[] getFilesInDirectory(URL directory) {
    File[] files = new File(directory.getFile())
    .listFiles(
        new FilenameFilter() {
          public boolean accept(File dir, String name) {
            return name.endsWith(classSuffix);
          }
        }
      );

    return files;
  }

  // Returns the Class from a given file
  private Class<?> getClassFromFile(File classFile)
    throws ClassNotFoundException {
    String className = classFile.getName().replaceAll(classSuffixRegex, "");
    Class<?> cls = Class.forName(packagePath + "." + className);

    return cls;
  }

  // Checks whether or not the given class inherits from AbstractConverter
  private boolean doesClassInheritFromConverter(Class<?> cls) {
    return AbstractConverter.class.isAssignableFrom(cls);
  }

  // Checks if the given class is inside the exceptions list
  private boolean isClassAnException(Class<?> cls) {
    for (String e : exceptions) {
      if (cls.getName().contains(e)) {
        return true;
      }
    }
    return false;
  }
}
