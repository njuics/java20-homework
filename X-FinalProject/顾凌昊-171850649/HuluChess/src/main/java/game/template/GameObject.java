package game.template;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject{

    public int width, height;

    private GameObject parent = null;
    private List<GameObject> children = new ArrayList<GameObject>();

    private Vec2d localPosition, worldPosition;

    public boolean visible;

    public boolean update;

    public GameObject(int w, int h){
        width = w;
        height = h;

        visible = true;
        update = true;

        localPosition = new Vec2d();
        worldPosition = new Vec2d();
    }

    public List<GameObject> getChildren(){
        return children;
    }

    public GameObject getParent(){
        return parent;
    }

    public Vec2d getLocalPosition(){ return localPosition; }
    public Vec2d getWorldPosition(){ return worldPosition; }

    public void  setLocalPosition(Vec2d pos){
        localPosition = pos;
        if(parent == null){
            worldPosition = localPosition;
        }else{
            worldPosition = new Vec2d(parent.getWorldPosition().x+localPosition.x, parent.getWorldPosition().y+localPosition.y);
        }

        for(GameObject child : children){
            child.setLocalPosition(child.getLocalPosition());
        }
    }

    public void setWorldPosition(Vec2d pos){
        worldPosition = pos;
        if(parent == null){
            localPosition = worldPosition;
        }else{
            localPosition = new Vec2d(parent.getWorldPosition().x-worldPosition.x, parent.getWorldPosition().y - worldPosition.y);

        }

        for(GameObject child : children){
            child.setLocalPosition(child.getLocalPosition());
        }
    }

    public void addChild(GameObject obj){
        children.add(obj);
        obj.parent = this;


    }

    public abstract void draw(GraphicsContext gc);

    public abstract void update();

}
