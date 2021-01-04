package nju.zjl.cvs.game;

import java.io.InputStream;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Constants {
    public enum Camp {
        CALABASH, MONSTER
    }

    //map size
    public static final int ROWS = 9;
    public static final int COLUMNS = 12;

    //game FPS
    public static final int FPS = 30;

    //creature move speed, 15 frames(0.5s) to move 1 grid
    public static final int CREATUREMOVECD = 15;

    public static final int GUIDEDBULLETSPEED = 10;

    public static final int STRAIGHTBULLETSPEED = 20;

    public static final int GRIDWIDTH = 70;
    public static final int GRIDHEIGHT = 70;

    public static int bulletPos2CreaturePos(int x, int y){
        return x / GRIDWIDTH + y / GRIDHEIGHT * COLUMNS;
    }

    public static int[] creaturePos2BulletPos(int pos){
        int[] ret = new int[2];
        ret[0] = pos % COLUMNS * GRIDWIDTH + GRIDWIDTH / 2;
        ret[1] = pos / COLUMNS * GRIDHEIGHT + GRIDHEIGHT / 2;
        return ret;
    }

    private static HashMap<String, Image> imgMap;

    static{
        imgMap = new HashMap<>();
        String[] images = {"red", "green", "blue", "yellow", "orange", "purple", "cyan", "snake", "scorpion", "toad", "centipede", "guidedBullet", "penetrableBullet", "bouncingBullet", "straightBullet"};
        for(String img : images){
            InputStream in = Constants.class.getClassLoader().getResourceAsStream("image/" + img +".png");
            imgMap.put(img, new Image(in));
        }
    }

    public static Image getImage(String imgName){
        return imgMap.get(imgName);
    }

    public static Color getColor(String color){
        switch(color){
            case "red":
                return Color.RED;
            case "black":
                return Color.BLACK;
            default:
                return Color.WHITE;
        }
    }
}
