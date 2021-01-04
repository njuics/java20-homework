package nju.zjl.cvs.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import nju.zjl.cvs.game.Constants.Camp;

public class StraightBullet implements Affector, Drawable {
    public StraightBullet(int x, int y, int target, int damage, String imgName){
        this.x = x;
        this.y = y;
        this.target = target;
        this.damage = damage;
        this.imgName = imgName;
        this.angle = 0.;
        this.firstUpdate = true;
        this.targetCamp = null;
    }

    @Override
    public void update(ItemManager items){
        if(firstUpdate){
            Creature ct = items.getCreatureById(target);
            if(ct == null){
                items.removeAffector(this);
                return;
            }
            targetCamp = ct.getCamp();
            int[] dest = Constants.creaturePos2BulletPos(ct.getPos());
            computeDirection(dest[0], dest[1]);
            firstUpdate = false;
        }

        x += speedX;
        y += speedY;
        if(x < 0 || x >= Constants.COLUMNS * Constants.GRIDWIDTH || y < 0 || y >= Constants.ROWS * Constants.GRIDHEIGHT){
            items.removeAffector(this);
            return;
        }

        Creature t = items.getCreatureByPos(Constants.bulletPos2CreaturePos(x, y));
        if(t == null || t.getCamp() != targetCamp){
            return;
        }

        int[] dest = Constants.creaturePos2BulletPos(t.getPos());
        if(Math.abs(x - dest[0]) <= 30 && Math.abs(y - dest[1]) <= 25){
            hit(t, items);
        }
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.save();

        Rotate r = new Rotate(angle, x, y);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        Image img = Constants.getImage(imgName);
        gc.drawImage(img, x - img.getWidth(), y - img.getHeight() / 2);

        gc.restore();
    }

    protected void computeDirection(int targetX, int targetY){
        int dx = targetX - x;
        double dis = Math.sqrt(dx * dx + (targetY- y) * (targetY - y));
        double r = Math.acos(dx / dis) / Math.PI * 180;
        angle = y > targetY ? 360 - r : r;
        speedX = (int)(Constants.STRAIGHTBULLETSPEED / dis * (targetX - x));
        speedY = (int)(Constants.STRAIGHTBULLETSPEED / dis * (targetY - y));
    }

    protected void hit(Creature t, ItemManager items){
        boolean dead = t.hurt(damage);
        if(dead){
            items.removeCreature(t.getId());
        }
        items.removeAffector(this);
    }
    
    protected int x;
    protected int y;
    protected int speedX;
    protected int speedY;
    protected double angle;

    protected int target;
    protected Camp targetCamp;
    protected int damage;

    private boolean firstUpdate;
    protected String imgName;
}
