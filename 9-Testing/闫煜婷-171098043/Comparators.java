package homework9;

import java.util.Comparator;

class NameComparator implements Comparator<Creature> {
    @Override
    public int compare(Creature o1, Creature o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class NameRevComparator implements Comparator<Creature> {
    @Override
    public int compare(Creature o1, Creature o2) {
        return o2.getName().compareTo(o1.getName());
    }
}