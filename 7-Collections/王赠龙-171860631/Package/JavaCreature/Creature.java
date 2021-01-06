package Package.JavaCreature;
abstract class Creature {
    protected int position=-1;
    protected String name;

    public abstract  void setPosition(int tempPosition);
    public int getPosition(){
        return position;
    }
}
