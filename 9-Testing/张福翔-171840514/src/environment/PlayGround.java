package environment;

import creature.Creature;
import creature.Grandpa;
import creature.HuluBaby;
import utils.comparator.InOrderComparator;
import utils.comparator.RandomComparator;
import utils.comparator.ReversedComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayGround extends EnvComponent {
    ArrayList<Creature> creatures = new ArrayList<>();
    Grandpa grandpa;

    public PlayGround() {
        addGrandpa();
    }

    public void addRandomHuluBaby() {
        creatures.add(new HuluBaby(HuluBaby.HuluOrder.OTHERS, HuluBaby.sampleName(), HuluBaby.sampleGender()));
    }

    public void addGrandpa() {
        grandpa = new Grandpa();
        creatures.add(grandpa);
    }

    public Grandpa getGrandpa() {
        return grandpa;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }
}
