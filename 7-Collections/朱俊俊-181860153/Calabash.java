import java.util.Collection;
import java.util.Random;

public class Calabash implements Comparable<Calabash> {
    private String name;
    private Gender gender;

    private Calabash(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public static Calabash randomCalabash() {
        Random random = new Random();
        Gender gender = random.nextInt() % 2 == 0 ? Gender.MALE : Gender.FEMALE;

        String KeyString = "abcdefghijklmnopqrstuvwxy";
        StringBuffer sb = new StringBuffer();
        int length = random.nextInt(5) + 2;
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt(random.nextInt(KeyString.length())));
        }
        String name = sb.toString();

        return new Calabash(name, gender);
    }

    public static void randomCalabash(Collection<Calabash> collection, int n) {
        for (int i = 0; i < n; i++)
            collection.add(randomCalabash());
    }

    @Override
    public int compareTo(Calabash o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " " + gender;
    }
}
