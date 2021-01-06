import java.util.*;
class Homework8 {
    public static void doCalabashSort(CalabashBoys c, String type){
        //输出随机生成结果
        c.report(type + "初始排序队列：");
        
        CreatureAscendingComparator<Calabash> ascending = new CreatureAscendingComparator<Calabash>();
        Collections.sort(c.set, ascending);
        c.report(type + "正序排序后的队列：");

        CreatureDescendingComparator<Calabash> descending = new CreatureDescendingComparator<Calabash>();
        Collections.sort(c.set, descending);
        c.report(type + "反序排序后的队列：");

        Collections.shuffle(c.set);
        c.report(type + "乱序排序后的队列：");

        System.out.println();
    }

    public static void main(String[] args){
        //初始化葫芦娃，可以在此随意增添删除修改
        CalabashBoys c1 = new CalabashBoys(7);//生成7个葫芦娃
        doCalabashSort(c1, "葫芦娃");
        CalabashBoys cBoy = c1.getBoyCalabashs();
        doCalabashSort(cBoy, "公葫芦娃");
        CalabashBoys cGirl = c1.getGirlCalabashs();
        doCalabashSort(cGirl, "母葫芦娃");
    }
}