package homework3.main;

import homework3.mylib.*;

import java.util.ArrayList;
import java.util.List;

public class QueuingActivity {
    private static List<Human> attendPeople;      //参加活动爷爷和葫芦娃

    /**
     * 初始化，生成参加活动的人员
     */
    private static void init() {
        attendPeople = new ArrayList<>();
        GrandFather grandpa = new GrandFather(0);
        attendPeople.add(grandpa);
        CalaBro cb;
        for(int i = 1; i <= 7; ++i) {
            cb = new CalaBro(i);
            attendPeople.add(cb);
        }
    }

    /**
     * orchestration排队方式，调用Grandfather类中的commandQueuing()函数来指挥排队
     */
    private static void orchestrationQueuing() {
        try {
            attendPeople.get(0).compareExchange();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * choreography排队方式
     */
    private static void choreographyQueuing() {
        System.out.println("大家正在排队…………");
        for(int i = 1; i <= 7; ++i)
            attendPeople.get(i).compareExchange();
        System.out.println("排队完成…………");
    }

    public static void main(String[] args) throws Exception {
        //生成参加活动的人员
        init();

        System.out.println("爷爷和七个葫芦娃要一起参加一个活动，但是现在葫芦娃没有按照顺序排好队，他们目前的顺序是：");
        for(int i = 1; i <= 7; ++i)
            Human.humanQueue[i].sayOutName();
        System.out.println("你会选择：1. 请爷爷帮忙排队；2. 葫芦娃们协作排队（请输入 1 或 2）");
        int choose = System.in.read();

        if(choose == '1') {
            orchestrationQueuing();
        } else if(choose == '2') {
            choreographyQueuing();
        } else {
            throw new Exception("输入无效！");
        }

        //开始按照顺序报数
        System.out.println("开始报数：");
        for(int i = 1; i <= 7; ++i)
            Human.humanQueue[i].sayOutName();
        System.out.println("报数结束");
    }
}
