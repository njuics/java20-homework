package Source.SortMethod;
import Source.Creature.*;
import java.util.Random;

interface Orchestration_sort{
    void OrchestrationSort(GrandFather grandpa, CalabashBrother[] bro);
}

public class Orchestration implements Orchestration_sort {
    private static Random rand=new Random();
    @Override
    public void OrchestrationSort(GrandFather grandpa,CalabashBrother[] bro){
        System.out.println("begin Orchestration sort:");
        do_shuffle(bro);
        printInformation(bro);
        System.out.println("After sort finished:");
        for(int i=0;i<bro.length-1;i++){
            for(int j=0;j<bro.length-1-i;j++)
            {
                if (grandpa.cmpCalabash(bro[j],bro[j+1])){
                    grandpa.swapCalabash(bro,j,j+1);
                }
            }
        }
        printInformation(bro);
    }
    void do_shuffle(CalabashBrother[] bro){
        int length=bro.length;
        System.out.println("Do shuffle:");
      for(int i=length;i>0;i--){
            int randInt=rand.nextInt(i);
            CalabashBrother tmp=bro[randInt];
            bro[randInt]=bro[i-1];
            bro[i-1]=tmp;
        }
    }
    void printInformation(CalabashBrother[] bro){
        for(CalabashBrother x: bro){
            System.out.print(x.get_name()+" ");
        }
        System.out.println();
    }
}