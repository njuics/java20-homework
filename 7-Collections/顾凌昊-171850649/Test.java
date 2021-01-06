package Collections;

public class Test {

    public static void main(String[] args) {

        Grandpa g = new Grandpa();
        SuperGrandpa sg = new SuperGrandpa();

        //随机生成葫芦娃
        for(int i = 0 ;i<10;i++){
            Huluwa h = new Huluwa();
            h.call();

            g.addHuluwa(h);
            sg.addHuluwa(h);
        }

        System.out.println("**********使用ArrayList容器**********");

        //正向、逆向、随机排列
        System.out.println("正序排列");
        g.sortHuluwa(false);
        g.printHuluwa();

        System.out.println("逆序排列");
        g.sortHuluwa(true);
        g.printHuluwa();

        System.out.println("随机排列");
        g.shuffleHuluwa();
        g.printHuluwa();

        //获取女性葫芦娃并打印，男性同理
        System.out.println("获得女性葫芦娃并打印");
        Grandpa gg = new Grandpa(g.getHuluwaOfGender(false));
        gg.sortHuluwa(false);
        gg.printHuluwa();


        System.out.println("**********使用自定义存储和迭代器类**********");
        sg.printHuluwa();

        System.out.println("逆序排列");
        sg.sortHuluwa(false);
        sg.printHuluwa();


    }
}
