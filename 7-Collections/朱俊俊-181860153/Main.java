import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Calabash> calabashes = new ArrayList<>();
        Calabash.randomCalabash(calabashes, 10);
        System.out.println("Before sorting:" + calabashes);

        Collections.sort(calabashes);
        System.out.println("Sort by comparator(ASE):" + calabashes);
        Collections.sort(calabashes, new CalabashComparator().reversed());
        System.out.println("Sort by comparator(DESC):" + calabashes);
        Collections.sort(calabashes, new CalabashComparator().random());
        System.out.println("Sort by comparator(random):" + calabashes + '\n');

        CalabashQueue maleQueue = new CalabashQueue();
        CalabashQueue femaleQueue = new CalabashQueue();

        maleQueue.add(calabashes, Gender.MALE);
        femaleQueue.add(calabashes, Gender.FEMALE);

        System.out.println("Male before sorting:" + maleQueue);
        System.out.println("Female before sorting:" + femaleQueue);
        maleQueue.sort();
        System.out.println("Male Sort by comparable:");
        for(Calabash calabash:maleQueue)        //male print by iterable
            System.out.print(calabash+" ");

        femaleQueue.sort(new CalabashComparator());
        System.out.println("\nFemale Sort by comparator:");
        Iterator<Calabash>it= femaleQueue.iterator();   //female print by iterator
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
