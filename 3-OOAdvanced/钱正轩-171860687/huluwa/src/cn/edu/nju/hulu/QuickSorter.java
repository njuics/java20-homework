package cn.edu.nju.hulu;

public class QuickSorter extends AbstractSorter {

    /**
     * 快速排序
     */
    public QuickSorter() {
        super("Quick Sort", "n log n");
    }

    @Override
    public void sort(Sortable list) {
        int n = list.size();
        quickSort(0, n - 1, list);
    }

    private void quickSort(int start, int end, Sortable list) {
        if (start < end) {
            int pivot = end;
            int i = start - 1;
            for (int j = start; j < end; j++) {
                if (list.compare(j, pivot) < 0) {
                    i++;
                    list.swap(i, j);
                }
            }
            list.swap(i + 1, end);
            int q = i + 1;
            quickSort(start, q - 1, list);
            quickSort(q + 1, end, list);
        }
    }

}
