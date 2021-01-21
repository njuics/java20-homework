import java.util.PriorityQueue;

public class MySort {
    public static int[] heapSort(int[] data){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(data.length);
        for(int i:data){
            heap.offer(i);
        }
        int[] res = new int[data.length];
        int pos = 0;
        while(heap.peek()!=null) {
            res[pos] = heap.poll();
            ++pos;
        }
        return res;
    }

    public static void main(String[] args){
        int[] data = new int[]{6,10,9,7,5,2,3,1};
        int[] res;
        res = heapSort(data);
        for(int i:res){
            System.out.printf("%d ",i);
        }
    }
}