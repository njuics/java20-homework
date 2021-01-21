package cn.edu.nju.zjj.java03;

import java.util.Random;

public class CalabashTogether implements Sorter {
    @Override
    public void sort(Calabash[] calabashes) {
        int n = calabashes.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (calabashes[j].selfCompare(calabashes[j + 1]) > 0) {
                    calabashes[j].selfSwap(calabashes, j, j + 1);
                }
            }
        }
    }

    public void shuffle(Calabash[] calabashes) {
        Random rnd = new Random();
        int n = calabashes.length;
        for (int i = n; i > 1; i--) {
            calabashes[i - 1].selfSwap(calabashes, i - 1, rnd.nextInt(i));
        }
    }
}
