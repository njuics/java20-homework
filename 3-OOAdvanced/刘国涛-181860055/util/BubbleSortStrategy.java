package util;
import java.util.Comparator;

import model.Calabash;
public class BubbleSortStrategy implements SortStrategy{
    @Override
    public final void sort(Calabash[] calabashs,Comparator<Calabash> cmp){
        int n = calabashs.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                if(cmp.compare(calabashs[j], calabashs[j+1])>0){
                    calabashs[j].swapWith(calabashs[j+1]);
                }
            }
        }
    }
} 