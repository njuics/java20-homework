package homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GrandFather {
    public void sortHuluWas(ArrayList<HuluWa> huluArray, Comparator<? super HuluWa> comparator){
        Collections.sort(huluArray, comparator);
        for(int i = 0; i < huluArray.size(); ++i){
            huluArray.get(i).setPos(i);
        }
    }
}
