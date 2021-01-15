import java.util.Random;
import world.creature.Huluwa;
import world.creature.GrandFather;
import world.sort.Orchestration;
import world.sort.Choreography;

public class Main{
    public static void main(String []args){ 
        GrandFather gf = new GrandFather();
        Huluwa[] arr = new Huluwa[7];
        System.out.println("Orchestration:");
        Orchestration orc = new Orchestration();
        create_random_arr(arr);
        orc.sort(gf, arr);
        arr_count_off(arr);
        System.out.println("Choreography:");
        Choreography cho = new Choreography();
        create_random_arr(arr);
        cho.sort(gf, arr);
        arr_count_off(arr);
    }
    public static void create_random_arr(Huluwa[] arr){
        boolean[] sig = {false,false,false,false,false,false,false};
        Random r = new Random();
        for(int i=0;i<arr.length;i++){
            int s = r.nextInt(arr.length);
            if(sig[s]==true){
                i--;
            }
            else{
                sig[s] = true;
                arr[i] = new Huluwa(s);
            }
        }
        System.out.print("随机顺序为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i].get_order());
        }
        System.out.println();
    }
    public static void arr_count_off(Huluwa[] arr){
        System.out.println("排序后排队报到：");
        for(int i=0;i<arr.length;i++){
            arr[i].count_off();
        }
        System.out.println();
    }
}