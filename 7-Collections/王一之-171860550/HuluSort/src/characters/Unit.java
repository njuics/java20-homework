package characters;

interface Say {
    public abstract String report();
}

abstract public class Unit implements Say {
    int pos;

    public int getPos() {
        return pos;
    }

    public boolean compare(Unit u) {
        return this.pos < u.pos;
    }
}

