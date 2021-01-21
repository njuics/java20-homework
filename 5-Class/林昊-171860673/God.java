import java.lang.reflect.*;
import java.util.*;

public class God {
    public static void main(String[] args) {
        try {
            CustomClassLoader clsLoader = new CustomClassLoader(args[0]);
            Class<?> cls = clsLoader.loadClass("Monster");

            // Create an instance 'Boss' of the type of the object 'Monster'
            Constructor<?> declaredCons = cls.getDeclaredConstructor(java.lang.String.class, int.class, int.class);
            declaredCons.setAccessible(true);
            Object obj = declaredCons.newInstance("Boss",100,10);
            printInstanceInfo(obj);
            printConstructors(obj);
            printFields(obj);
            printMethods(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void printInstanceInfo(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Class curClass = obj.getClass();
        System.out.printf("Instance: %s\nName: %s\nHealth: %d\nDamage: %d\n",
                obj.toString(),
                curClass.getDeclaredField("name").get(obj),
                curClass.getDeclaredField("health").get(obj),
                curClass.getDeclaredField("damage").get(obj));
    }

    private static void printConstructors(Object obj){
        Constructor[] constructors = obj.getClass().getDeclaredConstructors();
        System.out.println("Instance Constructors:");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void printFields(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        System.out.println("Instance Fields:");
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void printMethods(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        System.out.println("Instance Methods:");
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
