package creature.monster;

import creature.Creature;

public class Monster extends Creature {
    private int health;
    private int damage;
    
    public Monster(String name, int health, int damage) {
        super(name);
        this.health = health;
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void reset(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void reset(Monster c){
        reset(c.name, c.health, c.damage);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof Monster){
            Monster test = (Monster)obj;
            if(test.health == this.health && test.name == this.name && test.damage == this.damage) return true;
            else return false;
        }
        return false;
    }
} 