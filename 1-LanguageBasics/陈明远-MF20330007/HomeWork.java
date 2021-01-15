import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class HomeWork {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        Scanner in = new Scanner(System.in);
        System.out.println("Please intput array's length: ");
        int size = in.nextInt();
        System.out.println("Please intput array's element: ");
        for (int i = 0; i < size; i++) {
            int num = in.nextInt();
            array.add(num);
        }
        Collections.sort(array);
        System.out.println("After sorting, your array is: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
