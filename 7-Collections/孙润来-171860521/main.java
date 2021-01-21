package homework_7;

public class main {
    public static HuluBro hulu = new HuluBro(20);
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
