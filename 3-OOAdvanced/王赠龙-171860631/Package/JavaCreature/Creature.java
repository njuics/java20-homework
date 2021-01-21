package Package.JavaCreature;
class Creature {
    protected int position=-1;
    protected String name;
    Creature(String tempName){
        name=tempName;
    }
    public void setPosition(int tempPosition){
        position=tempPosition;
    }
    public int getPosition(){
        return position;
    }
}
