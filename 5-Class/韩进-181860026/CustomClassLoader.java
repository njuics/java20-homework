import java.lang.Class;
import java.lang.reflect.*;
import java.util.Base64;


public class CustomClassLoader extends ClassLoader
{
    private Class<?> loadUnknownClass() throws ClassNotFoundException
    {
        final String encoded_str = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] buffer = decoder.decode(encoded_str);
        return defineClass(buffer, 0, buffer.length);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        CustomClassLoader classloader = new CustomClassLoader();
        Class<?> myClass = null;
        try
        {
            myClass = classloader.loadUnknownClass();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        assert myClass != null;

        System.out.println("该对象所有属性为:");
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields)
        {
            System.out.println(field.toString());
        }
        System.out.println("该对象所有方法为:");
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods)
        {
            System.out.println(method.toString());
        }
        System.out.println("构造函数为:");
        Constructor<?>[] constructors=myClass.getDeclaredConstructors();
        for (Constructor<?> con: constructors)
        {
            System.out.println(con.toString());
        }
        Constructor<?> c=myClass.getDeclaredConstructor(String.class, int.class, int.class);
        c.setAccessible(true);
        Object obj = c.newInstance("monster1", 10,10);
        System.out.println("构造的对象为:");
        System.out.println(obj);
    }
}


