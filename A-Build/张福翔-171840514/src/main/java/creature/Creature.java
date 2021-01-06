package creature;

import com.google.common.base.MoreObjects;

public class Creature implements Comparable<Creature> {
    static int numCreature = 0;
    protected int id;
    Creature() {
        id = numCreature++;
    }

    @Override
    public int compareTo(Creature o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }
}
