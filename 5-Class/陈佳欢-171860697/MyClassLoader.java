import java.util.Base64;
import java.lang.reflect.*;

public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] b = decoder.decode(str);
        return defineClass(null, b, 0, b.length);
    }

    public static void main(String[] args) throws ClassNotFoundException {

        final String str = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

        MyClassLoader loader = new MyClassLoader();
        Class<?> unknown = loader.findClass(str);
        
        System.out.println(unknown);

        /* ------------------------------------------------------------------------------------------------- */

        try {
            Constructor<?> constructor = unknown.getDeclaredConstructor(String.class, int.class, int.class);
            constructor.setAccessible(true);
            Object object = constructor.newInstance("monster",1,1);
            Class<?> c = object.getClass();
            Field f[] = c.getDeclaredFields();
            Method m[] = c.getDeclaredMethods();
            for(int i = 0; i < f.length; i++)
                System.out.println(f[i].toString());
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

}
