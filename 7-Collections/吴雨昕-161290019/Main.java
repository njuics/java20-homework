public class Main {
   public static void main(String[] args) {
        BoyList boyList = new BoyList();
        boyList.PrintList();

        System.out.println("sort with Comparable:");
        boyList.sortWithComparable(true);
        boyList.PrintList();

        System.out.println("shuffle with Comparable:");
        boyList.shuffleWithComparable();
        boyList.PrintList();

        System.out.println("sort with Comparator:");
        boyList.sortWithComparator(false);
        boyList.PrintList();

        System.out.println("sort by gender:");
        boyList.sortByGender();
        System.out.println("Male:");
        boyList.PrintMaleList();
        System.out.println("Female:");
        boyList.PrintFemaleList();
   }
}