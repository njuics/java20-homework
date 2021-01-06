import java.lang.reflect.*;
import java.util.regex.*;

public class LoadClass{
	public static void main(String[] args){
		Pattern p = Pattern.compile("\\w+\\.");
		Base64ClassLoader bcl = new Base64ClassLoader();
		try{
			Class<?> ec = bcl.loadClass("EncrpytedClass");
			Method[] methods = ec.getDeclaredMethods();
			Field[] fields = ec.getDeclaredFields();
			Constructor[] ctors = ec.getDeclaredConstructors();
			System.out.println("Class Name:");
			System.out.println(ec.getName());
			System.out.println("Field:");
			for(Field f : fields){
				System.out.println(p.matcher(f.toString()).replaceAll(""));
			}
			System.out.println("Methods:");
			for(Method m : methods){
				System.out.println(p.matcher(m.toString()).replaceAll(""));
			}
			System.out.println("Constructors:");
			for(Constructor c : ctors){
				System.out.println(p.matcher(c.toString()).replaceAll(""));
			}
			System.out.println("Instance:");
			ctors[0].setAccessible(true);
			Object obj = ctors[0].newInstance("Naga", 999, 999);
			System.out.println(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}