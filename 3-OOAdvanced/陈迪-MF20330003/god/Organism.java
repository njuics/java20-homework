package god;
public class Organism {
    private int alive = 1;
    public void set_dead(){
        this.alive = 0;
    }
    public int is_alive(){
        return this.alive;
    }
}
