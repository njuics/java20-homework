package homework_5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class MyClassLoader extends ClassLoader{
    private static final String str = new String("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classByte = Base64.getDecoder().decode(str);
        return defineClass(name,classByte,0,classByte.length);
    }

    public static void main(String[] args) {
        try {
            MyClassLoader myLoader = new MyClassLoader();
            Class c = myLoader.findClass("Monster");

            Constructor con = c.getDeclaredConstructor(String.class,int.class,int.class);
            con.setAccessible(true);
            Object o = con.newInstance("test",1,1);
            Class test = o.getClass();

            System.out.println("className:");
            String className = test.getCanonicalName();
            System.out.println(className);
            System.out.println("DeclaredClasses:");
            Class<?>[] classArr = test.getDeclaredClasses();
            for(int i=0;i<classArr.length;++i){
                System.out.println(classArr[i]);
            }
            System.out.println("DeclaredConstructors:");
            Constructor<?>[] cons = test.getDeclaredConstructors();
            for(int i=0;i<cons.length;++i){
                System.out.println(cons[i]);
            }
            System.out.println("Constructors:");
            cons = test.getConstructors();
            for(int i=0;i<cons.length;++i){
                System.out.println(cons[i]);
            }
            System.out.println("DeclaredFields:");
            Field[] f = test.getDeclaredFields();
            for(int i=0;i<f.length;++i){
                System.out.println(f[i]);
            }
            System.out.println("Fields:");
            f = test.getFields();
            for(int i=0;i<f.length;++i){
                System.out.println(f[i]);
            }
            System.out.println("DeclaredMethods:");
            Method m[] = test.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
            System.out.println("Methods:");
            m = test.getMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());

        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
