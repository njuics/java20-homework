import java.util.*;

public class CalabashBoys {
    public LinkedList<Calabash> set;

    public CalabashBoys(int r){
        //生成葫芦娃信息
        Random rd = new Random();
        set = new LinkedList<Calabash>();
        for(int i = 0; i < r; i++) {
            int length =  rd.nextInt(5) + 1;
            String tempName = "";
            for (int j = 0; j <length; j++){
                char s = (char) ('a' + rd.nextInt(26));
                tempName += s;
            }
            boolean tempGender = true;
            tempGender = (int)(rd.nextInt(2)) == 1 ? true : false;
            set.add(new Calabash(tempName, tempGender));
        }
    }

    public CalabashBoys(LinkedList<Calabash> list){
        set = list;
    }

    //输出当前排序信息
    public void report(){
        System.out.println("当前葫芦娃队列为：");
        for(Calabash i:set){
            i.report();
            System.out.print(" ");
        }
        System.out.println();
    }

    //输出当前排序信息（自定义提示）
    public void report(String s){
        System.out.println(s);
        for(Calabash i:set){
            i.report();
            System.out.print(" ");
        }
        System.out.println();
    }

    public CalabashBoys getBoyCalabashs(){
        LinkedList<Calabash> list = new LinkedList<Calabash>();
        for(Calabash i: set) {
            if(i.getGender() == true) list.add(i);
        }
        return new CalabashBoys(list);
    }

    public CalabashBoys getGirlCalabashs(){
        LinkedList<Calabash> list = new LinkedList<Calabash>();
        for(Calabash i: set) {
            if(i.getGender() == false) list.add(i);
        }
        return new CalabashBoys(list);
    }
}