package cn.edu.nju;
import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;
public class CalabashBoy extends Creature {
    private String type;
    private int ability;
    public CalabashBoy(){
        type = "CalabashBoy";
        // String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // StringBuffer sb=new StringBuffer();
        // for(int i=0;i<10;i++){
        //     int number=rand.nextInt(62);
        //     sb.append(str.charAt(number));
        // }
        // name = sb.toString();
        name = RandomStringUtils.randomAlphabetic(10);
        Random rand=new Random();
        gender = rand.nextBoolean();
        ability = rand.nextInt(7);
    }

    @Override
    public String toString(){
        return "Type: "+type+" Name: "+name+" Gender: "+(gender?"Male":"Female")+" Ability: "+ability;
    }

}