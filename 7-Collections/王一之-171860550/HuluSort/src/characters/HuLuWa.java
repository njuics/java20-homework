package characters;

public class HuLuWa extends Unit implements Comparable<Unit> {

    public enum HuLuColor {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
    }

    public enum Gender {
        MALE, FEMALE
    }

    public static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }

    public static Gender getRandomGender() {
        if (Math.random() > 0.5)
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }

    public final int rank;
    public final HuLuColor color;
    public final Gender gender;
    public final String name;

    public HuLuWa(int rank, HuLuColor color) {
        this.rank = rank;
        this.color = color;
        this.gender = HuLuWa.getRandomGender();
        this.name = HuLuWa.getRandomString(5);
        this.pos = -1;//目前不维护位置
    }

    @Override
    public String report() {
        return "" + name + "  " + gender.toString();
    }

    @Override
    public int compareTo(Unit hulu) {
        if (!(hulu instanceof HuLuWa))
            return 0;
        return name.compareTo(((HuLuWa) hulu).name);
    }
}