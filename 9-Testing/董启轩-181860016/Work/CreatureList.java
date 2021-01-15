import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class CreatureList<T extends Creature> implements Iterable<T>{
    private List<T> creaturelist=new ArrayList<>();
    ComparatorT cT=new ComparatorT();
    public void add(T bro){
        creaturelist.add(bro);
    }
    public void sort(Order o){
        cT.set_order(o);
        cT.DOSort(creaturelist);
    }
    public void sort(){
        cT.set_order(Order.POSITIVE);
        cT.DOSort(creaturelist);
    }
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private int index=0;

            @Override
            public boolean hasNext(){
                return index<creaturelist.size();
            }

            @Override
            public T next()
            {
                return creaturelist.get(index++);
            }
        };
    }
    public Iterator<T> reverseIterator()
    {
        return new Iterator<T>(){
            private int index=creaturelist.size()-1;

            @Override
            public boolean hasNext(){
                return index>-1;
            }

            @Override
            public T next()
            {
                return creaturelist.get(index--);
            } 
        };
    }
}