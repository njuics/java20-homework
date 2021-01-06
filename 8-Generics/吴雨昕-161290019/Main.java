public class Main {
   public static void main(String[] args) {
        CreatureList<CalabashBoy> boyList = new CreatureList<>(new CalabashFactory());
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

        CreatureList<Monster> monsterList = new CreatureList<>(new MonsterFactory());
        monsterList.PrintList();

        System.out.println("sort with Comparable:");
        monsterList.sortWithComparable(true);
        monsterList.PrintList();

        System.out.println("shuffle with Comparable:");
        monsterList.shuffleWithComparable();
        monsterList.PrintList();

        System.out.println("sort with Comparator:");
        monsterList.sortWithComparator(false);
        monsterList.PrintList();

        System.out.println("sort by gender:");
        monsterList.sortByGender();
        System.out.println("Male:");
        monsterList.PrintMaleList();
        System.out.println("Female:");
        monsterList.PrintFemaleList();
   }
}