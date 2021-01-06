package world.sort;
import world.creature.*;

public class Choreography implements SortMethod{
    @Override
    public void sort(GrandFather gf, Huluwa[] arr){
        int current = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j].compare_order(arr[j+1])){
                    arr[j].swap_order(arr[j+1]);
                }
            }
        }
    }
}