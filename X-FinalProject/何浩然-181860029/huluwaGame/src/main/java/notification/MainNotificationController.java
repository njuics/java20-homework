package notification;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ui.ImageLoader;

public class MainNotificationController extends NotificationController{
    private ImageView background = new ImageView(ImageLoader.getImage("NotificationBackground"));
    @Override
    public void show(String word) {
        text.setText(word);
        if(word.length()>10){
            showDetail();
        }else{
            showKeyword();
        }
    }

    @Override
    protected void afterDrawingText(Group root) {
        root.getChildren().add(background);
        background.setFitWidth(400);
        background.setFitHeight(300);

        text.setWrappingWidth(400-60);
        text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 25));
        text.setFill(Color.BLACK);
        text.toFront();

        hide();
    }

    public void hide(){
        Platform.runLater(()->{
            text.setY(-background.getFitHeight());
            background.setY(-background.getFitHeight());
        });
    }

    private void showDetail(){
        Platform.runLater(()->{
            background.setFitWidth(400);
            background.setFitHeight(300);

            double x = (widthUnit*unitLength-background.getFitWidth())/2;
            double y = (heightUnit*unitLength-background.getFitHeight())/2;
            background.setX(x);
            background.setY(y);
            text.setX(x+30);
            text.setY(y+60);

            text.setWrappingWidth(400-60);
            text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
            text.setFill(Color.BLACK);
            text.toFront();
        });
    }

    private void showKeyword(){


        Platform.runLater(()->{
            background.setFitWidth(200);
            background.setFitHeight(100);

            double x = (widthUnit*unitLength-background.getFitWidth())/2;
            double y = (heightUnit*unitLength-background.getFitHeight())/2;
            background.setX(x);
            background.setY(y);
            text.setX(x+60);
            text.setY(y+60);

            text.setWrappingWidth(400-60);
            text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 40));
            text.setFill(Color.BLACK);
            text.toFront();
        });
    }
}
