package creature;

import app.Main;
import field.BattleField;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.image.Image;
import ui.CreatureSprite;
import java.time.format.DecimalStyle;
public abstract class Creature extends Thread{

    class FightingAnimationTimer extends AnimationTimer{
        private boolean running = false;
        @Override
        public void handle(long now) {
            //I Love Math
            Platform.runLater(() -> {
                sprite.getProfileImage().setRotate(Math.sin(now / 100000000) * 20);
            });
        }

        @Override
        public synchronized void start() {
            if(!running){
                running = true;
                super.start();
            }
        }

        @Override
        public synchronized void stop() {
            if(running){
                running = false;
            }
            super.stop();
        }

        public boolean isRunning() {
            return running;
        }
    }


    protected CreatureSprite sprite;
    private String name;
    protected BattleField bf;
    protected int x = -1;
    protected int y = -1;
    private volatile boolean moving = false;
    protected int hp;
    protected int maxhp;
    protected int power = 10;
    protected FightingAnimationTimer fightingTimer = new FightingAnimationTimer();
    protected boolean alive = true;

    public CreatureSprite getSprite() {
        return sprite;
    }

    public String getCreatureName() {
        return name;
    }

    protected Creature(Image image, String name) {
        this.sprite = new CreatureSprite(image);
        this.name = name;
    }

    public void moveTo(int newX,int newY){
        if(moving){
            return;
        }

        boolean successful = false;
        boolean newHere = (this.x<0||this.y<0);
        if(newHere){
            successful = bf.enter(this,newX,newY);
        }else{
            successful = bf.moveTo(this,newX,newY,this.x,this.y);
        }
        if(successful){
            if(!newHere){

                moving = true;

                final int xOldPixel = this.x*Main.UNIT_LENGTH;
                final int yOldPixel = this.y*Main.UNIT_LENGTH;
                final boolean selected = (bf.getCurrentSelectCreature()==this);
                new AnimationTimer() {
                    private final long startTime = System.nanoTime();
                    final int xDstPixel = newX*Main.UNIT_LENGTH;
                    final int yDstPixel = newY*Main.UNIT_LENGTH;
                    final int xDeltaPixel = (xDstPixel>xOldPixel?1:(xDstPixel==xOldPixel?0:-1));
                    final int yDeltaPixel = (yDstPixel>yOldPixel?1:(yDstPixel==yOldPixel?0:-1));

                    private boolean isArrived(int x,int y ){
                        boolean xArrived,yArrived;
                        if(xDeltaPixel == 0){
                            xArrived = true;
                        }else if(xDeltaPixel<0){
                            xArrived = (x<=xDstPixel);
                        }else{
                            xArrived = (x>=xDstPixel);
                        }
                        if(yDeltaPixel == 0){
                            yArrived = true;
                        }else if(yDeltaPixel<0){
                            yArrived = (y<= yDstPixel);
                        }else{
                            yArrived = (y>=yDstPixel);
                        }
                        return xArrived&&yArrived;
                    }

                    @Override
                    public void handle(long now) {

                        if(isArrived(sprite.getXPixel(),sprite.getYPixel())){
                            Platform.runLater(()->{
                                sprite.moveToByPixel(xDstPixel, yDstPixel);
                                if(selected){
                                    bf.getBfs().getOutline().moveToByPixel(xDstPixel,yDstPixel);
                                }
                                moving = false;
                            });
                            this.stop();
                        }else{
                            int deltaTime = (int)((now-startTime)/5000000);
                            Platform.runLater(()->{
                                sprite.moveToByPixel(xOldPixel+deltaTime* xDeltaPixel,yOldPixel+deltaTime* yDeltaPixel);
                                if(selected){
                                    bf.getBfs().getOutline().moveToByPixel(xOldPixel+deltaTime* xDeltaPixel,yOldPixel+deltaTime* yDeltaPixel);
                                }
                            });
                        }
                    }
                }.start();
            }else {
                sprite.moveToByUnit(newX,newY);
            }
            this.x = newX;
            this.y = newY;
        }
    }

    public void enterBattleField(BattleField bf,int x,int y){
        this.bf = bf;
        moveTo(x,y);
    }

    public void moveUp(){
        moveTo(x,y-1);
    }

    public void moveDown(){
        moveTo(x,y+1);
    }

    public void moveLeft(){
        moveTo(x-1,y);
    }

    public void moveRight(){
        moveTo(x+1,y);
    }

    protected abstract int getEnemyNum(Creature[] creatures);

    protected synchronized void setFightAnimationStatus(boolean enable){
        if(enable){
            if(!fightingTimer.isRunning()){
                fightingTimer.start();
            }
        }else{
            if(fightingTimer.isRunning()){
                fightingTimer.stop();
                Platform.runLater(()->{sprite.getProfileImage().setRotate(0);});
            }
        }
    }

    public synchronized boolean isMoving(){
        return moving;
    }

    public void decreaseHp(Creature creature,int n){
        int newHp = hp - n;
        hp = newHp>0?newHp:0;
        Platform.runLater(()->{sprite.setHp(hp,maxhp);});
        if(hp==0){
            becomeDead();
            Main.getUnc().show(creature.getCreatureName()+" 击败 "+this.getCreatureName());
        }
    }

    private void becomeDead(){
        bf.getOutOfField(this,x,y);
        alive = false;
        sprite.becomeDead();
        bf.deselectCurrentSelectCreature(this);
        bf.getBfs().toBack();
    }
    public double getPixelX(){
        return x*Main.UNIT_LENGTH;
    }
    public double getPixelY(){
        return y*Main.UNIT_LENGTH;
    }

}
