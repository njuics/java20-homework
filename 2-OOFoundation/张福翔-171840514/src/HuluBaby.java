public class HuluBaby implements Comparable<HuluBaby> {
    enum HuluName {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    };
    HuluName name;

    HuluBaby() {
        this.name = HuluName.ONE;
    }

    HuluBaby(HuluName name) {
        this.name = name;
    }

    public void setName(HuluName name) {
        this.name = name;
    }

    public void huluAssign(HuluBaby[]arr, int myPos, HuluBaby anotherOne) {
        arr[myPos] = anotherOne;
    }

    public void huluSwap(HuluBaby[] arr, int myPos, int hisPos) {
        HuluBaby tmp = arr[hisPos];
        arr[hisPos] = arr[myPos];
        arr[myPos] = tmp;
    }

    @Override
    public int compareTo(HuluBaby o) {
        // small number first
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        switch (this.name) {
            case ONE: return "老大";
            case TWO: return "老二";
            case THREE: return "老三";
            case FOUR: return "老四";
            case FIVE: return "老五";
            case SIX: return "老六";
            case SEVEN: return "最小的";
        }
        return "什么都不是";
    }

    public void greet() {
        System.out.println("大家好，我是" + this.toString() + "！");
    }

    public boolean equals(HuluBaby obj) {
        return this.name.equals(obj.name);
    }

    @Override
    protected HuluBaby clone() {
        HuluBaby a = null;
        try {
            a = (HuluBaby) super.clone();
            a.setName(this.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return a;
    }
}
