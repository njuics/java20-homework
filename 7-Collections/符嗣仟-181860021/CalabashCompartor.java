import java.util.*;
import java.util.Comparator;

public class CalabashCompartor implements Comparator<Calabash>{
    private int type;
    CalabashCompartor(){
        type = 0;
    }
    CalabashCompartor(int t){
        this.type = t;
    }
    public int compare(Calabash c1,Calabash c2){
        switch (type) {
            case 0:
                return c1.compareTo(c2);
            case 1:
                return -(c1.compareTo(c2));
            default:
                Random random = new Random();
                int num = 1-random.nextInt(3);
                return num;
        }

    }
}
