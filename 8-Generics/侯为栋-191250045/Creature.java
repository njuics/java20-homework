import util.Compare;
import util.Rand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature implements Comparable<Creature> {

    private String name;
    private String sex;

    public Creature() {
        this.name = Rand.randomName();
        this.sex = Rand.randomSex();
    }

    @Override
    public int compareTo(Creature bro) {
        return Compare.dict(this.name, bro.getName());
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " and I am a " + ((this.sex.equals("boy")) ? "boy" : "girl") + " !";
    }

}
