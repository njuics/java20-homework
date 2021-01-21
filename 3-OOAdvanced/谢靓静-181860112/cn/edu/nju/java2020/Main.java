package cn.edu.nju.java2020;

public class Main {
    private static Hulu[] huluBrothers;
    private static Grandpa grandpa;

    static {
        huluBrothers = new Hulu[]{
                new Hulu("老大", 1), new Hulu("老二", 2),
                new Hulu("老三", 3), new Hulu("老四", 4),
                new Hulu("老五", 5), new Hulu("老六", 6),
                new Hulu("老七", 7)
        };
        grandpa = new Grandpa();
    }

    public static void main(String[] args) {
        System.out.println("【以orchestration方式排序】");
        sortBy(grandpa);
        System.out.println("【以choreography方式排序】");
        sortBy(huluBrothers[0]);
    }

    private static void sortBy(Sort s) {
        s.shuffle(huluBrothers);
        System.out.print("排序前：");
        countOff();
        s.sort(huluBrothers);
        System.out.print("排序后：");
        countOff();
        System.out.println();
    }

    private static void countOff() {//报数
        for (int i = 0; i < huluBrothers.length; ++i) {
            System.out.print(huluBrothers[i].reportName() + " ");
        }
        System.out.println();
    }
}
