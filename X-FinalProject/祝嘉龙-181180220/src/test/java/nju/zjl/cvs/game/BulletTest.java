package nju.zjl.cvs.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nju.zjl.cvs.game.Constants.Camp;

public class BulletTest {
    @Test
    public void bulletTest1(){
        Affector bullet = AffectorFactory.getPlainBullet(targetX, targetY - 200, target.getId(), 10);
        items.addAffector(bullet);
        assertEquals(100, target.hp);
        while(items.atQueue.contains(bullet)){
            bullet.update(items);
        }
        assertEquals(90, target.hp);
    }    

    @Test
    public void bulletTest2(){
        Affector bullet = AffectorFactory.getPlainBullet(targetX + 300, targetY - 200, target.getId(), 110);
        items.addAffector(bullet);
        assertEquals(100, target.hp);
        while(items.atQueue.contains(bullet)){
            bullet.update(items);
        }
        assertTrue(!items.ctIdMap.containsKey(target.getId()));
    }    


    public BulletTest(){
        target = CreatureFactory.getPlainCreature(3, 4, Camp.CALABASH);
        int[] ret = Constants.creaturePos2BulletPos(target.getPos());
        targetX = ret[0];
        targetY = ret[1];
        items = new ItemManager();
        items.addCreature(target);
        items.addCreature(CreatureFactory.getPlainCreature(7, 8, Camp.CALABASH));
        items.addCreature(CreatureFactory.getPlainCreature(3, 6, Camp.CALABASH));
        items.addCreature(CreatureFactory.getPlainCreature(2, 5, Camp.CALABASH));
    }

    int targetX;
    int targetY;
    Creature target;
    ItemManager items;
}
