import java.util.Random;
import human.*;
import sort.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Grandpa g = new Grandpa();
        Hulu []huluwa = new Hulu[7];
        Hulu hulu1 = new Hulu("老大", 1);
        Hulu hulu2 = new Hulu("老二", 2);
        Hulu hulu3 = new Hulu("老三", 3);
        Hulu hulu4 = new Hulu("老四", 4);
        Hulu hulu5 = new Hulu("老五", 5);
        Hulu hulu6 = new Hulu("老六", 6);
        Hulu hulu7 = new Hulu("老七", 7);

        huluwa[0] = hulu1;
        huluwa[1] = hulu2;
        huluwa[2] = hulu3;
        huluwa[3] = hulu4;
        huluwa[4] = hulu5;
        huluwa[5] = hulu6;
        huluwa[6] = hulu7;

        HuluSort h = new HuluSort();
        System.out.println("orchestration:");
        System.out.print("Before Sort:");
        for(int index=Hulu.count-1; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            Hulu tmp = huluwa[randomNum];
            huluwa[randomNum] = huluwa[index];
            huluwa[index] = tmp;
        }  
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();
 
        h.orchestration(huluwa, g);

        System.out.print("After Sort:");
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();


        System.out.println("choreography:");
        System.out.print("Before Sort:");
        for(int index=Hulu.count-1; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            Hulu tmp = huluwa[randomNum];
            huluwa[randomNum] = huluwa[index];
            huluwa[index] = tmp;
        }  
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();
 
        h.choreography(huluwa);

        System.out.print("After Sort:");
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();
        System.out.println();


        System.out.println("Another Sort:");
        AnotherSort q = new AnotherSort();
        System.out.println("orchestration:");
        System.out.print("Before Sort:");
        for(int index=Hulu.count-1; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            Hulu tmp = huluwa[randomNum];
            huluwa[randomNum] = huluwa[index];
            huluwa[index] = tmp;
        }  
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();
 
        q.orchestration(huluwa, g);

        System.out.print("After Sort:");
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();

        System.out.println("choreography:");
        System.out.print("Before Sort:");
        for(int index=Hulu.count-1; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            Hulu tmp = huluwa[randomNum];
            huluwa[randomNum] = huluwa[index];
            huluwa[index] = tmp;
        }  
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();
 
        q.choreography(huluwa);

        System.out.print("After Sort:");
        for(int i=0; i<Hulu.count; i++){
            huluwa[i].soundOff();
        }
        System.out.println();

    }
}
