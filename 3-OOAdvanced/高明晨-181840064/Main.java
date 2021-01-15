import sort.*;
import character.*;
import java.util.Random;
public class Main{

    public static void main(String args[]) {
        Huluwa array[]=new Huluwa[7];
        for(int i=0;i<7;i++){
            array[i]=new Huluwa(i+1);
        }
        Grandpa gp=new Grandpa();
        orchestration(array,gp);
        choreography(array);
    }
    public static void randomShuffle(Huluwa array[]){
        System.out.println("Random Shuffle:");
        Random gen=new Random();
        for(int i=6;i>=0;i--){
            Huluwa temp=new Huluwa();
            int index=gen.nextInt(7);
            array[i].exchange(array[index]);
        }
        numberoff(array);
    }
    public static void numberoff(Huluwa array[]){
        for(Huluwa i:array)
            System.out.println(i.answerName());
        System.out.println();
    }
    public static void orchestration(Huluwa array[],Grandpa gp){ 
        randomShuffle(array);
        Sort method=new BubbleSort();
        //Sort method=new InsertSort();
        method.orchestrationSort(array,gp);
        System.out.println("orchestration sort:");
        numberoff(array);
    }
    

    public static void choreography(Huluwa array[]){
        randomShuffle(array);
        Sort method=new BubbleSort();
        //Sort method=new InsertSort();
        method.choreographySort(array);
        System.out.println("choreography sort:");
        numberoff(array);
    }
}