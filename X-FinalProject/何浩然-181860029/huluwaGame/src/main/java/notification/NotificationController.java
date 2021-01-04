package notification;

import javafx.scene.Group;
import javafx.scene.text.Text;

public abstract class NotificationController {
    protected Text text = new Text();
    protected int unitLength;
    protected int widthUnit;
    protected int heightUnit;

    public abstract void show(String word);

    public void draw(Group root,int unitLength,int widthUnit,int heightUnit){
        root.getChildren().add(text);
        this.unitLength = unitLength;
        this.widthUnit = widthUnit;
        this.heightUnit = heightUnit;
        afterDrawingText(root);
    }

    protected abstract void afterDrawingText(Group root);
}
