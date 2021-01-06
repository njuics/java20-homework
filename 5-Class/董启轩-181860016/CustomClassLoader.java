import java.lang.ClassLoader;
import java.util.Base64;
import java.lang.reflect.*;
import java.lang.String;
public class CustomClassLoader extends ClassLoader{
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        byte[] b=loadClassFromBase64(name);
        return defineClass(null,b,0,b.length);
    }
    private byte[] loadClassFromBase64(String base64){
        byte[] buffer=Base64.getDecoder().decode(base64);
        return buffer;
    }
    public void reflection(Class<?> myClass){
        System.out.println("Class Name: "+myClass.getName());
        System.out.println("Constructors:");
        Constructor<?> constructor[]=myClass.getDeclaredConstructors();
        for(Constructor<?> c:constructor){
            System.out.println(c);
        }
        System.out.println("Fields:");
        Field field[]=myClass.getDeclaredFields();
        for(Field f:field){
            System.out.println(f);
        }
        System.out.println("Methods:");
        //Method method[]=myClass.getDeclaredMethods();
        Method method[]=myClass.getMethods();
        for(Method m:method){
            System.out.println(m);
        }
    } 
    public static void main(String[] args){
        String base64 = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        CustomClassLoader myClassLoader=new CustomClassLoader();
        try
        {
            Class<?> myClass=myClassLoader.findClass(base64);
            myClassLoader.reflection(myClass);
            System.out.println("");
            Constructor<?> constructor=myClass.getDeclaredConstructor(String.class,int.class,int.class);
            constructor.setAccessible(true);
            Object monster=constructor.newInstance("zombie",100,5);
            System.out.println("create monster:");
            System.out.println(monster);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}