import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("reading file...");
        Class<?> cls = (new CustomizedClassLoader()).findClass("src/class.txt");
        System.out.println("--------------------------------------------------");

        //print info

        String name = cls.getName();
        System.out.println("name:" + name);
        System.out.println("--------------------------------------------------");

        Method[] methodsdList = cls.getDeclaredMethods();
        Constructor<?>[] constructorsList = cls.getDeclaredConstructors();
        Field[] fieldsList = cls.getDeclaredFields();

        for (int i = 0; i < methodsdList.length; i++)
        {
            int t=i+1;
            System.out.println("method " + t + ": " + methodsdList[i].toString());
        }
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < constructorsList.length; i++)
        {
            int t=i+1;
            System.out.println("constructor " + t + ": " + constructorsList[i].toString());
        }
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < fieldsList.length; i++)
        {
            int t=i+1;
            System.out.println("field " + t + ": " + fieldsList[i].toString());
        }
        System.out.println("--------------------------------------------------");

        //create an instanse
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class,Integer.TYPE,Integer.TYPE);
        constructor.setAccessible(true);
        Object[] argsList = new Object[3];
        argsList[0] = new String("monster");
        argsList[1] = 100;
        argsList[2] = 50;

        Object instance = constructor.newInstance(argsList);
        System.out.println("created an instance:" + instance);
    }
}
