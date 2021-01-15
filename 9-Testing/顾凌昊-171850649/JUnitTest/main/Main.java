package JUnitTest.main;

import JUnitTest.characters.Grandpa;
import JUnitTest.characters.Huluwa;
import JUnitTest.characters.Human;

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


        Grandpa grandpa = Grandpa.getInstance();
        letCall(grandpa);


        grandpa.addAll(list);
        grandpa.sort(true);
        callHuluwa(list);

    }

    private static void letCall(Human human){
        human.call();
    }

    public static List<Huluwa> createHuluwa(){
        List<Huluwa> list = new ArrayList<Huluwa>();

        for(int i = 0 ;i<8;i++){
            list.add(new Huluwa());

        }

        return list;
    }

    private static void callHuluwa(List<Huluwa> list){
        for (Huluwa h: list) {
            //以葫芦娃对象调用letCall方法
            letCall(h);
        }
        System.out.println();
    }

    private static void shuffleList(List list){
        Collections.shuffle(list);
    }
}
