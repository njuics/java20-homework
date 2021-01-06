package MyClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class MyClassLoader extends ClassLoader{
    static String classBase64Str;
    static byte[] classByteCode;
    static {
        classBase64Str="yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2x" +
                "hbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3Rl" +
                "cgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9Td" +
                "HJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFA" +
                "ARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQ" +
                "gZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50" +
                "ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZ" +
                "XI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAA" +
                "Zmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2x" +
                "hbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGph" +
                "dmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtY" +
                "mVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2" +
                "xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmp" +
                "hdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAA" +
                "AAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEt" +
                "QAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAA" +
                "AABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACc" +
                "AAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkD" +
                "KrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKA" +
                "AIAAAAQAA0AEQABACgAAAACACk=";
        classByteCode=Base64.getDecoder().decode(classBase64Str);
    }

    //字节码中的类对应的Class对象
    @Override
    public Class findClass(String name) throws ClassNotFoundException{
        return defineClass(name,classByteCode,0,classByteCode.length);
    }
    //通过类对应的Class对象创建该类的一个实例
    public Object getInstance() {
        Object o = null;
        try {
            Class c = findClass(null);
            //获得所的构造函数,私有的和公有的都有
            for (Constructor con : c.getDeclaredConstructors()) {
                System.out.println(con.toString());
            }
            //获取特定的构造函数
            Constructor con = c.getDeclaredConstructor(String.class, int.class, int.class);
            //允许私有构造函数创建类对应的对象
            con.setAccessible(true);
            o = con.newInstance("Cheng", 1, 1);
        }catch(Exception e){
            System.out.println(e);
        }finally {
            return o;
        }
    }

    public static void main(String[] args){
        try{
            MyClassLoader mycl=new MyClassLoader();
            Object o=mycl.getInstance();
            Class c=o.getClass();
            for(Field f:c.getDeclaredFields()) System.out.println(f);
            for(Method m:c.getDeclaredMethods()) System.out.println(m);
         }catch (Exception e){
            System.out.println(e);
        }
    }
}
