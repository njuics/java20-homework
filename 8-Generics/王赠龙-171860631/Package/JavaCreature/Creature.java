package Package.JavaCreature;
public  class Creature {
    protected int position=-1;
    protected String name;

    public void setPosition(int tempPosition){
        position=tempPosition;
    }
    public int getPosition(){
        return position;
    }
    public String getName(){return this.name;}
}
