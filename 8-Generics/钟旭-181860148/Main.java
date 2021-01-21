import javax.sound.sampled.Line;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int number = 15;
        QLine<CalabashBoy> bros=new QLine<CalabashBoy>(),
        male = new QLine<>(),
        female = new QLine<>();
        
        for(int i=0;i < number;i++){
            CalabashBoy a = new CalabashBoy();
            bros.add(a);
        }
        print("#####sort#####");
        Collections.sort(bros.brothers);
        for(CalabashBoy a:bros.brothers){
            print(a);
        }
        print("#####reverse sort#####");
        Collections.reverse(bros.brothers);
        for(CalabashBoy a:bros.brothers){
            print(a);
        }
        print("#####shuffle#####");
        Collections.shuffle(bros.brothers);
        for(CalabashBoy a:bros.brothers){
            print(a);
            if(a.ismale()==true)male.add(a);
            else female.add(a);
        }
        Collections.sort(male.brothers);
        Collections.sort(female.brothers);
        print("#####male#####");
        for(CalabashBoy a:male.brothers){
            print(a);
        }
        print("#####female#####");
        for(CalabashBoy a:female.brothers){
            print(a);
        }
    }
    public static void print(Object o){
        System.out.println(o);
    }
}
