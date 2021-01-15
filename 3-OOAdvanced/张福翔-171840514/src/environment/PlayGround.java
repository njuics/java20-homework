package environment;

import creature.Grandpa;
import creature.HuluBaby;
import utils.ArraySorter;

import java.util.Arrays;
import java.util.Collections;

public class PlayGround extends EnvComponent {
    HuluBaby[] huluBabies = new HuluBaby[HuluBaby.HuluType.values().length];
    Grandpa grandpa = new Grandpa();

    public PlayGround() {
    }

    public void huluSortDemo() {
        System.out.println("Initialize playground randomly with 7 HuluBaby...");
        createHuluBabiesInOrder();
        shuffleHuluBabies();
        huluBabiesGreeting();
        System.out.println("Initialization finished");
        System.out.println("Sort By Grandpa now (orchestration)");
        grandpa.sortOrchestration(huluBabies);
        huluBabiesGreeting();
        System.out.println("Random shuffle again...");
        shuffleHuluBabies();
        huluBabiesGreeting();
        System.out.println("Sort choreography now");
        ArraySorter.sortByChoreography(huluBabies);
        huluBabiesGreeting();
    }

    public void createHuluBabiesInOrder() {
        String[] huluNames = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        for (int i = 0; i < huluBabies.length; i++) {
            huluBabies[i] = new HuluBaby(HuluBaby.HuluType.values()[i], huluNames[i]);
        }
    }
    public void shuffleHuluBabies() {
        Collections.shuffle(Arrays.asList(huluBabies));
    }
    public void huluBabiesGreeting() {
        for (HuluBaby huluBaby : huluBabies) {
            huluBaby.greet();
        }
    }
}
