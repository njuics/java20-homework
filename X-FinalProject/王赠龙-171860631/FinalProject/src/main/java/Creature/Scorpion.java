package Creature;

import BattleControl.GameMap;
import javafx.scene.image.Image;

public class Scorpion extends Creature {
    public Scorpion(double hp, double damage, double defense, int posX, int posY, Image image){
        super( hp, damage, defense, posX,  posY,  image,Type.EVIL,"Scorpion");
    }
}
