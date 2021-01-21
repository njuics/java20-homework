import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[]args) {
        String base64 = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        Base64Loader b64Loader = new Base64Loader();
        Class<?> cls = b64Loader.findClass(base64);
        System.out.println("Class Name: " + cls);
        System.out.println();

        System.out.println("Constructors of class " + cls + " are: ");
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        try {
            Constructor<?> constructor = cls.getDeclaredConstructor(java.lang.String.class, int.class, int.class);
            constructor.setAccessible(true);
            Object object = constructor.newInstance("Quin", 22, 33);
            System.out.println("Create instance of class" + cls + " : " + object);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("\nFields of Class " + cls + " are: ");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nMethods of class" + cls + " are: ");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
