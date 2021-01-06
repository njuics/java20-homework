package sortimplement;
import sortmethod.*;
import hulubro.*;
import grandpa.*;
public class SortImplement{
    public static Choreography getChoreography(){return new Choreography();}
    public static Orchestration getOrchestration(){return new Orchestration();}
}
class Orchestration extends Grandpa implements SortMethod {
    static{
        System.out.println("Orchestration has started.");
    }
    @Override
    public void sort(HuluBro[] huluBro)
    {
        for (int i=0;i<HuluBro.count;++i)
        for (int j=HuluBro.count-1;j>i;--j)
            if (lessThan(huluBro[j],huluBro[j-1]))
            swap(huluBro[j],huluBro[j-1]);
    }
}
class Choreography implements SortMethod{
    static{
        System.out.println("Choreography has started.");
    }
    
    @Override
    public void sort(HuluBro[] huluBro)
    {
        for (int i=0;i<HuluBro.count;++i)
        for (int j=HuluBro.count-1;j>i;--j)
            if (huluBro[j].lessThan(huluBro[j-1]))
            huluBro[j].swap(huluBro[j-1]);
    }
}