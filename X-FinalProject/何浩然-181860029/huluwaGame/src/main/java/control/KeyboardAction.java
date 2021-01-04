package control;
import javafx.scene.input.KeyCode;
public class KeyboardAction extends Action{
    private KeyCode code;
    public KeyboardAction(long time,KeyCode code) {
        super(time);
        this.code = code;
    }
    public KeyCode getCode() {
        return code;
    }
    @Override
    public String getType() {
        return "KEYBOARD";
    }
}
