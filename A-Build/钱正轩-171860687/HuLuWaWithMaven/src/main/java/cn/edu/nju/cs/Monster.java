package cn.edu.nju.cs;

import java.util.Random;
import java.util.Objects;

import com.google.common.base.MoreObjects;


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
    public int compareTo(Creature o) {
        if (o instanceof Monster && super.compareTo(o) == 0) {
            Monster m = (Monster) o;
            return Integer.compare(atk, m.atk);
        }
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) && obj instanceof Monster) {
            return atk == ((Monster) obj).atk;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isGender(), atk);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("Monster").add("name", getName())
                .add("gender", isGender() ? "male" : "female").add("attack", atk).toString();
    }

}
