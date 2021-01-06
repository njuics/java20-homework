package homework5;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 新建自己定义的类加载器
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> myClass = null;
        try {
            // 加载Monster类
            myClass = classLoader.findClass("Monster");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // 输出属性，方法和构造器
        System.out.println("获取的Field：");
        Field[] allFeild = myClass.getFields();
        for (Field field : allFeild) {
            System.out.println(field.toString());
        }
        System.out.println("获取的DeclaredFiled：");
        Field[] allDeclaredFeild = myClass.getDeclaredFields();
        for (Field field : allDeclaredFeild) {
            System.out.println(field.toString());
        }

        System.out.println("获取的Method：");
        Method[] allMethod = myClass.getMethods();
        for (Method method : allMethod) {
            System.out.println(method.toString());
        }
        System.out.println("获取的DeclaredMethod：");
        Method[] allDeclaredMethod = myClass.getDeclaredMethods();
        for (Method method : allDeclaredMethod) {
            System.out.println(method.toString());
        }

        System.out.println("获取的Constructor：");
        Constructor<?>[] allCons = myClass.getConstructors();
        for (Constructor<?> cons : allCons) {
            System.out.println(cons);
        }
        System.out.println("获取的DeclaredConstructor：");
        Constructor<?>[] allDeclaredCons = myClass.getDeclaredConstructors();
        for (Constructor<?> cons : allDeclaredCons) {
            System.out.println(cons);
        }

        Class[] classes = new Class[] {String.class, int.class, int.class};
        Constructor<?> cons = myClass.getDeclaredConstructor(classes);
        cons.setAccessible(true); // 因为这个构造器是私有的，因此需要加入这条语句
        try {
            Object monsterObj = cons.newInstance("demo", 0, 0);
            System.out.println("创建的实例：");
            System.out.println(monsterObj);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
