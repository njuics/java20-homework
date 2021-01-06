import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class CreatureList<T extends Creature> {
    private List<T> CreatureList;
    private List<T> maleCreatureList;
    private List<T> femaleCreatureList;
    public CreatureList(CreatureFactory<T> factory){
        CreatureList = new ArrayList<T>();
        maleCreatureList = new ArrayList<T>();
        femaleCreatureList = new ArrayList<T>();
        for(int i=0;i<20;i++){
            CreatureList.add(factory.create());
        }
        Iterator<T> i = CreatureList.iterator();
        while(i.hasNext()){
            T b=i.next();
            if(b.getGender()){
                maleCreatureList.add(b);
            }
            else{
                femaleCreatureList.add(b);
            }
        }
    }
    public void PrintList(){
        for(T b:CreatureList){
            System.out.println(b.toString());
        }
    }
    public void PrintMaleList(){
        for(T b:maleCreatureList){
            System.out.println(b.toString());
        }
    }
    public void PrintFemaleList(){
        for(T b:femaleCreatureList){
            System.out.println(b.toString());
        }
    }
    public void sortWithComparable(boolean order){
        Collections.sort(CreatureList);
        if(!order)
            Collections.reverse(CreatureList);
    }
    public void shuffleWithComparable(){
        Collections.shuffle(CreatureList);
    }
    public void sortWithComparator(boolean order){
        if(order){
            Collections.sort(CreatureList,new Comparator<Creature>(){
                @Override
                public int compare(Creature a,Creature b){
                    return a.compareTo(b);
                }
            });
        }
        else{
            Collections.sort(CreatureList,new Comparator<Creature>(){
                @Override
                public int compare(Creature a,Creature b){
                    return -a.compareTo(b);
                }
            });
        }
    }
    public void sortByGender(){
        Collections.sort(maleCreatureList);
        Collections.sort(femaleCreatureList);
    }

    public T getCreature(int index){
        return CreatureList.get(index);
    }

    public int getSize(){
        return CreatureList.size();
    }
    public List<T> getMaleList(){
        return maleCreatureList;
    }
    public List<T> getFemaleList(){
        return femaleCreatureList;
    }
}