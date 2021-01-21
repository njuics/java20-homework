
import java.util.*;

public class QLine< T extends Creature> implements Iterable<Creature>{
    final int number=15;
    public List<T> brothers = new ArrayList<>();
    public void add(T t){
        if(brothers.size()<number){
            brothers.add(t);
        }
    }

    public void Sort(){
        Collections.sort(brothers);
    }

    public void Reverse(){
        Collections.sort(brothers);
        Collections.reverse(brothers);
    }

    public void Shuffle(){
        Collections.shuffle(brothers);
    }

    public void Print(){
        for(T t:brothers){
            System.out.println(t);
        }
    }
    @Override
    public Iterator<Creature> iterator(){
        return new Iterator<Creature>(){
            int index =0;
            public boolean hasNext(){return this.index < QLine.this.number;}
            public T next(){return brothers.get(index++);}
        };
    }
}
