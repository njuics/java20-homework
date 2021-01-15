import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;
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
        return new AscendingIterator();
    }
    private class AscendingIterator implements Iterator<T>{
        int point;
        AscendingIterator(){
            Collections.sort(array,new CharacterAscendingComparator());
            point=0;
        }
        public boolean hasNext(){
            if(point!=array.size()){
                return true;
            }
            else{
                return false;
            }
        }
        public T next(){
            T ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<T> decendingIterator(){
        return new DecendingIterator();
    }
    private class DecendingIterator implements Iterator<T>{
        int point;
        DecendingIterator(){
            Collections.sort(array,new CharacterDecendingComparator());
            point=0;
        }
        public boolean hasNext(){
            if(point!=array.size()){
                return true;
            }
            else{
                return false;
            }
        }
        public T next(){
            T ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<T> randIterator(){
        return new RandIterator();
    }
    private class RandIterator implements Iterator<T>{
        int point;
        RandIterator(){
            shuffle();
            point=0;
        }
        private void shuffle(){
            Random gen=new Random();
            int len=array.size();
            for(int i=len-1;i>=0;i--){
                int index=gen.nextInt(len);
                T temp=array.get(i);
                array.set(i,array.get(index));
                array.set(index,temp);
            } 
        }
        public boolean hasNext(){
            if(point!=array.size()){
                return true;
            }
            else{
                return false;
            }
        }
        public T next(){
            T ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<T> maleRandIterator(){
        return new MaleRandIterator();
    }
    private class MaleRandIterator extends RandIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Male")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }
    public Iterator<T> maleAscendingIterator(){
        return new MaleAscendingIterator();
    }
    private class MaleAscendingIterator extends AscendingIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Male")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }

    public Iterator<T> maleDecendingIterator(){
        return new MaleDecendingIterator();
    }
    private class MaleDecendingIterator extends DecendingIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Male")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }

    public Iterator<T> femaleRandIterator(){
        return new FemaleRandIterator();
    }
    private class FemaleRandIterator extends RandIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Female")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }
    public Iterator<T> femaleAscendingIterator(){
        return new FemaleAscendingIterator();
    }
    private class FemaleAscendingIterator extends AscendingIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Female")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }

    public Iterator<T> femaleDecendingIterator(){
        return new FemaleDecendingIterator();
    }
    private class FemaleDecendingIterator extends DecendingIterator{
        public boolean hasNext(){
            if(point==array.size()) return false;
            while (array.get(point).getGender().compareTo("Female")!=0){
                point+=1;
                if(point==array.size()){
                    return false;
                }
            }
            return true;
        }
    }
}