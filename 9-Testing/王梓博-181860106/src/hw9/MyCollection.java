/*
 * @Author: zb-nju
 * @Date: 2020-11-05 14:06:00
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-05 15:35:30
 */
package hw9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MyCollection<T extends Comparable<T> & People> implements Iterable<T>{
    ArrayList<T> CBList = new ArrayList<T>();
    IFactory<T> factory;
    int numOfCB;

    public MyCollection(int n, IFactory<T>f){
        numOfCB = n;
        this.factory = f;
        for(int i=0;i<n;i++)
            CBList.add(this.factory.create());
    }

    public MyCollection(IFactory<T>f){
        numOfCB = 0;
        this.factory = f;
    }

    public void insert(T c){
        numOfCB++;
        CBList.add(c);
    }

    public Iterator<T> iterator() {
        //匿名内部类
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {return index < CBList.size();}
            @Override
            public T next() { return CBList.get(index++);    }
        };
    }

    //反向迭代器
    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            private int index = CBList.size()-1;
            @Override
            public boolean hasNext() {return index > 0;}
            @Override
            public T next() { return CBList.get(index--);    }
        };
    }

    public MyCollection<T> divideByGender(Gender gender){
        MyCollection<T> ret = new MyCollection<T>(this.factory);
        Iterator<T> it=CBList.iterator();
        while(it.hasNext()){
            T c = it.next();
            if(c.getGender()==gender)
                ret.insert(c);
        }
        return ret;
    }

    public void sortAscComparator(){
        Collections.sort(CBList,new AscCmp<T>());
    }

    public void sortDescComparator(){
        Collections.sort(CBList,new DescCmp<T>());
    }

    public void sortRandComparator(){
        Collections.sort(CBList,new RandomCmp<T>());
    }

    public void sortAscComparable(){
        Collections.sort(CBList);
    }

    public void sortDescComparable(){
        Collections.sort(CBList,Collections.reverseOrder());
    }

    public void sortRandComparable(){
        Collections.shuffle(CBList);
    }
}