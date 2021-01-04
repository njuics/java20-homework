package creature;

import creature.Creature;
import javafx.scene.image.Image;
import ui.ImageLoader;

public class GrandFather extends PlayerCreature {

    private GrandFather(Image image, String name) {
        super(image, name);
    }
    private static GrandFather gf;

    public static GrandFather getInstance() {
        if (gf == null) {
            synchronized (GrandFather.class) {
                if (gf == null) {
                    gf = new GrandFather(ImageLoader.getImage("GrandFather"), "爷爷");
                }
            }
        }
        return gf;
    }
}
