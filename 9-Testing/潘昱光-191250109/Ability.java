public class Ability {
    private String name;
    private int level;
    Ability(){
        name=null;
        level=0;
    }
    Ability(String abilityName,int level){
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
