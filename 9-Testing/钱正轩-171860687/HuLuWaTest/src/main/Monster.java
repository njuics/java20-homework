import java.util.Random;

public class Monster extends Creature {
    private final int atk;

    Monster() {
        super();
        Random random = new Random();
        atk = random.nextInt(100);
    }

    Monster(String name, int atk) {
        super(name);
        this.atk = atk;
    }

    @Override
    public String toString() {
        return "Monster " + super.toString() + " Atk: " + atk;
    }

    @Override
    public int compareTo(Creature o) {
        if (o instanceof Monster && super.compareTo(o) == 0) {
            Monster m = (Monster) o;
            return Integer.compare(atk, m.atk);
        }
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj instanceof Monster) {
                Monster m = (Monster) obj;
                return atk == m.atk;
            }
            return true;
        }
        return false;
    }
}
