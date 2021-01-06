public class Main {

    public static void main(String[] args) {
//        set the names of seven Calabash Brothers
        final String[] names = {"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
//        initialize a queue of brothers, and the order is random

//        choreography
        final CalabashBroQueue queue = new CalabashBroQueue(names);

//        orchestration
//        final CalabashBroQueue queue = new MasteredCalabashBroQueue(names);
        System.out.println("Before lining up:");
        queue.countOff();
//        line up the queue from the oldest to the youngest
        queue.lineUp();

        System.out.println("After lining up:");
        queue.countOff();

    }

}
