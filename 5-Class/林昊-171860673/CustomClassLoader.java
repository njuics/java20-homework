import java.io.*;
import java.util.Base64;

public class CustomClassLoader extends ClassLoader {
    private String classPath;
    private ClassLoader parent;

    public CustomClassLoader(String classPath) {
        this(ClassLoader.getSystemClassLoader(), classPath);
    }

    public CustomClassLoader(ClassLoader parent, String classPath) {
        super(parent);
        this.parent = parent;
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String fileName) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassFromBase64File(this.classPath + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return defineClass(fileName, b, 0, b.length);
    }

    private byte[] loadClassFromBase64File(String fileName)throws FileNotFoundException, ClassNotFoundException{
        byte[] buffer = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
            buffer = Base64.getDecoder().decode(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
