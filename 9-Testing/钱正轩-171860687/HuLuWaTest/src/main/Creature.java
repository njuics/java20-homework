import java.util.Random;

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
    public int compareTo(Creature o) {
        return name.compareTo(o.name);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Name: " + name + " Gender: " + (gender ? "male" : "female");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Creature) {
            Creature c = (Creature) obj;
            return name.equals(c.name);
        }
        return false;
    }

}
