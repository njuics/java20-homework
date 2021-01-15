import java.util.Base64;

public class Base64ClassLoader extends ClassLoader {

    public Class<?> findClass(String name, String base64) {
        byte[] buffer = Base64.getDecoder().decode(base64);
        return defineClass(name, buffer, 0, buffer.length);
    }
}