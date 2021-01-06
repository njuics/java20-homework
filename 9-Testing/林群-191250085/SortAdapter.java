
import java.util.Collections;

public class SortAdapter<T extends Creature> {
    private void resetPosition(Iterable<T> q){
        int i = 0;
        for (T c : q){
            c.getPosition().setPosition(i++);
        }
    }

    public void sortByComparator(IterableQueue<T> q){
        q.getC().sort(new Grandpa());

        System.out.print("After sorting,");
        //by Iterable
        queueUpInOrder(q);
        queueUpInReverseOrder(q);
        queueUpRandomly(q);

    }

    public void sortByComparable(IterableQueue<T> q){
        Collections.sort(q.getC());
    }

    public void queueUpInOrder(IterableQueue<T> q){
        System.out.println("queue up in order:");
        Iterable<T> Q = q.inorder();
        resetPosition(Q);
        for (T c : Q)
            if (c instanceof Calabash)
                ((Calabash) c).numberOff();
        System.out.println("----------------------------");
    }

    public void queueUpInReverseOrder(IterableQueue<T> q){
        System.out.println("queue up in reverse order:");
        Iterable<T> reversedQ = q.reversed();
        resetPosition(reversedQ);
        for (T c : reversedQ)
            if (c instanceof Calabash)
                ((Calabash) c).numberOff();
        System.out.println("----------------------------");
    }

    public void queueUpRandomly(IterableQueue<T> q){
        System.out.println("queue up randomly:");
        Iterable<T> randomizedQ = q.randomized();
        resetPosition(randomizedQ);
        for (T c : randomizedQ)
            if (c instanceof Calabash)
                ((Calabash) c).numberOff();
        System.out.println("----------------------------");
    }
}