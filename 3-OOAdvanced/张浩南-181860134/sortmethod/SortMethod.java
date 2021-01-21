package sortmethod;


import hulubro.*;
import java.util.Random;
public interface SortMethod{
    public default void randomShuffle(HuluBro[] huluBro)
    {
        Random seed=new Random();
        for (int j,i=1;i<HuluBro.count;++i)
        {
            j=seed.nextInt(i+1);
            huluBro[i].swap(huluBro[j]);
        }
    }
    //public void swap(HuluBro a,HuluBro b);
    //public boolean compare(HuluBro a,HuluBro b);
    public void sort(HuluBro[] huluBro);
    public default void call(HuluBro[] huluBro)
    {
        for (int i=0;i<HuluBro.count;++i)
            huluBro[i].call();
    }
}
