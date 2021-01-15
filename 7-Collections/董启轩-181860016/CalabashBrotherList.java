import java.util.*;
public class CalabashBrotherList implements Iterable<CalabashBrother>{
    private ArrayList<CalabashBrother> list=new ArrayList<>();
    public void add(CalabashBrother bro){
        list.add(bro);
    }
    public void sort(Comparator<CalabashBrother> comparator){
        Collections.sort(list,comparator);
    }
    public Iterator<CalabashBrother> iterator(){
        return new Iterator<CalabashBrother>(){
            private Iterator<CalabashBrother> iter=list.iterator();

            @Override
            public boolean hasNext(){
                return iter.hasNext();
            }

            @Override
            public CalabashBrother next(){
                return iter.next();
            }
        };
    }
}