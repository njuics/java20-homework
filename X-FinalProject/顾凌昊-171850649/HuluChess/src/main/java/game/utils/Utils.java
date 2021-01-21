package game.utils;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

public class Utils {

    public static Image getImage(String add){
        Image img = null;

        String str = Utils.class.getClassLoader().getResource(add).getFile();

        try {
            FileInputStream file = new FileInputStream(new File(str));
            img = new Image(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(str);



        return img;
    }
}
