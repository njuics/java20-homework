package myhw5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class Main {
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MyClassLoader myclass=new MyClassLoader();
		String name="Monster";
		Class<?> hw5=myclass.findClass(name);
		
		output_name(hw5);
		get_instantiation(hw5);
		output_attribution(hw5);
		output_function(hw5);
		
	}
	public static void output_name(Class<?> a) {
		String name=a.getName();
		System.out.println("the name of class is "+name);
		System.out.println("-------------------------------------------------------------");
	}
	public static void output_attribution(Class<?> a) {
    	Field[] field=a.getDeclaredFields();
    	
    	System.out.println("the names of attributions are : ");
    	for(int i=0;i<field.length;i++) {
    		System.out.println(field[i]);
    		  
    	}
    	System.out.println("-------------------------------------------------------------");
    }
    public static void output_function(Class<?> a) {
    	Method[] method=a.getMethods();    	
    	System.out.println("the names of methods are : ");
    	for(int i=0;i<method.length;i++) {
    		System.out.println(method[i]);  
    	}
    	System.out.println("-------------------------------------------------------------");
    }
    
    public static void get_instantiation(Class<?> a) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	try {
    		
			Constructor wht=a.getDeclaredConstructor(String.class,int.class,int.class);
			wht.setAccessible(true);
			Object mon=wht.newInstance("wht",10,1);
			System.out.println(mon);  
			System.out.println("name of monster is wht");
			System.out.println("health of monster is 10");
			System.out.println("damage of monster is 1");
			System.out.println("-------------------------------------------------------------");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
