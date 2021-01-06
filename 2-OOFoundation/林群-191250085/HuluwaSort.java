import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashSet;
import java.util.Random;

public class HuluwaSort {

    //初始化队列，随机站队
    static void initialize(Huluwa[] queue) {
        Random rand = new Random();
        HashSet<Integer> hashSet = new HashSet();
        int i = 0;

        while (hashSet.size() < 7){
            int tmp = rand.nextInt(7) + 1;
            if (!hashSet.contains(tmp))queue[i++] = new Huluwa(tmp);
            hashSet.add(tmp);
        }
    }

    public static void main(String[] args) {
        Huluwa[] queue = new Huluwa[7];
        GrandPa grandPa = new GrandPa();



        initialize(queue);
        System.out.println("Orchestration:");
        BubbleSort.orchestration(queue,grandPa);

        initialize(queue);
        System.out.println("\nChoreography:");
        BubbleSort.choreography(queue);

    }
}
