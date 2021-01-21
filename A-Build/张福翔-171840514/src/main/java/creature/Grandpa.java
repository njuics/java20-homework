package creature;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.ArrayList;

public class Grandpa extends Creature {
    ArrayList<HuluBaby> huluBabies;
    public Grandpa() {}
    public void checkCreaturesInPlayGround(ArrayList<Creature> creatures) {
        System.out.println("爷爷正在战场中搜索葫芦娃...");
        huluBabies = Lists.newArrayList();
        for (Creature creature : creatures) {
            if (creature.getClass().equals(HuluBaby.class)) {
                System.out.println("爷爷发现了一个葫芦娃, 请他/她来打个招呼吧! ");
                System.out.print("  - ");
                ((HuluBaby) creature).greet();
                huluBabies.add((HuluBaby)creature);
            }
            else if (!creature.getClass().equals(Grandpa.class)) {
                System.out.println(creature + " 被爷爷丢出了队伍, 你大爷永远是你大爷.");
                creatures.remove(creature);
            }
        }
        System.out.println("爷爷发现了" + huluBabies.size() + "个葫芦娃");

        HuluBaby.setComparationType(HuluBaby.ComparationType.BYNAME);

        System.out.println("爷爷要求葫芦娃们正序排列");
        Ordering<HuluBaby> natural = Ordering.natural();
        System.out.println(natural.sortedCopy(huluBabies));

        System.out.println("爷爷要求葫芦娃们逆序排列");
        Ordering<HuluBaby> reverse = Ordering.natural().reverse();
        System.out.println(reverse.sortedCopy(huluBabies));

        System.out.println("爷爷要求葫芦娃们乱序排列");
        Ordering<Object> random = Ordering.arbitrary();
        System.out.println(random.sortedCopy(huluBabies));

        System.out.println("爷爷正在按性别挑出葫芦娃...");
        HuluBaby.setComparationType(HuluBaby.ComparationType.BYGENDER);
        System.out.println(natural.sortedCopy(huluBabies));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("huluBabies", huluBabies).toString();
    }
}
