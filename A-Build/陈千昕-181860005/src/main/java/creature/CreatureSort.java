package creature;

import java.util.*;
import creature.calabash.*;

public class CreatureSort {
    /**
     * Sort a LinkedList consists of CalabashBoys
     * @param list The LinkedList which consists of CalabashBoys to be sorted.
     * @param type Define the Sort operation: 0 is for Ascending, 1 is for Descending, 2 is for Shuffle.
     */
    public static void doCalabashSort(LinkedList<Calabash> list, int type){
        CalabashBoys cBoys = new CalabashBoys(list);
        cBoys.sort(type);
        list = cBoys.set;
    }

    public static void doCreatureSort(LinkedList<Creature> list, int type){
        switch(type){
            case 0:
                CreatureAscendingComparator<Creature> ascending = new CreatureAscendingComparator<Creature>();
                Collections.sort(list, ascending);
                System.out.println("正序排序后的队列："); 
                for (Creature creature: list) {
                    System.out.print(creature.name + " ");
                }
                break;
            case 1:
                CreatureDescendingComparator<Creature> descending = new CreatureDescendingComparator<Creature>();
                Collections.sort(list, descending);
                System.out.println("反序排序后的队列："); 
                for (Creature creature: list) {
                    System.out.print(creature.name + " ");
                }
                break;
            case 2:
                Collections.shuffle(list);
                System.out.println("乱序排序后的队列："); 
                for (Creature creature: list) {
                    System.out.print(creature.name + " ");
                }
                break;
            default: break;
        }
        System.out.println();
        System.out.println();
    }
}
