public class ArraySort{
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,9,8,7,6,0};
        java.util.Arrays.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}