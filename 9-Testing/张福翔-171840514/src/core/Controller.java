package core;

import creature.Grandpa;
import environment.PlayGround;

public class Controller {
    PlayGround playGround = new PlayGround();
    public Controller() {
    }
    public void runDemoHW8() {
        int huluNums = 10;
        for (int i = 0; i < huluNums; i++) {
            playGround.addRandomHuluBaby();
        }
        Grandpa grandpa = playGround.getGrandpa();
        grandpa.checkCreaturesInPlayGround(playGround.getCreatures());
    }
}
