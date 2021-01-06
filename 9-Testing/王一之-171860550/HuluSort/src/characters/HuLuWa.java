package characters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HuLuWa extends Unit implements Comparable<Unit> {

    public enum HuLuColor {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
        private static final List<HuLuColor> VALUES =Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        public static HuLuColor randomColor()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public enum Gender {
        MALE, FEMALE
    }

    public final int rank;
    public final HuLuColor color;
    public final Gender gender;
    public final String name;

    public static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sBuffer = new StringBuilder();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sBuffer.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sBuffer.toString();
    }

    public static Gender getRandomGender() {
        if (Math.random() > 0.5)
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }

    public HuLuWa(int rank, HuLuColor color) {
        this.rank = rank;
        this.color = color;
        this.gender = HuLuWa.getRandomGender();
        this.name = HuLuWa.getRandomString(5);
    }
    public HuLuWa(int rank) {
        this.rank = rank;
        this.color = HuLuColor.randomColor();
        this.gender = HuLuWa.getRandomGender();
        this.name = HuLuWa.getRandomString(5);
    }

    @Override
    public String toString() {
        return "huluwa: "+ name + "  " + gender.toString();
    }

    @Override
    public int compareTo(Unit hulu) {
        if (!(hulu instanceof HuLuWa))
            return 0;
        return name.compareTo(((HuLuWa) hulu).name);
    }
}