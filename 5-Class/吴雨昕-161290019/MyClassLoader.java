import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Base64;

public class MyClassLoader extends ClassLoader {
    static final String classByteCode = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
    
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] byteCode = Base64ToByte(name);
        return defineClass(null, byteCode, 0, byteCode.length);
    }
    private byte[] Base64ToByte(String base64code){
        byte[] decoded = Base64.getDecoder().decode(base64code);
        return decoded;
    }

    public static void main(String[] args){
        ClassLoader loader = new MyClassLoader();
        try{
            Class myClass = loader.loadClass(classByteCode);
            System.out.println(myClass.getName());
            Constructor[] constructors = myClass.getDeclaredConstructors();
            Method[] classMethods = myClass.getDeclaredMethods();
            Field[] members = myClass.getDeclaredFields();
            for (Constructor c : constructors) {
                System.out.println(c.toString());
            }
            for (Method m : classMethods) {
                System.out.println(m.toString());
            }
            for (Field m : members) {
                System.out.println(m.toString());
            }
            Constructor instanceConsturctor = myClass.getDeclaredConstructor(new Class[]{String.class, int.class, int.class});
            instanceConsturctor.setAccessible(true);
            Object[] parameters={"myLittleMonster",1000,50};
            Object myLittleMonster = instanceConsturctor.newInstance(parameters);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}