import java.util.Comparator;
public class ComparatorReverse implements Comparator<Calabash>{

    @Override
    public int compare(Calabash o1, Calabash o2) {
        int ans= o1.getName().compareTo(o2.getName());
        return -ans;
    }
    
}