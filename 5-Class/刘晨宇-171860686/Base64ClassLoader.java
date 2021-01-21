import java.io.*;
import java.util.Arrays;

public class Base64ClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64 = loadBase64FromFile(name);
        if(base64 == null) {
            throw new ClassNotFoundException();
        }
        byte[] byteCode = decodeBase64(base64);
        if(byteCode == null) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, byteCode, 0, byteCode.length);
    }

    private String loadBase64FromFile(String filename) {
        // get base64 encoded file from filename relative to classpath
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                filename.replace('.', File.separatorChar) + ".b64");
        if(inputStream == null) {
            System.out.println("Base 64 file with required name doesn't exist.");
            return null;
        }
        // read all characters from base64 encoded file, and put them into a string
        StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
            }
        } catch(IOException e) {
            System.out.println("IOException occurred while reading base64 file.");
            return null;
        }
        return new String(stringBuilder);
    }

    private byte[] decodeBase64(String base64) {
        // length of base64 string must be an integer multiple of 4
        if(base64.length() % 4 != 0) {
            System.out.println("Error while decoding base 64 code.");
            return null;
        }
        // perform character-to-byte indexing
        byte[] encodedBytes = new byte[base64.length()];
        int extraBytes = 0;
        for(int i = 0; i < base64.length(); i++) {
            char c = base64.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                encodedBytes[i] = (byte)(c - 'A');
            } else if(c >= 'a' && c <= 'z') {
                encodedBytes[i] = (byte)(c - 'a' + 26);
            } else if(c >= '0' && c <= '9') {
                encodedBytes[i] = (byte)(c - '0' + 52);
            } else if(c == '+') {
                encodedBytes[i] = (byte)62;
            } else if(c == '/') {
                encodedBytes[i] = (byte)63;
            } else if(c == '=') {
                encodedBytes[i] = (byte)0;
                extraBytes++;
            } else {
                System.out.println("Error while decoding base 64 code.");
                return null;
            }
        }
        // decode every 4 bytes of base64 code
        byte[] decodedBytes = new byte[encodedBytes.length / 4 * 3];
        for(int i = 0; i < encodedBytes.length / 4; i++) {
            decodedBytes[3 * i] = (byte)((encodedBytes[4 * i] << 2) | (encodedBytes[4 * i + 1] >>> 4));
            decodedBytes[3 * i + 1] = (byte)((encodedBytes[4 * i + 1] << 4) | (encodedBytes[4 * i + 2] >>> 2));
            decodedBytes[3 * i + 2] = (byte)((encodedBytes[4 * i + 2] << 6) | (encodedBytes[4 * i + 3]));
        }
        int decodedLength = encodedBytes.length / 4 * 3 - extraBytes;
        return Arrays.copyOfRange(decodedBytes, 0, decodedLength);
    }
}








