package cn.edu.xiaoyu.homework8;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main<T extends Calabash> {
    private static final int NAME_LENGTH = 10;
    private static final int N = 10;
    CalabashCollection<T> list = new CalabashCollection<>();

    public static void main(String[] args){
        Main<Calabash> p1 = new Main<>();
        Main<CalabashFire> p2 = new Main<>();
        Main<CalabashWater> p3 = new Main<>();

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
            String name = "";
            for (int j = 0; j < nameLength; j++) {
                if(j == 0){
                    name += (char)('A'+rand.nextInt(26));
                }
                else{
                    name += (char)('a'+rand.nextInt(26));
                }
            }
            try{
                T calabash = type.newInstance();
                calabash.change(new Calabash(name,rand.nextBoolean()?Gender.MALE:Gender.FEMALE));
                list.add(calabash);
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    CalabashCollection<T> divideByGender(CalabashCollection<T> calabashes,Gender gender){
        Iterator<T> iterator = calabashes.CalabashIterator();
        CalabashCollection<T> calabashes1 = new CalabashCollection<>();
        while(iterator.hasNext()){
            T c = iterator.next();
            if(c.gender==gender){
                calabashes1.add(c);
            }
        }
        return calabashes1;
    }

}