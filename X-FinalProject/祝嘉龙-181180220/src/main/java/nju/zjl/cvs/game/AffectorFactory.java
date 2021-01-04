package nju.zjl.cvs.game;

public class AffectorFactory {
    public static Affector getPlainBullet(int x, int y, int target, int damage){
        return new GuidedBullet(x, y, target, damage, "guidedBullet");
    }
    
    public static Affector getGuidedBullet(int x, int y, int target, int damage){
        return new GuidedBullet(x, y, target, damage, "guidedBullet");
    }

    public static Affector getStraightBullet(int x, int y, int target, int damage){
        return new StraightBullet(x, y, target, damage, "straightBullet");
    }

    public static Affector getPenetrableBullet(int x, int y, int target, int damage){
        return new PenetrableBullet(x, y, target, damage, "penetrableBullet");
    }

    public static Affector getBouncingBullet(int x, int y, int target, int damage){
        return new BouncingBullet(x, y, target, damage, "bouncingBullet");
    }
}
