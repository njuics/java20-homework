package Class;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        String base64 = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

        MyClassLoader classLoader = new MyClassLoader(base64);

        Class<?> cls = classLoader.findClass("Monster");

        //构造方法
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        System.out.println("*************构造方法共"+constructors.length+"个*************");
        for (Constructor<?> c : constructors
             ) {
            System.out.println(Arrays.toString(c.getGenericParameterTypes()));
        }

        //属性
        Field[] fields = cls.getDeclaredFields();
        System.out.println("*************属性共"+fields.length+"个*************");
        for (Field c : fields
        ) {
            System.out.println(c.getName());
        }

        //其他方法
        Method[] methods = cls.getDeclaredMethods();
        System.out.println("*************普通方法共"+methods.length+"个*************");
        for (Method c : methods
        ) {
            System.out.println(c);
        }

        //构建对象
        System.out.println("*************创建对象实例*************");
        Constructor<?> creator = constructors[0];
        creator.setAccessible(true);
        Object obj = creator.newInstance("Monster1",10,2);

        //查看、更改属性
        Field nameField = cls.getField("name");
        Field healthField = cls.getField("health");
        System.out.println("name\t"+nameField.get(obj));
        healthField.set(obj,99);
        System.out.println("health\t"+healthField.get(obj));

        //调用方法
        Method m = methods[0];
        Object result = m.invoke(obj, obj);
        System.out.println(result);




    }


}
