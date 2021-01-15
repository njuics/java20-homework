package sort;
import character.*;
public class BubbleSort extends Sort{
    public void orchestrationSort(Huluwa array[],Grandpa gp){
        for(int k=0;k<array.length;k++)
            for(int i=0;i<array.length-1;i++)
                if(!gp.compareSmall(array[i],array[i+1])){
                    gp.swap(array[i],array[i+1]);
                }
    }
    public void choreographySort(Huluwa array[]){
        for(int k=0;k<array.length;k++)
            for(int i=0;i<array.length-1;i++)
                if(!array[i].isSmall(array[i+1])){
                    array[i].exchange(array[i+1]);
                }
    }
}