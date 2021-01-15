
import java.lang.reflect.*;
import java.util.Base64;


public class BASE64ClassLoader extends ClassLoader { 
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        byte[] b=loadClassFromBase64String(name);
        return defineClass(null,b, 0, b.length);
    }
    private byte[] loadClassFromBase64String(String s){
        byte[] buffer=Base64.getDecoder().decode(s);
        return buffer;
    }

    public static void main(String[] args)throws Exception{
        String s=new String("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");
        BASE64ClassLoader bcl=new BASE64ClassLoader();
        Class cls=bcl.findClass(s);
        print("Class name: "+cls.getName());
        print("");
        print(cls.getName()+" fields:");
        Field[] field=cls.getFields();
        for(Field f:field){
            print(f);
        }
        print("");
        print(cls.getName()+" methods:");
        Method[] method=cls.getMethods();
        for(Method m:method){
            print(m);
        }
        try{
            Constructor con=cls.getDeclaredConstructor(String.class,int.class,int.class);
            con.setAccessible(true);
            Object obj=con.newInstance("worm baby",1,1);
            Field name=cls.getField("name");
            Field health=cls.getField("health");
            Field damage=cls.getField("damage");
            print("Create a "+name.get(obj)+". Health: "+health.get(obj)+". Damage: "+damage.get(obj));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
}
    public static void print(Object obj){
        System.out.println(obj);
}
}


