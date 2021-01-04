package creature;

import javafx.scene.image.Image;
import ui.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Minion extends PCCreature {
    private Minion(Image image, String name) {
        super(image, name);
    }
    public static final int TOTAL_NUM = 6;
    private static List<Minion> minions = new ArrayList<>();
    static {
        for (int i = 0; i < TOTAL_NUM; i++) {
            minions.add(null);
        }
    }
    public static Minion getInstance(int index){
        if(minions.get(index-1)==null){
            minions.set(index-1,new Minion(ImageLoader.getImage("Minion"),String.format("喽啰%d",index)));
        }
        return minions.get(index-1);
    }

}
