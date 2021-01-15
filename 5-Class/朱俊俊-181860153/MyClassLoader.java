import java.util.Base64;

public class MyClassLoader extends ClassLoader{
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromBase64(name);
        return defineClass(null, b, 0, b.length);
    }

    private byte[] loadClassFromBase64(String str){
        byte[] decoded = Base64.getDecoder().decode(str);
        return decoded;
    }
}
