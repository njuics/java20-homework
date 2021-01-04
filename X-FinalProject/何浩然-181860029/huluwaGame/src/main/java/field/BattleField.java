package field;

import app.Main;
import creature.Creature;
import creature.PCCreature;
import creature.PlayerCreature;
import creature.SnakeWoman;
import javafx.application.Platform;
import ui.BattleFieldSprite;

import java.util.ArrayList;
import java.util.List;

public  class BattleField {
    private BattleFieldSprite bfs;
    private Main app;
    private List<Creature> playerCreatures = new ArrayList<>();
    private List<Creature> pcCreatures = new ArrayList<>();

    private Creature[][] creatures;
    private int width,height;

    private Creature currentSelectCreature;

    public BattleField(int width,int height){
        bfs = new BattleFieldSprite(width,height);
        creatures = new Creature[width][height];
        this.width = width;
        this.height = height;
    }

    public BattleFieldSprite getBfs() {
        return bfs;
    }

    public synchronized boolean moveTo(Creature creature,int x,int y,int fromX,int fromY){
        if(!isValidPosition(x,y)){
            return false;
        }
        if(creatures[x][y]!=null){
            return false;
        }
        if(isValidPosition(fromX,fromY)&&creatures[fromX][fromY]!=creature){
            return false;
        }
        creatures[x][y] = creature;
        if(isValidPosition(fromX,fromY)){
            creatures[fromX][fromY] = null;
        }
        return true;
    }

    private boolean isValidPosition(int x, int y){
        return x>=0&&x<width&&y>=0&&y<height;
    }

    public boolean enter(Creature creature,int x,int y){
        boolean succussful = moveTo(creature,x,y,-1,-1);
        if(succussful){
            if(creature instanceof PlayerCreature){
                playerCreatures.add(creature);
            }else{
                pcCreatures.add(creature);
            }
        }
        return succussful;
    }

    public void clickOn(int x,int y){
        if(!isValidPosition(x,y)||(currentSelectCreature!=null&&currentSelectCreature.isMoving())){
            return;
        }
        if(creatures[x][y]==null||creatures[x][y] instanceof PCCreature){
            currentSelectCreature = null;
            Platform.runLater(()->{bfs.getOutline().moveToByUnit(-1,-1);});
        }else{
            currentSelectCreature = creatures[x][y];
            Platform.runLater(()->{bfs.getOutline().moveToByUnit(x,y);});
        }
    }

    public Creature getCurrentSelectCreature() {
        return currentSelectCreature;
    }

    public synchronized Creature[] getNearbyCreatures(int x,int y){
        Creature[] nearby = new Creature[4];
        nearby[0] = (isValidPosition(x-1,y)?creatures[x-1][y]:null);
        nearby[1] = (isValidPosition(x+1,y)?creatures[x+1][y]:null);
        nearby[2] = (isValidPosition(x,y-1)?creatures[x][y-1]:null);
        nearby[3] = (isValidPosition(x,y+1)?creatures[x][y+1]:null);
        return nearby;
    }

    public synchronized void getOutOfField(Creature creature,int x,int y){
        if(!isValidPosition(x,y)){
            return;
        }
        if(creatures[x][y]!=creature){
            return;
        }

        if(creatures[x][y] instanceof PlayerCreature){
            playerCreatures.remove(creature);
            if(playerCreatures.size()<=0){
                Main.getMnc().show("失败");
                app.setType(Main.GameType.FINISH,Main.getType()== Main.GameType.PLAY);
            }
        }else{
            pcCreatures.remove(creature);
            if(pcCreatures.size()<=0){
                Main.getMnc().show("成功");
                app.setType(Main.GameType.FINISH,Main.getType()== Main.GameType.PLAY);
            }
        }

        creatures[x][y] = null;
    }

    public synchronized void deselectCurrentSelectCreature(Creature creature){
        if(currentSelectCreature==creature){
            currentSelectCreature = null;
            Platform.runLater(()->{bfs.getOutline().moveToByUnit(-1,-1);});
        }
    }

    public void setMainController(Main app){
        this.app = app;
    }
    private SnakeWoman sw = SnakeWoman.getInstance();

    public void checkSkillEffect(double angle){
        if(angle<=90){
            angle = 90- angle;
        }else{
            angle = 270 - angle;
        }
        double tanRadian = Math.tan((angle*Math.PI)/180);
        double denominator = Math.sqrt(tanRadian*tanRadian+1);
        for(Creature creature:playerCreatures){
            double distance = Math.abs(tanRadian*creature.getPixelX()-creature.getPixelY()+sw.getPixelY()-tanRadian*sw.getPixelX())/denominator;
            if(distance<10){
                Platform.runLater(()->{creature.decreaseHp(sw,200);});
            }
        }
    }

}
