package Creature;

import BattleControl.GameMap;
import javafx.scene.image.Image;

public class Centipede extends Creature {
    private int rank=-1;//共10个蜈蚣精，值从1-10
    public int getRank(){return rank;}
    public void setRank(int rank){this.rank=rank;}
    public Centipede(double hp, double damage, double defense, int posX, int posY, Image image, int rank){
        super( hp, damage, defense, posX,  posY,  image,Type.EVIL,"Centipede"+rank);
        this.rank=rank;
    }
}
