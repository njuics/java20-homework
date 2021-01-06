package cn.edu.nju.java2020;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) throws Exception {
        /*通过自定义类加载器从字符串中加载类型*/
        CustomClassLoader myClassLoader = new CustomClassLoader(base64String);
        Class<?> monster = myClassLoader.findClass(null);

        /*通过Java反射机制找出该对象的属性和方法*/
        myPrint("constructor", monster);
        myPrint("field", monster);
        myPrint("method", monster);

        /*创建一个该类型的对象实例*/
        Constructor<?> constructor = monster.getConstructor(String.class, int.class, int.class);
        Object jillian = constructor.newInstance("Jillian", 100, 9999);
    }

    private static String base64String = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

    private static void myPrint(String str, Class<?> monster) {
        switch (str) {
            case "constructor":
                Constructor[] constructors = monster.getDeclaredConstructors();
                System.out.println("打印所有构造函数：");
                for (Constructor constructor : constructors) {
                    System.out.println(constructor);
                }
                break;
            case "field":
                Field[] fields = monster.getDeclaredFields();
                System.out.println("打印所有属性：");
                for (Field field : fields) {
                    System.out.println(field);
                }
                break;
            case "method":
                Method[] methods = monster.getDeclaredMethods();
                System.out.println("打印所有方法：");
                for (Method method : methods) {
                    System.out.println(method);
                }
                break;
            default:
                System.out.println("Error");
        }
    }
}
