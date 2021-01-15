import java.util.Base64;
import java.util.Base64.Decoder;
import java.io.*;
class MyLoader extends ClassLoader {
    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(null, b, 0, b.length);
    }
    private byte[] loadClassFromFile(String fileName) {
        File file=new File(fileName);
        FileInputStream  fileinput=null;
        try {
            fileinput=new FileInputStream(file);     
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception");
        }
        byte[] contentByte=new byte[(int)file.length()];
        try{
            fileinput.read(contentByte);
        } catch (IOException e){
            System.out.println("IO Exception");
        }
        String contentStr=new String(contentByte);
        Decoder decoder=Base64.getDecoder();
        byte[] decoderContent= decoder.decode(contentStr);
        return decoderContent;
    }
}