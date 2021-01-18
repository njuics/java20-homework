package Creature;

import BattleControl.GameMap;
import javafx.scene.image.Image;

public class Grandpa extends Creature {
    public Grandpa(double hp, double damage, double defense, int posX, int posY, Image image){
        super( hp, damage, defense, posX,  posY,  image,Type.JUSTICE,"Grandpa");
    }
}
