import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuluWaQueue {
    private ArrayList<HuluWa> huluArray;

    HuluWaQueue() {
        huluArray = new ArrayList<HuluWa>();
    }

    HuluWaQueue(int num) {
        huluArray = new ArrayList<HuluWa>();
        for(int i = 0; i < num; ++i){
            huluArray.add(new HuluWa(i+1, HuluWa.genRandomName(), i, Gender.get()));
        }
        shuffle();
    }

    public ArrayList<HuluWa> getHuluArray() {
        return huluArray;
    }

    public int size(){ return huluArray.size();}

    public HuluWa get(int index){ return huluArray.get(index); }

    public void add(HuluWa h){
        huluArray.add(h);
    }

    public void numberOff(){
        for(HuluWa h : huluArray){
            h.tellName();
        }
        System.out.println();
    }

    public void shuffle(){
        Collections.shuffle(huluArray);
        for(int i = 0; i < huluArray.size(); ++i){
            huluArray.get(i).setPos(i);
        }
    }

    public void autoSort(){
        for(HuluWa h: huluArray) {
            h.goToCorrectPos(huluArray);
        }
    }

    public HuluWaQueue sepByGender(Gender gender){
        HuluWaQueue q = new HuluWaQueue();
        for(HuluWa h: huluArray){
            if(h.getGender() == gender){
                q.add(h);
            }
        }
        for(int i = 0; i < q.size(); ++i){
            q.get(i).setPos(i);
        }
        return q;
    }

    public void sort(Comparator comparator){
        huluArray.sort(comparator);
        for(int i = 0; i < huluArray.size(); ++i){
            huluArray.get(i).setPos(i);
        }
    }
}
