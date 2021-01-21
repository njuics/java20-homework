import java.util.Base64;
import java.lang.ClassLoader;
import java.lang.reflect.*;
import java.lang.String;

public class MyLoader extends ClassLoader {
    @Override
    public Class findClass(String base64code) throws ClassNotFoundException {
        // 解码 & 创建类型
        byte[] decodedBytes = Base64.getDecoder().decode(base64code);
        return defineClass(null, decodedBytes, 0, decodedBytes.length);
    }
    public static void main(String []args) { 
        String base64code = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        MyLoader loader = new MyLoader();
        try{
            Class myclass = loader.findClass(base64code);
            // 获取构造函数、方法、字段并输出
            Constructor[] constructors = myclass.getDeclaredConstructors();
            Method[] methods = myclass.getMethods();
            Field[] fields = myclass.getFields();
            System.out.println("构造函数:");
            // Monster(java.lang.String,int,int)
            for(Constructor constructor:constructors)
                System.out.println(constructor);
            System.out.println("方法:");
            for(Method method:methods)
                System.out.println(method);
            System.out.println("字段:");
            for(Field field:fields)
                System.out.println(field);
            try{
                constructors[0].setAccessible(true);
                Object obj = constructors[0].newInstance("monster_name", 100, 100);
            } catch(Exception e) {
                System.out.println(e);
                System.exit(1);
            }
            System.out.println("实例创建成功");
        }catch(ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}