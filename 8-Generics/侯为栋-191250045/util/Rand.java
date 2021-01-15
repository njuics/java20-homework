import java.util.Random;
import java.util.UUID;

public class Rand {

    private static Random rand = new Random();

    public static String randomName() {
        int size = rand.nextInt(20) + 8;
        String base = UUID.randomUUID().toString().replace("-", "");
        StringBuilder builder = new StringBuilder();
        int len = base.length();
        for (int i = 0; i < size; ++i)
            builder.append(base.charAt(rand.nextInt(len)));
        return builder.toString();
    }

    public static String randomSex() {
        int sexNum = rand.nextInt(2);
        String res;
        if (sexNum == 0)
            res = "boy";
        else
            res = "girl";
        return res;
    }
}
