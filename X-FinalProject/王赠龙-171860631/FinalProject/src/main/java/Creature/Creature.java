package Creature;

import BattleControl.*;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.Random;

public class Creature implements Controllable,Runnable, BattleConfig {
    private double hp;
    private double maxHp;
    private double damage;
    private double defense;
    private int posX;
    private int posY;
    private Image image;
    private Type type;
    private boolean isAlive=true;
    private boolean isControlled=false;
    private String name;
    private static GameMap gameMap;
    private static GameState gameState;
    private static Player player=Player.JUSTICEPLAYER;
    public Creature(double hp,double damage,double defense,int posX,int posY,Image image,Type type,String name){
        this.hp = hp;
        this.damage=damage;
        this.defense=defense;
        this.posX=posX;
        this.posY=posY;
        this.image=image;
        this.type=type;
        this.name=name;
    }
    public static void setStaticFileds(GameMap tempGameMap,GameState tempGameState){
        gameMap=tempGameMap;
        gameState=tempGameState;
    }
    public static void setPlayer(Player tempPlayer){
        player=tempPlayer;
    }
    public double getHp(){ return hp; }
    public void setHp(double hp) {
        this.hp = hp;
        if(this.hp<=0) {
            this.isAlive = false;
            /*
            synchronized (gameMap) {
                gameMap.removeCreature(posX, posY);
            }*/
            /*
            if(type.equals(Type.JUSTICE)) {
                synchronized (gameState) {
                    gameState.setJusticeCreatureNum(gameState.getJusticeCreatureNum()-1);
                }
            }
            else{
                synchronized (gameState) {
                    gameState.setEvilCreatureNum(gameState.getEvilCreatureNum()-1);
                }
            }*/
        }
    }
    public double getDamage(){ return damage; }
    public void setDamage(double damage){ this.damage=damage; }
    public double getDefense(){return defense;}
    public void setDefense(double defense){this.defense=defense;}
    public Image getImage(){return image;}
    public void setImage(URL url){image=new Image(url.toString());}
    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean isAlive){this.isAlive=isAlive;}
    public int getPosX() { return posX; }
    public void setPosX(int posX) { this.posX = posX; }
    public int getPosY(){return posY;}
    public void setPosY(int posY){this.posY=posY;}
    public GameMap getGameMap(){return gameMap;}
    public void randomlyMove(){
            Random random=new Random();
            int biasX=random.nextInt(3)-1;
            int biasY=random.nextInt(3)-1;
            move(biasX,biasY);
    }
    public Type getType(){return type;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public void setMaxHp(double maxHp){this.maxHp=maxHp;}
    public double getMaxHp(){return maxHp;}

    @Override
    public void controlledMove(Direction dir){
            int biasX, biasY;
            switch(dir) {
                case UP:biasX=0;biasY=-1;break;
                case DOWN:biasX=0;biasY=1;break;
                case LEFT:biasX=-1;biasY=0;break;
                case RIGHT:biasX=1;biasY=0;break;
                default:biasX=0;biasY=0;
            }
            move(biasX,biasY);
            NetPacket netPacket=new NetPacket(true,name,posX,posY,hp);
            Controller.send(netPacket);
    }
    public void move(int biasX,int biasY){
        int newX=posX+biasX;
        int newY=posY+biasY;
        synchronized (gameMap) {
            if (gameMap.isInMap(newX, newY) && gameMap.noCreatureAt(newX, newY)) {
                gameMap.removeCreature(posX, posY);
                synchronized (this) {
                    setPosX(newX);
                    setPosY(newY);
                }
                gameMap.setCreature(posX, posY, this);
            }
        }
        //Controller.send(this.name+" move to "+posX+" "+posY);
    }
    public void attack(Creature creature){
        if(creature!=null&&creature.isAlive()) {
            boolean isEvil = (creature instanceof Snake) || (creature instanceof Scorpion) || (creature instanceof Centipede);
            if((type.equals(Type.JUSTICE)&&isEvil)||(type.equals(Type.EVIL)&&(!isEvil))){
                    synchronized (this) {
                        setHp(getHp() - creature.getDamage()/getDefense()*100);
                    }
            }
        }
    }

    @Override
    public void run(){
        while(isAlive&&Thread.interrupted()==false){
            try{
                synchronized (gameState) {
                    while (gameState.getIsPaused()) {
                        gameState.wait();//如果游戏暂停了，则所有生物线程阻塞在gameState上，再次按下空格之后由gameState唤醒全部阻塞在其上的线程
                    }
               }
                Thread.sleep(1000);
                if(!isAlive)break;

                if(!isControlled&&gameState.getIsStart()) {
                    if((type.equals(Type.JUSTICE)&&(player.equals(Player.JUSTICEPLAYER)))||(type.equals(Type.EVIL)&&(player.equals(Player.EVILPLAYER)))) {
                        randomlyMove();
                    }
                }
               // synchronized (gameMap) {
                if((type.equals(Type.JUSTICE)&&(player.equals(Player.JUSTICEPLAYER)))||(type.equals(Type.EVIL)&&(player.equals(Player.EVILPLAYER)))) {
                    Creature creature = gameMap.getCreature(posX - 1, posY);//首先向左侧的妖精发起攻击
                    attack(creature);
                    creature = gameMap.getCreature(posX + 1, posY);//向右侧的妖精发起攻击
                    attack(creature);
                    creature = gameMap.getCreature(posX, posY - 1);//向右侧的妖精发起攻击
                    attack(creature);
                    creature = gameMap.getCreature(posX, posY + 1);//向右侧的妖精发起攻击
                    attack(creature);
                }
                NetPacket netPacket=new NetPacket(true,name,posX,posY,hp);
                Controller.send(netPacket);

             //   }
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
    @Override
    public void setControlled(boolean controlled) { isControlled = controlled; }
    @Override
    public boolean getIsControlled(){return isControlled;}
    @Override
    public boolean canBeControlled(){
        return isAlive&&!isControlled;
    }
}
