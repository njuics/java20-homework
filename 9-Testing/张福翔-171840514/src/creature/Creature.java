package creature;

import org.jetbrains.annotations.NotNull;

public class Creature implements Comparable<Creature> {
    static int numCreature = 0;
    private int id;
    Creature() {
        id = numCreature++;
    }

    @Override
    public int compareTo(Creature o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Creature#" + id + " Type: " + this.getClass().getSimpleName();
    }
}
