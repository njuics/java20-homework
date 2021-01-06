import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class MyClassLoader extends ClassLoader {
    /**
     * @param classbyte
     *        classbyte为用Base64编码的一个Java字节码对应的字符串
     */
    public Class findClass(String classbyte) {
        Base64.Decoder decoder = Base64.getDecoder();
        //获取Base64解码器
        byte[] b = decoder.decode(classbyte);
        //解码，得到Base64编码对应的二进制码
        return defineClass(null, b, 0, b.length);
        //直接调用父类的defineClass方法获取字节码对应的Class对象
    }

    public static void main(String[] args) {
        MyClassLoader classloader = new MyClassLoader();

        try
        {
            Class clazz = classloader.findClass("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");

            System.out.println(clazz.getName());
            //打印出类名
            //结果为Monster

            System.out.println();

            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) System.out.println(constructor.toString());
            //结果为Monster(java.lang.String,int,int)

            System.out.println();

            Object object = clazz.getDeclaredConstructor(String.class, int.class, int.class);
            //根据类构造器创建出该类的对象

            Method[] methods = clazz.getMethods();
            for(Method method : methods) System.out.println(method.toString());
            //反射机制的利用
            //通过Class.getMethods()获取clazz对应的类的所有方法并遍历输出
            /*
            结果：

            public java.lang.String Monster.attack(Monster)
            public final void java.lang.Object.wait() throws java.lang.InterruptedException
            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            public boolean java.lang.Object.equals(java.lang.Object)
            public java.lang.String java.lang.Object.toString()
            public native int java.lang.Object.hashCode()
            public final native java.lang.Class java.lang.Object.getClass()
            public final native void java.lang.Object.notify()
            public final native void java.lang.Object.notifyAll()

             */

            System.out.println();

            Field[] fields = clazz.getFields();
            for(Field field : fields) System.out.println(field.toString());
            //通过Class.getFields()获取clazz对应的类的所有字段并遍历输出
            /*
            结果：

            public java.lang.String Monster.name
            public int Monster.health
            public int Monster.damage

             */

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
