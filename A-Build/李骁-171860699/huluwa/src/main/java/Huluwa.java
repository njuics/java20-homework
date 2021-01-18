import java.util.Random;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;

enum Gender {
    female, male
}

public class Huluwa implements Comparable<Huluwa> {
    
    private String name;
    
    private Gender gender;

    //generate name and sex randomly
    public Huluwa() {
        name = RandomStringUtils.randomAlphabetic(5);
        gender = RandomUtils.nextBoolean() == true ? Gender.male : Gender.female;
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
        //return "name: " + name + ", gender: " + gender;
        return MoreObjects.toStringHelper("Huluwa").add("name", getName()).add("gender", getGender() == Gender.male ? "male" : "female")
                .toString();
    }
}