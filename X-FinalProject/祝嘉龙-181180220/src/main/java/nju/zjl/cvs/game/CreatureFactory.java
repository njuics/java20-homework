package nju.zjl.cvs.game;

import nju.zjl.cvs.game.Constants.Camp;

public class CreatureFactory {
    public static Creature getPlainCreature(int x, int y, Camp camp){
        return new Creature(camp, x * Constants.COLUMNS + y, 100, 10, 3, 45, AffectorFactory::getPlainBullet, "red");
    }

    public static Creature getCalabash(int x, int y, String name){
        switch(name){
            case "red":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 150, 8, 2, 45, AffectorFactory::getStraightBullet, "red");
            case "orange":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 100, 15, 4, 30, AffectorFactory::getPenetrableBullet, "orange");
            case "yellow":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 200, 5, 1, 60, AffectorFactory::getStraightBullet, "yellow");
            case "green":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 150, 8, 2, 45, AffectorFactory::getStraightBullet, "green");
            case "cyan":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 150, 8, 2, 45, AffectorFactory::getStraightBullet, "cyan");
            case "blue":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 120, 15, 3, 30, AffectorFactory::getPenetrableBullet, "blue");
            case "purple":
                return new Creature(Camp.CALABASH, x * Constants.COLUMNS + y, 200, 5, 1, 60, AffectorFactory::getStraightBullet, "purple");
            default:
                return null;
        }
    }

    public static Creature getMonster(int x, int y, String name){
        switch(name){
            case "snake":
                return new Creature(Camp.MONSTER, x * Constants.COLUMNS + y, 150, 12, 5, 30, AffectorFactory::getBouncingBullet, "snake");
            case "scorpion":
                return new Creature(Camp.MONSTER, x * Constants.COLUMNS + y, 200, 8, 1, 60, AffectorFactory::getBouncingBullet, "scorpion");   
            case "toad":
                return new Creature(Camp.MONSTER, x * Constants.COLUMNS + y, 100, 10, 3, 40, AffectorFactory::getGuidedBullet, "toad");
            case "centipede":
                return new Creature(Camp.MONSTER, x * Constants.COLUMNS + y, 100, 8, 2, 50, AffectorFactory::getGuidedBullet, "centipede");
            default:
                return null;
        }
    }
}
