import java.util.*;

public class IterableCalabash {
    private List<Calabash> c;

    public IterableCalabash(List<Calabash> c){
        this.c = c;

    }

    public List<Calabash> getC() {
        return c;
    }

    public Iterable<Calabash> order(){
        return c;
    }

    public Iterable<Calabash> reversed() {
        return new Iterable<Calabash>(){
            public Iterator<Calabash> iterator(){
                return new Iterator<Calabash>() {
                    int current = c.size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Calabash next() {
                        return c.get(current--);
                    }
                };
            }
        };
    }

    public Iterable<Calabash> randomized() {
        List<Calabash> shuffled = new ArrayList<Calabash>(c);
        Collections.shuffle(shuffled,new Random(42));
        return shuffled;
    }


}
