import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Base64;

public class CustomClassLoader extends ClassLoader {

    static final String b64Bytecode = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
    @Override
    public Class findClass(String name){
        byte[] byteCode=Base64.getDecoder().decode(b64Bytecode);
        return defineClass(null,byteCode,0,byteCode.length);
    }
    

    public static void main(String[] args){
        ClassLoader loader= new CustomClassLoader();
   
		Class myClass = loader.loadClass(b64Bytecode);
		System.out.println(myClass.getName());  //Monster
		Constructor[] constructors=myClass.getDeclaredConstructors();
		Method[] classMethods=myClass.getDeclaredMethods();
		Field[] members=myClass.getDeclaredFields();
		//Monster(java.lang.String,int,int)
		for(Constructor c: constructors){
			System.out.println("constructor:");
			System.out.println(c.toString());
		}
		for(Method m:classMethods){
			System.out.println("methods:");
			System.out.println(m.toString());
		}
		System.out.println("members:");
		for(Field m: members){
			
			System.out.println(m.toString());
		}
		Constructor instanceConstructor=myClass.getDeclaredConstructor(new Class[]{String.class,int.class,int.class});
		instanceConstructor.setAccessible(true);
		Object[] parameters={"myLittleMonster",2333,233};
		Object myLittleMonster = instanceConstructor.newInstance(parameters);

        
    }
}



