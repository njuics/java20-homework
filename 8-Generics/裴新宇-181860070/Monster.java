
public class Monster extends Creature{
    // protected String name;
    private int health;
    private int damage;
    public Monster() {
        super();
        this.health = -1;
        this.damage = -1;
    }
    public Monster(String name,int health,int damage) {
        super(name);
        this.health = health;
        this.damage = damage;
    }
    public int get_health(){
        return this.health;
    }
    public void set_health(int health){
        this.health = health;
    }
    public int get_damage(){
        return this.damage;
    }
    public void set_damage(int damage){
        this.damage = damage;
    }
}