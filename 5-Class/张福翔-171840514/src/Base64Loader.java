import java.util.Base64;

public class Base64Loader extends ClassLoader {
    public Class<?> findClass(String base64) {
        Base64.Decoder b64Decoder = Base64.getDecoder();
        byte[] classContent = b64Decoder.decode(base64);
        return defineClass(classContent, 0, classContent.length);
    }
}
