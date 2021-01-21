package cn.edu.nju.hulu;

public class InsertSorter extends AbstractSorter {

    /**
     * 插入排序
     */
    public InsertSorter() {
        super("Insert Sort", "n^2");
    }

    @Override
    public void sort(Sortable list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            int j = i - 1;
            while (j >= 0 && list.compare(j, j + 1) > 0) {
                list.swap(j, j + 1);
                j--;
            }
        }
    }
}
