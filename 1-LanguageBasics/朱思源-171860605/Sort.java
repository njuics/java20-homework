import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {

        //input numbers
        System.out.println("Please enter the numbers to sort, separated by spaces:");

        //handle input
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] strArray=str.split(" ");

        //output numbers
        System.out.print("before:");
        int len= strArray.length;
        System.out.println(Arrays.toString(strArray));

        //sort numbers
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(String s:strArray)
        {
            arrayList.add(Integer.parseInt(s));
        }
        Collections.sort(arrayList);

        //output result
        System.out.print("after:");
        System.out.println(arrayList);
    }
}