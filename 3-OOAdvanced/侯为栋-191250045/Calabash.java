// package java20homework.ooadvanced;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Calabash implements Comparable<Calabash> {
    private int seniority;
    private int position;
    private String name;

    public static int calabashSum;

    static {
        calabashSum = 0;
    }

    public Calabash(int seniority, String name) {
        ++Calabash.calabashSum;
        this.seniority = seniority;
        this.name = name;
        this.position = -1;
    }

    public int getSeniority() {
        return this.seniority;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void exchangePos(Calabash brother, Calabash[] queue) {
        int broPos = brother.getPosition();
        int selfPos = this.position;
        queue[broPos] = this;
        queue[selfPos] = brother;
        brother.setPosition(selfPos);
        this.position = broPos;
    }

    public int pickPosition(boolean[] pos) {
        //选择自己的位置，并把自己的位置告诉爷爷
        int index = -1;
        try {
            Random rand = SecureRandom.getInstanceStrong();
            index = rand.nextInt(7);
            while (pos[index]) {
                index = rand.nextInt(7);
            }
            pos[index] = true;
            this.position = index;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return index;
    }

    public void callName() {
        System.out.println(this.name + "!");
    }

    @Override
    public int compareTo(Calabash brother) {
        return this.seniority - brother.getSeniority();
    }
}
