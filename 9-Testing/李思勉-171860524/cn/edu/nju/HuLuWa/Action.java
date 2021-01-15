package cn.edu.nju.HuLuWa;

public interface Action {
    void walkTo(BattleField<Creature> battleField,int row, int column);
    void tellName();
}
