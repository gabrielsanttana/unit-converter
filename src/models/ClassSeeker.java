package models;

import converters.AbstractConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * A class the looks for all the converter classes in a predetermined package
 */
public class ClassSeeker {

  public static final String packageName = "converters";
  public static final String filePrefix = "file:/";
  public static final String jarSuffix = ".jar";
  public static final String classSuffix = ".class";
  public static final String fileSeparator = "/";
  public static final String classSuffixRegex = classSuffix + "$";
  public static final String[] exceptions = new String[] {
    "BaseUnitConverter",
    "AbstractConverter",
  };
  public boolean isJarFile = false;

  /**
   * Returns a list of classes that inherit from the AbstractConverter
   * @return the list with the converter classes to be further instantiated
   * @throws ClassNotFoundException
   * @throws java.net.MalformedURLException
   */
  public List<Class<AbstractConverter>> lookForConverterClasses()
    throws ClassNotFoundException, MalformedURLException {
    List<Class<AbstractConverter>> convertersFound = new ArrayList<>();

    URL root = getRootUrl();

    if (!isJarFile) {
      root = getRootUrl(packageName.replace(".", "/"));
      File[] classFiles = getFilesInDirectory(root);

      for (File classFile : classFiles) {
        Class<?> classFromFile = getClassFromFile(classFile);

        if (doesClassInheritFromConverter(classFromFile)) {
          if (!isClassAnException(classFromFile)) {
            convertersFound.add((Class<AbstractConverter>) classFromFile);
          }
        }
      }
    } else {
      convertersFound =
        loadClassesFromJar(root.toString().replace(filePrefix, ""));
    }

    for (Class<AbstractConverter> classFound : convertersFound) {
      System.out.println(classFound.getName());
    }

    return convertersFound;
  }

  /**
   * Returns the URL of root package
   *
   * @return the URL of the root package
   */
  private URL getRootUrl() {
    URL url =
      ClassSeeker.class.getProtectionDomain().getCodeSource().getLocation();
    if (url.toString().contains(jarSuffix)) {
      isJarFile = true;
    }

    return url;
  }

  /**
   * Returns the root URL for the jar file
   *
   * @param path the path to the root
   * @return the URL of the root package
   */
  private URL getRootUrl(String path) throws MalformedURLException {
    return Thread.currentThread().getContextClassLoader().getResource(path);
  }

  /**
   * Returns all the files inside a given directory
   *
   * @param directory the URL of the directory to be searched
   * @return an array of files contained in the given directory
   */
  private File[] getFilesInDirectory(URL directory) {
    File[] files = new File(directory.getFile())
    .listFiles(
        new FilenameFilter() {
          @Override
          public boolean accept(File dir, String name) {
            return name.endsWith(classSuffix);
          }
        }
      );

    return files;
  }

  /**
   * Returns the class from a given file
   *
   * @param classFile the file where the class is contained
   * @return the class contained in the given file
   * @throws ClassNotFoundException
   */
  private Class<?> getClassFromFile(File classFile)
    throws ClassNotFoundException {
    String className = classFile.getName().replaceAll(classSuffixRegex, "");
    Class<?> cls = Class.forName(packageName + "." + className);

    return cls;
  }

  /**
   * Checks whether or not the given class inherits from AbstractConverter
   *
   * @param cls the class to be checked
   * @return true if the class inherit from a converter class and false if it
   * does not
   */
  private boolean doesClassInheritFromConverter(Class<?> cls) {
    return AbstractConverter.class.isAssignableFrom(cls);
  }

  /**
   * Checks if the given class is inside the exceptions list
   *
   * @param cls the class to be checked
   * @return true if the class is an exception and false if it is not
   */
  private boolean isClassAnException(Class<?> cls) {
    for (String e : exceptions) {
      if (cls.getName().contains(e)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Loads the converter classes from the given jar file
   *
   * @param jarFileName the compiled jar file name
   * @return list of converters classes to be instantiated
   */
  private ArrayList<Class<AbstractConverter>> loadClassesFromJar(
    String jarFileName
  ) {
    ArrayList<Class<AbstractConverter>> myClasses = new ArrayList<>();

    JarInputStream jarFile = null;
    JarEntry jarEntry = null;

    try {
      jarFile = new JarInputStream(new FileInputStream(jarFileName));

      while (true) {
        jarEntry = jarFile.getNextJarEntry();

        if (jarEntry == null) {
          break;
        }

        Class<AbstractConverter> newClass = loadClassFromJar(
          jarEntry,
          new URL("jar:file:" + jarFileName + "!/")
        );
        if (newClass != null) {
          myClasses.add(newClass);
        }
      }
      jarFile.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return myClasses;
  }

  /**
   * Loads a converter class from the given jar file
   *
   * @param jarEntry the object refering to the current jar file entry
   * @param url the url object of the jar file
   * @return the loaded class from the given jar file
   */
  private Class<AbstractConverter> loadClassFromJar(
    JarEntry jarEntry,
    URL url
  ) {
    Class<AbstractConverter> loadedClass = null;

    String jarString = jarEntry.getName();

    if (jarString.startsWith(packageName) && jarString.endsWith(".class")) {
      String className = jarString
        .replaceAll(".class", "")
        .replaceAll("/", "\\.");

      try {
        URLClassLoader classLoader = new URLClassLoader(new URL[] { url });

        Class<?> classToBeLoaded = classLoader.loadClass(className);

        if (
          AbstractConverter.class.isAssignableFrom(classToBeLoaded) &&
          AbstractConverter.class != classToBeLoaded &&
          !isClassAnException(classToBeLoaded)
        ) {
          loadedClass = (Class<AbstractConverter>) classToBeLoaded;
        }

        classLoader.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return loadedClass;
  }
}
