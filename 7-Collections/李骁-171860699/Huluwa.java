import java.util.Comparator;
import java.util.Random;
//import org.apache.commons.lang.RandomStringsUtils;

enum Gender {
    female, male
}

public class Huluwa implements Comparable<Huluwa> {
    
    private String name;
    
    private Gender gender;

    //generate name and sex randomly
    public Huluwa() {
        Random rand = new Random();
        //name = "hlw" + rand.nextInt(10);
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        //name = RandomStringsUtils.randomAlphanumeric(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        name = sb.toString();
        gender = rand.nextBoolean() == true ? Gender.male : Gender.female;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int compareTo(Huluwa o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "name: " + name + ", gender: " + gender;
    }
}