package nju.zjl.cvs.client;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import nju.zjl.cvs.game.Constants;
import nju.zjl.cvs.game.Drawable;
import nju.zjl.cvs.game.ItemManager;


public class DrawController implements Runnable{
    public DrawController(ItemManager items, Canvas canvas){
        this.items = items;
        this.canvas = canvas;
    }

    @Override
    public void run(){
        while(!gameOver)try{
            Platform.runLater(() -> {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                Stream.of(items.getCreatures()).forEach(c ->c.draw(gc));
                Stream.of(items.getAffectors()).forEach(c -> {
                    if(c instanceof Drawable){
                        ((Drawable)c).draw(gc);
                    }
                });
            });
            TimeUnit.MILLISECONDS.sleep(1000 / Constants.FPS);
        }catch(InterruptedException exception){
            exception.printStackTrace();
        }
    }

    public void terminate(){
        gameOver = true;
    }

    protected boolean gameOver = false;
    protected ItemManager items;
    protected Canvas canvas;
}
