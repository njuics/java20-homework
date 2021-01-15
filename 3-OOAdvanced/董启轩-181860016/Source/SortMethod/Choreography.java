package Source.SortMethod;
import Source.Creature.CalabashBrother;
import java.util.Random;

interface Choreography_sort{
    void ChoreographySort(CalabashBrother[] bro);
}

public class Choreography implements Choreography_sort{
    private static Random rand=new Random();
    @Override
    public void ChoreographySort(CalabashBrother[] bro){
        System.out.println("begin Choreography sort:");
        do_shuffle(bro);
        printInformation(bro);
        System.out.println("After sort finished:");
        for(int i=0;i<bro.length-1;i++){
            for(int j=0;j<bro.length-1-i;j++)
            {
                if (bro[j].cmp(bro[j+1])){
                    bro[j].swap_with_next(bro,j);
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