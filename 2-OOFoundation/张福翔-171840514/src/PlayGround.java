import java.util.Arrays;
import java.util.Collections;

public class PlayGround {
    HuluBaby[] hulus;
    PlayGround() {
        System.out.println("Initialize playground randomly with 7 HuluBaby...");
        hulus = new HuluBaby[7];
        for (int i = 0; i < hulus.length; i++) {
            hulus[i] = new HuluBaby(HuluBaby.HuluName.values()[i]);
        }
        shuffleHuluBaby();
        hulusGreeting();
        System.out.println("Initialization finished");
    }

    public HuluBaby[] getHulus() {
        return hulus;
    }

    public void shuffleHuluBaby() {
        Collections.shuffle(Arrays.asList(hulus));
    }
    public void hulusGreeting() {
        for (int i = 0; i < hulus.length; i++) {
            hulus[i].greet();
        }
    }
}
