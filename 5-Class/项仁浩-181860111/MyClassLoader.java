import java.lang.ClassLoader;
import java.lang.Class;
import java.lang.reflect.*;
import java.util.Base64;


public class MyClassLoader extends ClassLoader{
    public Class<?> findClass(byte[] byteCode)throws ClassNotFoundException{
        return defineClass(null,byteCode,0,byteCode.length);
    }

    public static void main(String[] args){
        final String str = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

        MyClassLoader mcl = new MyClassLoader();
        Class<?> unknownClass = null;
        try{
            byte[] byteCode = Base64.getDecoder().decode(str);
            unknownClass = mcl.findClass(byteCode);
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Class Not Found!");
            return;
        }

        System.out.println("所有属性:");
        Field[] fields = unknownClass.getDeclaredFields();
        for (Field field : fields)
            System.out.println(field.toString());

        System.out.println("所有方法:");
        Method[] methods = unknownClass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method.toString());

        System.out.println("所有构造方法:");
        Constructor<?>[] constructors = unknownClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors)
            System.out.println(constructor.toString());
        try {
            Constructor<?> cons = unknownClass.getDeclaredConstructor(String.class, int.class, int.class);
            cons.setAccessible(true);
            Object obj = cons.newInstance("bear", 100, 100);
            System.out.println("创建的对象为:");
            System.out.println(obj.toString());
        }
        catch (NoSuchMethodException nme){
            System.out.println("NoSuchMethodException:"+nme.getMessage());
        }
        catch(SecurityException se){
            System.out.println("SecurityException:"+se.getMessage());
        }
        catch (InstantiationException ie){
            System.out.println("InstantiationException:"+ie.getMessage());
        }
        catch(IllegalAccessException iae){
            System.out.println("IllegalAccessException:"+iae.getMessage());
        }
        catch(IllegalArgumentException ilae){
            System.out.println("IllegalArgumentException:"+ilae.getMessage());
        }
        catch(InvocationTargetException ite){
            System.out.println("InvocationTargetException:"+ite.getMessage());
        }
    }

}
