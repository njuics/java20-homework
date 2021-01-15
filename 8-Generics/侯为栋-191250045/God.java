import java.util.Comparator;

public interface God<T extends Creature> extends Comparator<T> {

    default void setName(T child, String name) {
        child.setName(name);
    }

    default void setSex(T child, String sex) {
        child.setSex(sex);
    }

    void yellAll();

    void yellBoys();

    void yellGirls();

    void sort(GodQueue<T> queue);

    void shuffle(GodQueue<T> queue);

}
