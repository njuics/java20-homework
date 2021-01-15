package java作业9_Testing;
import java.util.*;
import java.util.Random;

public class Huluwa extends Creature{
    //String name;葫芦娃名字
    //boolean sex;true表示男，false表示女
    //int pos;Position位置

    int range;//葫芦娃的排行,原先的老大至老七
    static int num=7;//初始有7个葫芦娃，后面随着葫芦娃的生成而增加
    Huluwa(){
        num++;
        Random g=new Random();
        this.pos=-1;
        this.range=num;
        this.sex=g.nextBoolean();//随机生成性别
        this.name=getRandomString();//随机生成姓名
    }
    Huluwa(int range){
        this.range=range;
        this.pos=-1;
        switch(range){
            case 1:name="1brother";break;
            case 2:name="2brother";break;
            case 3:name="3brother";break;
            case 4:name="4brother";break;
            case 5:name="5brother";break;
            case 6:name="6brother";break;
            case 7:name="7brother";break;
            default:break;
        }

        Random g=new Random();
        this.sex=g.nextBoolean();//随机生成性别
    }
    static String getRandomString(){//随机生成葫芦娃的名字
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<8;i++){//葫芦娃的姓名为8个字符
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();

    }


}
