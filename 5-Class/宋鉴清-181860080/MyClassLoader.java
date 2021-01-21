import java.lang.ClassLoader;
import java.lang.ClassNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class MyClassLoader extends ClassLoader {
    public Class<?> LoadFromByte64(String base64bytes) throws ClassNotFoundException {
        byte[] bytes = Base64.getDecoder().decode(base64bytes);
        return defineClass(null, bytes, 0, bytes.length);
    }
    public static void main(String[] args){
        String base64bytes = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        MyClassLoader myloader = new MyClassLoader();
        Class<?> LoaderClass = null;
        try {
            LoaderClass = myloader.LoadFromByte64(base64bytes);
            Constructor<?>[] cons = LoaderClass.getDeclaredConstructors();
            Constructor<?> Con = cons[0];
            System.out.println(LoaderClass.getName() + "的构造函数：");
            for(Constructor<?> con : cons){
                System.out.print("\t");
                System.out.println(con);
            }

            Field[] allFields = LoaderClass.getFields();
            System.out.println(LoaderClass.getName() + "的属性有：");
            for(Field field : allFields){
                System.out.print("\t");
                System.out.println(field.toString());
            }

            Method[] allMethods = LoaderClass.getDeclaredMethods();
            System.out.println(LoaderClass.getName() + "的方法有：");
            for(Method method : allMethods){
                System.out.print("\t");
                System.out.println(method.toString());
            }


            System.out.println("构造一个该对象的实例：");   
            Object ClassIns = null;
            try {
                Con.setAccessible(true);
                ClassIns = Con.newInstance("Snake", 10, 10);
            } catch(Exception e){
                e.printStackTrace();
            }
            System.out.print("\t");
            System.out.println(ClassIns);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
