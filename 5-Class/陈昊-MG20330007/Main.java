import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = (new CustomClassLoader()).findClass("class.txt");
            String name = cls.getName();
            System.out.println("name:" + name);
            Method[] mtdList = cls.getDeclaredMethods();
            Constructor<?>[] ctrList = cls.getDeclaredConstructors();
            Field[] fldList = cls.getDeclaredFields();

            for (int i = 0; i < mtdList.length; i++)
                System.out.println("method " + i + ": " + mtdList[i].toString());

            for (int i = 0; i < ctrList.length; i++)
                System.out.println("constructor " + i + ": " + ctrList[i].toString());

            for (int i = 0; i < fldList.length; i++)
                System.out.println("field " + i + ": " + fldList[i].toString());

            Class<?>[] paramTypes = new Class[3];
            paramTypes[0] = java.lang.String.class;
            paramTypes[1] = int.class;
            paramTypes[2] = int.class;

            Constructor<?> ct = cls.getDeclaredConstructor(paramTypes);
            ct.setAccessible(true);
            Object[] argList = new Object[3];
            argList[0] = new String("Hello");
            argList[1] = 100;
            argList[2] = 20;

            Object ins = ct.newInstance(argList);
            System.out.println("create an instance" + ins);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }
}
