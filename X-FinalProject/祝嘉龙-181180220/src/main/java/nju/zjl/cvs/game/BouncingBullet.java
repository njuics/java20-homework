package nju.zjl.cvs.game;

import java.util.HashSet;

public class BouncingBullet extends GuidedBullet {
    public BouncingBullet(int x, int y, int target, int damage, String imgName){
        super(x, y, target, damage, imgName);
        damaged = new HashSet<>();
    }

    @Override
    protected void hit(Creature t, ItemManager items){
        boolean dead = t.hurt(damage);
        if(dead){
            items.removeCreature(t.getId());
        }

        damaged.add(t.getId());
        if(damaged.size() == 3){
            items.removeAffector(this);
            return;
        }

        int tx = t.getPos() / Constants.COLUMNS - 2;
        int ty = t.getPos() % Constants.COLUMNS - 2;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(tx + i < 0 || tx + i >= Constants.ROWS || ty + j < 0 || ty + j >= Constants.COLUMNS){
                    continue;
                }
                Creature next = items.getCreatureByPos((tx + i) * Constants.COLUMNS + ty + j);
                if(next == null || next.getCamp() != t.getCamp() || damaged.contains(next.getId())){
                    continue;
                }
                target = next.getId();
                return;
            }
        }

        items.removeAffector(this);
    }

    protected HashSet<Integer> damaged;
}
