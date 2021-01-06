import cn.edu.nju.java.huluwa.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<HuLuWa> hulubrothers = new ArrayList<>();

    private static GrandPa grandpa = new GrandPa();
    
    static void init() {
        hulubrothers.add(new One_HuLuWa());
        hulubrothers.add(new Two_HuLuWa());
        hulubrothers.add(new Three_HuLuWa());
        hulubrothers.add(new Four_HuLuWa());
        hulubrothers.add(new Five_HuLuWa());
        hulubrothers.add(new Six_HuLuWa());
        hulubrothers.add(new Seven_HuLuWa());
        Collections.shuffle(hulubrothers);
    }

    static void printout_list() {
        String output = "";
        for(int i=0;i<hulubrothers.size();i++)
            output += (hulubrothers.get(i).tell_name() + " ");
        System.out.println(output);
    }

    static void choreography(List<HuLuWa> hulubrothers) {
        for(int i=0;i<hulubrothers.size();i++) {
            hulubrothers.get(i).walk(hulubrothers,i);;
        }
    }


    public static void main(String[] args) {

        //初始化
        init();

        //初始随机队列结果
        System.out.println("-------------随机站队-------------");
        printout_list();

        //orchestration排序后队列结果
        System.out.println("----------orchestration----------");
        grandpa.orchestration(hulubrothers);
        printout_list();

        //choreography排序后队列结果
        System.out.println("-----------choreography-----------");
        choreography(hulubrothers);
        printout_list();
    }
    
}
