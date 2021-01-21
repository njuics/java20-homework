import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Reflection {
    static final String encodedClassName = "Monster";

    public static void main(String[] args) {
        Base64ClassLoader customClassLoader = new Base64ClassLoader();
        Class<?> encodedClass;
        try {
            // load base64 encoded class from file
            encodedClass = Class.forName(encodedClassName, true, customClassLoader);
            // create an object of encoded class
            Constructor<?> constructor = encodedClass.getDeclaredConstructor(String.class, Integer.TYPE, Integer.TYPE);
            constructor.setAccessible(true);
            Object instance = constructor.newInstance("Godzilla", 1919810, 114514);
            System.out.println("Created an object of encoded class: " + instance.toString());
            // find out inherited methods and fields
            ArrayList<Method> inheritedMethods = new ArrayList<>();
            ArrayList<Field> inheritedFields = new ArrayList<>();
            Class<?> superClass = encodedClass.getSuperclass();
            while(superClass != null) {
                for(Method method: superClass.getDeclaredMethods()) {
                    int modifier = method.getModifiers();
                    if(Modifier.isPublic(modifier) || Modifier.isProtected(modifier)) {
                        inheritedMethods.add(method);
                    }
                }
                for(Field field: superClass.getDeclaredFields()) {
                    int modifier = field.getModifiers();
                    if(Modifier.isPublic(modifier) || Modifier.isProtected(modifier)) {
                        inheritedFields.add(field);
                    }
                }
                superClass = superClass.getSuperclass();
            }
            System.out.println("Class canonical name:");
            System.out.println("\t" + encodedClass.getCanonicalName());
            System.out.println("Methods declared in class:");
            for(Method method: encodedClass.getDeclaredMethods()) {
                System.out.println("\t" + method);
            }
            System.out.println("Fields declared in class:");
            for(Field field: encodedClass.getDeclaredFields()) {
                System.out.println("\t" + field);
            }
            System.out.println("Inherited methods:");
            inheritedMethods.forEach(method -> System.out.println("\t" + method));
            if(inheritedMethods.isEmpty()) {
                System.out.println("\tNone");
            }
            System.out.println("Inherited fields:");
            inheritedFields.forEach(field -> System.out.println("\t" + field));
            if(inheritedFields.isEmpty()) {
                System.out.println("\tNone");
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Class loading failed.");
        } catch(NoSuchMethodException e) {
            System.out.println("Required constructor not found.");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to required constructor.");
        } catch (InstantiationException e) {
            System.out.println("Error while instantiating with the constructor.");
        } catch (InvocationTargetException e) {
            System.out.println("Unhandled exception in constructor.");
        }
    }
}
