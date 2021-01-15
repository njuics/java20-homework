import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(10)+15;
        List<Hulu> huluList = new ArrayList<>();
        for(int i=0; i<num; ++i){
            huluList.add(new Hulu());
        }

        MySort mySort = new MySort();

        System.out.println("===Before order===");
        for(int i=0; i<num; ++i){
            System.out.println(huluList.get(i).getName());
        }
        System.out.println();

        System.out.println("===Out-of-order===");
        mySort.outOfOrder(huluList);
        System.out.println();

        System.out.println("===Positive-order===");
        mySort.positiveOrder(huluList);
        System.out.println();

        System.out.println("===Negative-order===");
        mySort.negativeOrder(huluList);
        System.out.println();

        System.out.println("===Positive-order-by-gender===");
        mySort.genderSort(huluList,false);
        System.out.println();

        System.out.println("===Negative-order-by-gender===");
        mySort.genderSort(huluList,true);
        System.out.println();
    }
}
