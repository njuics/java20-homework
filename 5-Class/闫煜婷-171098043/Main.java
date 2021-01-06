package Homework5;
import java.lang.reflect.*;
/**
 * 生成对象实例：在运行时刻才能获取constructor的参数类型，而newInstance方法的参数输入需要提前写好，所以参数输入只能在看过具体需要的参数类型和个数后，采用硬编码。
 */
public class Main {
    public static void main(String[] args) throws Exception{
        MyClassLoader loader = new MyClassLoader();
        String base64str = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        Class someClass = loader.findClass(null, base64str);

        //Object obj = someClass.newInstance();
        System.out.println("New an Instance: ");
        Constructor constr = someClass.getDeclaredConstructors()[0];
        constr.setAccessible(true); // get access to a protected constructor of the class
        Object obj = constr.newInstance("", 0, 0); // hard-coded parameters of the newInstance function
        System.out.println(obj);

        String clsName = someClass.getName();

        Method[] publicMethodList= someClass.getMethods();
        Field[] publicFieldsList = someClass.getFields();
        Constructor[] publicConstructorList = someClass.getConstructors();

        Method[] decMethodList= someClass.getDeclaredMethods();
        Field[] decFieldsList = someClass.getDeclaredFields();
        Constructor[] decConstructorList = someClass.getDeclaredConstructors();

        System.out.println("----------------\nName of the Class: " + clsName);
        System.out.println("----------------\nDeclared Fields of the Class:");
        for(Field f: decFieldsList){
            System.out.println(f.toGenericString());
        }
        System.out.println("----------------\nDeclared Constructors of the Class:");
        for(Constructor c: decConstructorList){
            System.out.println(c.toGenericString());
        }
        System.out.println("----------------\nDeclared Methods of the Class:");
        for(Method m: decMethodList){
            System.out.println(m.toGenericString());
        }
        System.out.println("----------------\nPublic Fields of the Class:");
        for(Field f: publicFieldsList){
            System.out.println(f.toGenericString());
        }
        System.out.println("----------------\nPublic Constructors of the Class:");
        for(Constructor c: publicConstructorList){
            System.out.println(c.toGenericString());
        }
        System.out.println("----------------\nPublic Methods of the Class:");
        for(Method m: publicMethodList){
            System.out.println(m.toGenericString());
        }
    }
}
