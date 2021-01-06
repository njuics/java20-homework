public class SimpleSort{

    public void quick_sort(int[] a, int l, int r){
        if(l >= r) return;

        int x = a[l + r >> 1];
        int i = l - 1, j = r + 1;
        int temp;
        while(i < j){
            do i++; while(a[i] < x);
            do j--; while(a[j] > x);
            if(i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        quick_sort(a, l, j);
        quick_sort(a, j + 1, r);
    }

    public static void main(String[] args){
        int[] a = {1, 5, 3, 8, 4, 6, 4, 6};
        new SimpleSort().quick_sort(a, 0, a.length - 1);
        for(int item : a) System.out.print(" " + item);
    }
}