public class Monster extends Creature{
    Monster(){
        super();
    }

    @Override
    public String toString(){
        return "<Monster>|"+super.toString();
    }
}
