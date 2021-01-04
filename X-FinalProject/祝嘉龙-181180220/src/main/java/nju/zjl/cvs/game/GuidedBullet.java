package nju.zjl.cvs.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class GuidedBullet implements Affector, Drawable {
    public GuidedBullet(int x, int y, int target, int damage, String imgName){
        this.x = x;
        this.y = y;
        this.target = target;
        this.damage = damage;
        this.imgName = imgName;
        this.angle = 0.;
    }
    
    @Override
    public void update(ItemManager items){
        Creature ct = items.getCreatureById(target);
        if(ct == null){
            items.removeAffector(this);
            return;
        }
        int[] dest = Constants.creaturePos2BulletPos(ct.getPos());
        moveTo(dest[0], dest[1]);
        computeAngle(dest[0], dest[1]);
        if(Math.abs(x - dest[0]) <= 25 && Math.abs(y - dest[1]) <= 25){
            hit(ct, items);
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

    protected void hit(Creature t, ItemManager items){
        boolean dead = t.hurt(damage);
        if(dead){
            items.removeCreature(t.getId());
        }
        items.removeAffector(this);
    }

    protected void moveTo(int destX, int destY){
        int deltaX = destX - x;
        int deltaY = destY - y;
        double dis = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        if(dis <= Constants.GUIDEDBULLETSPEED){
            x = destX;
            y = destY;
        }
        else{
            double s = Constants.GUIDEDBULLETSPEED / dis;
            x += deltaX * s;
            y += deltaY * s;
        }
    }
    
    protected void computeAngle(int destX, int destY){
        int dx = destX - x;
        double dis = Math.sqrt(dx * dx + (destY - y) * (destY - y));
        double r = Math.acos(dx / dis) / Math.PI * 180;
        angle = y > destY ? 360 - r : r;
    }

    protected int x;
    protected int y;
    protected double angle;

    protected int target;
    protected int damage;

    protected String imgName;
}
