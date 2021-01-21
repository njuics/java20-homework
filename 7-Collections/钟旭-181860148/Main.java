import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int number = 15;
        CalabashBrother cb=new CalabashBrother();
        List<CalabashBoy> male=new ArrayList<>();
        List<CalabashBoy> female=new ArrayList<>();
        for(int i=0;i < number;i++){
            CalabashBoy a = new CalabashBoy();
            cb.add(a);
        }
        /*for(CalabashBoy a:cb.brothers){
            print(a);
        }*/
        print("#####sort#####");
        Collections.sort(cb.brothers);
        for(CalabashBoy a:cb.brothers){
            print(a);
        }
        print("#####reverse sort#####");
        Collections.reverse(cb.brothers);
        for(CalabashBoy a:cb.brothers){
            print(a);
        }
        print("#####shuffle#####");
        Collections.shuffle(cb.brothers);
        for(CalabashBoy a:cb.brothers){
            print(a);
            if(a.ismale()==true)male.add(a);
            else female.add(a);
        }
        Collections.sort(male);
        Collections.sort(female);
        print("#####male#####");
        for(CalabashBoy a:male){
            print(a);
        }
        print("#####female#####");
        for(CalabashBoy a:female){
            print(a);
        }

    }
   
    public static void print(Object o){
        System.out.println(o);
    }
}
