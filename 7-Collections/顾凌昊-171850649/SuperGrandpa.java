package Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 自己实现一个葫芦娃的存储和迭代器类，不使用原版Collections API的方法
 */
public class SuperGrandpa implements Comparator<Huluwa>, Iterable<Huluwa>, HuluwaController {

    Huluwa[] data;
    int capacity, count;


    public SuperGrandpa(){
        this(10);
    }

    public SuperGrandpa(int cap){
        if(cap<10) cap=10;
        data = new Huluwa[cap];
        capacity = cap;
    }

    @Override
    public void addHuluwa(Huluwa h){
        if(count > capacity-2){
            data = Arrays.copyOf(data, capacity*2+1);
            capacity = capacity*2+1;
        }
        data[count++] = h;
    }

    @Override
    public void printHuluwa(){
        Iterator<Huluwa> it = new HuluwaIterator();
        while(it.hasNext()){
            it.next().call();
        }
    }


    @Override
    public void sortHuluwa(boolean reverse){

        for(int i = count-1;i>0;i--){
            for(int j = 0 ;j<i;j++){
                if((reverse && compare(data[j], data[j+1])>0) || (!reverse && compare(data[j], data[j+1])<0)){

                    Huluwa temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;

                }
            }
        }

    }

    @Override
    public Iterator<Huluwa> iterator() {
        return new HuluwaIterator();
    }

    @Override
    public int compare(Huluwa o1, Huluwa o2) {
        return o1.name.compareTo(o2.name);
    }


    /**
     * Iterator的迭代器
     */
    private class HuluwaIterator implements Iterator<Huluwa>{

        int index;

        public HuluwaIterator(){
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index+1 < count;
        }

        @Override
        public Huluwa next() {
            return data[++index];
        }
    }
}
