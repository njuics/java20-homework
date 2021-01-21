package cn.edu.nju.HuLuWa;
import java.util.ArrayList;

public class BattleField <T extends Creature>{
    private final ArrayList <ArrayList<T>> grid = new ArrayList<>();
    private Class<T> kind;
    private int rowNumInit = 3;
    private int columnNumInit = 40;
    public BattleField(Class<T> kind) {
        this.kind = kind;
        for(int i = 0; i< rowNumInit; i++){
            addColumn();
        }
    }
    public BattleField(Class<T> kind,int row,int column){
        rowNumInit = row;
        columnNumInit = column;
        this.kind = kind;
        for(int i = 0; i< rowNumInit; i++){
            addColumn();
        }
    }
    public void addColumn(){
        ArrayList<T> newColumn = new ArrayList<>();
        try {
            for(int i = 0; i< columnNumInit; i++){
                    int rowIndex = grid.size();
                    T c = kind.newInstance();
                    c.setPos(rowIndex,i);
                    newColumn.add(c);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        grid.add(newColumn);
    }
    public  void  set(int row,int column, T c){
        ArrayList<T> array = grid.get(row);
        array.set(column,c);
        c.setPos(row,column);
    }
    public Creature get(int row,int column){
        ArrayList<T> array = grid.get(row);
        return array.get(column);
    }
    public ArrayList<T> get(int row){
        return grid.get(row);
    }
    public int getRowNum(){
        return grid.size();
    }
    public void clear(){
        for(int i = 0;i<rowNumInit;i++){
            clear(i);
        }
    }
    public void clear(int column){
        ArrayList<T> array = grid.get(column);
        for(T c:array){
            c.clear();
        }
    }
    public ArrayList<T> getSpecieArray(int row,int specie){
        ArrayList<T> rowArray = grid.get(row);
        ArrayList<T> array = new ArrayList<>();
        for(T c:rowArray){
            if(c.specie == specie){
                array.add(c);
            }
        }
        return array;
    }
}
