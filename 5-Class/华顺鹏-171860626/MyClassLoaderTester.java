import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTester {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classname = "unknown";
        MyClassLoader myclassloader = new MyClassLoader();
        Class c = myclassloader.findClass(classname);
        //Object object = c.newInstance();
        //看一下构造器
        for(Constructor con:c.getDeclaredConstructors()){
            System.out.println(con.toString());
        }
        Constructor<?> constructor = c.getDeclaredConstructor(String.class,int.class,int.class);
        constructor.setAccessible(true);
        Object object = constructor.newInstance("hw", 1, 1);

        //反射机制找出所有的属性
        for(Field field:c.getDeclaredFields())
            System.out.println(field.toString());
        //反射机制找出所有的方法
        for(Method method:c.getDeclaredMethods())
            System.out.println(method.toString());
    }
}
