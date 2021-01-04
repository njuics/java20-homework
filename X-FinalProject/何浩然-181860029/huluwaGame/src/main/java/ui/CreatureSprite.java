package ui;

import app.Main;
import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreatureSprite {
    public ImageView getProfileImage() {
        return profileImage;
    }
    public ProgressBar getHpBar() {
        return hpBar;
    }

    private ImageView profileImage;
    private ProgressBar hpBar;
    private int xPixel, yPixel;

    public static int UNIT_LENGTH = Main.UNIT_LENGTH;
    private final double hpBarWidth = UNIT_LENGTH*0.8;

    public CreatureSprite(Image image){
        profileImage = new ImageView();
        profileImage.setImage(image);
        profileImage.setFitWidth(UNIT_LENGTH);
        profileImage.setFitHeight(UNIT_LENGTH);

        hpBar = new ProgressBar();
        hpBar.setPrefWidth(hpBarWidth);
        hpBar.setProgress(1.0);
    }

    public void moveToByPixel(int x,int y){
        Platform.runLater(()->{
            profileImage.setX(x);
            profileImage.setY(y);
            hpBar.setTranslateX(x+(UNIT_LENGTH-hpBarWidth)/2);
            hpBar.setTranslateY(y);

            this.xPixel = x;
            this.yPixel = y;
        });
    }

    public void moveToByUnit(int x,int y){
        moveToByPixel(x*UNIT_LENGTH,y*UNIT_LENGTH);
    }

    public void setHp(int hpValue,int hpMaxValue){
        Platform.runLater(()->{
            hpBar.setProgress((double)hpValue/(double)hpMaxValue);
        });
    }

    public int getXPixel() {
        return xPixel;
    }

    public int getYPixel() {
        return yPixel;
    }

    public int getXUnit(){
        return xPixel/UNIT_LENGTH;
    }

    public int getYUnit(){
        return yPixel/UNIT_LENGTH;
    }

    public void becomeDead(){
        Platform.runLater(()->{
            hpBar.setTranslateX(-2*UNIT_LENGTH);
            hpBar.setTranslateY(-2*UNIT_LENGTH);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-1);
            profileImage.setEffect(colorAdjust);

            profileImage.toBack();
        });
    }
}
