import java.util.Random;
public class Monster extends Creature{
    private int damage;
    Monster(){
        super();
        Random r=new Random();
        damage=r.nextInt(10);
    }
    Monster(String Name,Gender sex,int d){
        super(Name, sex);
        if(d>0){
            damage=d;
        }
        else {
            Random r=new Random();
            damage=r.nextInt(10);
        }
    }
    public int get_damage(){
        return damage;
    }
    @Override
    public void printInformation(){
        System.out.println("Monster Name:"+super.getName()+" Gender:"+super.getGender()+" Damage:"+damage);
    }
}