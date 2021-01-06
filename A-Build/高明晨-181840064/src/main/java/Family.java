import java.util.ArrayList;
import java.util.Iterator;
import com.google.common.collect.Ordering;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
public class Family<T extends Character>{
    private ArrayList<T> array;
    Family(){
        array=new ArrayList<T>();
    }
    public void add(T x){
        array.add(x);
    }
    public void show(){
        for(T i:array) System.out.println(i);
    }

    public Iterator<T> iterator(){
        return array.iterator();
    }

    public Iterator<T> ascendingIterator(){
        return Ordering.from(new CharacterAscendingComparator()).sortedCopy(array).iterator();
    }
    public Iterator<T> decendingIterator(){
        return Ordering.from(new CharacterAscendingComparator()).reverse().sortedCopy(array).iterator();
    }

    public Iterator<T> randIterator(){
        return Ordering.arbitrary().sortedCopy(array).iterator();
    }
    public Iterator<T> maleRandIterator(){
        return
        Collections2.filter(Ordering.arbitrary().sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Male")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;
    }
    public Iterator<T> maleAscendingIterator(){
        return
        Collections2.filter(Ordering.from(new CharacterAscendingComparator()).sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Male")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;

    }

    public Iterator<T> maleDecendingIterator(){
        return
        Collections2.filter(Ordering.from(new CharacterAscendingComparator()).reverse().sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Male")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;
    }

    public Iterator<T> femaleRandIterator(){
        return
        Collections2.filter(Ordering.arbitrary().sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Female")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;
    }
    public Iterator<T> femaleAscendingIterator(){
        return
        Collections2.filter(Ordering.from(new CharacterAscendingComparator()).sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Female")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;
    }
    public Iterator<T> femaleDecendingIterator(){
        return
        Collections2.filter(Ordering.from(new CharacterAscendingComparator()).reverse().sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Female")
                        return true;
                    else 
                        return false;
                }
            }).iterator()
        ;
    }

}