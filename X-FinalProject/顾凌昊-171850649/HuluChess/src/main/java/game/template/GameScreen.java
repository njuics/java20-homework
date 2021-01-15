package game.template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends Canvas {


    private List<GameObject> mObjects = new ArrayList<GameObject>();

    private Timeline timeline;
    private KeyFrame keyFrame;
    private int duration = 10;


    public GameScreen(double width, double height) {
        super(width, height);
        initTimeLine();

        start();
    }


    public void addObject(GameObject baseObject){
        this.mObjects.add(baseObject);
    }


    public void removeObject(GameObject baseObject){
        this.mObjects.remove(baseObject);
    }


    public void removeObjectAtIndex(int index){
        this.mObjects.remove(index);
    }


    public void draw(GraphicsContext gc){
        gc.clearRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < mObjects.size(); i++) {
            GameObject wObject = mObjects.get(i);
            if (wObject.visible) {
                wObject.draw(gc);
            }
        }
    }


    public void update(){
        for (int i = 0; i < mObjects.size(); i++) {
            GameObject wObject = mObjects.get(i);
            if (wObject.update) {
                mObjects.get(i).update();
            }
        }
    }

    /**
     * init the timeline
     */
    private void initTimeLine() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                draw(getGraphicsContext2D());
                update();
            }
        });
        timeline.getKeyFrames().add(keyFrame);
    }

    /**
     * start the update timeline
     */
    public void start(){
        timeline.play();
    }

    /**
     * pause the update timeline
     */
    public void pause(){
        timeline.pause();
    }

    /**
     * stop the update timeline
     */
    public void stop(){
        timeline.stop();
    }



}
