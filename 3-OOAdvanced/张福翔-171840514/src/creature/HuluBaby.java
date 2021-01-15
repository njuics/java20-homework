package creature;

import utils.Sortable;

public class HuluBaby extends Creature implements Comparable<HuluBaby>, Sortable<HuluBaby> {
    public enum HuluType {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    };
    HuluType type;
    String name;

    public HuluBaby(HuluType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public int compareTo(HuluBaby o) {
        // small number first
        return this.type.compareTo(o.type);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int moveTo(HuluBaby[] arr, int myIndex) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(this) <= 0 && i < myIndex)
                idx++;
            else if (arr[i].compareTo(this) < 0)
                idx++;
        }
        return idx;
    }

    public void greet() {
        System.out.println("大家好，我是" + this.toString() + "！");
    }
}
