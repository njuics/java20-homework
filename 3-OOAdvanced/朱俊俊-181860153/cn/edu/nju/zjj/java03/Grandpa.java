package cn.edu.nju.zjj.java03;

public class Grandpa implements Sorter{

    private static Grandpa grandpa;

    static {
        grandpa = new Grandpa();
    }

    private Grandpa(){}

    public static Grandpa getGrandpa() {
        return grandpa;
    }

    int grandpaCompare(Calabash a, Calabash b) {
        return a.getIndex() - b.getIndex();
    }

    void grandpaSwap(Calabash[] calabashes, int a, int b) {
        Calabash tmp = calabashes[a];
        calabashes[a] = calabashes[b];
        calabashes[b] = tmp;
    }

    @Override
    public void sort(Calabash[] calabashes) {
        int n = calabashes.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (grandpaCompare(calabashes[j], calabashes[j + 1]) > 0) {
                    grandpaSwap(calabashes, j, j + 1);
                }
            }
        }
    }

    public void callOff(Calabash[] calabashes){
        for (Calabash calabash:calabashes){
            System.out.print(calabash+" ");
        }
        System.out.print("\n");
    }
}
