import java.util.*;
public class CalabashBrother implements Iterable<CalabashBoy>{
    final int number = 15;
    public List<CalabashBoy> brothers = new ArrayList<>();

    

    public void add(CalabashBoy c){
        brothers.add(c);
    }
    @Override
    public Iterator<CalabashBoy> iterator(){
        return new Iterator<CalabashBoy>(){
            int index =0;
            public boolean hasNext(){return this.index < CalabashBrother.this.number;}
            public CalabashBoy next(){return brothers.get(index++);}
        };
    }

}
