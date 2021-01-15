package Creature;

import BattleControl.GameMap;
import javafx.scene.image.Image;

public class HuLuWa extends Creature {
    private int rank=-1;//表示葫芦娃的排行，用于区分各个葫芦娃

    public HuLuWa(double hp, double damage, double defense, int posX, int posY, Image image, int rank){
        super( hp, damage, defense, posX,  posY,  image,Type.JUSTICE,"No"+rank);
        this.rank=rank;
    }
    public int getRank(){return rank;}
    public void setRank(int rank){this.rank=rank;}
}
