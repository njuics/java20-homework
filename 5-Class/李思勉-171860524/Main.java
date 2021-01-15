import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    static MyClassLoader classLoader = new MyClassLoader();
    // 加载Monster类
    static void loadMonster(){
        try {
            // 从字符串文件加载Monster类
            classLoader.findClass("Monster");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 创建Monster实例
    static Object newMonster(String name,int health,int damage){
        Class mc = null;
        try {
            mc = Class.forName("Monster");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class[] classes = new Class[] { String.class,int.class,int.class };
        Constructor constructor = null;
        try {
            constructor = mc.getDeclaredConstructor(classes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj =  constructor.newInstance(name,health,damage);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
    // 打印实例的属性和方法
    static void printObj(Object obj){
        Class objClass = obj.getClass();
        // 打印属性
        System.out.println("该对象的所有属性如下：");
        Field fields[] = objClass.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field.toString());
        }
        // 打印方法
        System.out.println("该对象的所有方法如下：");
        Method methods[] = objClass.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.toString());
        }
    }
    public static void main(String[] args){
        // 加载Monster类
        loadMonster();
        // 创建Monster实例
        Object obj = newMonster("蝎子精",100,100);
        // 打印实例的属性和方法
        printObj(obj);
    }
}
