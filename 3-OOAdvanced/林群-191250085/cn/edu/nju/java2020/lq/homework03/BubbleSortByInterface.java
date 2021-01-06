package cn.edu.nju.java2020.lq.homework03;

public class BubbleSortByInterface implements SortAlgorithmByInterface {

    public void orchestration(Huluwa[] queue, Grandpa grandpa) {
        System.out.print("Before Sort:");
        this.numberoff(queue);

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
        this.numberoff(queue);
    }

    public void choreography(Huluwa[] queue) {
        System.out.print("Before Sort:");
        this.numberoff(queue);

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
        this.numberoff(queue);
    }

    private void numberoff(Huluwa[] queue) {
        for (Huluwa huluwa : queue){
            huluwa.number();
        }
    }
}
