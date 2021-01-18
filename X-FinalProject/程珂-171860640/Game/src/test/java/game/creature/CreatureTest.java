package game.creature;

import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.creature.HuluBro;
import advancedjava.finalproj.game.creature.Monster;
import org.junit.Test;

import java.util.Random;

import static advancedjava.finalproj.game.creature.Utils.formatDouble;
import static advancedjava.finalproj.game.creature.Utils.limitRandomRange;
import static org.junit.Assert.assertEquals;

public class CreatureTest
{
    static Random random1 = new Random();
    static Random random2 = new Random();
    static Random random3 = new Random();

    static
    {
        Random random = new Random();
        long randNum = random.nextLong();
        random1.setSeed(randNum);
        random2.setSeed(randNum);
    }

    HuluBro bro1 = HuluBro.getInstance();
    HuluBro bro2 = HuluBro.getInstance(random1);
    Monster monster1 = Monster.getInstance();
    Monster monster2 = Monster.getInstance(random1);

    public void testMonster()
    {
        assertEquals(monster1.getCamp(), CampEnum.MONSTER);
        double delta = 0.00001;

        assertEquals(monster1.getHp(), 5, delta);
        assertEquals(monster1.getDamage(), 4, delta);
        assertEquals(monster1.getDamageRange(), 2, delta);
        assertEquals(monster1.getDefense(), 5, delta);
        monster1.defense();
        assertEquals(monster1.isDefensive(), true);
        monster1.takeDownDefense();
        assertEquals(monster1.isDefensive(), false);
        for (int i = 0; i < 5; i++)
        {
            bro1.attack(monster1, random3);
        }
        assertEquals(monster1.isDead(), true);

        assertEquals(monster2.getHp(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 5), delta);

        assertEquals(monster2.getDamage(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 4), delta);

        assertEquals(monster2.getDamageRange(), 2, delta);

        assertEquals(monster2.getDefense(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 5), delta);
    }


    public void testHuluBro()
    {
        assertEquals(bro1.getCamp(), CampEnum.HULUBRO);
        double delta = 0.00001;
        assertEquals(bro1.getHp(), 5, delta);
        assertEquals(bro1.getDamage(), 6, delta);
        assertEquals(bro1.getDamageRange(), 1, delta);
        assertEquals(bro1.getDefense(), 4, delta);
        bro1.defense();
        assertEquals(bro1.isDefensive(), true);
        bro1.takeDownDefense();
        assertEquals(bro1.isDefensive(), false);
        for (int i = 0; i < 5; i++)
        {
            monster1.attack(bro1, random3);
        }
        assertEquals(bro1.isDead(), true);

        assertEquals(bro2.getHp(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 5), delta);

        assertEquals(bro2.getDamage(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 6), delta);

        assertEquals(bro2.getDamageRange(), 1, delta);

        assertEquals(bro2.getDefense(), formatDouble(
                limitRandomRange(random2.nextDouble()) + 4), delta);

        assertEquals(monster1.getCamp(), CampEnum.MONSTER);
    }

    @Test
    public void testAll()
    {
        //顺序不能乱
        testHuluBro();
        testMonster();
    }
}
