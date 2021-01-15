package cn.edu.nju.zjj.java03;

public class Calabash {
    static final String[] nameList = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    private int index;
    private String name;

    Calabash(int i, String name) {
        this.index = i;
        this.name = name;
    }

    int getIndex() {
        return index;
    }

    String getName() {
        return name;
    }

    int selfCompare(Calabash calabash) {
        return this.index - calabash.index;
    }

    static void selfSwap(Calabash[] calabashes, int i, int j) {
        Calabash tmp = calabashes[i];
        calabashes[i] = calabashes[j];
        calabashes[j] = tmp;
    }

    @Override
    public String toString() {
        return name;
    }

}
