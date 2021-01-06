public class Calabash extends Creature {
    Calabash(){
        super();
    }

    Calabash(String name){
        super(name);
    }

    @Override
    public String toString(){
        return "<Calabash>|"+super.toString();
    }
}
