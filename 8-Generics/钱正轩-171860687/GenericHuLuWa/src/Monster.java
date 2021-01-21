import java.util.Random;

public class Monster extends Creature {
    private final int atk;

    Monster() {
        super();
        Random random = new Random();
        atk = random.nextInt(100);
    }

    @Override
    public String toString() {
        return "Monster " + super.toString() + " Atk: " + atk;
    }

    @Override
    public int compareTo(Creature o) {
        if (o instanceof Monster) {
            Monster m = (Monster) o;
            return Integer.compare(atk, m.atk);
        } else {
            return super.compareTo(o);
        }
    }
}
