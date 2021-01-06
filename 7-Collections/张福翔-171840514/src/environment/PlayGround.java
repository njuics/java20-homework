package environment;

import creature.Grandpa;
import creature.HuluBaby;
import utils.ArraySorter;
import utils.IterableArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayGround extends EnvComponent {
    IterableArrayList<HuluBaby> huluFamily = new IterableArrayList<>();
    public PlayGround() {
    }

    // API for HW7
    public void huluFamilyDemo() {
        int huluNums = 10;
        for (int i = 0; i < huluNums; i++) {
            HuluBaby baby = new HuluBaby(HuluBaby.HuluOrder.OTHERS, HuluBaby.sampleName(), HuluBaby.sampleGender());
            huluFamily.add(baby);
        }
        System.out.println("产生"+ huluNums + "个随机葫芦娃: ");
        huluBabiesGreeting(huluFamily);

        System.out.println("葫芦娃正序排列: ");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYNAME);
        Collections.sort(huluFamily);
        huluBabiesGreeting(huluFamily);

        System.out.println("葫芦娃逆序排列: ");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYNAMEREVERSED);
        Collections.sort(huluFamily);
        huluBabiesGreeting(huluFamily);

        System.out.println("葫芦娃乱序排列: ");
        Collections.shuffle(huluFamily);
        huluBabiesGreeting(huluFamily);

        System.out.println("按性别分开...");
        IterableArrayList<HuluBaby> maleGroup = new IterableArrayList<>(), femaleGroup = new IterableArrayList<>();
        for (HuluBaby baby : huluFamily) {
            if (HuluBaby.Gender.MALE.equals(baby.getGender())) {
                maleGroup.add(baby);
            }
            else {
                femaleGroup.add(baby);
            }
        }
        System.out.println("男性葫芦娃排序! ");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYNAME);
        Collections.sort(maleGroup);
        huluBabiesGreeting(maleGroup);

        System.out.println("女性葫芦娃排序! ");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYNAME);
        Collections.sort(femaleGroup);
        huluBabiesGreeting(femaleGroup);
    }

    private void huluBabiesGreeting(List<HuluBaby> huluBabies) {
        for (HuluBaby huluBaby : huluBabies) {
            huluBaby.greet();
        }
    }

    // API for HW3 (deprecated)
    public void huluSortDemo() {
        System.out.println("Initialize playground randomly with 7 HuluBaby...");
        Grandpa grandpa = new Grandpa();
        String[] huluNames = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        HuluBaby[] huluBabies = new HuluBaby[huluNames.length];
        for (int i = 0; i < huluNames.length; i++) {
            huluBabies[i] = new HuluBaby(HuluBaby.HuluOrder.values()[i], huluNames[i], HuluBaby.sampleGender());
        }
        shuffleHuluBabies(huluBabies);
        huluBabiesGreeting(huluBabies);
        System.out.println("Initialization finished");
        System.out.println("Sort By Grandpa now (orchestration)");
        grandpa.sortOrchestration(huluBabies);
        huluBabiesGreeting(huluBabies);
        System.out.println("Random shuffle again...");
        shuffleHuluBabies(huluBabies);
        huluBabiesGreeting(huluBabies);
        System.out.println("Sort choreography now");
        ArraySorter.sortByChoreography(huluBabies);
        huluBabiesGreeting(huluBabies);
    }

    private void shuffleHuluBabies(HuluBaby[] huluBabies) {
        Collections.shuffle(Arrays.asList(huluBabies));
    }
    private void huluBabiesGreeting(HuluBaby[] huluBabies) {
        for (HuluBaby huluBaby : huluBabies) {
            huluBaby.greet();
        }
    }
}
