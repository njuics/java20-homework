package cn.edu.nju.HuLuWa;
public class Creature implements Action, Comparable  {
    protected int specie;
    protected int rowPos;
    protected int columnPos;
    protected int ID;
    protected int gender;
    protected String name;
    static private int count;
    static{
        count = 0;
    }
    Creature(){
        gender = -1;
        specie = -1;
        rowPos = -1;
        columnPos = -1;
        ID = count++;
        name = "";
    }
    public void setPos(int row,int column){
        rowPos = row;
        columnPos = column;
    }
    public void walkTo(BattleField<Creature> battleField,int row,int column){
        if(hasMobility()){
            Creature c  = battleField.get(row,column);
            battleField.set(rowPos,columnPos,c);
            battleField.set(row,column,this);
        }
    }
    public int compareTo(Object o) {
        if(o instanceof Creature){
            return this.name.compareTo(((Creature) o).name);
        }
        System.out.println("Warning: Creature compare to an Object not Creature!");
        return 0;
    }
    public void clear(){
        gender = -1;
        specie = -1;
        name = "";
    }
    public void tellName(){
        if(hasMobility()) {
            System.out.print(name + " ");
        }
    }
    public boolean hasMobility(){
        if(specie == -1){
            return false;
        }
        return true;
    }
    public boolean isHuLuWa(){
        return specie == 1;
    }
    public boolean isBoy(){
        return gender == 1;
    }
    public boolean isGirl(){
        return gender == 0;
    }
}
