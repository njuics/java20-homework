package game.character.object;

import game.character.data.CharacterData;
import game.template.GameObject;
import game.utils.Vec2Int;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Chess extends GameObject {

    //阵营，分为葫芦娃、妖精两类
    public CharacterData.Fraction fraction;

    //图片
    public Image image;

    public Vec2Int location;

    //状态：分为两种，0：平移一格；1：跳跃
    public int status = 0;


    public Chess(int w, int h) {
        super(w, h);
    }

    @Override
    public void draw(GraphicsContext gc) {

        gc.save();

        if(fraction == CharacterData.Fraction.Huluwa){

            if(status == 0){
                gc.setFill(Color.ALICEBLUE);

            }else{
                gc.setFill(Color.LIGHTBLUE);

            }


        }else{
            if(status == 0){
                gc.setFill(Color.ORANGE);
            }else{
                gc.setFill(Color.ORANGERED);

            }

        }

        gc.fillOval(getWorldPosition().x+5, getWorldPosition().y+5, width-10,height-10);

        if(status == 0){
            gc.strokeOval(getWorldPosition().x +5, getWorldPosition().y+5, width-10,height-10);
        }else{

        }

        gc.restore();

        gc.drawImage(image, getWorldPosition().x+5, getWorldPosition().y+5,width-10,height-10);
    }

    @Override
    public void update() {

    }

    public void Unit(CharacterData cd){
        init(cd, 0);
    }

    public void init(CharacterData cd, int s){

        fraction = cd.fraction;

        this.image = cd.image;

        status = s;
    }
}
