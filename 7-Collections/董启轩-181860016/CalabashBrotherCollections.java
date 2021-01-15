import java.util.*;

public class CalabashBrotherCollections{
    private static final int BROTHER_NUM=12;
    public static void DOSort(CalabashBrotherList bros){
        CalabashBrotherComparator comparator=new CalabashBrotherComparator();
        System.out.println("Positive Sort:");
        bros.sort(comparator);
        Iterator<CalabashBrother> iter=bros.iterator();
        while(iter.hasNext()){
            iter.next().printInformation();
        }
        comparator.set_order(Order.NEGATIVE);
        System.out.println("Negative Sort:");
        bros.sort(comparator);
        iter=bros.iterator();
        while(iter.hasNext()){
            iter.next().printInformation();
        }
        comparator.set_order(Order.RANDOM);
        System.out.println("Random Sort:");
        bros.sort(comparator);
        iter=bros.iterator();
        while(iter.hasNext()){
            iter.next().printInformation();
        }
    }
    public static void main(String[] args){
        CalabashBrotherList bros=new CalabashBrotherList();
        CalabashBrotherList male_bros=new CalabashBrotherList();
        CalabashBrotherList female_bros=new CalabashBrotherList();
        for(int i=0;i<BROTHER_NUM;i++){
            CalabashBrother bro=new CalabashBrother();
            bros.add(bro);
            if(bro.is_male()) male_bros.add(bro);
            else if(bro.is_female()) female_bros.add(bro);
        }
        System.out.println("bros list do sort:");
        System.out.println("Original list:");
        for(CalabashBrother b:bros){
            b.printInformation();
        }
        DOSort(bros);
        System.out.println("male_bros list do sort:");
        System.out.println("Original list:");
        for(CalabashBrother b:male_bros){
            b.printInformation();
        }
        DOSort(male_bros);
        System.out.println("female_bros list do sort:");
        System.out.println("Original list:");
        for(CalabashBrother b:female_bros){
            b.printInformation();
        }
        DOSort(female_bros);
    }
}