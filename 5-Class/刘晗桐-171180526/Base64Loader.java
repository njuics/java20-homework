import java.lang.ClassLoader;
import java.util.Base64;
import java.lang.reflect.*;

public class Base64Loader extends ClassLoader {
	static final String base64Code = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
	
	public Class<?> findClass() throws ClassNotFoundException {
    	byte[] b = Base64.getDecoder().decode(base64Code);
        // define class
        return defineClass(null, b, 0, b.length);
    }
    
    public void classReflection(Class<?> loadedClass) throws NoSuchMethodException, SecurityException {
      	// print name, methods and atrributes
        System.out.println("The name of class is " + loadedClass.getName()); 
        
        // constructors
        Constructor<?>[] constructors = loadedClass.getDeclaredConstructors(); 
        for (Constructor<?> constructor : constructors)
        	System.out.println("The name of constructor is " + constructor.getName()); 
          
        // methods
        System.out.println("The public methods of class are : ");
        Method[] methods = loadedClass.getMethods(); 
        for (Method method : methods) 
            System.out.println(method.getName()); 

    }
    
    public static void main(String args[]) throws 
    		ClassNotFoundException, 
    		NoSuchMethodException, 
    		SecurityException, 
    		InstantiationException, 
    		IllegalAccessException, 
    		IllegalArgumentException, 
    		InvocationTargetException 
    {
    	// load the class
    	Base64Loader loader = new Base64Loader();
    	Class<?> loadedClass = loader.findClass();
    	// create instance based on loaded constructor
    	Constructor<?> constructor=loadedClass.getDeclaredConstructor(String.class, int.class, int.class);    	
    	constructor.setAccessible(true);
    	Object Monster=constructor.newInstance("Monster",0,0);
    	// reflection to get the class attris, methods, etc.
    	loader.classReflection(Monster.getClass());
    }
}

