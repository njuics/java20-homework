package cn.edu.nju.HuLuWa;
public class BattleField {
    public Creature[] grid;
    private int max  = 20;
    BattleField() {
        grid = new Creature[max];
        for(int i=0;i<max;i++){
            grid[i] = new Creature();
        }
    }
    public int getMax(){
        return max;
    }
}
