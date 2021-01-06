import java.io.*;
import java.util.Base64;
import java.util.Base64.Decoder;

public class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(null, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        
        try {
            InputStream inputStream = new FileInputStream(fileName);
            int nextValue = 0;
            try {
                while ((nextValue = inputStream.read()) != -1) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        Decoder decoder = Base64.getDecoder();
        buffer = decoder.decode(byteStream.toByteArray());
        
        return buffer;
    }
}