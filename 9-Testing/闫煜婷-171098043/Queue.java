package homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class Queue<T extends Creature> implements Iterable<T> {
    ArrayList<T> arr;

    Queue() {
        arr = new ArrayList<T>();
    }


    public ArrayList<T> getArr() {
        return arr;
    }

    public int size(){ return arr.size();}

    public T get(int index){ return arr.get(index); }

    public void add(T h){
        arr.add(h);
    }

    @Override
    public Iterator<T> iterator() {
        return arr.iterator();
    }
}

class HuluWaQueue<T extends HuluWa> extends Queue<T> {
    public void numberOff(){
        for(T h : arr){
            h.tellName();
        }
        System.out.println();
    }

    public void shuffle(){
        Collections.shuffle(arr);
        for(int i = 0; i < arr.size(); ++i){
            arr.get(i).setPos(i);
        }
    }

    public HuluWaQueue<T> sepByGender(Gender gender){
        HuluWaQueue<T> q = new HuluWaQueue<>();
        for(T h: arr){
            if(h.getGender() == gender){
                q.add(h);
            }
        }
        for(int i = 0; i < q.size(); ++i){
            q.get(i).setPos(i);
        }
        return q;
    }

    public void sort(Comparator<? super T> comparator){
        arr.sort(comparator);
        for(int i = 0; i < arr.size(); ++i){
            arr.get(i).setPos(i);
        }
    }

}