package Battlefield;
import AllCreature.*;
import Gui.LayoutControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.omg.CORBA.BAD_CONTEXT;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battlefiled {
    private final int col = 10;//列数
    private final int row = 10;//行数
    private Position[][] battleground;//战场的设置

    private LayoutControl layout;//布局控制
    private  ArrayList<Thread> threads;//多线程

    public Grandfather grandfather;//爷爷
    public Pangolin pangolin;//穿山甲
    public Snake shejing;//蛇精
    public Crab pangxiejing;//螃蟹精
    public ArrayList<Huluwa> huluwas;//葫芦娃
    public ArrayList<Monster> monsters;//小喽啰、小怪物
    public ArrayList<Creature> goodCamp;//好人阵营，包括葫芦娃、爷爷、穿山甲
    public ArrayList<Creature> badCamp;//坏人阵营，包括蛇精、螃蟹精、小怪物们

    public ArrayList<Imageview> imageviews;//图像

    public boolean isBattle = false;

    public Battlefiled(){}
    public Battlefiled(LayoutControl l){this.layout = l; layout.setField(this);}

    public synchronized Position[][] getGround()
    {//同步锁，控制不被多个线程同时执行
        return battleground;
    }
    private void init()//初始化
    {
        this.battleground = new Position[row][col];//战场位置的初始化
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                battleground[i][j] = new Position(i,j);
            }
        }
        imageviews = new ArrayList<Imageview>();
        huluwas = new ArrayList<Huluwa>();
        monsters = new ArrayList<Monster>();
        goodCamp = new ArrayList<Creature>();
        badCamp = new ArrayList<Creature>();

        grandfather = new Grandfather(this);
        pangolin = new Pangolin(this);
        pangxiejing = new Crab(this);
        shejing = new Snake(this);


    }


}
