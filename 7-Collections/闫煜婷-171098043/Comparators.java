import java.util.Comparator;

class SeniorityComparator implements Comparator<HuluWa> {
    @Override
    public int compare(HuluWa o1, HuluWa o2) {
        return o2.getSeniority() - o1.getSeniority();
    }
}

class NameComparator implements Comparator<HuluWa> {
    @Override
    public int compare(HuluWa o1, HuluWa o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class NameRevComparator implements Comparator<HuluWa> {
    @Override
    public int compare(HuluWa o1, HuluWa o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
