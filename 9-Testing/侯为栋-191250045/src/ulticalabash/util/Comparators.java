package ulticalabash.util;

public class Comparators {

    public static int dict(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int minLen = Math.min(aLen, bLen);
        for (int i = 0; i < minLen; ++i) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            if (aChar == bChar) continue;
            if (aChar > bChar) return 1;
            return -1;
        }
        if (aLen > bLen) return 1;
        if (aLen < bLen) return -1;
        return 0;
    }


}