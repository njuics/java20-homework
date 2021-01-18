import java.util.*;
//import java.util.Random;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
public class Huluwa extends Creature{
    //String name;葫芦娃名字
    //boolean sex;true表示男，false表示女
    //int pos;Position位置

    int range;//葫芦娃的排行,原先的老大至老七
    int year;//葫芦娃的年纪
    static int num=7;//初始有7个葫芦娃，后面随着葫芦娃的生成而增加
    Huluwa(){
        num++;
        //Random g=new Random();
        this.pos=-1;
        this.range=num;
        this.year=RandomUtils.nextInt()%10+1;//重写
        this.sex=RandomUtils.nextBoolean();//重写，随机生成性别
        //this.sex=g.nextBoolean();//随机生成性别
        this.name=RandomStringUtils.random(8, "abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");//重写，利用RandomStringUtils.random()随机生成葫芦娃的名字
        //this.name=getRandomString();//随机生成姓名
    }
    Huluwa(int range){
        this.range=range;
        this.pos=-1;
        switch(range){
            case 1:name="1brother";year= 20;break;
            case 2:name="2brother";year= 19;break;
            case 3:name="3brother";year= 18;break;
            case 4:name="4brother";year= 17;break;
            case 5:name="5brother";year= 16;break;
            case 6:name="6brother";year= 15;break;
            case 7:name="7brother";year= 14;break;
            default:break;
        }

        //Random g=new Random();
        //this.sex=g.nextBoolean();//随机生成性别
        this.sex=RandomUtils.nextBoolean();//重写，随机生成性别
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

