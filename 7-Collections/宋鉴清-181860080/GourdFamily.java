import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Comparator;

class NegativeSort implements Comparator<Gourd> {
    @Override
    public int compare(Gourd one, Gourd another){
        return -one.getname().compareTo(another.getname());
    }
}

class GourdIterator implements Iterator<Gourd>{
    private int curror = -1;
    ArrayList<Gourd> list;
    GourdIterator(ArrayList<Gourd> list){
        this.list = list;
    }
    public boolean hasNext(){
        return curror < list.size() - 1;
    }
    public Gourd next(){
        curror++;
        return list.get(curror);
    }
}

class GourdIterable implements Iterable<Gourd>{
    ArrayList<Gourd> list;
    GourdIterable(ArrayList<Gourd> list){
        this.list = list;
    }
    @Override
    public Iterator<Gourd> iterator(){
        return new GourdIterator(list);
    }
}

public class GourdFamily{
    ArrayList<Gourd> GourdList = new ArrayList<Gourd>();

    GourdFamily(){
        Random r = new Random(System.currentTimeMillis());
        HashSet<String> name_list = new HashSet<String>();
        for(int i = 0; i < 20; i++){
            String name = "";
            char t = (char)(r.nextInt(26) + 'a');
            name += t;
            t = (char)(r.nextInt(26) + 'a');
            name += t;
            if(name_list.contains(name) == true) continue;
            name_list.add(name);
            int randnum = r.nextInt(2);
            String gender = "";
            if(randnum == 0) gender = "Male";
            else gender = "Female";
            GourdList.add(new Gourd(name, gender));
        }
    }

    private ArrayList<Gourd> classifGourds(String gender){
        ArrayList<Gourd> result = new ArrayList<Gourd>();
        for(Gourd obj : GourdList){
            if(obj.getgender() == gender){
                result.add(obj);
            }
        }
        return result;
    }
    public Iterable<Gourd> BeginIterable(){
        return new GourdIterable(GourdList);
    }

    public Iterable<Gourd> positIterable(){
        ArrayList<Gourd> list = GourdList;
        Collections.sort(list);
        return new GourdIterable(list);
    }

    public Iterable<Gourd> negaIterable(){
        ArrayList<Gourd> list = GourdList;
        Collections.sort(list, new NegativeSort());
        return new GourdIterable(list);
    }

    public Iterable<Gourd> chaosIterable(){
        ArrayList<Gourd> list = GourdList;
        Random r = new Random(System.currentTimeMillis());
        Collections.shuffle(list, r);
        return new GourdIterable(list);
    }

    public Iterable<Gourd> malepositIterable(){
        ArrayList<Gourd> list = classifGourds("Male");
        Collections.sort(list);
        return new GourdIterable(list);
    }

    public Iterable<Gourd> malenegaIterable(){
        ArrayList<Gourd> list = classifGourds("Male");
        Collections.sort(list, new NegativeSort());
        return new GourdIterable(list);
    }

    public Iterable<Gourd> malechaosIterable(){
        ArrayList<Gourd> list = classifGourds("Male");
        Random r = new Random(System.currentTimeMillis());
        Collections.shuffle(list, r);
        return new GourdIterable(list);
    }

    public Iterable<Gourd> femalepositIterable(){
        ArrayList<Gourd> list = classifGourds("Female");
        Collections.sort(list);
        return new GourdIterable(list);
    }

    public Iterable<Gourd> femalenegaIterable(){
        ArrayList<Gourd> list = classifGourds("Female");
        Collections.sort(list, new NegativeSort());
        return new GourdIterable(list);
    }

    public Iterable<Gourd> femalechaosIterable(){
        ArrayList<Gourd> list = classifGourds("Female");
        Random r = new Random(System.currentTimeMillis());
        Collections.shuffle(list, r);
        return new GourdIterable(list);
    }
}
