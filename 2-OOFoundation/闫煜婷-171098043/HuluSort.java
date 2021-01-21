import java.util.Comparator;

public class HuluSort {
    public static Comparator<HuluWa> seniorityComparator = new Comparator<HuluWa>() {
        @Override
        public int compare(HuluWa o1, HuluWa o2) {
            if(o1.getSeniority() < o2.getSeniority()) return 1;
            else if (o1.getSeniority() == o2.getSeniority()) return 0;
            else return -1;
        }
    };
    public static void main(String[] args){
        HuluWaQueue queue = new HuluWaQueue();
        GrandFather grandFather = new GrandFather();

        System.out.println("orchestration:");
        System.out.println("排序前:");
        queue.numberOff();
        grandFather.sortHuluWas(queue.getHuluArray(), seniorityComparator);
        System.out.println("排序后:");
        queue.numberOff();

        queue.shuffle();

        System.out.println("choreography:");
        System.out.println("排序前:");
        queue.numberOff();
        queue.autoSort(seniorityComparator);
        System.out.println("排序后:");
        queue.numberOff();
    }
}
