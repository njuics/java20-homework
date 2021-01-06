public class Creature {
    int specie;
    int pos;
    Creature(){
        specie = -1;
        pos = -1;
    }
    public void clear(){
        specie = -1;
        pos = -1;
    }
    public void setPos(int pos){
        this.pos = pos;
    }
}
