package creature;

import utils.Sortable;

public class HuluBaby extends Creature implements Comparable<HuluBaby>, Sortable<HuluBaby> {
    public enum HuluOrder {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, OTHERS
    };
    public enum ComparationType {
        BYNAME, BYORDER, BYNAMEREVERSED
    };
    public enum Gender {
        MALE("男♂"), FEMALE("女♀");

        private String name;
        Gender(String s) {
            this.name = s;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }

    static ComparationType comparationType = ComparationType.BYNAME;

    static public Gender sampleGender() {
        Gender[] genders = Gender.values();
        int rand = (int) (Math.random() * Gender.values().length);
        return genders[rand];
    }
    static public String sampleName() {
        // randomly generate name with length in 4-7
        int nameLength = (int) (Math.random() * 4) + 4;
        String nameList = "abcdefghijklmnopgrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String name = "";
        for (int i = 0; i < nameLength; i++) {
            int rand = (int) (Math.random() * nameList.length());
            name += nameList.charAt(rand);
        }
        return name;
    }
    static public void setComparationType(ComparationType type) {
        HuluBaby.comparationType = type;
    }

    HuluOrder order;
    String name;
    Gender gender;

    public HuluBaby(HuluOrder type, String name, Gender gender) {
        this.order = type;
        this.name = name;
        this.gender = gender;
    }

    public void greet() {
        System.out.println("大家好, 我是葫芦娃" + this.name + ", 性别" + gender.toString() + "! ");
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int compareTo(HuluBaby o) {
        if (comparationType == ComparationType.BYNAME) {
            return this.name.compareTo(o.name);
        }
        else if (comparationType == ComparationType.BYNAMEREVERSED) {
            return o.name.compareTo(this.name);
        }
        else {
            // small number first
            return this.order.compareTo(o.order);
        }
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

}
