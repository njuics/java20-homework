package creature;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GrandFatherTest {
    //for disable error "Internal graphics not initialized yet"
    JFXPanel jfxPanel = new JFXPanel();

    @Test
    public void grandFatherGetInstance(){
        GrandFather base = GrandFather.getInstance();
        for(int i=0;i<5;i++){
            new Thread(()->{
                GrandFather temp = GrandFather.getInstance();
                assertTrue(temp == base);
            }).start();
        }
    }
}
