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
        for(int i=0;i<huluNum;++i){
            hulu[i]=new HuLuWa(i);
        }

        ground.init(0,hulu);
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