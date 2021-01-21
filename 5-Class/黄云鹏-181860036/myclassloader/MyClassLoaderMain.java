package myclassloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class MyClassLoaderMain {
	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader myclassloader = new MyClassLoader();
		String classname = "Monster";
		Class<?> myclass = myclassloader.findClass(classname);
		
		printAllFields(myclass);  // 打印所有成员属性
		printAllMethods(myclass); // 打印所有成员方法
		printAllConstructors(myclass); // 打印所有构造方法
		printInstance(myclass); // 构造实例
	}
	
	public static void printAllFields(Class<?> myclass) {
		Field[] fields = myclass.getDeclaredFields();
		System.out.println("======All fields are as below:======");
		for(Field f:fields) {
			System.out.println(f);
		}
		System.out.println();
	}
	
	public static void printAllMethods(Class<?> myclass) {
		Method[] methods = myclass.getMethods();
		System.out.println("======All methods are as below:======");
		for(Method m:methods) {
			System.out.println(m);
		}
		System.out.println();
	}
	
	public static void printAllConstructors(Class<?> myclass) {
		Constructor<?>[] constructors = myclass.getDeclaredConstructors();
		System.out.println("======All constructors are as below:======");
		for(Constructor<?> c:constructors) {
			System.out.println(c);
		}
		System.out.println();
	}
	
	public static void printInstance(Class<?> myclass) {
		String name = "Gesla";
		int health = 100;
		int damage = 50;
		try {
			Constructor<?> con = myclass.getDeclaredConstructor(String.class,int.class,int.class);
			con.setAccessible(true);
			Object obj = con.newInstance(name,health,damage);
			System.out.println("======Instance======");
			 System.out.println(obj);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
