import java.util.*;
//import java.util.Random;
class Huluwa{//葫芦娃
    String name;
    boolean sex;//true表示男，false表示女
    int range;//葫芦娃的排行,原先的老大至老七
    Huluwa(){
        Random g=new Random();
        this.sex=g.nextBoolean();//随机生成性别
        this.name=getRandomString();//随机生成姓名
    }
    Huluwa(int range){
        this.range=range;
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
    static String getRandomString(){
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
