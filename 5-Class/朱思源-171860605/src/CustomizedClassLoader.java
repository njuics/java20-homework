import java.io.*;
import java.util.Base64;

public class CustomizedClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] buffer = null;

        try {
            InputStream fin = new FileInputStream(name);
            buffer = new byte[fin.available()];
            int t=fin.read(buffer);
            fin.close();
            buffer = Base64.getDecoder().decode(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert buffer != null;
        return defineClass(null, buffer, 0, buffer.length);
    }

}
