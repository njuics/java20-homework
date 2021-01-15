// package java20homework.customizedclass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class CustomizedClassLoader extends ClassLoader {

    private String byteCode;
    private Class<?> clazz;

    public CustomizedClassLoader(String byteCode) {
        super();
        this.byteCode = byteCode;
        this.clazz = this.getClazz();
    }

    private byte[] decode() {
        return Base64.getDecoder().decode(byteCode);
    }

    private Class<?> getClazz() {
        byte[] tmpArray = this.decode();
        return this.defineClass(null, tmpArray, 0, tmpArray.length);
    }

    public Object getNewInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Constructor<?> constructor = this.clazz.getDeclaredConstructor(String.class, int.class, int.class);
        constructor.setAccessible(true);
        return constructor.newInstance("hwd", 50, 100);
    }

    public Constructor<?>[] getConstructorArray() {
        return this.clazz.getDeclaredConstructors();
    }

    public void printFields() {
        Field[] fields = this.clazz.getFields();
        for (var field : fields) System.out.println(field);
    }

    public void printMethods() {
        Method[] methods = this.clazz.getMethods();
        for (var method : methods) System.out.println(method);
    }

    public void printConstructors() {
        Constructor<?>[] constructors = this.clazz.getDeclaredConstructors();
        for (var constructor : constructors) {
            for (var curClazz : constructor.getParameterTypes()) System.out.println("构造函数参数 " + curClazz);
            System.out.println(constructor);
        }
    }

    public static void main(String[] args) {
        CustomizedClassLoader test = new CustomizedClassLoader("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
        try {
            Object instance = test.getNewInstance();
            if (instance != null) System.out.println("实例创造成功");
        } catch (Exception e) {
            if (test.getConstructorArray().length == 0) System.out.println("没有构造函数");
            e.printStackTrace();
        }
        test.printConstructors();
        test.printFields();
        test.printMethods();
    }
}
