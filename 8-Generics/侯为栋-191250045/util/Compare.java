// package java20homework.generics.util;

public class Compare {

    /**
     * 根据字符串的字典序返回先后顺序
     *
     * @param a
     * @param b
     * @return 0 a == b; 1 a > b; -1 a < b
     */
    public static int dict(String a, String b) {
        int selfLen = a.length(), broLen = b.length();
        for (int i = 0; i < Math.min(selfLen, broLen); ++i) {
            char selfChar = a.charAt(i);
            char broChar = b.charAt(i);
            if (selfChar == broChar) continue;
            if (selfChar > broChar) return 1;
            return -1;
        }
        if (selfLen > broLen) return 1;
        if (selfLen < broLen) return -1;
        return 0;
    }


}
