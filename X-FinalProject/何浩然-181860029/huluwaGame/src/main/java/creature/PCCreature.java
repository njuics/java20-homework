package creature;

import javafx.application.Platform;
import javafx.scene.image.Image;

public class PCCreature extends  Creature {
    protected PCCreature(Image image, String name) {
        super(image, name);
        maxhp = 150;
        hp = maxhp;
    }
    @Override
    protected int getEnemyNum(Creature[] creatures) {
        int num = 0;
        for(Creature creature:creatures){
            if(creature instanceof PlayerCreature){
                num ++;
            }
        }
        return num;
    }
    @Override
    public void run() {
        int num = 0;
        while (alive){
            try {
                Thread.sleep(500);
                num++;
                if(num >= 2){
                    num = 0;
                    Platform.runLater(()->{moveLeft();});
                }

                Creature[] nearbyCreatures = bf.getNearbyCreatures(this.x,this.y);
                int nearbyEnemyNum = getEnemyNum(nearbyCreatures);

                if(!fightingTimer.isRunning()&&nearbyEnemyNum>0){
                    setFightAnimationStatus(true);
                }else if(fightingTimer.isRunning()&& nearbyEnemyNum==0){
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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fightingTimer.stop();

    }
}
