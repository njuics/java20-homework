package game.character.data;

import game.utils.Utils;
import javafx.scene.image.Image;

public class CharacterData {

    //角色编号
    public int id;

    //生命值及其上限
    public int maxHP, HP;

    //名称
    public String name;

    //射程
    public int baseFireRange, baseNoFireRange;

    //攻击、防御值
    public int baseAttack, baseDefense;

    //阵营，分为葫芦娃、妖精两类
    public enum Fraction { Huluwa, Monster};
    public Fraction fraction;

    //图片
    public Image image;

    public CharacterData(){}

    public CharacterData(int i, String n, Image img, Fraction f){
        id = i;
        name = n;
        image = img;
        fraction = f;
    }

    public static CharacterData Grandpa = new CharacterData(

            0,
            "葫芦爷爷",
            Utils.getImage("grandpa.png"),
            Fraction.Huluwa
    );

    public static CharacterData Monster = new CharacterData(
            1,
            "青蛇精",
            Utils.getImage("monster.png"),
            Fraction.Monster
    );

}
