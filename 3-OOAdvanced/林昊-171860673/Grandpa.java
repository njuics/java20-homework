import creature.Human;

import java.util.Comparator;

public class Grandpa extends Human implements Comparator<CalabashKid> {
    public Grandpa() {
        this.name = "爷爷";
    }

    public Grandpa(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // 询问两个葫芦娃哪个优先级更高并返回
    @Override
    public int compare(CalabashKid calabashKid1, CalabashKid calabashKid2) {
        return calabashKid1.getPriority() - calabashKid2.getPriority();
    }
}
