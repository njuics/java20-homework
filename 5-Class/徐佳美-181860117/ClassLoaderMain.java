
import java.lang.reflect.Constructor;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderMain {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {

         // 加载文件的绝对路径
        String classPath = "/home/njucs/Class3_fall/JAVAClass/Javahomework/java20-homework/5-Class/徐佳美-181860117/Test";
        CustomClassLoader myClassLoader = new CustomClassLoader(classPath,1);//0:从class构建 1:从base64构建
        // 加载这个class文件
        Class<?> Monster = Class.forName("Monster", true, myClassLoader);
        //打印构造器，属性，方法
        printInformation(Monster);
        //检查是否由自定义加载器加载
        System.out.println("类加载器是:" + Monster.getClassLoader());
        //构造实例
        try{
            Constructor<?> constructor=Monster.getDeclaredConstructor(java.lang.String.class,int.class,int.class);
            constructor.setAccessible(true);
            Object XJM= constructor.newInstance("sevenxqq", 7, 777);
        }catch (InstantiationException ie){System.out.println("InstantiationException");return;}
        catch (IllegalAccessException iae){System.out.println("IllegalAccessException");return;}
        catch (NoSuchMethodException nme){System.out.println("NoSuchMethodException");return;}
        catch (InvocationTargetException ite){System.out.println("InvocationTargetException");return;}
        ///////////
    }

    private static void printInformation(Class<?> Testclass){
        Constructor[] con = Testclass.getDeclaredConstructors();
        for (int i = 0; i < con.length; i++)
            System.out.println(con[i]);

        Field[] field = Testclass.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (int i = 0; i < field.length; i++) { // 遍历所有属性
            String name = field[i].getName(); // 获取属性的名字
            String type = field[i].getGenericType().toString(); // 获取属性的类型
            System.out.println(type + " " + name);

        }

        Method m[] = Testclass.getDeclaredMethods();
        for (int i = 0; i < m.length; i++)
            System.out.println(m[i].toString());
        
        System.out.println("print over");
        
    }

}