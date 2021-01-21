package creature.calabash;

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

    /*
     * 输出当前排序信息
     * <p>默认输出："当前葫芦娃队列为："
     */
    public void report(){
        report("当前葫芦娃队列为：");
    }

    /*
     * 输出当前排序信息
     * <p>默认会在输出前输出你提供的字符串
     */
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

    /**
     * Sort this CalabashBoys
     * @param type Define the Sort operation: 0 is for Ascending, 1 is for Descending, 2 is for Shuffle.
     */
    public void sort(int type){
        switch(type){
            case 0:
                CalabashAscendingComparator ascending = new CalabashAscendingComparator ();
                Collections.sort(set, ascending);
                report("正序排序后的队列："); break;
            case 1:
                CalabashDescendingComparator descending = new CalabashDescendingComparator ();
                Collections.sort(set, descending);
                report("反序排序后的队列："); break;
            case 2:
                Collections.shuffle(set);
                report("乱序排序后的队列："); break;
            default: break;
        }
        System.out.println();
    }
}