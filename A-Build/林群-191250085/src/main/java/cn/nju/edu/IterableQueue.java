package cn.nju.edu;


import java.util.*;

import org.apache.commons.collections4.CollectionUtils;

public class IterableQueue<T extends Creature> {
    private List<T> c;

    public IterableQueue(List<T> c){
        this.c = c;

    }

    public List<T> getC() {
        return c;
    }

    public Iterable<T> inorder(){
        return c;
    }

    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = c.size() - 1;
            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return c.get(current--);
            }
        };
    }

    public Iterable<T> randomized() {
        List<T> shuffled = new ArrayList<>(c);
        Collections.shuffle(shuffled,new Random(42));
        return shuffled;
    }

    /**
     * 返回当前队列是否为空
     * @return
     */
    public Boolean isEmpty(){
        return CollectionUtils.isEmpty(this.c);
    }


    /**
     * 比较两个IterableQueue中元素以及元素的个数是否相同，不要求顺序
     * @param l 要比较的队列
     * @return
     */
    public Boolean equals(IterableQueue<T> l){
        return CollectionUtils.isEqualCollection(this.c,l.getC());
    }

    /**
     * 求两个IterableQueue类的并集
     * @param l
     * @return
     */
    public IterableQueue<T> union(IterableQueue<T> l){
        return new IterableQueue<T>((List<T>) CollectionUtils.union(this.c,l.getC()));
    }

    /**
     * 求两个IterableQueue类的交集
     * @param l
     * @return
     */
    public IterableQueue<T> intersection(IterableQueue<T> l){
        return new IterableQueue<T>((List<T>) CollectionUtils.intersection(this.c,l.getC()));
    }

    /**
     * 求两个IterableQueue类的差集
     * @param l
     * @return c-l 差集
     */
    public IterableQueue<T> subtraction(IterableQueue<T> l){
        Collection<T> c = CollectionUtils.subtract(this.c,l.getC());
        return new IterableQueue<T>((List<T>)c);
    }
}
