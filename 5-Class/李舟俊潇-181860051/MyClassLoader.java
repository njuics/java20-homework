import java.util.Base64;
import java.lang.ClassLoader;
import java.lang.reflect.*;

public class MyClassLoader{
    public static void main(String[] argv) throws NoSuchMethodException,InstantiationException,IllegalAccessException,InvocationTargetException{
        CustomClassLoader loader=new CustomClassLoader();
        Class myclass=loader.findClass(null);

        Field[] field=myclass.getDeclaredFields();
        Method[] method=myclass.getDeclaredMethods();
        Constructor[] constructor=myclass.getDeclaredConstructors();

        System.out.println("Print all the fields of this class.");
        for(Field f:field)
            System.out.println(f.toString());
        System.out.println("Print all the methods of this class.");
        for(Method m:method)
            System.out.println(m.toString());
        System.out.println("Print all the constructors of this class.");
        for(Constructor c:constructor)
            System.out.println(c.toString());

        Constructor<?> myconstructor=myclass.getDeclaredConstructor(String.class,int.class,int.class);
        myconstructor.setAccessible(true);
        Object obj=myconstructor.newInstance("myobj",1,1);
    }
}

class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        String classbytecode="yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        byte[] bytecode=Base64.getDecoder().decode(classbytecode);
        return defineClass(name,bytecode,0,bytecode.length);
    }
}
