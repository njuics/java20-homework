import java.util.*;
public class Monster extends Creature {
    private String type;
    private int attack;
    public Monster(){
        type = "Monster";
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=rand.nextInt(62);
            sb.append(str.charAt(number));
        }
        name = sb.toString();
        gender = rand.nextBoolean();
        attack = rand.nextInt(7)*100;
    }

    @Override
    public String toString(){
        return "Type: "+type+" Name: "+name+" Gender: "+(gender?"Male":"Female")+" Attack: "+attack;
    }
}