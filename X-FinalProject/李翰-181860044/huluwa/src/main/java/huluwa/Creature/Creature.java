package huluwa.Creature;

import huluwa.Bullet.Bullet;
import huluwa.Bullet.BulletFactory;

public class Creature{
    private String name;  //名字
    private int fullHP;   //总HP值
    private int curHP;    //当前HP值
    private int defence;  //防御力
    private BulletFactory bulletFactory;
    private Bullet bullet;   //自己的子弹类型
    private int posX, posY;  //在场上坐标
    private boolean alive;   //是否还活着
    private boolean goodOrBad;  //true表示好人，false表示坏人

    Creature(String name, int fullHP, int defence, String bulletType, int posX, int posY, boolean flag){
        bulletFactory = new BulletFactory();
        this.name = name;
        this.fullHP = fullHP;
        this.curHP = fullHP;
        this.defence = defence;
        this.bullet = bulletFactory.getShape(bulletType);
        this.posX = posX;
        this.posY = posY;
        this.alive = true;
        this.goodOrBad = flag;
    }
    public String getName(){
        return this.name;
    }
    public int getFullHP(){
        return this.fullHP;
    }
    public int getCurHP(){
        return this.curHP;
    }
    public int getDefence(){
        return this.defence;
    }
    public Bullet getBullet(){
        return this.bullet;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public void setHP(int newHP){
        this.curHP = newHP;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public boolean getGoodOrBad(){
        return this.goodOrBad;
    }
    public boolean isAlive(){
        return this.alive;
    }

    public void beAttacked(Bullet b){ //受到攻击
        this.curHP -= (b.getPower()-this.defence);
        if(this.curHP <= 0){
            this.alive = false;
        }
    }
}