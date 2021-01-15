final public class GrandPa extends Creature{
    
    private String name;

    GrandPa() {
        this.name = "grandpa";
    }

    @Override
    public String get_name() {
        return this.name;
    }

    @Override
    public int walk() {
        return 0;
    }
}
