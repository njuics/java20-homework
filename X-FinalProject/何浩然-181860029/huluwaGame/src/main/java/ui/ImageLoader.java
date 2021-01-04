package ui;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
    private ImageLoader(){}
    private static Map<String, Image>  images = new HashMap<>();
    public static Image getImage(String name){
        if(!images.containsKey(name)){
            String fileName;
            switch (name){
                case "Calabash1":fileName = "1.png";break;
                case "Calabash2":fileName = "2.png";break;
                case "Calabash3":fileName = "3.png";break;
                case "Calabash4":fileName = "4.png";break;
                case "Calabash5":fileName = "5.png";break;
                case "Calabash6":fileName = "6.png";break;
                case "Calabash7":fileName = "7.png";break;
                case "GrandFather":fileName = "grandfather.png";break;
                case "SnakeWoman":fileName = "snake.png";break;
                case "ScorpionMan":fileName = "scorpion.png";break;
                case "Minion":fileName = "minion.png";break;
                case "Fire":fileName = "fire.jpg";break;
                case "DarkGrass":fileName = "grass_dark.png";break;
                case "LightGrass":fileName = "grass_light.png";break;
                case "CreatureSelect":fileName = "select.png";break;
                case "NotificationBackground":fileName = "intro.png";break;
                default:throw new RuntimeException("Invalid image name.");
            }
            images.put(name,new Image(fileName));
        }
        return images.get(name);
    }
}
