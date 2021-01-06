import java.util.ArrayList;
import java.util.Comparator;


public class GrandFather {
    public void sortHuluWas(ArrayList<HuluWa> huluArray, Comparator<HuluWa> comparator){
        int size = huluArray.size();
        for(int i = 0; i < size; ++i){
            for(int j = i; j > 0; --j){
                if(comparator.compare(huluArray.get(j), huluArray.get(j-1)) > 0){
                    HuluWa tmp = huluArray.get(j);
                    huluArray.set(j, huluArray.get(j-1));
                    huluArray.set(j-1, tmp);
                    huluArray.get(j).setPos(j);
                    huluArray.get(j-1).setPos(j-1);
                }
                else break;
            }
        }
    }
}
