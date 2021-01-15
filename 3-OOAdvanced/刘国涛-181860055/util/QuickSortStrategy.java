package util;

import java.util.Comparator;

import model.Calabash;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public final void sort(Calabash[] calabashs,Comparator<Calabash> cmp){
        quickSort(calabashs, cmp, 0, calabashs.length-1);
    }

    private static void quickSort(Calabash[] calabashs,Comparator<Calabash> cmp,int left,int right){
        if(left>right)return;
        int i = left, j = right;
        Calabash base = calabashs[left];
        while(i<j){
            while(cmp.compare(calabashs[j], base)>=0&&i<j)
                --j;
            while(cmp.compare(calabashs[i], base)<=0&&i<j)
                ++i;
            calabashs[i].swapWith(calabashs[j]);
        } 
        calabashs[left] = calabashs[i];
        calabashs[i] = base;

        quickSort(calabashs, cmp, left, i-1);
        quickSort(calabashs, cmp, i+1, right);

    }
}
