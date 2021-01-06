import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Random;
import java.util.Collections;
public class Family implements Iterable<Huluwa>{
    private ArrayList<Huluwa> array;
    Family(){
        array=new ArrayList<>();
    }
    Family(int num){
        this();
        for(int i=1;i<=num;i++) array.add(new Huluwa());
    }
    public void show(){
        for(Huluwa i:array) System.out.println(i.getInfo());
    }

    public Iterator<Huluwa> iterator(){
        return array.iterator();
    }

    public Iterator<Huluwa> ascendingIterator(){
        return new AscendingIterator();
    }
    private class AscendingIterator implements Iterator<Huluwa>{
        int point;
        AscendingIterator(){
            Collections.sort(array,new HuluwaAscendingComparator());
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
        public Huluwa next(){
            Huluwa ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Huluwa> decendingIterator(){
        return new DecendingIterator();
    }
    private class DecendingIterator implements Iterator<Huluwa>{
        int point;
        DecendingIterator(){
            Collections.sort(array,new HuluwaDecendingComparator());
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
        public Huluwa next(){
            Huluwa ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Huluwa> randIterator(){
        return new RandIterator();
    }
    private class RandIterator implements Iterator<Huluwa>{
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
                Huluwa temp=array.get(i);
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
        public Huluwa next(){
            Huluwa ret=array.get(point);
            point+=1;
            return ret;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<Huluwa> maleRandIterator(){
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
    public Iterator<Huluwa> maleAscendingIterator(){
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

    public Iterator<Huluwa> maleDecendingIterator(){
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

    public Iterator<Huluwa> femaleRandIterator(){
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
    public Iterator<Huluwa> femaleAscendingIterator(){
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

    public Iterator<Huluwa> femaleDecendingIterator(){
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