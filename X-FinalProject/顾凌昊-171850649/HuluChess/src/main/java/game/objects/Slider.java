package game.objects;

import game.template.GameObject;
import javafx.scene.canvas.GraphicsContext;

public class Slider extends GameObject {

    public int value;
    public int maxValue, minValue;

    public void setValue(int v){

        value = v;

        if(value<minValue) value = minValue;
        if(value>maxValue) value = maxValue;

    }


    public Slider(int w, int h) {
        super(w, h);
    }

    public void draw(GraphicsContext gc) {

    }

    public void update() {

    }
}
