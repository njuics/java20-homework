import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
    public void sort(ArrayList<Huluwa> arr){
        arr.sort(new Comparator<Huluwa>(){
            public int compare(Huluwa o1, Huluwa o2) {
                return o1.compareTo(o2);
            }
        });
    }
    public void reverseSort(ArrayList<Huluwa> arr){
        arr.sort(new Comparator<Huluwa>(){
            public int compare(Huluwa o1, Huluwa o2) {
                return o2.compareTo(o1);
            }
        });
    }
}
