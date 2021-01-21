package ulticalabash.character;

import lombok.Getter;
import ulticalabash.util.Comparators;
import ulticalabash.util.CompareFlag;
import ulticalabash.util.Gender;
import ulticalabash.util.Rand;

@Getter
public abstract class Creature implements Comparable<Creature> {

    protected String name;

    protected Gender sex;

    public static CompareFlag flag = CompareFlag.NAME;

    public Creature() {
        this.name = Rand.randomName(6);
        this.sex = Rand.randomSex();
    }

    public Creature(String name, Gender sex) {
        this.name = name;
        this.sex = sex;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return switch (Creature.flag) {
            case SEX, SEX_REVERSE -> this.sex.toString();
            default -> this.name;
        };
    }

    @Override
    public int compareTo(Creature bro) {
        return Comparators.dict(this.getFlag(), bro.getFlag());
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " and I am a " + ((this.sex.equals(Gender.BOY)) ? "boy" : "girl") + " !";
    }

}