package homework_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GrandFather extends Huluwa{
    Map<String,Integer> huluBrothers = new HashMap<String, Integer>();
    GrandFather(){
        this.pos = id;
        this.name = "爷爷";
        huluBrothers.put("老大",1);
        huluBrothers.put("老二",2);
        huluBrothers.put("老三",3);
        huluBrothers.put("老四",4);
        huluBrothers.put("老五",5);
        huluBrothers.put("老六",6);
        huluBrothers.put("老七",7);
    }
    @Override
    public int getNowPos(String name) {
        return huluBrothers.get(name);
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public ArrayList<Huluwa> sort(ArrayList<Huluwa> que){
        int i = 1;
        while(i<8){
            if(getNowPos(que.get(i).getName())!=i){
                Collections.swap(que,i,getNowPos(que.get(i).getName()));
            }
            else{
                ++i;
            }
        }
        return que;
    }
}
