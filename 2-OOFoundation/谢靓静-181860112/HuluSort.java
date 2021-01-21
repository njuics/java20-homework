public class HuluSort {
    private static HuluList huluBrothers = new HuluList();
    private static Grandpa grandpa = new Grandpa();

    public static void main(String[] args) {
        System.out.print("排队前：");
        huluBrothers.shuffle();
        System.out.println("葫芦娃自行排队中...");
        System.out.print("排队后：");
        huluBrothers.choreography();

        System.out.print("排队前：");
        grandpa.shuffle();
        System.out.println("爷爷指挥排队中...");
        System.out.print("排队后：");
        grandpa.orchestration();
    }
}
