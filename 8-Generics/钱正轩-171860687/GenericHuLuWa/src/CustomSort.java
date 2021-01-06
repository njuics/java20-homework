import java.util.Collections;
import java.util.List;

public class CustomSort {
    private CustomSort() {
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void insertSort(List<T> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    private static <T extends Comparable<? super T>> void quickSort(List<T> list, int start, int end) {
        if (start < end) {
            T pivot = list.get(end);
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (list.get(j).compareTo(pivot) < 0) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }
            Collections.swap(list, i + 1, end);
            int q = i + 1;
            quickSort(list, start, q - 1);
            quickSort(list, q + 1, end);
        }
    }
}
