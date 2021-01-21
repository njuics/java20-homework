import java.io.*;
import java.util.Base64;

public class MyClassLoader extends ClassLoader {
    final Base64.Decoder decoder = Base64.getDecoder();
    final String classPath = getClass().getResource("/").toString().substring(6);
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);// 核心部分，可以是二维码，网络，本地
        return defineClass(name, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName) {

        String fileString = null;
        try {
            // 从文件中读取字符串
            char[] inBuffer = new char[952];
            FileReader fileReader = new FileReader(fileName);
            fileReader.read(inBuffer);
            fileString = String.valueOf(inBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将字符串解码
        byte[] buffer = decoder.decode(fileString);
        try {
            // 将解码后的字符串写入classPath目录下的文件
            File file = new File(classPath+fileName+".class");
            OutputStream out = new FileOutputStream(file);
            out.write(buffer);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 从文件中读取字节码
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream (fileName + ".class");
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}