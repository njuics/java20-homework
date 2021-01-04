package creature;

import app.Main;
import field.BattleField;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.image.Image;
import ui.FireSkillSprite;
import ui.ImageLoader;

import java.util.Random;

public class SnakeWoman extends PCCreature{
    private SnakeWoman(Image image , String name) {
        super(image, name);
    }

    private static SnakeWoman sw;
    public static SnakeWoman getInstance(){
        if(sw == null){
            synchronized (SnakeWoman.class){
                if(sw == null){
                    sw = new SnakeWoman(ImageLoader.getImage("SnakeWoman"),"蛇精");
                }
            }
        }
        return sw;
    }

    private FireSkillSprite fss = new FireSkillSprite(this);
    private AnimationTimer fireTimer = new AnimationTimer() {
        @Override
        public void start() {
            startTime = System.nanoTime();
            super.start();
        }

        private long startTime;
        @Override
        public void handle(long now) {
            long angle = ((now-startTime)/40000000)%180;
            fss.setAngle(angle);
            if(angle%2==0){
                bf.checkSkillEffect(angle);
            }
            if(Math.abs(angle-180)<3){
                stopSkill();
            }
        }
    };

    @Override
    public void run() {
        int num = 0;
        Random random = new Random(47);
        while (alive){
            try {
                Thread.sleep(500);
                num++;
                if(num == 40&&Main.getType()== Main.GameType.PLAY&&true){
                    startSkill();
                    Main.hasSnakeWomanStartSkill();
                    num = 0;
                }

                Creature[] nearbyCreatures = bf.getNearbyCreatures(this.x,this.y);
                int nearbyEnemyNum = getEnemyNum(nearbyCreatures);

                if(!fightingTimer.isRunning()&&nearbyEnemyNum>0){
                    setFightAnimationStatus(true);
                }else if(fightingTimer.isRunning()&&nearbyEnemyNum==0){
                    setFightAnimationStatus(false);
                }

                if(nearbyEnemyNum>0){
                    for(Creature creature:nearbyCreatures){
                        if(creature instanceof PlayerCreature){
                            creature.decreaseHp(this,power/nearbyEnemyNum);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fightingTimer.stop();
    }

    public FireSkillSprite getFss() {
        return fss;
    }

    public void startSkill(){
        //show
        Platform.runLater(()->{
            fss.getFireImage().toFront();
            sprite.getProfileImage().toFront();
            sprite.getHpBar().toFront();
        });
        //start
        fireTimer.start();
    }

    public void stopSkill(){
        fireTimer.stop();
        fss.hide();
    }

    private BattleField bf;

    public void setBf(BattleField bf) {
        this.bf = bf;
    }
}
