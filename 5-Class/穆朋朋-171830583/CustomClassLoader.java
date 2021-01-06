// 穆朋朋 171830583
import java.util.Base64;

public class CustomClassLoader extends ClassLoader {
    private byte [] b;
 
    public CustomClassLoader(String s) {
        b=Base64.getDecoder().decode(s);    // 解码；
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        return defineClass(name, b, 0, b.length); // 由于字节码数组不需要从文件读取，直接可以利用defineClass方法获得结果。
    }
}