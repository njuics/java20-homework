package control;

import characters.Ground;
import characters.HuLuWa;

public class LineUp {
    static int huluNum;

    static {
        huluNum = 7;
        System.out.println("初始化葫芦娃数量:7");
    }

    public static void main(String[] args) {
        Ground ground = new Ground(2);//2列

        HuLuWa[] hulu = new HuLuWa[huluNum];
        hulu[0] = new HuLuWa(1, HuLuWa.HuLuColor.RED);
        hulu[1] = new HuLuWa(2, HuLuWa.HuLuColor.ORANGE);
        hulu[2] = new HuLuWa(3, HuLuWa.HuLuColor.YELLOW);
        hulu[3] = new HuLuWa(4, HuLuWa.HuLuColor.GREEN);
        hulu[4] = new HuLuWa(5, HuLuWa.HuLuColor.CYAN);
        hulu[5] = new HuLuWa(6, HuLuWa.HuLuColor.BLUE);
        hulu[6] = new HuLuWa(7, HuLuWa.HuLuColor.PURPLE);

        ground.init(hulu);
        ground.sort(0,3);
        System.out.println("after randomly init:");
        ground.printColumn(0);

        ground.sort(0,1);
        System.out.println("after Sort:");
        ground.printColumn(0);

        ground.sort(0,3);
        System.out.println("after shuffle:");
        ground.printColumn(0);

        ground.sort(0,2);
        System.out.println("after reverse order sort:");
        ground.printColumn(0);

        ground.divideByGender(0);
        System.out.println("after divide by gender:");
        ground.printColumn(0);
        ground.sort(0,1);
        ground.printColumn(1);
        ground.sort(1,1);
    }

}