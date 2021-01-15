import java.util.*;

public class CreatureList<T extends Creature> implements Iterable<T>{
    private ArrayList<T> lst = new ArrayList<>();
    
    public void sort(Comparator<Creature> cp){
        Collections.sort(lst,cp);
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
}