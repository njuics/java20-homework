import java.util.*;
import java.util.Comparator;

public class CreatureCompartor implements Comparator<Creature> {
    private int type;
    CreatureCompartor(){
        type = 0;
    }
    
    CreatureCompartor(int t){
        this.type = t;
    }
    public int compare(Creature c1,Creature c2){
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
