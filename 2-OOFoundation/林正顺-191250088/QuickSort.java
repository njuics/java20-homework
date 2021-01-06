public class QuickSort extends Sort{
    public void concreteSort(CalabashBrothers[] brothers, int l, int r) {
        if (l >= r) return;

        int x = brothers[l + r >> 1].getNumber();
        int i = l - 1, j = r + 1;
        CalabashBrothers temp;
        while (i < j) {
            do i++; while (brothers[i].getNumber() < x);
            do j--; while (brothers[j].getNumber() > x);
            if (i < j) {
                temp = brothers[i];
                brothers[i] = brothers[j];
                brothers[j] = temp;
            }
        }

        concreteSort(brothers, l, j);
        concreteSort(brothers, j + 1, r);
    }
}
