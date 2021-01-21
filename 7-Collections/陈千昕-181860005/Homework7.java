import java.util.*;
class Homework7 {
    public static void doSort(CalabashBoys c, String type){
        //输出随机生成结果
        c.report(type + "初始排序队列：");
        
        CalabashAscendingComparator ascending = new CalabashAscendingComparator();
        Collections.sort(c.set, ascending);
        c.report(type + "正序排序后的队列：");

        CalabashDescendingComparator descending = new CalabashDescendingComparator();
        Collections.sort(c.set, descending);
        c.report(type + "反序排序后的队列：");

        Collections.shuffle(c.set);
        c.report(type + "乱序排序后的队列：");

        System.out.println();
    }

    public static void main(String[] args){
        //初始化葫芦娃，可以在此随意增添删除修改
        CalabashBoys c1 = new CalabashBoys(7);//生成7个葫芦娃
        doSort(c1, "葫芦娃");
        CalabashBoys cBoy = c1.getBoyCalabashs();
        doSort(cBoy, "公葫芦娃");
        CalabashBoys cGirl = c1.getGirlCalabashs();
        doSort(cGirl, "母葫芦娃");
    }
}