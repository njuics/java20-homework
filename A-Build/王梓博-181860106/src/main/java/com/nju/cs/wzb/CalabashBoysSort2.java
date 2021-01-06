/*
 * @Author: zb-nju
 * @Date: 2020-11-05 10:22:02
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-23 15:23:31
 */
import com.nju.cs.wzb.hwA.*;

public class CalabashBoysSort2 {
    public static void main(String[] args) {
        MyCollection<CalabashBoy> CBs = new MyCollection<CalabashBoy>(10,new CalabashBoyFactory());

        System.out.println("sort by comparator");
        System.out.println("positive:");
        CBs.sortAscComparator();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("negative");
        CBs.sortDescComparator();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("random");
        CBs.sortRandComparator();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("sort by comparable");
        System.out.println("positive:");
        CBs.sortAscComparable();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("negative");
        CBs.sortDescComparable();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("random");
        CBs.sortRandComparable();
        for(CalabashBoy c:CBs)
            System.out.println(c);
        System.out.println();

        System.out.println("MALE");
        MyCollection<CalabashBoy> CBmales = CBs.divideByGender(Gender.MALE);
        CBmales.sortAscComparable();
        for(CalabashBoy c:CBmales)
            System.out.println(c);
        System.out.println();

        System.out.println("FEMALE");
        MyCollection<CalabashBoy> CBfemales = CBs.divideByGender(Gender.FEMALE);
        CBfemales.sortAscComparable();
        for(CalabashBoy c:CBfemales)
            System.out.println(c);
        System.out.println();
    }
}