import java.util.*;

public class CreatureList<T extends Comparable<T>& Creature> implements Iterable<T>{
    private ArrayList<T> lst = new ArrayList<>();
    
    public T get(int i){
        return lst.get(i);
    }
    public void add(T cb){
        lst.add(cb);
    }

    public Iterator<T> iterator(){
        //此处不能使用private修饰，因为方法内部定义的变量只能在方法内部使用
        //声明作用域无意义
        return new Iterator<T>(){
            Iterator<T> iter = lst.iterator();
            
            @Override
            public T next(){
                return iter.next();
            }

            @Override
            public boolean hasNext(){
                return iter.hasNext();
            }
        
        };
    }
    
    //利用Comparator完成排序
    public void Possort(){
        Collections.sort(lst,new PosComparator<T>());
    }

    public void Negsort(){
        Collections.sort(lst,new NegComparator<T>());
    }

    public void Randsort(){
        Collections.sort(lst,new RandComparator<T>());
    }

    //适配器模式
    public Iterable<T> reversed(){
        return new Iterable<T>(){
            public Iterator<T> iterator(){
                return new Iterator<T>(){
                    int cur = lst.size()-1;
                    @Override
                    public boolean hasNext(){
                        return cur>-1;
                    }
                    @Override
                    public T next(){
                        return lst.get(cur--);
                    }
                };
            }
        };
    }

    public Iterable<T> randomize(){
        //随机排序
        //此处换种方式，直接返回被打乱list的Iterator
        return new Iterable<T>(){
            public Iterator<T> iterator(){
            ArrayList<T> shuffled = new ArrayList<T>(lst);
            Collections.shuffle(shuffled,new Random(47));
            return shuffled.iterator();
            }
        };
    }


}