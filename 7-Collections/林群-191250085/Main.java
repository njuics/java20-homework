
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static int lenOfQueue;
    static List<Calabash> queue = new ArrayList<>();

    static {
        lenOfQueue = 10;//default

        Rand.RandName N = new Rand.RandName();
        Rand.RandGender G = new Rand.RandGender();
        while (queue.size() < lenOfQueue)queue.add(new Calabash(N.get(),G.get()));

    }

    public static void main(String[] args){
        System.out.println("Before Sorting:");
        for (Calabash c : queue)c.numberOff();
        System.out.println("============================");

        IterableCalabash newQueue = new IterableCalabash(queue);
        sortByComparator(newQueue);

        //divide into 2 queues by Iterator
        IterableCalabash maleQueue = new IterableCalabash(new ArrayList<>());
        IterableCalabash femaleQueue = new IterableCalabash(new ArrayList<>());
        Iterator<Calabash> it = queue.iterator();
        while (it.hasNext()){
            Calabash c = it.next();
            if (c.getGender().equals(Gender.MALE)) {
                maleQueue.getC().add(c);
            } else {
                femaleQueue.getC().add(c);
            }
        }

        System.out.println("Male:");
        sortByComparable(maleQueue);
        queueUpInOrder(maleQueue);

        System.out.println("Female:");
        sortByComparable(femaleQueue);
        queueUpInOrder(femaleQueue);

    }

    private static void sortByComparator(IterableCalabash q){
        q.getC().sort(new Grandpa());

        System.out.print("After sorting,");
        //by Iterable
        queueUpInOrder(q);
        queueUpInReverseOrder(q);
        queueUpRandomly(q);

    }

    private static void sortByComparable(IterableCalabash q){
        Collections.sort(q.getC());
    }

    private static void queueUpInOrder(IterableCalabash q){
        System.out.println("queue up in order:");
        for (Calabash c : q.getC())
            c.numberOff();
        System.out.println("----------------------------");
    }

    private static void queueUpInReverseOrder(IterableCalabash q){
        System.out.println("queue up in reverse order:");
        for (Calabash c : q.reversed())
            c.numberOff();
        System.out.println("----------------------------");
    }

    private static void queueUpRandomly(IterableCalabash q){
        System.out.println("queue up randomly:");
        for (Calabash c : q.randomized())
            c.numberOff();
        System.out.println("----------------------------");
    }
}
/* Output:
    Before Sorting:
    Name:vojsbtm Gender:MALE
    Name:pqelbvs Gender:FEMALE
    Name:gbknmsc Gender:MALE
    Name:jczubqs Gender:MALE
    Name:xaladdj Gender:MALE
    Name:nigdzvr Gender:MALE
    Name:oucjzhi Gender:FEMALE
    Name:izoxqra Gender:MALE
    Name:ohdzifx Gender:MALE
    Name:tylzhgj Gender:MALE
    ============================
    After sorting,queue up in order:
    Name:gbknmsc Gender:MALE
    Name:izoxqra Gender:MALE
    Name:jczubqs Gender:MALE
    Name:nigdzvr Gender:MALE
    Name:ohdzifx Gender:MALE
    Name:oucjzhi Gender:FEMALE
    Name:pqelbvs Gender:FEMALE
    Name:tylzhgj Gender:MALE
    Name:vojsbtm Gender:MALE
    Name:xaladdj Gender:MALE
    ----------------------------
    queue up in reverse order:
    Name:xaladdj Gender:MALE
    Name:vojsbtm Gender:MALE
    Name:tylzhgj Gender:MALE
    Name:pqelbvs Gender:FEMALE
    Name:oucjzhi Gender:FEMALE
    Name:ohdzifx Gender:MALE
    Name:nigdzvr Gender:MALE
    Name:jczubqs Gender:MALE
    Name:izoxqra Gender:MALE
    Name:gbknmsc Gender:MALE
    ----------------------------
    queue up randomly:
    Name:ohdzifx Gender:MALE
    Name:pqelbvs Gender:FEMALE
    Name:jczubqs Gender:MALE
    Name:izoxqra Gender:MALE
    Name:tylzhgj Gender:MALE
    Name:xaladdj Gender:MALE
    Name:vojsbtm Gender:MALE
    Name:oucjzhi Gender:FEMALE
    Name:nigdzvr Gender:MALE
    Name:gbknmsc Gender:MALE
    ----------------------------
    Male:
    queue up in order:
    Name:gbknmsc Gender:MALE
    Name:izoxqra Gender:MALE
    Name:jczubqs Gender:MALE
    Name:nigdzvr Gender:MALE
    Name:ohdzifx Gender:MALE
    Name:tylzhgj Gender:MALE
    Name:vojsbtm Gender:MALE
    Name:xaladdj Gender:MALE
    ----------------------------
    Female:
    queue up in order:
    Name:oucjzhi Gender:FEMALE
    Name:pqelbvs Gender:FEMALE
    ----------------------------
 */