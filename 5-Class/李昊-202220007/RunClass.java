import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author q
 * @create 2020-10-18 21:56
 */
public class RunClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        MyClassLoader loader1 = new MyClassLoader();
        Class<?> clazz = loader1.findClass("some");
        //Object o = clazz.newInstance();

        System.out.println("name of this class is:");
        System.out.println("    " + clazz.getName());

        System.out.println("this class has methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println("    " + method);
        }

        System.out.println("this class has fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            System.out.println("    " + field);
        }

        System.out.println("this class has constructors:");
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        for (Constructor con : cons){
            System.out.println("    " + con);
        }

        System.out.println("this class has superclass:");
        String superClassName = clazz.getSuperclass().getName();
        System.out.println("    " + superClassName);

        System.out.println("new an instance:");
        Constructor con = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        con.setAccessible(true);
        Object o = con.newInstance("abc",1,1);
        System.out.println("    " + o.toString());

        System.out.println("get field value after new an instance:");
        for(Field field: fields){
            String name = field.getName();
            Object fieldValue = field.get(o);
            System.out.println("    " + name + ": " + fieldValue);
        }

    }
}
