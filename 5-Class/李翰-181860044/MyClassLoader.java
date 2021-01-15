import java.util.Base64;
import java.io.*;
import java.lang.reflect.*;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = null;
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            File file = new File(fileName);
            inputStream = new FileInputStream(file);
            while ((nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String base64Str = new String(byteStream.toByteArray());
        buffer = Base64.getDecoder().decode(base64Str);
        return buffer;
    }

    public static void reflect(Class c){
        System.out.println("Class Name:\n"+c.getName());
        System.out.println();

        System.out.println("Class Constructors:");
        Constructor C[] = c.getDeclaredConstructors();
        for (int i = 0; i < C.length; i++)
            System.out.println(C[i].toString());
        System.out.println();

        System.out.println("Class Fields:");
        Field f[] = c.getFields();
        for (int i = 0; i < f.length; i++)
            System.out.println(f[i].toString());
        System.out.println();

        System.out.println("Class Methods:");
        Method m[] = c.getMethods();
        for (int i = 0; i < m.length; i++)
            System.out.println(m[i].toString());
        System.out.println();
    }

    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        Class c = null;
        String path="bytecode.txt";   
        try{
            c = loader.findClass(path);
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
        // Create an object instance
        try { 
			Class[] parameterTypes={java.lang.String.class,int.class,int.class};
            Constructor constructor=c.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
			Object[] parameters={"object instance",1,1};
            Object instance=constructor.newInstance(parameters);
            System.out.println("Create an object instance: "+instance.toString());
		} catch (Exception e) {
			e.printStackTrace();
        }
        System.out.println();
        reflect(c);
    }
}