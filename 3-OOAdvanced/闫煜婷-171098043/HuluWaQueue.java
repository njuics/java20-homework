import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuluWaQueue {
    private static ArrayList<HuluWa> huluArray;
    static {
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        huluArray = new ArrayList<>();
        for(int i = 0; i < 7; ++i){
            huluArray.add(new HuluWa(i+1, names[i], i));
        }
        shuffle();
    }

    public static ArrayList<HuluWa> getHuluArray() {
        return huluArray;
    }

    public static void numberOff(){
        for(HuluWa h : huluArray){
            h.tellName();
        }
        System.out.println();
    }
    public static void shuffle(){
        Collections.shuffle(huluArray);
        for(int i = 0; i < huluArray.size(); ++i){
            huluArray.get(i).setPos(i);
        }
    }

    public static void autoSort(Comparator comparator){
        for(HuluWa h: huluArray) {
            h.goToCorrectPos(huluArray, comparator);
        }
    }
}
