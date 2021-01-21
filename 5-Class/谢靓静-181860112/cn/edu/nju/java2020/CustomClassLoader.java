package cn.edu.nju.java2020;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class CustomClassLoader extends ClassLoader {
    private String base64String;

    public CustomClassLoader(String base64String) {
        this.base64String = base64String;
    }

    @Override
    public Class<?> findClass(String name) {
        byte[] b = loadClassFromString(base64String);
        Class log = null;
        if (null != b) {
            log = defineClass(name, b, 0, b.length);
        }
        return log;
    }

    private byte[] loadClassFromString(String base64String) {
        byte[] buffer = new byte[0];
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            if (null != base64String && !base64String.equals("")) {
                buffer = decoder.decodeBuffer(base64String);
            }
        } catch (IOException e) {
            System.out.println("Base64toByte() Exception");
        }
        return buffer;
    }
}