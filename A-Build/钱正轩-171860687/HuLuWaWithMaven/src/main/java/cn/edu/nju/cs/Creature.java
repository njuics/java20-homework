package cn.edu.nju.cs;

import java.util.Objects;
import java.util.Random;

import com.google.common.base.MoreObjects;

public abstract class Creature implements Comparable<Creature> {
    private static final String BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 12;

    private final String name;
    private final boolean gender;

    Creature() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < NAME_LENGTH; i++) {
            int index = random.nextInt(BASE.length());
            stringBuilder.append(BASE.charAt(index));
        }
        name = stringBuilder.toString();
        gender = random.nextBoolean();
    }

    Creature(String name) {
        Random random = new Random();
        this.name = name;
        this.gender = random.nextBoolean();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("Creature").add("name", name).add("gender", gender ? "male" : "female")
                .toString();
    }

    @Override
    public int compareTo(Creature o) {
        return name.compareTo(o.name);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Creature)) {
            return false;
        }
        Creature other = (Creature) obj;
        return Objects.equals(name, other.name);
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @return the gender
     */
    public final boolean isGender() {
        return gender;
    }
}
