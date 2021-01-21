import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Map
{
    public List<Position> all_position=new ArrayList<>();
    void init()
    {
        System.out.print("\nprintinf map:\n");
        for(int i=0;i<10;i++)
        {
            String name="add1";
            Position<Calabash> one=new Position<>(Calabash.class);
            all_position.add(one);
            one.print_info();
            name="add2";
            Position<Golbin> one1=new Position<>(Golbin.class);
            all_position.add(one1);
            one1.print_info();
        }
    }
    public void sort_by_name(Comparator<?super Position> comparator)
    {
        all_position.sort(comparator);
    }
}