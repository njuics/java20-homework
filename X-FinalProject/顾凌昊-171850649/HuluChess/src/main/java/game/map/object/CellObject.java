package game.map.object;

import com.sun.javafx.geom.Vec2d;
import game.Settings;
import game.map.data.CellData;
import game.template.GameObject;
import game.utils.Vec2Int;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CellObject extends GameObject {

    CellData cellData;

    public Vec2Int location;

    public Color color = Color.WHITE;


    public CellObject(int w, int h) {
        super(w, h);
    }


    public void draw(GraphicsContext gc) {
        gc.save();
        gc.setFill(Color.WHITE);

        Vec2d position = getWorldPosition();
        gc.fillRect(position.x + Settings.CELL_GAP, position.y+ Settings.CELL_GAP, width -Settings.CELL_GAP*2,height -Settings.CELL_GAP*2);

        gc.restore();
    }

    public void update() {

    }
}
