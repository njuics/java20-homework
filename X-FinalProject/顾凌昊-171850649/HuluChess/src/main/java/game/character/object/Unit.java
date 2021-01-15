package game.character.object;

import game.template.GameObject;
import game.character.data.CharacterData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;

public class Unit extends GameObject {

    public int maxHP, HP;

    //名称
    public String name;

    //射程、禁止射击距离
    public int fireRange, noFireRange;

    //攻击、防御值
    public int attack, defense;

    //阵营，分为葫芦娃、妖精两类
    public CharacterData.Fraction fraction;

    //图片
    public Image image;

    //**************************************** ui组件 ****************************************

    public Unit(int w, int h) {
        super(w, h);
    }


    //**************************************** 方法 ****************************************
    public void Unit(){}

    public void Unit(CharacterData cd){
        init(cd);
    }

    public void init(CharacterData cd){

        maxHP = cd.maxHP;
        HP = maxHP;

        name = cd.name;

        fireRange = cd.baseFireRange;
        noFireRange = cd.baseNoFireRange;

        attack = cd.baseAttack;
        defense = cd.baseDefense;

        fraction = cd.fraction;

        this.image = cd.image;
    }

    public void changeHP(int delta){

        HP+=delta;

        if(HP<0) HP = 0;
        if(HP >maxHP) HP = maxHP;

    }

    public boolean isAlive(){
        return HP > 0;
    }


    public void draw(GraphicsContext gc) {

        gc.save();

        if(image == null){
            gc.fillRect(getWorldPosition().x, getWorldPosition().y, width, height);
        }else{
            gc.drawImage(image, getWorldPosition().x, getWorldPosition().y, width, height);
        }

        gc.restore();
    }

    public void update() {

    }
}
