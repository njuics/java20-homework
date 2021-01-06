package creature;

import utils.comparator.InOrderComparator;
import utils.comparator.RandomComparator;
import utils.comparator.ReversedComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Grandpa extends Creature {
    ArrayList<HuluBaby> huluBabies;
    public Grandpa() {}
    public void checkCreaturesInPlayGround(ArrayList<Creature> creatures) {
        ArrayList<HuluBaby> huluBabies = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature.getClass().equals(HuluBaby.class)) {
                huluBabies.add((HuluBaby)creature);
            }
            else if (!creature.getClass().equals(Grandpa.class)) {
                System.out.println(creature.toString() + " 被爷爷丢出了队伍, 你大爷永远是你大爷.");
                creatures.remove(creature);
            }
        }
        this.huluBabies = huluBabies;
        System.out.println("爷爷发现了" + huluBabies.size() + "个葫芦娃, 并要求葫芦娃们介绍自己");
        HuluBaby.huluBabiesGreetings(huluBabies);
        System.out.println("爷爷要求葫芦娃们正序排列");
        Collections.sort(huluBabies, new InOrderComparator<Creature>());
        for (int i = 0; i < huluBabies.size(); i++) {
            System.out.println("位置" + i + ": " + huluBabies.get(i).toString());
        }
        System.out.println("爷爷要求葫芦娃们逆序排列");
        Collections.sort(huluBabies, new ReversedComparator<Creature>());
        for (int i = 0; i < huluBabies.size(); i++) {
            System.out.println("位置" + i + ": " + huluBabies.get(i).toString());
        }
        System.out.println("爷爷要求葫芦娃们乱序排列");
        Collections.sort(huluBabies, new RandomComparator<Creature>());
        for (int i = 0; i < huluBabies.size(); i++) {
            System.out.println("位置" + i + ": " + huluBabies.get(i).toString());
        }
        System.out.println("爷爷正在按性别挑出葫芦娃...");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYGENDER);
        Collections.sort(huluBabies);
        for (int i = 0; i < huluBabies.size(); i++) {
            System.out.println("位置" + i + ": " + huluBabies.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return super.toString() + " 爷爷";
    }
}
