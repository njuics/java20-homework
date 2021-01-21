package cn.edu.nju.kecheng.java.advancedoop;

public class GrandPa extends Man{
    GrandPa(){
        super("GrandPa",-1);
    }

    private void exchangeLoc(HuLuBro[] grid,int i,int j){
        HuLuBro temp=grid[i];
        grid[i]=grid[j];
        grid[j]=temp;
        grid[i].setLoc(i);
        grid[j].setLoc(j);
    }
    public void brosSort(HuLuBro[] bros){
        for(int i=0;i<bros.length;i++){
            int minIndex=i;
            for(int j=i;j<bros.length;j++){
                if(bros[j].getColorByRank()<bros[minIndex].getColorByRank())minIndex=j;
            }
            exchangeLoc(bros,i,minIndex);
        }
    }
}
