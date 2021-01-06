package ulticalabash.character;

import lombok.Getter;
import lombok.Setter;
import ulticalabash.factory.FactoryCreature;
import ulticalabash.util.Comparators;
import ulticalabash.util.CompareFlag;
import ulticalabash.util.Gender;
import ulticalabash.util.Rand;

import java.util.ArrayList;
import java.util.Comparator;

@Getter
@Setter
public abstract class God<T extends Creature> implements Comparator<T> {

    protected FactoryCreature factory;

    protected ArrayList<T> children;

    protected CompareFlag flag;

    public void setName(T child, String name) {
        child.setName(name);
    }

    public String callChildren() {
        StringBuilder builder = new StringBuilder();
        for (var child : this.children) {
            builder.append(child.getName() + " ");
        }
        return builder.toString().strip();
    }

    public Comparator<T> buildComparator() {
        return switch (this.flag) {
            case NAME_REVERSE -> ((o1, o2) -> -Comparators.dict(o1.getName(), o2.getName()));
            case SEX -> ((o1, o2) -> {
                int res = Comparators.dict(o1.getSex().toString(), o2.getSex().toString());
                if (res == 0)
                    return Comparators.dict(o1.getName(), o2.getName());
                return res;
            });
            case SEX_REVERSE -> ((o1, o2) -> {
                int res = -Comparators.dict(o1.getSex().toString(), o2.getSex().toString());
                if (res == 0) {
                    return -Comparators.dict(o1.getName(), o2.getName());
                }
                return res;
            });
            case RANDOM -> (o1, o2) -> ((Rand.randNum(2) > 0) ? 0 : 1);
            default -> ((o1, o2) -> Comparators.dict(o1.getName(), o2.getName()));
        };
    }

    public void setChildFlag(CompareFlag curFlag) {
        T.flag = curFlag;
    }

    public abstract void sortChildren();

    public abstract void shuffleChildren();

    public abstract T newChild();

    public abstract T newChild(String name, Gender sex);

}
