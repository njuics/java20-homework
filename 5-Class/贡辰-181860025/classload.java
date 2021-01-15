import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class classload extends ClassLoader {
    @Override
    public Class findClass(String name) throws ClassNotFoundException
    {
        //System.out.println("file:"+this.getClass().getClassLoader().getResource("") );
        //byte[] b = loadClassFromFile(name);
        byte [] byteArray = Base64.getDecoder().decode
                ("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
        return defineClass(name, byteArray, 0, byteArray.length);
    }


    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //File file=new File("D://2.class");
        classload myClassload=new classload();
        Class<?> log=myClassload.findClass("Monster");
        //Object obj=log.newInstance();

        System.out.println("The constructor is:");
        Constructor<?> cons[] = log.getDeclaredConstructors();
        for (Constructor<?> constructor : cons) {
            System.out.println(constructor);
        }
        //获得构造函数

        Class[] classes = new Class[] {String.class, int.class, int.class};
        Constructor<?> Con=log.getDeclaredConstructor(classes);
        Con.setAccessible(true);
        Object obj=Con.newInstance("1",1,1);

        System.out.println("The Method is:");
        Method m[] = log.getDeclaredMethods();
        for (int i = 0; i < m.length; i++)
            System.out.println(m[i].toString());
    }
}
