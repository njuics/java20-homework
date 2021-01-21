package world.creature;
import world.creature.Huluwa;

public class GrandFather extends Creature{
    public void sort(Huluwa[] arr){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(arr[j].get_order()>arr[j+1].get_order()){
                    Huluwa t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}