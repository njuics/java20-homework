package homework_9;

public class Main {
    public static HuluBro<Huluwa> hulu = new HuluBro<>(20,new HFactory());
    public static void main(String[] args){
        int order=1;
        hulu.myShuffle();
        hulu.sortByComparable(order);
        hulu.print(order);

        hulu.myShuffle();
        hulu.sortByComparator(order);
        hulu.print(order);
    }
}
