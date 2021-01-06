package huluwa;

import java.util.ArrayList;
import java.util.List;

import huluwa.Bullet.Bullet;
import huluwa.Client.PlayerClient;
import huluwa.Creature.Creature;
import huluwa.Creature.Grandpa;
import huluwa.Creature.Hulu;
import huluwa.Creature.Pangolin;
import huluwa.Creature.Snack;
import huluwa.Creature.Scorpion;
import huluwa.Creature.LittleSoldier;
import javafx.scene.Group;

public class Game {
    List<Creature> goodMan, badMan;
    public List<BattlefieldGrid> goodManGrid, badManGrid; //good: 爷爷+穿山甲+七个葫芦娃, bad: 蛇精+蝎子精+十个小喽啰 
    private boolean good;
    static List<Creature> staticGoodMan, staticBadMan;
    public static List<BattlefieldGrid> staticGoodManGrid, staticBadManGrid;
    private PlayerClient pc;

    
    public Game(boolean good, PlayerClient pc){
        this.pc = pc;
        this.good = good;
        goodMan = new ArrayList<Creature>();
        badMan = new ArrayList<Creature>();
        goodManGrid = new ArrayList<BattlefieldGrid>();
        badManGrid = new ArrayList<BattlefieldGrid>();
    }

    public void init(Group root){
        goodMan.add(new Grandpa("grandpa", 20, 1, "One", 2 ,4));
        goodMan.add(new Pangolin("pangolin", 15, 2, "One", 2, 7));
        goodMan.add(new Hulu("one", 10, 3, "One", 5, 2));
        goodMan.add(new Hulu("two", 10, 3, "One", 5, 3));
        goodMan.add(new Hulu("three", 10, 3, "One", 5, 4));
        goodMan.add(new Hulu("four", 10, 3, "One", 5, 5));
        goodMan.add(new Hulu("five", 10, 3, "One", 5, 6));
        goodMan.add(new Hulu("six", 10, 3, "One", 5, 7));
        goodMan.add(new Hulu("seven", 10, 3, "One", 5, 8));

        badMan.add(new Snack("snack", 20, 2, "One", 18, 7));
        badMan.add(new Scorpion("scorpion", 15, 3, "One", 18, 4));
        badMan.add(new LittleSoldier("littleSoldier1", 10, 2, "One", 15, 1));
        badMan.add(new LittleSoldier("littleSoldier2", 10, 2, "One", 15, 2));
        badMan.add(new LittleSoldier("littleSoldier3", 10, 2, "One", 15, 3));
        badMan.add(new LittleSoldier("littleSoldier4", 10, 2, "One", 15, 4));
        badMan.add(new LittleSoldier("littleSoldier5", 10, 2, "One", 15, 5));
        badMan.add(new LittleSoldier("littleSoldier6", 10, 2, "One", 15, 6));
        badMan.add(new LittleSoldier("littleSoldier7", 10, 2, "One", 15, 7));
        badMan.add(new LittleSoldier("littleSoldier8", 10, 2, "One", 15, 8));
        badMan.add(new LittleSoldier("littleSoldier9", 10, 2, "One", 15, 9));
        badMan.add(new LittleSoldier("littleSoldier10", 10, 2, "One", 15, 10));

        for(int i=0; i<goodMan.size(); ++i){
            goodManGrid.add(new BattlefieldGrid(goodMan.get(i), pc));
        }
        for(int i=0; i<badMan.size(); ++i){
            badManGrid.add(new BattlefieldGrid(badMan.get(i), pc));
        }

        for(int i=0; i<goodManGrid.size(); ++i){
            root.getChildren().add(goodManGrid.get(i).getVBox());
        }
        for(int i=0; i<badManGrid.size(); ++i){
            root.getChildren().add(badManGrid.get(i).getVBox());
        }

        staticGoodMan = new ArrayList<Creature>(goodMan);
        staticBadMan = new ArrayList<Creature>(badMan);
        staticGoodManGrid = new ArrayList<BattlefieldGrid>(goodManGrid);
        staticBadManGrid = new ArrayList<BattlefieldGrid>(badManGrid);
    }

    public static List<Integer> shoot(Creature c, Bullet b){  //(x,y)处的生物发射一个子弹, game模块负责找到命中目标并更新命中目标的情况，不负责绘图
        int startX = c.getPosX();
        int startY = c.getPosY();
        int endX = -1, endY = -1;
        //规定子弹只能直线发射
        endY = startY;

        int tmp = -1;
        if(c.getGoodOrBad()){   //葫芦娃阵营发射子弹
            endX = 20;
            for(int xi = startX+1; xi<=19; ++xi){
                for(int i = 0; i<staticBadMan.size();++i){
                    if(staticBadMan.get(i).getPosX() == xi && staticBadMan.get(i).getPosY() == endY ){  //找到目标
                        tmp = i;
                        endX = xi;
                        break;
                    }
                }
                if(endX!=20)break;
            }
        }else{   //蛇精阵营发射子弹
            endX = 0;
            for(int xi = startX-1; xi>0; --xi){
                for(int i = 0; i<staticGoodMan.size();++i){
                    if(staticGoodMan.get(i).getPosX() == xi && staticGoodMan.get(i).getPosY() == endY ){
                        tmp = i;
                        endX = xi;
                        break;
                    }
                }
                if(endX!=0)break;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        res.add(tmp);
        res.add(startX);
        res.add(startY);
        res.add(endX);
        res.add(endY);
        return res;
        //Render.drawBullet(c,b,tmp,startX, startY, endX, endY);  
    }

    public boolean updateHp(Creature c, Bullet b, int tmp){
        if(tmp == -1){  //没有命中目标
            return false;
        }
        if(c.getGoodOrBad()){
            badMan.get(tmp).beAttacked(b);
            badManGrid.get(tmp).updateHpBarAndTips();
            if(!badMan.get(tmp).isAlive()){    //若死亡，将其删去
                //Render.removeDead(badManGrid.get(tmp));
                badMan.remove(badMan.get(tmp));
                badManGrid.remove(badManGrid.get(tmp));
                staticBadMan.remove(staticBadMan.get(tmp));
                staticBadManGrid.remove(staticBadManGrid.get(tmp));
                return true;
            }
        }else{
            goodMan.get(tmp).beAttacked(b);
            goodManGrid.get(tmp).updateHpBarAndTips();
            if(!goodMan.get(tmp).isAlive()){
                //Render.removeDead(goodManGrid.get(tmp));
                goodMan.remove(goodMan.get(tmp));
                goodManGrid.remove(goodManGrid.get(tmp));
                staticGoodMan.remove(staticGoodMan.get(tmp));
                staticGoodManGrid.remove(staticGoodManGrid.get(tmp));
                return true;
            }
        }
        return false;
        //Render.gameIsOver();
    }

    public int gameOver(){  //判断游戏是否结束，1表示葫芦娃获胜，-1表示蛇精获胜，0表示未结束
        if(goodMan.size()==0){ 
            return -1;
        }else if(badMan.size()==0){
            return 1;
        }
        return 0;
    }

    public static boolean existCreature(int x, int y){  //给定坐标(x,y)，判断上面是否存在生物
        for(int i=0; i<staticGoodMan.size(); ++i){
            if(staticGoodMan.get(i).getPosX()==x && staticGoodMan.get(i).getPosY()==y){
                return true;
            }
        }
        for(int i=0; i<staticBadMan.size(); ++i){
            if(staticBadMan.get(i).getPosX()==x && staticBadMan.get(i).getPosY()==y){
                return true;
            }
        }
        return false;
    }

}
