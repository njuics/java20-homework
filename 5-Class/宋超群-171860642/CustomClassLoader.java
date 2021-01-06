//import java.io.*;
import java.lang.reflect.*;
import java.io.IOException;
import sun.misc.BASE64Decoder;

public class CustomClassLoader  {

    public static void main(String[] ags)  throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        LoadFunctions funs = new LoadFunctions();
        funs.outClass();

    }
}

class LoadFunctions extends ClassLoader{
    protected void outClass()  throws  IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class targetClass = findClass(null);
        //获取构造函数
        System.out.println(targetClass.getDeclaredConstructors()[0].toString());

        System.out.println('\n');

        Constructor<?> myConstructor = targetClass.getDeclaredConstructor(String.class, int.class, int.class);
        myConstructor.setAccessible(true);
        Object myObject = myConstructor.newInstance("tmp", 1000,100000);

        Field fields[] = targetClass.getDeclaredFields();
        Method methods[] = targetClass.getDeclaredMethods();

        System.out.println("fields:");
        for(Field field:fields)
            System.out.println(field);

        System.out.println("\nmethods:");
        for(Method method:methods)
            System.out.println(method);
    }

    @Override
    protected Class<?> findClass(String name)  {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] classContent= new byte[0];
        try {
            String encodedText = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
            classContent = decoder.decodeBuffer(encodedText);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name, classContent, 0, classContent.length);
    }
}