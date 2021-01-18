public class Calabash extends Creature implements Comparable<Calabash>{
    private int index;
    public Calabash(int index,String name) {
        super(name);
        this.index = index;
    }

    @Override
    public int compareTo(Calabash o) {
        return Integer.compare(index,o.index);
    }

    @Override
    public String toString() {
        return "Calabash{" +
                "name='" + name + '\'' +
                '}';
    }
}
