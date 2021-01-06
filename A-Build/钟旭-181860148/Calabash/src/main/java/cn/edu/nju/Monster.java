package cn.edu.nju;



public class Monster extends  Creature {
    private int damage;
    private int health;
    Monster(){
        super();
        this.damage=1;
        this.health=10;
    }

    Monster(String name){
        super(name);
    }

    Monster(int d, int h){
        super();
        this.damage=d;
        this.health=h;
    }

    Monster(String s,int d, int h){
        super();
        this.name = s;
        this.damage = d;
        this.health = h;
    }
    
    
}
