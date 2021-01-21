public class GrandFatherSort implements Sort{
    public void Sort(CalabashBrothers[] brothers, int l, int r) {
        if (l >= r) return;

        int x = brothers[l + r >> 1].getNumber();
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (brothers[i].getNumber() < x);
            do j--; while (brothers[j].getNumber() > x);
            if (i < j) {
                CalabashBrothers.changePlace(brothers[i], brothers[j]);
                //葫芦娃不乖巧了#爷爷强制让这群小崽子交换位置
            }
        }

        Sort(brothers, l, j);
        Sort(brothers, j + 1, r);
    }
}