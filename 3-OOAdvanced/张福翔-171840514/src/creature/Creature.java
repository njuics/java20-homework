package creature;

public class Creature {
    static int numCreature = 0;
    private int id;
    Creature() {
        id = numCreature++;
    }
}
