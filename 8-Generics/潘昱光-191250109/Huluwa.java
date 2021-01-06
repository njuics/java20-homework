public class Huluwa<T extends Ability> implements Comparable<Huluwa> {
    private String name;
    private T ability;
    Huluwa(){
        name=null;
        ability=null;
    }
    Huluwa(String name,T ability){
        this.name=name;
        this.ability=ability;
    }

    public String getName(){
        return name;
    }
    public T getAbility(){
        return ability;
    }

    @Override
    public int compareTo(Huluwa o) {
        return this.ability.getLevel()-o.getAbility().getLevel();
    }

}