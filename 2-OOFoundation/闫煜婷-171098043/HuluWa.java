import java.util.ArrayList;
import java.util.Comparator;

public class HuluWa {
    int seniority;
    String name;
    int pos;
    HuluWa(int seniority, String name, int pos){
        this.seniority = seniority;
        this.name = name;
        this.pos = pos;
    }

    public int getSeniority() {
        return seniority;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void exchangePos(HuluWa huluWa, ArrayList<HuluWa> huluArray){
        int tmp = this.pos;
        this.pos = huluWa.getPos();
        huluWa.setPos(tmp);
        huluArray.set(this.pos, this);
        huluArray.set(huluWa.getPos(), huluWa);
    }

    public void goToCorrectPos(ArrayList<HuluWa> huluArray, Comparator comparator){
        while(this.pos > 0){
            if(comparator.compare(this, huluArray.get(this.pos - 1)) > 0){
                this.exchangePos(huluArray.get(this.pos-1), huluArray);
            }
            else break;
        }
    }

    public void tellName(){
        System.out.print(this.name + " ");
    }
}