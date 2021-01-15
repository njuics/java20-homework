import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Collections;
import java.util.Random;

class Negativesort <T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T one, T another){
        return -one.get_name().compareTo(another.get_name());
    }
}

class CreatureIterator <T extends Creature> implements Iterator<T>{
    private int curror = -1;
    ArrayList<T> list;
    CreatureIterator(ArrayList<T> list){
        this.list = list;
    }
    public boolean hasNext(){
        return curror < list.size() - 1;
    }
    public T next(){
        curror++;
        return list.get(curror);
    }
}

class CreatureIterable <T extends Creature> implements Iterable<T>{
    ArrayList<T> list;
    CreatureIterable(ArrayList<T> list){
        this.list = list;
    }
    @Override
    public Iterator<T> iterator(){
        return new CreatureIterator<T>(list);
    }
}

public class Family <T extends Creature>{
    ArrayList<T> memberlist;

    Family(){
        memberlist = new ArrayList<T>();
    }
    public void add_member(T x){
        memberlist.add(x);
    }

    private ArrayList<T> classifygender(String gender){
        ArrayList<T> result = new ArrayList<T>();
        for(T obj : memberlist){
            if(obj.get_gender() == gender){
                result.add(obj);
            }
        }
        return result;
    }

    public ArrayList<T> get_posit_list(){
        ArrayList<T> list = memberlist;
        Collections.sort(list);
        return list;
    }

    public ArrayList<T> get_nega_list(){
        ArrayList<T> list = memberlist;
        Collections.sort(list, new Negativesort<T>());
        return list;
    }

    public ArrayList<T> get_male_posit_list(){
        ArrayList<T> list = classifygender("Male");
        Collections.sort(list);
        return list;
    }

    public ArrayList<T> get_male_nega_list(){
        ArrayList<T> list = classifygender("Male");
        Collections.sort(list, new Negativesort<T>());
        return list;
    }

    public ArrayList<T> get_female_posit_list(){
        ArrayList<T> list = classifygender("Female");
        Collections.sort(list);
        return list;
    }

    public ArrayList<T> get_female_nega_list(){
        ArrayList<T> list = classifygender("Female");
        Collections.sort(list, new Negativesort<T>());
        return list;
    }

    public Iterable<T> beginIterable(){
        return new CreatureIterable<T>(memberlist);
    }

    public Iterable<T> positIterable(){
        return new CreatureIterable<T>(get_posit_list());
    }

    public Iterable<T> negaIterable(){
        return new CreatureIterable<T>(get_nega_list());
    }

    public Iterable<T> chaosIterable(){
        ArrayList<T> list = memberlist;
        Random r = new Random(System.currentTimeMillis());
        Collections.shuffle(list, r);
        return new CreatureIterable<T>(list);
    }

    public Iterable<T> malepositIterable(){
        return new CreatureIterable<T>(get_male_posit_list());
    }

    public Iterable<T> femalepositIterable(){
        return new CreatureIterable<T>(get_female_posit_list());
    }
}
