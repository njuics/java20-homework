package sortset;
import java.util.Random;
import object.Calabash;

public interface Sortset{
    public default  void randLine(Calabash[] grandsons) {
        Random rand = new Random();
        int len = grandsons.length;
        for (int i = len; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(grandsons, randInd, i - 1);
        }
    }

    public default void newSort(Calabash[] grandsons) {
        int len = grandsons.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (grandsons[i].getAge() < grandsons[j].getAge()) {
                    swap(grandsons, i, j);
                }
            }
        }
    }

    default void swap(Calabash[] grandsons, int a, int b) {
        Calabash temp = grandsons[a];
        grandsons[a] = grandsons[b];
        grandsons[b] = temp;
    }

    public default void report(Calabash[] grandsons) {
        for (Calabash huluwa : grandsons) {
            huluwa.sayName();
        }
        System.out.println();
    }

};