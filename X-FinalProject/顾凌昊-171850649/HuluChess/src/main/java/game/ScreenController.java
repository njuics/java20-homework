package game;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenController{

    private HashMap<String, Pane> screenMap = new HashMap<String, Pane>();
    private Scene main;

    public static ScreenController instance;

    public static ScreenController getInstance(){
        if(instance == null){

            instance = new ScreenController();
        }

        return instance;
    }

    public ScreenController(){}

    /*public ScreenController(Scene main) {
        this.main = main;
    }*/

    public void setScene(Scene s){
        main = s;
    }

    public void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    public void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name){
        main.setRoot(screenMap.get(name));
    }



}
