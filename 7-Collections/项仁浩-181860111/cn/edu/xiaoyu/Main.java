package cn.edu.xiaoyu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    private static final int NAME_LENGTH = 10;
    private static final int N = 10;

    public static void main(String[] args){
        ArrayList<Calabash> calabashes = new ArrayList<>();
        Main p = new Main();

        p.addSomeCalabashes(calabashes,N,NAME_LENGTH);

        System.out.println("calabashes:");
        p.printCalabashes(calabashes);

        System.out.println("divide by gender:");
        p.printCalabashes(p.divideByGender(calabashes,Gender.MALE));
        p.printCalabashes(p.divideByGender(calabashes,Gender.FEMALE));

        System.out.println("Comparator:");
        System.out.println("Ascending Order:");
        CalabashSortA.ascendingOrder(calabashes);
        p.printCalabashes(calabashes);
        System.out.println("Descending Order:");
        CalabashSortA.descendingOrder(calabashes);
        p.printCalabashes(calabashes);
        System.out.println("Out of Order:");
        CalabashSortA.outOfOrder(calabashes);
        p.printCalabashes(calabashes);

        System.out.println("Comparable:");
        System.out.println("Ascending Order:");
        CalabashSortB.ascendingOrder(calabashes);
        p.printCalabashes(calabashes);
        System.out.println("Descending Order:");
        CalabashSortB.descendingOrder(calabashes);
        p.printCalabashes(calabashes);
        System.out.println("Out of Order:");
        CalabashSortB.outOfOrder(calabashes);
        p.printCalabashes(calabashes);
    }

    void addSomeCalabashes(ArrayList<Calabash> calabashes,int amount,int nameLength){
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
            Calabash c = new Calabash(name,rand.nextBoolean()?Gender.MALE:Gender.FEMALE);
            calabashes.add(c);
        }
    }

    void printCalabashes(Iterable<Calabash> calabashIterable){
        Iterator<Calabash> iterator = calabashIterable.iterator();
        while(iterator.hasNext()){
            Calabash c = iterator.next();
            System.out.println("name:"+c.name+" gender:"+c.gender);
        }
    }

    ArrayList<Calabash> divideByGender(ArrayList<Calabash> calabashes,Gender gender){
        Iterator<Calabash> iterator = calabashes.iterator();
        ArrayList<Calabash> calabashes1 = new ArrayList<>();
        while(iterator.hasNext()){
            Calabash c = iterator.next();
            if(c.gender==gender){
                calabashes1.add(c);
            }
        }
        return calabashes1;
    }

}
