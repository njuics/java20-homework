/*
 * @Author: zb-nju
 * @Date: 2020-10-18 11:29:25
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-10-18 15:50:05
 */
import java.io.*;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.lang.*;

public class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(null, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName)  {
        File file = new File(fileName);
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try{
            FileInputStream is = new FileInputStream(file);
            int nextValue = 0;
            try {
                while ( (nextValue = is.read()) != -1 ) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
			e.printStackTrace();
        }
        Decoder decoder = Base64.getDecoder();
        String stringCode = new String(byteStream.toByteArray());
        buffer = decoder.decode(stringCode);
        return buffer;
    }
}