package environment;

import com.google.common.collect.Lists;
import creature.Creature;
import creature.Grandpa;
import creature.HuluBaby;

import java.util.ArrayList;

public class PlayGround extends EnvComponent {
    ArrayList<Creature> creatures = Lists.newArrayList();
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
