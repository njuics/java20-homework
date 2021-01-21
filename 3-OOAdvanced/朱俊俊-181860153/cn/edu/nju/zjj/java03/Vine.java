package cn.edu.nju.zjj.java03;

public class Vine {
    public Calabash[] makeCalabashes() {
        Calabash[] calabashes = new Calabash[7];
        for (int i = 0; i < 7; i++) {
            calabashes[i] = new Calabash(i, Calabash.nameList[i]);
        }
        return calabashes;
    }
}
