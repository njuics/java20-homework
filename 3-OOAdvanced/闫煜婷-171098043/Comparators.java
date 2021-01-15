import java.util.Comparator;

class SeniorityComparator implements Comparator<HuluWa> {
    @Override
    public int compare(HuluWa o1, HuluWa o2) {
        return o2.getSeniority() - o1.getSeniority();
    }
}