package cn.edu.nju.zjj.java03;

public class Main {
    public static void process(Sorter sorter,Calabash[] calabashes)
    {
        new CalabashTogether().shuffle(calabashes);
        sorter.sort(calabashes);
        Grandpa.getGrandpa().callOff(calabashes);
    }

    public static void main(String[] args)
    {
        Calabash[] calabashes = new Vine().makeCalabashes();
        process(Grandpa.getGrandpa(),calabashes);
        process(new CalabashTogether(),calabashes);
    }
}
