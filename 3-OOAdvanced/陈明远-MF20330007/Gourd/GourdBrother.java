package Gourd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GourdBrother extends GourdBaby {
    public static GourdBrother[] gourdBrothers = new GourdBrother[7];
    public GourdBrother() {
    }
    public GourdBrother(int ranking , String name) {
        super(ranking, name);
    }
    public void reportName() {
        for(GourdBrother item:gourdBrothers) {
            System.out.println(item.getName());
        }
    }

    public void brith() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 7; i++) {
            System.out.println("请输入葫芦娃的名字：");
            String name = sc.next();
            System.out.println("请输入葫芦娃的排行：");
            int ranking = sc.nextInt();
            GourdBrother gourdBaby = new GourdBrother(ranking, name);
            gourdBrothers[i] = gourdBaby;
        }
    }
    public void sort() {
        Arrays.sort(gourdBrothers, new Comparator<GourdBrother>() {
            @Override
            public int compare(GourdBrother o1, GourdBrother o2) {
               return o1.getRanking() - o2.getRanking();
            }
        });
    }
    public void finishSort() {
        System.out.println("排序已完成");
    }
}
