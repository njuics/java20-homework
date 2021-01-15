public class HuluWaSort {
    public static void main(String[] args){
        //HuluWaQueue queue = new HuluWaQueue();
        GrandFather grandFather = new GrandFather();

        System.out.println("orchestration:");
        System.out.println("排序前:");
        HuluWaQueue.numberOff();
        grandFather.sortHuluWas(HuluWaQueue.getHuluArray(), new SeniorityComparator());
        System.out.println("排序后:");
        HuluWaQueue.numberOff();

        HuluWaQueue.shuffle();

        System.out.println("choreography:");
        System.out.println("排序前:");
        HuluWaQueue.numberOff();
        HuluWaQueue.autoSort(new SeniorityComparator());
        System.out.println("排序后:");
        HuluWaQueue.numberOff();
    }
}
