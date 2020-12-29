package huluwa.ability;
public class Ability {
    private String name;
    private int level;
    public Ability(){
        name=null;
        level=0;
    }
    public Ability(String abilityName,int level){
        this.name=abilityName;
        this.level=level;
    }
    public int getLevel(){
        return level;
    }
    public String getAbilityName(){
        return name;
    }
}
