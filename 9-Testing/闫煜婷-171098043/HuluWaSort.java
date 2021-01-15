package homework9;

public class HuluWaSort {
    public static void main(String[] args){
        HuluWaQueue<HuluWa> queue = new HuluWaQueue<>();
        for(int i = 0; i < 10; ++i){
            queue.add(new HuluWa(i+1, HuluWa.genRandomName(), i, Gender.get()));
        }
        queue.shuffle();
        GrandFather grandFather = new GrandFather();

        System.out.println("排序前:");
        queue.numberOff();

        grandFather.sortHuluWas(queue.getArr(), new NameComparator());
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
        HuluWaQueue<HuluWa> males = queue.sepByGender(Gender.MALE);
        HuluWaQueue<HuluWa> females = queue.sepByGender(Gender.FEMALE);

        System.out.println("排序前:");
        System.out.print("male: ");
        males.numberOff();
        System.out.print("female: ");
        females.numberOff();

        males.sort(new NameComparator());
        females.sort(new NameComparator());
        System.out.println("排序后:");
        System.out.print("male: ");
        males.numberOff();
        System.out.print("female: ");
        females.numberOff();
    }
}
