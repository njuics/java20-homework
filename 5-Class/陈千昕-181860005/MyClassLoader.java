import java.io.*;
import java.util.Base64;

class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name, String filePath) {
        try {
            // 寻找字节码
            byte[] code = loadAndDecodeFromBase64File(filePath);
            // 组装Class对象
            return defineClass(name, code, 0, code.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    private byte[] loadAndDecodeFromBase64File(String fileName) throws IOException{
        byte[] buffer = null;
        FileInputStream fin = new FileInputStream(fileName);
        buffer = new byte[fin.available()];
        fin.read(buffer);
        fin.close();
        buffer = Base64.getDecoder().decode(buffer);
        
        return buffer;
    }
} 