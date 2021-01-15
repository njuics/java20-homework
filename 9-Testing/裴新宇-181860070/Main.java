import java.util.*;
import java.lang.Math;

@SuppressWarnings("unchecked")
public class Main {
    public static void Count_off(LinkedList<? extends Creature> list) {
        for(Creature it: list) {
            it.count_off();
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String []args) {
        LinkedList<Huluwa> huluwaList = new LinkedList<Huluwa>();
        String name = "unknown";
        int gender = 2;
        char[] dict = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<50;i++) {
            // 五十个随机姓名、性别的葫芦娃
            char[] n = {dict[(int)(Math.random()*26)],dict[(int)(Math.random()*26)],dict[(int)(Math.random()*26)],dict[(int)(Math.random()*26)]};
            name = String.valueOf(n);
            gender = (int)(Math.random()*2) == 1 ? 0 : 1;
            huluwaList.add(new Huluwa(name,gender));
        }
        System.out.println("原始队列：");
        Main.Count_off(huluwaList);

        System.out.println("正序队列：");
        TAscendingComparator hac = new TAscendingComparator();
        Collections.sort(huluwaList,hac);
        Main.Count_off(huluwaList);
        
        System.out.println("反序队列：");
        TDescendingComparator hdc = new TDescendingComparator();
        Collections.sort(huluwaList,hdc);
        Main.Count_off(huluwaList);

        System.out.println("乱序队列：");
        Collections.shuffle(huluwaList);
        Main.Count_off(huluwaList);

        System.out.println();

        LinkedList huluwaMaleList = new LinkedList<Huluwa>();
        LinkedList huluwaFemaleList = new LinkedList<Huluwa>();
        for(Huluwa it: huluwaList) {
            if(it.get_gender() == 1)
                huluwaMaleList.add(it);
            else
                huluwaFemaleList.add(it);
        }
        System.out.println("公葫芦娃原始队列：");
        Main.Count_off(huluwaMaleList);

        System.out.println("公葫芦娃正序队列：");
        Collections.sort(huluwaMaleList,hac);
        Main.Count_off(huluwaMaleList);

        System.out.println("公葫芦娃反序队列：");
        Collections.sort(huluwaMaleList,hdc);
        Main.Count_off(huluwaMaleList);

        System.out.println("公葫芦娃乱序队列：");
        Collections.shuffle(huluwaMaleList);
        Main.Count_off(huluwaMaleList);

        System.out.println();

        System.out.println("母葫芦娃原始队列：");
        Main.Count_off(huluwaFemaleList);

        System.out.println("母葫芦娃正序队列：");
        Collections.sort(huluwaFemaleList,hac);
        Main.Count_off(huluwaFemaleList);

        System.out.println("母葫芦娃反序队列：");
        Collections.sort(huluwaFemaleList,hdc);
        Main.Count_off(huluwaFemaleList);

        System.out.println("母葫芦娃乱序队列：");
        Collections.shuffle(huluwaFemaleList);
        Main.Count_off(huluwaFemaleList);
    }

}