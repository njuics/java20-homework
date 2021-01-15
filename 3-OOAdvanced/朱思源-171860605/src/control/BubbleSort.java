package control;
import map.*;
import object.*;

public class BubbleSort implements Sorter {
    @Override
    public int comparable(Boy b1, Boy b2) {
        return b1.getRank()-b2.getRank();
    }
    public void sort(Queue que)
    {
        for(int j=que.len-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(comparable(que.array[i],que.array[i+1])>0){
                    que.array[i].changePos(que.array[i+1]);
                }
            }
        }
    }
}
