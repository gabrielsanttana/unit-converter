package models;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassSeeker {
	
	public static final String packagePath = "models.converters";
	public static final String classSuffix = ".class";
	public static final String classSuffixRegex = classSuffix + "$";
	
	public List<Class<IConverter>> lookForConverterClasses() throws ClassNotFoundException {
		List<Class<IConverter>> convertersFound = new ArrayList<>();
		
		URL root = getRootUrl(packagePath.replace(".", "/"));
		File[] classFiles = getFilesInDirectory(root);
		
		for (File classFile : classFiles) {
			Class<?> cls = getClassFromFile(classFile);
			
			if (doesClassInheritFromConverter(cls)) {
				convertersFound.add((Class<IConverter>)cls);
			}
		}
		
		return convertersFound;
	}
	
	private URL getRootUrl(String path) {
		return Thread.currentThread().getContextClassLoader().getResource(path);
	}
	
	private File[] getFilesInDirectory(URL directory) {
		
		File[] files = new File(directory.getFile()).listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(classSuffix);
			}
		});
		
		return files;
	}

	private Class<?> getClassFromFile(File classFile) throws ClassNotFoundException {
		String className = classFile.getName().replaceAll(classSuffixRegex, "");
		Class<?> cls = Class.forName(packagePath + "." + className);
		
		return cls;
	}
	
	private boolean doesClassInheritFromConverter(Class<?> cls) {
		return IConverter.class.isAssignableFrom(cls);
	}
}