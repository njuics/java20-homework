package cn.edu.xiaoyu.homework10;


import java.util.Iterator;
import java.util.Random;
import org.apache.commons.lang3.*;

public class Main<T extends Calabash> {
    private static final int NAME_LENGTH = 10;
    private static final int N = 10;
    CalabashCollection<T> list = new CalabashCollection<T>();

    public static void main(String[] args){
        Main<Calabash> p1 = new Main<Calabash>();
        Main<CalabashFire> p2 = new Main<CalabashFire>();
        Main<CalabashWater> p3 = new Main<CalabashWater>();

        System.out.println("Calabash:");
        p1.addSomeCalabashes(N,NAME_LENGTH,Calabash.class);
        p1.sortAndDivideAndPrint(p1.list);

        System.out.println("CalabashFire:");
        p2.addSomeCalabashes(N,NAME_LENGTH,CalabashFire.class);
        p2.sortAndDivideAndPrint(p2.list);

        System.out.println("CalabashWater:");
        p3.addSomeCalabashes(N,NAME_LENGTH,CalabashWater.class);
        p3.sortAndDivideAndPrint(p3.list);
    }

    void sortAndDivideAndPrint(CalabashCollection<T> list){
        System.out.println("Init:");
        list.printList();
        System.out.println("After Ascending Order:");
        list.ascendingOrder();
        list.printList();
        System.out.println("After Descending Order:");
        list.descendingOrder();
        list.printList();
        System.out.println("After Out of Order:");
        list.outOfOrder();
        list.printList();
        System.out.println("Divide By Gender:");
        divideByGender(list,Gender.MALE).printList();
        divideByGender(list,Gender.FEMALE).printList();
    }

    void addSomeCalabashes(int amount,int nameLength,Class<T> type){
        Random rand = new Random();
        for (int i = amount; i > 0; i--) {
            String name = RandomStringUtils.random(10,"abcdefg");
            try{
                T calabash = type.newInstance();
                calabash.change(new Calabash(name,rand.nextBoolean()?Gender.MALE:Gender.FEMALE));
                list.add(calabash);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    void addSomeCalabashes(int amount,String[] s,Gender[] genders,Class<T> type){
        try{
            for(int i=0;i<amount;i++){
                T calabash = type.newInstance();
                calabash.change(new Calabash(s[i],genders[i]));
                list.add(calabash);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    CalabashCollection<T> divideByGender(CalabashCollection<T> calabashes,Gender gender){
        Iterator<T> iterator = calabashes.CalabashIterator();
        CalabashCollection<T> calabashes1 = new CalabashCollection<T>();
        while(iterator.hasNext()){
            T c = iterator.next();
            if(c.gender==gender){
                calabashes1.add(c);
            }
        }
        return calabashes1;
    }

    void sort(boolean sortType){
        if(sortType)
            list.ascendingOrder();
        else
            list.descendingOrder();
    }
}