import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Base64;

public class MyClassLoader extends ClassLoader {
    static final String BINARY_CODE = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = Base64.getDecoder().decode(BINARY_CODE);
        return defineClass(null, bytes, 0, bytes.length);
    }

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        Class<?> c = null;
        try {
            c = loader.loadClass("");
            // c = Class.forName("", false, loader);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("===Class Name===");
        System.out.println(c.getCanonicalName());
        System.out.println("===Constructors===");
        Arrays.stream(c.getConstructors()).forEach(System.out::println);
        System.out.println("===DeclaredConstructors===");
        Arrays.stream(c.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("===Methods===");
        Arrays.stream(c.getMethods()).forEach(System.out::println);
        System.out.println("===DeclaredMethods===");
        Arrays.stream(c.getDeclaredMethods()).forEach(System.out::println);
        System.out.println("===Fields===");
        Arrays.stream(c.getFields()).forEach(System.out::println);
        System.out.println("===DeclaredFields===");
        Arrays.stream(c.getDeclaredFields()).forEach(System.out::println);
        try {
            Constructor<?> cons = c.getDeclaredConstructor(String.class, Integer.TYPE, Integer.TYPE);
            cons.setAccessible(true);
            Object obj = cons.newInstance("A", 1, 2);
            System.out.println("Create instance: " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
