package Class;

import java.util.Base64;

public class MyClassLoader extends ClassLoader{

    private String base64Bytes = null;

    public MyClassLoader(String bytes){
        base64Bytes = bytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = null;
        bytes = readBytes(base64Bytes);

        return super.defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 将base64编码格式转化为byte[]
     * @param str
     * @return
     */
    private byte[] readBytes(String str){

        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(str);
        return bytes;
    }
}
