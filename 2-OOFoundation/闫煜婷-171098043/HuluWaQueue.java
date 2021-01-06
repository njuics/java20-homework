import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuluWaQueue {
    static ArrayList<HuluWa> huluArray;
    HuluWaQueue(){
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        huluArray = new ArrayList<>();
        for(int i = 0; i < 7; ++i){
            huluArray.add(new HuluWa(i+1, names[i], i));
        }
        this.shuffle();
    }

    public static ArrayList<HuluWa> getHuluArray() {
        return huluArray;
    }

    public void numberOff(){
        for(HuluWa h : this.huluArray){
            h.tellName();
        }
        System.out.println();
    }
    public void shuffle(){
        Collections.shuffle(this.huluArray);
        for(int i = 0; i < this.huluArray.size(); ++i){
            this.huluArray.get(i).setPos(i);
        }
    }

    public void autoSort(Comparator comparator){
        for(HuluWa h: this.huluArray) {
            h.goToCorrectPos(this.huluArray, comparator);
        }
    }
}
