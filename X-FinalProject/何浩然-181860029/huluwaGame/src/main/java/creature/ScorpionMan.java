package creature;

import javafx.scene.image.Image;
import ui.ImageLoader;

public class ScorpionMan extends PCCreature {
     private ScorpionMan(Image image, String name) {
        super(image, name);
    }
    private static ScorpionMan sm;
     public static ScorpionMan getInstance(){
         if(sm==null){
             synchronized (ScorpionMan.class){
                 if(sm == null){
                     sm = new ScorpionMan(ImageLoader.getImage("ScorpionMan"),"蝎子精");
                 }
             }
         }
         return sm;
     }

}
