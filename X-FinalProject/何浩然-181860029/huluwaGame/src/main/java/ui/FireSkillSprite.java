package ui;

import app.Main;
import creature.Creature;
import creature.SnakeWoman;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class FireSkillSprite {

    private Creature creature;
    public ImageView getFireImage() {
        return fireImage;
    }
    private ImageView fireImage = new ImageView(ImageLoader.getImage("Fire"));

    public FireSkillSprite(Creature creature){
        this.creature = creature;
        fireImage.setFitWidth(10);
    }

    //Used in setAngle(),pre-calculating for efficiency
    private static final double mainHeightPixel = Main.HEIGHT_UNIT*Main.UNIT_LENGTH;
    private static final double mainWidthPixelMinusHalfUnit = Main.WIDTH_UNIT*Main.UNIT_LENGTH - Main.UNIT_LENGTH/2;

    public void setAngle(double angle){


        Platform.runLater(()->{
            double radian = (angle*Math.PI)/180;
            fireImage.setRotate(-angle);
            if(angle<=90){
                fireImage.setFitHeight((mainHeightPixel)/(2*Math.cos(radian)));
                fireImage.setX(mainWidthPixelMinusHalfUnit -(Math.tan(radian))*mainHeightPixel/4);
                fireImage.setY(mainHeightPixel*0.25-fireImage.getFitHeight()/2);
            }else{
                radian=Math.PI - radian;
                fireImage.setFitHeight((mainHeightPixel)/(2*Math.cos(radian)));
                fireImage.setX(mainWidthPixelMinusHalfUnit -(Math.tan(radian))*mainHeightPixel/4);
                fireImage.setY(mainHeightPixel*0.75-fireImage.getFitHeight()/2);
            }
        });
    }

    public void hide(){
        Platform.runLater(()->{
            fireImage.setRotate(0);
            fireImage.setX(-100);
        });
    }


}
