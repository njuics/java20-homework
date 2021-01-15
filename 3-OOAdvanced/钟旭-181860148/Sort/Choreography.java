package Sort;

import CalabashBrothers.CalabashBoy;
import static CalabashBrothers.CalabashBoy.*;
public class Choreography implements Ssort{

    public void sort(CalabashBoy[] brothers,int num){
        System.out.println("Choreography:");
        for(int i=0;i<num;i++){
            for(int j=num-1;j>i;j--){
                if(compare(brothers[j],brothers[j-1]))swap(brothers[j],brothers[j-1]);
            }
        }
    }

}

