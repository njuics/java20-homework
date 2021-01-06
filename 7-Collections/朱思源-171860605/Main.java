public class Main {

    public static void printCrossLine(){
        System.out.println("----------------------------------------------------");
    }

    public static void printCalashCollection(Iterable<Calabash> list){
        for(Calabash c : list){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        CalabashCollection calabashes=new CalabashCollection(12);

        System.out.println("Print collection via Iterable Interface:");
        printCalashCollection(calabashes.getIterable());
        printCrossLine();

        System.out.println("Sort all via Comparable in ASC condition:");
        calabashes.sortViaComparable(ORDER.ASC);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort all via Comparable in DESC condition:");
        calabashes.sortViaComparable(ORDER.DESC);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort all via Comparable in RAN condition:");
        calabashes.sortViaComparable(ORDER.RAN);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparable in ASC condition:");
        calabashes.sortViaComparable(ORDER.ASC,FLAG.SORT_BY_GENDER);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparable in DESC condition:");
        calabashes.sortViaComparable(ORDER.DESC,FLAG.SORT_BY_GENDER);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparable in RAN condition:");
        calabashes.sortViaComparable(ORDER.RAN,FLAG.SORT_BY_GENDER);
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort all via Comparator in ASC condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.ASC));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort all via Comparator in ASC condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.DESC));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort all via Comparator in ASC condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.RAN));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparator in ASC condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.ASC,FLAG.SORT_BY_GENDER));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparator in DESC condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.DESC,FLAG.SORT_BY_GENDER));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();

        System.out.println("Sort by gender via Comparator in RAN condition:");
        calabashes.sortViaComparator(Calabash.getComparator(ORDER.RAN,FLAG.SORT_BY_GENDER));
        printCalashCollection(calabashes.getIterable());
        calabashes.shuffle();
        printCrossLine();
    }

}
