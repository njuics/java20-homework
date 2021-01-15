import java.util.*;
import java.lang.ClassLoader;
import java.lang.reflect.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.Class;

class CustomClassLoader extends ClassLoader {
    public Class findClass(byte[] byteCode) throws ClassNotFoundException {
        return defineClass(null, byteCode, 0, byteCode.length);
    }
}
public class CustomizeLoader{
    final static String TEXT="yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
    public static void main(String[] args)
    {
        byte[] byteCode=Base64.getDecoder().decode(TEXT);
        /*//String str=decoder.decode(text);
        PrintStream ps=null;
        try {
            ps= new PrintStream("log.txt");
        }
        catch (FileNotFoundException e){return;}
        byte[] byteCode=null;
        try 
        {
            //byteCode=toUTF();//获得字节码
            byteCode=Base64.getDecoder().decode(TEXT);
            
            System.setOut(ps);
            System.out.write(byteCode);
            System.setOut(System.err);
        }
        
        catch (IOException e){System.out.println("UTF failed!");return;}*/
        CustomClassLoader ccl=new CustomClassLoader();
        try{
            Class<?> unknownClass=ccl.findClass(byteCode);
            for(Field f : unknownClass.getDeclaredFields()){//输出所有字段（包括私有等）
				System.out.println(f);
            }
            for (Method m: unknownClass.getDeclaredMethods()){//输出所有方法（包括私有等）
                System.out.println(m);
            }
            for(Constructor<?> c : unknownClass.getDeclaredConstructors()){//输出所有构造器
                System.out.println(c);
            }
            try{//获得构造器并创建对象
                Constructor constructor=unknownClass.getDeclaredConstructor(java.lang.String.class,int.class,int.class);
                constructor.setAccessible(true);
                Object object=constructor.newInstance("Dragon",40,40);
            }catch (InstantiationException ie){System.out.println("InstantiationException");return;}
            catch (IllegalAccessException iae){System.out.println("IllegalAccessException");return;}
            catch (NoSuchMethodException nme){System.out.println("NoSuchMethodException");return;}
            catch (InvocationTargetException ite){System.out.println("InvocationTargetException");return;}
            
        }
        catch (ClassNotFoundException cne){System.out.println("Class not found!");return;}
    }
}