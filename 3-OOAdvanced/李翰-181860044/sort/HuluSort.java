package sort;
import human.*;

public class HuluSort extends Sort implements SortWay{
    public void orchestration(Hulu []hulu, Grandpa g){
        for (int i=0; i < Hulu.count-1; ++i)
            for (int j=0; j < Hulu.count-1-i; ++j)
            {
                if (g.cmp(hulu[j],hulu[j + 1]))
                {
                    g.command(hulu, j, j+1);
                }
            }
    }
    public void choreography(Hulu []hulu){
        for (int i=0; i < Hulu.count-1; ++i)
            for (int j=0; j < Hulu.count-1-i; ++j)
            {
                int otherRank = hulu[j].getOtherRank(hulu[j + 1]);
                if (hulu[j].getRank() > otherRank)
                {
                    hulu[j].exchangePos(hulu[j+1]);
                }
            }
    }
}
