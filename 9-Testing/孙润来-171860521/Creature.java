package homework_9;

import java.util.Comparator;
import java.util.Random;

public class Creature implements Comparable<Creature>{
    protected String name;
    protected boolean gender; /* 0 是女生 1 是男生*/
    protected int order;  /* 1 顺序 2 逆序 3 乱序 */
    public void selectOrder(int order){
        this.order = order;
    }

    public Creature(){}

    @Override
    public int compareTo(Creature o) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public Boolean getGender() {
        return gender;
    }
}
