package ulticalabash.util;

import ulticalabash.character.Creature;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {

    public static <T extends Creature> void sort(ArrayList<T> list, Comparator<T> comparator) {
        int len = list.size();
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < len - i; ++j) {
                T a = list.get(j);
                T b = list.get(j + 1);
                if (comparator.compare(a, b) > 0) {
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
        }
    }

}
