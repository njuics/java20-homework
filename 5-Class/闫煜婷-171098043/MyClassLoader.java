package Homework5;

import java.util.Base64;
public class MyClassLoader extends ClassLoader {
    byte[] parseBase64(String base64str){
        return Base64.getDecoder().decode(base64str);
    }
    public Class<?> findClass(String name, String base64str) throws ClassNotFoundException {
        byte[] b = parseBase64(base64str);
        return defineClass(name, b, 0, b.length);
    }

}
