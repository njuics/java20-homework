package homework_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BroQue {
    ArrayList<Huluwa> que = new ArrayList<Huluwa>(
            Arrays.asList(
                    new GrandFather(),
                    new Huluwa("老大"),
                    new Huluwa("老二"),
                    new Huluwa("老三"),
                    new Huluwa("老四"),
                    new Huluwa("老五"),
                    new Huluwa("老六"),
                    new Huluwa("老七")));

    BroQue(){
        myShuffle();
    }
    public void myShuffle(){
        Collections.shuffle(que);
        for(int i=0;i<8;++i) {
            if (que.get(i).getName() == "爷爷") {
                Collections.swap(que, 0, i);
                break;
            }
        }
    }
    public void quickSort(int begin,int end){
        if(begin>=end)
            return ;
        int p = que.get(end-1).getNowPos("");
        int left = begin;
        for(int i=begin;i<end;++i) {
            if (que.get(i).getNowPos("") < p) {
                Collections.swap(que, left, i);
                ++left;
            }
        }
        Collections.swap(que,end-1,left);
        quickSort(begin,left);
        quickSort(left+1,end);
    }
}
