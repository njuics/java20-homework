package nju.zjl.cvs.game;

import java.util.HashSet;

public class PenetrableBullet extends StraightBullet {
    public PenetrableBullet(int x, int y, int target, int damage, String imgName){
        super(x, y, target, damage, imgName);
        damaged = new HashSet<>();
    }

    @Override
    protected void hit(Creature t, ItemManager items){
        int id = t.getId();
        if(!damaged.contains(id)){
            damaged.add(id);
            boolean dead = t.hurt(damage);
            if(dead){
                items.removeCreature(t.getId());
            }
        }
    }

    protected HashSet<Integer> damaged;
}
