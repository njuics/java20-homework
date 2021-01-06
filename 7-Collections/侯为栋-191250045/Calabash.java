// package java20homework.collections;

import lombok.Getter;

import java.util.Random;
import java.util.UUID;

@Getter
public class Calabash implements Comparable<Calabash> {
    private String name;
    private String sex;

    public Calabash() {
        this.name = UUID.randomUUID().toString();
        Random rand = new Random();
        int sexNum = rand.nextInt(2);
        if (sexNum == 0) this.sex = "boy";
        else this.sex = "girl";
    }

    @Override
    public int compareTo(Calabash bro) {
        String broName = bro.getName();
        int selfLen = this.name.length(), broLen = broName.length();
        for (int i = 0; i < Math.min(selfLen, broLen); ++i) {
            char selfChar = this.name.charAt(i);
            char broChar = broName.charAt(i);
            if (selfChar == broChar) continue;
            if (selfChar > broChar) return 1;
            return -1;
        }
        if (selfLen > broLen) return 1;
        if (selfLen < broLen) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return name + " " + this.sex + "! ";
    }
}
