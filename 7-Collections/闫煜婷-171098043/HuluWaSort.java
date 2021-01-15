public class HuluWaSort {
    public static void main(String[] args){
        HuluWaQueue queue = new HuluWaQueue(10);
        GrandFather grandFather = new GrandFather();

        System.out.println("orchestration:");
        System.out.println("排序前:");
        queue.numberOff();

        grandFather.sortHuluWas(queue.getHuluArray(), new NameComparator());
        System.out.println("正序排序后:");
        queue.numberOff();

        queue.sort(new NameRevComparator());
        System.out.println("倒序排序后:");
        queue.numberOff();

        queue.shuffle();
        System.out.println("乱序排序:");
        queue.numberOff();

        System.out.println("\n----------------------------------------\n");

        System.out.println("将葫芦娃按性别分为两队");
        HuluWaQueue males = queue.sepByGender(Gender.MALE);
        HuluWaQueue females = queue.sepByGender(Gender.FEMALE);

        System.out.println("choreography:");
        System.out.println("排序前:");
        System.out.print("male: ");
        males.numberOff();
        System.out.print("female: ");
        females.numberOff();

        males.autoSort();
        females.autoSort();
        System.out.println("排序后:");
        System.out.print("male: ");
        males.numberOff();
        System.out.print("female: ");
        females.numberOff();
    }
}
