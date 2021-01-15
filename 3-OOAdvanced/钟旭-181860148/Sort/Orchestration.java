package Sort;

import CalabashBrothers.CalabashBoy;
import static CalabashBrothers.CalabashBoy.swap;

public class Orchestration implements Ssort{
    
    public void sort(CalabashBoy[] brothers,int num){
        System.out.println("Orchestration:");
        for(int i=0;i<num;i++){
            while(brothers[i].getid()!=i){
                swap(brothers[i],brothers[brothers[i].getid()]);
            }
        }
    }
}