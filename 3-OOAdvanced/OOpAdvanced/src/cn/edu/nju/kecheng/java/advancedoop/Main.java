package cn.edu.nju.kecheng.java.advancedoop;

class OrcSorter implements GridSorter{
    public void gridSort(HuLuBro[] grid){
        GrandPa gp=new GrandPa();
        gp.brosSort(grid);
    }
}

class ChoSorter implements GridSorter{
    public void gridSort(HuLuBro[] grid){
        for(HuLuBro hlb:grid){
            hlb.moveToOrdinal(grid);
        }
    }
}

public class Main {
    static void sort(String sortType,GridSorter sorter,HuLuBro[] grid){
        System.out.println(sortType);
        for(HuLuBro hlb:grid)hlb.shoutSelf();
        sorter.gridSort(grid);
        for(HuLuBro hlb:grid)hlb.shoutSelf();
    }

    static public void main(String[] args){
        HuLuBro[] bros=new HuLuBro[Field.BRO_NUM];
        for(int i=0;i<Field.BRO_NUM;i++)bros[i]=new HuLuBro(Color.values()[i]);

        Field field1=new Field(bros);
        sort("orchestration",new OrcSorter(),field1.grid);

        Field field2=new Field(bros);
        sort("choreography",new ChoSorter(),field2.grid);
    }
}
