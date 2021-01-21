import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Base64;
import java.lang.reflect.*;
public class MyClassLoader extends ClassLoader{
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName){
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return Base64.getDecoder().decode(buffer);
    }
    private void printClass(Class myClass){
        System.out.println("constructor:");
        for (Constructor<?> constructor : myClass.getDeclaredConstructors()) {//构造方法
            System.out.println(constructor.toString());
        }
        System.out.println("Methods:");
        for (Method method : myClass.getDeclaredMethods()) {
            System.out.println(method.toString());
        }
        System.out.println("Fields:");
        for (Field field : myClass.getDeclaredFields()) {
            System.out.println(field.toString());
        }
    }
    public static void main(String[] ags)  {
        MyClassLoader loader=new MyClassLoader();
        try {
            Class<?> myClass = loader.findClass("Monster");
            loader.printClass(myClass);
            
            Constructor<?> constructor = myClass.getDeclaredConstructor(String.class, int.class, int.class);
            constructor.setAccessible(true);//设置构造参数为可访问
            Object monster = constructor.newInstance("Titan", 5000, 200);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}