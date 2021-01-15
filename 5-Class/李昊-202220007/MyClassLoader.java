import javax.xml.bind.DatatypeConverter;
import java.io.*;

/**
 * @author q
 * @create 2020-10-18 21:36
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) {
        byte[] b = new byte[0];
        try {
            b = loadClassFromString(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(null, b, 0, b.length);
    }
    private byte[] loadClassFromString(String name) throws IOException {
        byte[] buffer;

        InputStream is = new FileInputStream("F:\\二学位\\高级java程序设计\\code\\java20-homework\\5-Class\\src\\some.txt");
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        line = reader.readLine(); // 读取第一行

        reader.close();
        is.close();

        buffer = DatatypeConverter.parseBase64Binary(line);
        return buffer;
    }
}
