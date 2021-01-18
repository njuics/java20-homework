import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import org.apache.commons.lang3.RandomStringUtils;
import com.google.common.collect.Collections2;

import creature.Human;
import algorithm.Sort;
import enums.Gender;
import enums.Order;
import enums.Enums;

public class JadeEmperor {
    // public成员
    public static void main(String[] args) {
        print(calabashKidArray, "依次出生的葫芦娃");
        // 玉皇大帝非常好奇, 想看看打乱葫芦娃以后能不能用三种方法让葫芦娃排好序
        // 第1.1种方法是用Comparable, 按照名字正序排序
        Collections.shuffle(calabashKidArray);// 打乱葫芦娃
        CalabashKidArrayList.sortByComparable(calabashKidArray, Order.ASC);
        print(calabashKidArray, "Comparable的名字正序排序");

        // 第1.2种方法是用Comparable, 按照名字反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparable(calabashKidArray, Order.DESC);
        print(calabashKidArray, "Comparable的名字反序排序");

        // 第1.3种方法是用Comparable, 按照名字乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList. sortByComparable(calabashKidArray, Order.RANDOM);
        print(calabashKidArray, "Comparable的名字乱序排序");

        // 第2.1种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的正序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable(Order.ASC, "Comparable的性别分开的正序排序");

        // 第2.2种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable(Order.DESC, "Comparable的性别分开的反序排序");

        // 第2.3种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable(Order.RANDOM, "Comparable的性别分开的乱序排序");

        // 第3.1种方法是用Comparator, 按照名字正序排序
        Collections.shuffle(calabashKidArray);// 打乱葫芦娃
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.ASC);
        print(calabashKidArray, "Comparator的名字正序排序");

        // 第3.2种方法是用Comparator, 按照名字反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.DESC);
        print(calabashKidArray, "Comparator的名字反序排序");

        // 第3.3种方法是用Comparator, 按照名字乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.RANDOM);
        print(calabashKidArray, "Comparator的名字乱序排序");

        // 第4.1种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的正序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator(Order.ASC, "Comparator的性别分开的正序排序");

        // 第4.2种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator(Order.DESC, "Comparator的性别分开的反序排序");

        // 第4.3种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator(Order.RANDOM, "Comparator的性别分开的乱序排序");

        // 第5.1方法是调用Collections.sort()进行排序, 然后正向和反向用Iterable, 正向和反向的Iterator遍历葫芦娃列表获得升序和降序
        Collections.shuffle(calabashKidArray);
        for(CalabashKid calabashKid : calabashKidArray){
            calabashKid.setOrder(Order.ASC);
        }
        Collections.sort(calabashKidArray, CalabashKid.calabashKidComparator);
        printIterable("正序排序的正向Iterable结果");
        printReversedIterable("正序排序的反向Iterable结果");
        printIterator("正序排序的正向Iterator结果");
        printReversedIterator("正序排序的反向Iterator结果");
    }

    // private成员
    // 玉皇大帝管理所有的人间生死
    private static CalabashKidArrayList<CalabashKid> calabashKidArray = new CalabashKidArrayList<>();
    private static CalabashKidArrayList<CalabashKid> maleCalabashKidArray;
    private static CalabashKidArrayList<CalabashKid> femaleCalabashKidArray;
    private static Random rand;

    private static String[] familyNameArr = {
            "赵", "钱", "孙", "李",
            "周", "吴", "郑", "王",
            "冯", "陈", "沈", "韩",
            "朱", "秦", "尤", "许",
            "何", "吕", "施", "张",
            "孔", "曹", "严", "杨",
            "金", "魏", "陶", "姜",
            "司马", "上官", "欧阳",
            "诸葛",  "尉迟"
    };

    static {
        // 一个随机数种子
        rand = new Random();
        // 10个葫芦娃出生
        for (int i = 1; i <= 10; i++) {
//            calabashKidArray.add(new CalabashKid(i, "老" + i, Enums.random(Gender.class))); // just for debug
            calabashKidArray.add(
                    new CalabashKid(i,
                            getFamilyName() + getGivenName(),
                            Enums.random(Gender.class)));
        }
    }

    public static class CalabashKidIterable implements Iterable<CalabashKid>{
        @Override
        public Iterator<CalabashKid> iterator(){
            return new Iterator<CalabashKid>(){
                @Override
                public boolean hasNext() {
                    return index < calabashKidArray.size();
                }

                @Override
                public CalabashKid next(){
                    CalabashKid currCalabashKid = calabashKidArray.get(index);
                    index++;
                    return currCalabashKid;
                }

                private int index = 0;
            };
        }
    }

    public static class CalabashKidReversedIterable implements Iterable<CalabashKid>{
        @Override
        public Iterator<CalabashKid> iterator(){
            return new Iterator<CalabashKid>(){
                @Override
                public boolean hasNext() {
                    return index >= 0;
                }

                @Override
                public CalabashKid next(){
                    CalabashKid currCalabashKid = calabashKidArray.get(index);
                    index--;
                    return currCalabashKid;
                }

                private int index = calabashKidArray.size() - 1;
            };
        }
    }

    public static class CalabashKidArrayList<T extends CalabashKid> extends ArrayList<T> {
        public static <T extends CalabashKid> void sortByComparable(CalabashKidArrayList<T> array, Order order){
            for(T calabashKid : array){
                calabashKid.setOrder(order);
            }
            Sort.insertionSort(array);
        }

        public static <T extends CalabashKid> void sortByComparator(CalabashKidArrayList<T> array, Order order){
            for(T calabashKid : array){
                calabashKid.setOrder(order);
            }
            Sort.insertionSort(array, CalabashKid.calabashKidComparator);
        }

        public static void sortDividedByComparable(Order order, String msg){
            sortByComparable(maleCalabashKidArray, order);
            print(maleCalabashKidArray, Gender.MALE, msg);
            sortByComparable(femaleCalabashKidArray, order);
            print(femaleCalabashKidArray, Gender.FEMALE);
        }

        public static void sortDividedByComparator(Order order, String msg){
            CalabashKidArrayList.sortByComparator(maleCalabashKidArray, order);
            print(maleCalabashKidArray, Gender.MALE, msg);
            CalabashKidArrayList.sortByComparator(femaleCalabashKidArray, order);
            print(femaleCalabashKidArray, Gender.FEMALE);
        }

        public static void divideCalabashKids() {
            maleCalabashKidArray = new CalabashKidArrayList<>();
            maleCalabashKidArray.addAll(Collections2.filter(calabashKidArray, calabashKid -> calabashKid.getGender() == Gender.MALE));
            femaleCalabashKidArray = new CalabashKidArrayList<>();
            femaleCalabashKidArray.addAll(Collections2.filter(calabashKidArray, calabashKid -> calabashKid.getGender() == Gender.FEMALE));
        }
    }

    // 玉皇大帝有打印人类名单的能力
    private static <T extends Human> void print(ArrayList<T> array) {
        for (T curHuman : array) {
            System.out.print(curHuman.toString() + " ");
        }
        System.out.println();
    }

    private static <T extends Human> void print(ArrayList<T> array, Gender gender){
        System.out.print(gender + ": ");
        print(array);
    }

    private static <T extends Human> void print(ArrayList<T> array, String msg){
        System.out.println(msg);
        print(array);
    }

    private static <T extends Human> void print(ArrayList<T> array, Gender gender, String msg) {
        System.out.println(msg);
        print(array, gender);
    }

    // 玉皇大帝能够用Iterable和Iterator的方式打印葫芦娃名单
    private static void printIterable(String msg){
        System.out.println(msg);
        CalabashKidIterable calabashKidIterable = new CalabashKidIterable();
        for(Human curHuman : calabashKidIterable){
            System.out.print(curHuman.toString() + " ");
        }
        System.out.println();
    }

    private static void printReversedIterable(String msg){
        System.out.println(msg);
        CalabashKidReversedIterable calabashKidReversedIterable = new CalabashKidReversedIterable();
        for(Human curHuman : calabashKidReversedIterable){
            System.out.print(curHuman.toString() + " ");
        }
        System.out.println();
    }

    private static void printIterator(String msg){
        System.out.println(msg);
        Iterator<CalabashKid> calabashKidIterator = new CalabashKidIterable().iterator();
        while(calabashKidIterator.hasNext()){
            Human curHuman = calabashKidIterator.next();
            System.out.print(curHuman.toString() + " ");
        }
        System.out.println();
    }

    private static void printReversedIterator(String msg){
        System.out.println(msg);
        Iterator<CalabashKid> calabashKidIterator = new CalabashKidReversedIterable().iterator();
        while(calabashKidIterator.hasNext()){
            Human curHuman = calabashKidIterator.next();
            System.out.print(curHuman.toString() + " ");
        }
        System.out.println();
    }

    private static String getFamilyName() {
        int index = rand.nextInt(familyNameArr.length - 1);
        return familyNameArr[index];
    }

    private static String getGivenName() {
        return RandomStringUtils.random(rand.nextInt(2) + 1, 0x4e00, 0x9fa5, false, false);
    }
}
