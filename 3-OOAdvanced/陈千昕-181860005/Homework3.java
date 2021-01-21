import calabash.*;
import calabash.sort.*;
class Homework3 {
    public static void main(String[] args){
        //初始化葫芦娃，可以在此随意增添删除修改
        Calabash[] set = {  new Calabash(0, "老大"), new Calabash(1, "老二"), 
                            new Calabash(2, "老三"), new Calabash(3, "老四"), 
                            new Calabash(4, "老五"), new Calabash(5, "老六"), 
                            new Calabash(6, "老七") 
                         };
    
        CalabashBoys c1 = new CalabashBoys(set);
        //随机，并输出随机结果
        c1.shuffle();
        c1.report();
        
        //获取排序后的葫芦娃set
        set = c1.getSet();

        //生成与c1一样的平行世界中的CalabashBoys c2，便于比较两种排序
        CalabashBoys c2 = new CalabashBoys(set);

        //为两种平行世界内不同的排序方法生成对象
        BaseSort s1 = new Orchestration();
        BaseSort s2 = new Choreography();

        //两个平行世界用两种方法进行排序
        s1.sort(c1);
        s2.sort(c2);
    }
}