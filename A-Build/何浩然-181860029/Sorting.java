import java.util.*;
import org.apache.commons.lang3.builder.CompareToBuilder;
public  class Sorting <T extends Creature>
        //implements Comparable<Creature>
        implements Comparator<Creature>
{
    List<T> p = new ArrayList<T>();
    public Sorting() {
    }
    public int compare(Creature t1, Creature t2){
        String name1=t1.name;
        String name2=t2.name;
        return name1.compareTo(name2);

    }

    /*public int compareTo(Creature o1) {
        Creature o2=p.get(0);
        return CompareToBuilder.reflectionCompare(o1.name,o2.name);
    }*/

    public void add_some(T e) {
        p.add(e);
    }
    public void print() {
        for (T i : p) {
            System.out.print(i.name + ' ');
        }
        System.out.println();
    }

}
