
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static int lenOfQueue;
    static List<Calabash> queue = new ArrayList<>();
    static SortAdapter<Calabash> sortAdapter = new SortAdapter<>();

    static {
        lenOfQueue = 10;//default

        Rand.RandName N = new Rand.RandName();
        Rand.RandGender G = new Rand.RandGender();
        while (queue.size() < lenOfQueue)queue.add(new Calabash(N.get(),G.get(),new Position(queue.size())));

    }

    public static void main(String[] args){

        System.out.println("Before Sorting:");
        for (Calabash c : queue)c.numberOff();
        System.out.println("============================");

        IterableQueue<Calabash> newQueue = new IterableQueue<>(queue);
        sortAdapter.sortByComparator(newQueue);

        //divide into 2 queues by Iterator
        IterableQueue<Calabash> maleQueue = new IterableQueue<>(new ArrayList<>());
        IterableQueue<Calabash> femaleQueue = new IterableQueue<>(new ArrayList<>());
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
        sortAdapter.sortByComparable(maleQueue);
        sortAdapter.queueUpInOrder(maleQueue);

        System.out.println("Female:");
        sortAdapter.sortByComparable(femaleQueue);
        sortAdapter.queueUpInOrder(femaleQueue);

    }

}
/* Output:
    Before Sorting:
    Name:vojsbtm Gender:MALE Position:0
    Name:pqelbvs Gender:FEMALE Position:1
    Name:gbknmsc Gender:MALE Position:2
    Name:jczubqs Gender:MALE Position:3
    Name:xaladdj Gender:MALE Position:4
    Name:nigdzvr Gender:MALE Position:5
    Name:oucjzhi Gender:FEMALE Position:6
    Name:izoxqra Gender:MALE Position:7
    Name:ohdzifx Gender:MALE Position:8
    Name:tylzhgj Gender:MALE Position:9
    ============================
    After sorting,queue up in order:
    Name:gbknmsc Gender:MALE Position:0
    Name:izoxqra Gender:MALE Position:1
    Name:jczubqs Gender:MALE Position:2
    Name:nigdzvr Gender:MALE Position:3
    Name:ohdzifx Gender:MALE Position:4
    Name:oucjzhi Gender:FEMALE Position:5
    Name:pqelbvs Gender:FEMALE Position:6
    Name:tylzhgj Gender:MALE Position:7
    Name:vojsbtm Gender:MALE Position:8
    Name:xaladdj Gender:MALE Position:9
    ----------------------------
    queue up in reverse order:
    Name:xaladdj Gender:MALE Position:0
    Name:vojsbtm Gender:MALE Position:1
    Name:tylzhgj Gender:MALE Position:2
    Name:pqelbvs Gender:FEMALE Position:3
    Name:oucjzhi Gender:FEMALE Position:4
    Name:ohdzifx Gender:MALE Position:5
    Name:nigdzvr Gender:MALE Position:6
    Name:jczubqs Gender:MALE Position:7
    Name:izoxqra Gender:MALE Position:8
    Name:gbknmsc Gender:MALE Position:9
    ----------------------------
    queue up randomly:
    Name:ohdzifx Gender:MALE Position:0
    Name:pqelbvs Gender:FEMALE Position:1
    Name:jczubqs Gender:MALE Position:2
    Name:izoxqra Gender:MALE Position:3
    Name:tylzhgj Gender:MALE Position:4
    Name:xaladdj Gender:MALE Position:5
    Name:vojsbtm Gender:MALE Position:6
    Name:oucjzhi Gender:FEMALE Position:7
    Name:nigdzvr Gender:MALE Position:8
    Name:gbknmsc Gender:MALE Position:9
    ----------------------------
    Male:
    queue up in order:
    Name:gbknmsc Gender:MALE Position:0
    Name:izoxqra Gender:MALE Position:1
    Name:jczubqs Gender:MALE Position:2
    Name:nigdzvr Gender:MALE Position:3
    Name:ohdzifx Gender:MALE Position:4
    Name:tylzhgj Gender:MALE Position:5
    Name:vojsbtm Gender:MALE Position:6
    Name:xaladdj Gender:MALE Position:7
    ----------------------------
    Female:
    queue up in order:
    Name:oucjzhi Gender:FEMALE Position:0
    Name:pqelbvs Gender:FEMALE Position:1
    ----------------------------
 */