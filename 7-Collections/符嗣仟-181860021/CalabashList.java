import java.util.*;

public class CalabashList implements Iterable<Calabash>{
    private ArrayList<Calabash> lst = new ArrayList<>();
    
    public void sort(Comparator<Calabash> cp){
        Collections.sort(lst,cp);

    }

    public void add(Calabash cb){
        lst.add(cb);
    }

    @Override
    public Iterator<Calabash> iterator(){
        //此处不能使用private修饰，因为方法内部定义的变量只能在方法内部使用
        //声明作用域无意义
        return new Iterator<Calabash>(){
            Iterator<Calabash> iter = lst.iterator();
            
            @Override
            public Calabash next(){
                return iter.next();
            }

            @Override
            public boolean hasNext(){
                return iter.hasNext();
            }
        
        };
    }
}