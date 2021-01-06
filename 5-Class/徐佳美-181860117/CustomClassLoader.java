import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sun.misc.BASE64Decoder;

public class CustomClassLoader extends ClassLoader {
    private String pathName;
    private int inmethod;
    byte[] buffer;

    public CustomClassLoader() {
    }

    public CustomClassLoader(String classPath, int inme) {
        pathName = classPath;
        inmethod = inme;
    }

    public static void main(String[] args) {

    }

    @Override
    // para1: name是类的全路径
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            loadClassFromFile();
            // defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> c = this.defineClass(name, buffer, 0, buffer.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    // 将文件转成字节码数组
    private void loadClassFromFile() throws IOException {
        // 从class文件构建
        if (inmethod == 0) {
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream(pathName.replace('.', File.separatorChar) + ".class");
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = 0;
            try {
                while ((nextValue = inputStream.read()) != -1) {
                    byteStream.write(nextValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer = byteStream.toByteArray();
            System.out.println("good run loadclass");
            // return buffer;
        }

        // 从base64编码的文件构建
        if (inmethod == 1) {
            try {
                Path path = Paths.get(pathName);
                Stream<String> lines = Files.lines(path);

                String content = lines.collect(Collectors.joining(System.lineSeparator()));
                lines.close();

                BASE64Decoder decoder = new BASE64Decoder();

                try {
                    if (content != null && !content.equals("")) {
                        buffer = decoder.decodeBuffer(content);
                    }
                } catch (IOException e) {
                    System.out.println("pathname Exception");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}