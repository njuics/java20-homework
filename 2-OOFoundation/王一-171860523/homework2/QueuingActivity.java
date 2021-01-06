package homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueuingActivity {
    private static Grandfather grandpa;                    //参加活动的爷爷
    private static List<CalabashBrother> calabashBrothers;     //参加活动的葫芦娃

    /**
     * 初始化，生成参加活动的人员
     */
    private static void init() {
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七", "爷爷"};
        grandpa = new Grandfather(names[7], 7);
        CalabashBrother cb;
        calabashBrothers = new ArrayList<>();
        for(int i = 0; i < 7; ++i) {
            cb = new CalabashBrother(names[i], i);
            calabashBrothers.add(cb);
        }
    }

    /**
     * 为CalabashBrother.calabashQueue生成一个乱序的队列
     */
    private static void shuffleBrothers() {
        CalabashBrother.calabashQueue = new ArrayList<>();
        List<Integer> random = new ArrayList<>();
        for(int i = 0; i < 7; ++i)
            random.add(i);
        Collections.shuffle(random);              //打乱序列，打乱后的数字代表该位置的葫芦娃编号
        for(int i : random)
            CalabashBrother.calabashQueue.add(calabashBrothers.get(i));
    }

    /**
     * orchestration排队方式，调用Grandfather类中的commandQueuing()函数来指挥排队
     */
    private static void orchestrationQueuing() {
        try {
            grandpa.commandQueuing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * choreography排队方式
     */
    private static void choreographyQueuing() {
        System.out.println("大家正在排队…………");
        for(CalabashBrother calaBro : calabashBrothers)
            calaBro.compareExchange();
        System.out.println("排队完成…………");
    }

    public static void main(String[] args) throws Exception {
        //生成参加活动的人员
        init();

        //生成随机的排队序列
        shuffleBrothers();

        System.out.println("爷爷和七个葫芦娃要一起参加一个活动，但是现在葫芦娃没有按照顺序排好队，他们目前的顺序是：");
        for(CalabashBrother calaBro : CalabashBrother.calabashQueue)
            calaBro.sayOutName();
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
        for(CalabashBrother calaBro : CalabashBrother.calabashQueue)
            calaBro.sayOutName();
        System.out.println("报数结束");
    }
}
