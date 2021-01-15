package hulusort;
import sortimplement.*;
import sortmethod.*;
import hulubro.*;
//封装or 包，继承
public class HuluSort{
    HuluBro huluBro[]=new HuluBro[HuluBro.count];
    void run(SortMethod sortMethod)
    {
        sortMethod.randomShuffle(huluBro);
        sortMethod.sort(huluBro);
        sortMethod.call(huluBro);
    }
    void initialize()
    {
        for (int i=0;i<HuluBro.count;++i)
            huluBro[i]=new HuluBro(i);
    }
    
    public static void main(String[] args)
    {
        HuluSort huluSort=new HuluSort();
        huluSort.initialize();
        huluSort.run(SortImplement.getOrchestration());
        huluSort.run(SortImplement.getChoreography());
        return;
    }
}