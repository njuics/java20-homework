import java.io.*;
import java.lang.reflect.Field; 
import java.lang.reflect.Method; 
import java.lang.reflect.Constructor;
import java.util.Base64;

class CustomClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer = byteStream.toByteArray();
        return buffer;       
    }
}

public class Main{  

    public static void main(String[] args) {  
        new Main().test();  
    }  

    private void decodeFile(String infile,String outfile){//Base64 to bytestream
        try (FileInputStream encoded = new FileInputStream(infile); FileOutputStream decoded = new FileOutputStream(outfile)) {
            byte[] buffer = new byte[encoded.available()];
            encoded.read(buffer);
            Base64.Decoder base64Decoder = Base64.getMimeDecoder();
            decoded.write(base64Decoder.decode(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test() {  
        String srcFile="src.txt";
        String className="Monster";
        decodeFile(srcFile,className+".class");
        CustomClassLoader classloader = new CustomClassLoader();
        try {  
            //load class
            Class<?> c=classloader.loadClass(className);
            //print attributes
            Field f[] = c.getDeclaredFields();
            for (int i = 0; i < f.length; i++)
                System.out.println(f[i].toString());
            //print functions
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
            //create instance
            Constructor con = c.getDeclaredConstructor(String.class,int.class,int.class);
            Object obj=con.newInstance("Mike",10,10);
        } catch (Exception e) {  
            e.printStackTrace();  
        }

    }  
}