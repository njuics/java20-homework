package cn.edu.nju.HuLuWa;
import java.util.ArrayList;

public class BattleField {
    public ArrayList <ArrayList<Creature>> grid = new ArrayList<>();
    private int rowNumInit = 3;
    private int columnNumInit = 40;
    BattleField() {
        for(int i = 0; i< rowNumInit; i++){
            addColumn();
        }
    }
    public void addColumn(){
        ArrayList<Creature> newColumn = new ArrayList<Creature>();
        for(int i = 0; i< columnNumInit; i++){
            int rowIndex = grid.size();
            newColumn.add(new Creature(rowIndex,i));
        }
        grid.add(newColumn);
    }
    public void set(int row,int column, Creature c){
        ArrayList<Creature> array = grid.get(row);
        array.set(column,c);
        c.setPos(row,column);
    }
    public Creature get(int row,int column){
        ArrayList<Creature> array = grid.get(row);
        return array.get(column);
    }
    public ArrayList<Creature> get(int row){
        return grid.get(row);
    }
    public int getRowNum(){
        return grid.size();
    }
}
