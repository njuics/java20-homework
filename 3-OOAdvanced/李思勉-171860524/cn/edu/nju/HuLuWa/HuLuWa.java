package cn.edu.nju.HuLuWa;
public class HuLuWa extends Creature implements Action{
    private int rank;
    private String chineseRank;
    HuLuWa(int rank){
        setRank(rank);
        this.specie = 1;
    }

    public void setRank(int rank){
        String [] chineseRankList = {"老大","老二","老三","老四","老五","老六","老七"};
        this.rank = rank;
        this.chineseRank = chineseRankList[rank];
    }
    public int getRank(){
        return rank;
    }
    public void tellRank(){
        System.out.println(this.chineseRank);
        // System.out.println(ID);
    }
    public void walkTo(BattleField battleField,int pos){
        battleField.grid[this.pos] = battleField.grid[pos];
        battleField.grid[this.pos].pos = this.pos;
        battleField.grid[pos] = this;
        this.pos = pos;
    }
    public int findFrontPos(BattleField battleField){
        if(rank==0){
            return 0;
        }
        for (Creature c:battleField.grid){
            if(c.specie==1){
                HuLuWa huLuWa = (HuLuWa) c;
                if(huLuWa.rank==rank-1){
                    return huLuWa.pos;
                }
            }
        }
        return -1;
    }
}
