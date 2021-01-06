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
    public void walkTo(BattleField<Creature> battleField,int row,int column){}
    public int compareTo(Object o) {
        if(o instanceof Creature){
            return this.name.compareTo(((Creature) o).name);
        }
        System.out.println("Warning: Creature compare to an Object not Creature!");
        return 0;
    }
}
