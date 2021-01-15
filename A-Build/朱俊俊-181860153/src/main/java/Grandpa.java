import java.util.ArrayList;
import java.util.Comparator;

public class Grandpa extends Creature implements Comparator<Calabash> {
    public Grandpa(){
        super("Old Grandpa");
        calabashArrayList.add(new Calabash(1,"老大"));
        calabashArrayList.add(new Calabash(2,"老二"));
        calabashArrayList.add(new Calabash(3,"老三"));
        calabashArrayList.add(new Calabash(4,"老四"));
        calabashArrayList.add(new Calabash(5,"老五"));
        calabashArrayList.add(new Calabash(6,"老六"));
        calabashArrayList.add(new Calabash(7,"老七"));
    }
    private ArrayList<Calabash>calabashArrayList = new ArrayList<>();

    public ArrayList<Calabash>getCalabash(){
        return calabashArrayList;
    }

    @Override
    public int compare(Calabash o1, Calabash o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Comparator<Calabash> reversed(){
        return new Comparator<Calabash>() {
            @Override
            public int compare(Calabash o1, Calabash o2) {
                return o2.compareTo(o1);
            }
        };
    }

    public Comparator<Calabash> random(){
        return new Comparator<Calabash>() {
            @Override
            public int compare(Calabash o1, Calabash o2) {
                return Math.random() >= 0.5 ? 1 : -1;
            }
        };
    }
}
