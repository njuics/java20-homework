import java.util.Random;

public class CalabashBroQueue {
    final protected CalabashBrother[] members;
    final protected int length;
    public CalabashBroQueue(String[] names){
        this.length = names.length;
        members = new CalabashBrother[this.length];

//        generate an array 0,1,...,(length-1)
        int[] order = new int[length];
        for (int i = 0; i < length; i++) {
            order[i] = i;
        }
//        shuffle the array randomly
        shuffle(order);

//        place the Brothers according to the array "order"
        for (int i = 0; i < length; i++) {
            members[i] = new CalabashBrother(order[i],names[order[i]]);
        }
    }
    private void shuffle(int[] array){
        Random rand = new Random();
        int length = array.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(array, randInd, i - 1);
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void countOff(){
        for (int i = 0; i < length; i++) {
            members[i].report();
            if(i < length-1)
                System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void lineUp(){
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 -i; j++) {
                if(!members[j].compareTo(members[j+1]))
                    members[j].exchange(members[j+1]);
            }
        }
    }
}
