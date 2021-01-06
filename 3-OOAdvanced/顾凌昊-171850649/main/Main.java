package OOAdvanced.main;

import OOAdvanced.characters.Grandpa;
import OOAdvanced.characters.Huluwa;
import OOAdvanced.characters.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Huluwa> list = createHuluwa();

        //爷爷指挥排序
        System.out.println("*******orchestration*******");
        shuffleList(list);
        callHuluwa(list);

        letCall(Grandpa.getInstance());

        Grandpa.getInstance().sortHuluwa(list);
        callHuluwa(list);

        //葫芦娃自发排序
        System.out.println("*******choreography*******");
        shuffleList(list);
        callHuluwa(list);

        choreography(list);
        callHuluwa(list);

        //显示人数
        System.out.println("世界上总人口数为："+ Human.count);

    }

    private static void letCall(Human human){
        human.call();
    }

    public static void choreography(List<Huluwa> list){
        for(int i = list.size()-1 ;i>0;i--){
            for(int j = 0;j < i;j++){
                if(list.get(j).compareTo(list.get(j+1))>0){
                    list.get(j).swapWith(list.get(j+1));
                }
            }
        }
    }

    public static List<Huluwa> createHuluwa(){
        List<Huluwa> list = new ArrayList<Huluwa>();

        list.add(new Huluwa(1,"老大"));
        list.add(new Huluwa(2,"老二"));
        list.add(new Huluwa(3,"老三"));
        list.add(new Huluwa(4,"老四"));
        list.add(new Huluwa(5,"老五"));
        list.add(new Huluwa(6,"老六"));
        list.add(new Huluwa(7,"老七"));

        return list;
    }

    public static void callHuluwa(List<Huluwa> list){
        for (Huluwa h: list) {
            //以葫芦娃对象调用letCall方法
            letCall(h);
        }
        System.out.println();
    }

    public static void shuffleList(List list){
        Collections.shuffle(list);
    }
}
