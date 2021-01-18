import java.util.ArrayList;
import java.util.Comparator;

public class Sort<T extends Comparable<T>, E extends Comparator<T>> {
    void sort(ArrayList<T> arrayList) {
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    T tmp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, tmp);
                }
            }
        }
    }

    void sort(ArrayList<T> arrayList, E e) {
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (e.compare(arrayList.get(j), arrayList.get(j + 1)) > 0) {
                    T tmp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, tmp);
                }
            }
        }

    }

}
