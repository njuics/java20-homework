public class BubbleSort extends SortType{
    public static void orchestration(Huluwa[] queue, GrandPa grandpa){
        System.out.print("Before Sort:");
        numberoff(queue);

        //bubble sort
        int length = queue.length;
        for (int i = 0;i < length-1;i++){
            for (int j = 0;j < length-i-1;j++){
                if (grandpa.compare(queue[j],queue[j+1])){
                    grandpa.swap(queue[j],queue[j+1]);
                }
            }
        }

        System.out.print("\nAfter Sort:");
        numberoff(queue);
    }

    public static void choreography(Huluwa[] queue) {
        System.out.print("Before Sort:");
        numberoff(queue);


        //bubble sort
        int length = queue.length;
        for (int i = 0;i < length-1;i++){
            for (int j = 0;j < length-i-1;j++){
                if (queue[j].compare(queue[j+1])){
                    queue[j].swap(queue[j+1]);
                }
            }
        }

        System.out.print("\nAfter Sort:");
        numberoff(queue);
    }

    private static void numberoff(Huluwa[] queue) {
        for (Huluwa huluwa : queue){
            huluwa.number();
        }
    }
}
