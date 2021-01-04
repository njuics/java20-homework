package ui;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class SelectOutlineSprite {
    private ImageView selectOutline = new ImageView(ImageLoader.getImage("CreatureSelect"));
    private int length;

    public ImageView getSelectOutline() {
        return selectOutline;
    }
    public void setLength(int length){
        Platform.runLater(()->{
            selectOutline.setFitWidth(length);
            selectOutline.setFitHeight(length);

            this.length = length;
        });
    }

    public void moveToByUnit(int x, int y){
        Platform.runLater(()->{
            selectOutline.setX(x*length);
            selectOutline.setY(y*length);
        });
    }

    public void moveToByPixel(int x,int y){
        Platform.runLater(()->{
            selectOutline.setX(x);
            selectOutline.setY(y);
        });
    }

}
