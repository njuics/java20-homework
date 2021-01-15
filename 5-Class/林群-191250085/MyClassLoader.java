import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class MyClassLoader extends ClassLoader{
    public Class<?> findClass (String base64Code) throws ClassNotFoundException{
        byte[] decodedBytes = Base64.getDecoder().decode(base64Code);
        return defineClass(null,decodedBytes,0,decodedBytes.length);
    }

    private static void findConstructors (Class<?> clazz){
        System.out.println("Find all declared constructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors){
            System.out.println(c);
        }
    }

    private static void getFields (Object obj){
        System.out.println("Get all fields:");
        Field[] fields = obj.getClass().getFields();
        for (Field f : fields){
            System.out.println(f);
        }
    }

    private static void getMethods (Object obj){
        System.out.println("Get all methods:");
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
    }

    public static void main(String[] args){
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> clazz = myClassLoader.findClass("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
            System.out.println("Class name:" + clazz.getName());

            findConstructors(clazz);
            // Monster(java.lang.String,int,int)

            Constructor<?> c = clazz.getDeclaredConstructor(String.class,int.class,int.class);
            c.setAccessible(true);
            Object newInstance = c.newInstance("NewInstance",100,100);
            //Generate new instance by reflection

            getFields(newInstance);
            getMethods(newInstance);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
    /*输出：
    Class name:Monster
    Find all declared constructors:
    Monster(java.lang.String,int,int)
    Get all fields:
    public java.lang.String Monster.name
    public int Monster.health
    public int Monster.damage
    Get all methods:
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