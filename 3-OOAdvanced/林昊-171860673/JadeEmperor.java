import java.util.Random;
import creature.*;
import algorithm.Sort;

public class JadeEmperor {
    // public成员
    public static void main(String[] args){
        // 玉皇大帝非常好奇，想看看打乱葫芦娃以后能不能用三种方法让葫芦娃排好序
        // 第一种方法是用玉皇大帝的算法
        shuffle();// 打乱葫芦娃
        Sort.insertionSort(calabashKidArray);
        System.out.println("Algorithm结果：");
        print();

        // 第二种方法是让爷爷帮助指挥
        shuffle();// 打乱葫芦娃
        Sort.orchestration(calabashKidArray, grandpa);
        System.out.println("Orchestration结果：");
        print();

        // 第三种方法是让葫芦娃自己根据兄弟的信息来排序
        shuffle();// 打乱葫芦娃
        Sort.choreography(calabashKidArray);
        System.out.println("Choreography结果：");
        print();
    }

    // private成员
    // 玉皇大帝管理所有的人间生死
    private static CalabashKid calabashKidArray[];
    private static Grandpa grandpa;
    private static Random rand;
    static {
        // 爷爷出生
        grandpa = new Grandpa("爷爷");
        // 葫芦娃出生
        calabashKidArray = new CalabashKid[7];
        calabashKidArray[0] = new CalabashKid(1, "老大");
        calabashKidArray[1] = new CalabashKid(2, "老二");
        calabashKidArray[2] = new CalabashKid(3, "老三");
        calabashKidArray[3] = new CalabashKid(4, "老四");
        calabashKidArray[4] = new CalabashKid(5, "老五");
        calabashKidArray[5] = new CalabashKid(6, "老六");
        calabashKidArray[6] = new CalabashKid(7, "老七");
        // 一个打乱葫芦娃的随机数种子
        rand = new Random();
    }

    // 玉皇大帝有打乱葫芦娃排列顺序的能力
    private static void shuffle() {
        for (int i = 0; i < calabashKidArray.length; i++) {
            swap(i, rand.nextInt(calabashKidArray.length - i) + i);
        }
    }

    // 玉皇大帝有交换葫芦娃顺序的能力
    private static void swap(int element1, int element2) {
        CalabashKid tempHuman = calabashKidArray[element1];
        calabashKidArray[element1] = calabashKidArray[element2];
        calabashKidArray[element2] = tempHuman;
    }

    // 玉皇大帝有打印葫芦娃名单的能力
    private static void print(){
        for (Human curHuman : calabashKidArray){
            System.out.println(curHuman.getName());
        }
    }
}
