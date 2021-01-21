package creature;

import java.util.ArrayList;

public class HuluBaby extends Creature {
    public enum HuluOrder {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, OTHERS
    };
    public enum ComparationType {
        BYNAME, BYORDER, BYGENDER
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
    static public void huluBabiesGreetings(ArrayList<HuluBaby> huluBabies) {
        for (HuluBaby huluBaby : huluBabies) {
            huluBaby.greet();
        }
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
    public String toString() {
        return super.toString() + " 葫芦娃姓名: " + this.name + " 性别: " + this.gender;
    }

    @Override
    public int compareTo(Creature o) {
        if (this.getClass().equals(o.getClass())) {
            HuluBaby obj = (HuluBaby)o;
            if (comparationType.equals(ComparationType.BYNAME)) {
                return this.name.compareTo(obj.name);
            } else if (comparationType.equals(ComparationType.BYORDER)) {
                return this.order.compareTo(obj.order);
            } else {
                if (this.gender.equals(obj.gender)) {
                    return this.name.compareTo(obj.name);
                } else {
                    return this.gender.compareTo(obj.gender);
                }
            }
        }
        else {
            return super.compareTo(o);
        }
    }
}
