package ooFoundation;

import Sort.Sort;

import java.util.List;
import java.util.Random;

/**
 * @author ：杨海洋
 * @date ：Created in 2020/9/16 13:21
 * @description：爷爷类，实现对葫芦娃们的排序
 * @modified By：
 * @version: $
 */
public class GrandFather {
    public static void sort(List<GourdBaby> list){
        List<GourdBaby> gB = Sort.sort1(list);
        System.out.println("爷爷控制排序之后进行报数：");
        for(int i=0;i<gB.size();i++){
            System.out.print(gB.get(i).getName());
            if(i!=gB.size()-1)
                System.out.print(",");
        }
        System.out.println();
    }
    public static List<GourdBaby> shuffle(List<GourdBaby> list){
        Random r=new Random();
        for(int i=0;i<list.size();i++){
            int ran=r.nextInt(list.size());
            GourdBaby gB=list.get(i);
            list.set(i,list.get(ran));
            list.set(ran,gB);
        }
        System.out.println("葫芦娃们打乱了自己的顺序：");
        for (GourdBaby temp:
             list) {
            System.out.print(temp.getName());
            if(list.iterator().hasNext()){
                System.out.print(",");
            }
        }
        System.out.println();
        return list;
    }

}
