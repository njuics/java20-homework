import creature.*;
import enums.Gender;
import java.lang.Math;
import java.text.Collator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

import enums.Order;

public class CalabashKid
        implements Human, Comparable<CalabashKid> {
    public static CalabashKidComparator calabashKidComparator = new CalabashKidComparator();

    public CalabashKid() {
        this(0, "", Gender.MALE);
    }

    public CalabashKid(int priori) {
        this(priori, "", Gender.MALE);
    }

    public CalabashKid(int priori, String name) {
        this(priori, name, Gender.MALE);
    }

    public CalabashKid(int priori, String name, Gender gender){
        this.priori = priori;
        this.name = name;
        this.gender = gender;
        this.order = Order.DEFAULT;
    }


    // 葫芦娃可以告诉别人自己的优先级
    public int getPriority() {
        return priori;
    }

    // 葫芦娃可以告诉别人自己的性别
    public Gender getGender(){
        return gender;
    }

    // 葫芦娃可以告诉别人自己的名字
    @Override
    public String getName() {
        return name;
    }

    // 转换成字符串
    @Override
    public String toString(){
//        return name + "(" + gender + ");";
        return name + ";";
    }

    @Override
    public String getSpecies() {
        return "CalabashKid";
    }

    // 葫芦娃可以和其它葫芦娃比较相互的优先级
    @Override
    public int compareTo(CalabashKid calabashKid) {
        CalabashKidComparator calabashKidComparator = new CalabashKidComparator();
        return calabashKidComparator.compare(this, calabashKid);
    }

    public static class CalabashKidComparator implements Comparator<CalabashKid>{
        Collator collator = Collator.getInstance(Locale.CHINA);
        @Override
        public int compare(CalabashKid o1, CalabashKid o2) {
            switch(o1.order) {
                case ASC:
                    return collator.compare(o1.getName(), o2.getName());
                case DESC:
                    return collator.compare(o2.getName(), o1.getName());
                case RANDOM:
                    return Math.random() > 0.5 ? 1 : -1;
                case DEFAULT:
                default:
                    return o1.getPriority() - o2.getPriority();
            }
        }
    }

    // 葫芦娃可以让别人更改自己的排序顺序
    public void setOrder(Order order){
        this.order = order;
    }

    private int priori;
    private Gender gender;
    private Order order;
    private String name;
}
