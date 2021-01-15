import java.lang.reflect.*;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.io.*;

public class MyClassLoader extends ClassLoader {
    public MyClassLoader()
    {

    }
    public MyClassLoader(ClassLoader parent)
    {
        super(parent);
    }
    @Override
    public Class findClass(String name) throws ClassNotFoundException
    {
        byte[] bArray = Base64.getDecoder().decode("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
        return defineClass(name, bArray, 0,bArray.length);
    }
    public static void myreflect(Class<?> obj)
    {
        //Using reflect to get fields,methods,constructors
        //Output name
        System.out.println("Class Name:");
        String s = obj.getName();
        System.out.println(s);
        //Output constructors
        System.out.println("Class Constructors:");
        Constructor C[] = obj.getDeclaredConstructors();
        for (int i = 0; i < C.length; i++)
            System.out.println(C[i].toString());
        //Output properties
        System.out.println("Class Fields:");
        Field F[] = obj.getDeclaredFields();
        for (int i = 0; i < F.length; i++)
            System.out.println(F[i].toString());
        //Output methods
        System.out.println("Class Methods:");
        Method M[] = obj.getDeclaredMethods();
        for (int i = 0; i < M.length; i++)
            System.out.println(M[i].toString());
    }
    public static void main(String args[])
    {
        try{
            MyClassLoader myloader = new MyClassLoader();
            Class<?> myclass =  myloader.findClass("Monster");
            myloader.myreflect(myclass);
        }
        catch(ClassNotFoundException I){
            System.out.println("Class Not Found");
        }
    }
}
