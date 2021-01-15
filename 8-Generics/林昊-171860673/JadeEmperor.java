import java.io.UnsupportedEncodingException;
import java.util.*;
import creature.*;
import algorithm.Sort;
import enums.*;
import sun.reflect.generics.repository.GenericDeclRepository;

public class JadeEmperor {
    // public成员
    public static void main(String[] args) {
        print("依次出生的葫芦娃", calabashKidArray);
        // 玉皇大帝非常好奇, 想看看打乱葫芦娃以后能不能用三种方法让葫芦娃排好序
        // 第1.1种方法是用Comparable, 按照名字正序排序
        Collections.shuffle(calabashKidArray);// 打乱葫芦娃
        CalabashKidArrayList.sortByComparable(calabashKidArray, Order.ASC);
        print("Comparable的名字正序排序", calabashKidArray);

        // 第1.2种方法是用Comparable, 按照名字反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparable(calabashKidArray, Order.DESC);
        print("Comparable的名字反序排序", calabashKidArray);

        // 第1.3种方法是用Comparable, 按照名字乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList. sortByComparable(calabashKidArray, Order.RANDOM);
        print("Comparable的名字乱序排序", calabashKidArray);

        // 第2.1种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的正序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable("Comparable的性别分开的正序排序", Order.ASC);

        // 第2.2种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable("Comparable的性别分开的反序排序", Order.DESC);

        // 第2.3种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparable("Comparable的性别分开的乱序排序", Order.RANDOM);

        // 第3.1种方法是用Comparator, 按照名字正序排序
        Collections.shuffle(calabashKidArray);// 打乱葫芦娃
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.ASC);
        print("Comparator的名字正序排序", calabashKidArray);

        // 第3.2种方法是用Comparator, 按照名字反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.DESC);
        print("Comparator的名字反序排序", calabashKidArray);

        // 第3.3种方法是用Comparator, 按照名字乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.sortByComparator(calabashKidArray, Order.RANDOM);
        print("Comparator的名字乱序排序", calabashKidArray);

        // 第4.1种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的正序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator("Comparator的性别分开的正序排序", Order.ASC);

        // 第4.2种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的反序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator("Comparator的性别分开的反序排序", Order.DESC);

        // 第4.3种方法是用Comparable, 将葫芦娃按性别分开后, 按照名字的乱序排序
        Collections.shuffle(calabashKidArray);
        CalabashKidArrayList.divideCalabashKids();
        CalabashKidArrayList.sortDividedByComparator("Comparator的性别分开的乱序排序", Order.RANDOM);

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

        public static void sortDividedByComparable(String msg, Order order){
            sortByComparable(maleCalabashKidArray, order);
            print(msg, maleCalabashKidArray, Gender.MALE);
            sortByComparable(femaleCalabashKidArray, order);
            print(femaleCalabashKidArray, Gender.FEMALE);
        }

        public static void sortDividedByComparator(String msg, Order order){
            CalabashKidArrayList.sortByComparator(maleCalabashKidArray, order);
            print(msg, maleCalabashKidArray, Gender.MALE);
            CalabashKidArrayList.sortByComparator(femaleCalabashKidArray, order);
            print(femaleCalabashKidArray, Gender.FEMALE);
        }

        public static void divideCalabashKids() {
            maleCalabashKidArray = new CalabashKidArrayList<>();
            femaleCalabashKidArray = new CalabashKidArrayList<>();
            CalabashKidIterable calabashKidIterable = new CalabashKidIterable();
            for (CalabashKid calabashKid : calabashKidIterable) {
                if (calabashKid.getGender() == Gender.MALE) {
                    maleCalabashKidArray.add(calabashKid);
                } else {
                    femaleCalabashKidArray.add(calabashKid);
                }
            }
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

    private static <T extends Human> void print(String msg, ArrayList<T> array, Gender gender) {
        System.out.println(msg);
        print(array, gender);
    }

    private static <T extends Human> void print(String msg, ArrayList<T> array){
        System.out.println(msg);
        print(array);
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
        int highPos = (176 + Math.abs(rand.nextInt(71)));
        int lowPos = 161 + Math.abs(rand.nextInt(94));
        byte[] givenNameArr = new byte[2];
        givenNameArr[0] = (new Integer(highPos)).byteValue();
        givenNameArr[1] = (new Integer(lowPos)).byteValue();
        String givenName = null;
        try {
            givenName = new String(givenNameArr, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return givenName;
    }
}
