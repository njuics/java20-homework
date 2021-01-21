package sort;
import human.*;

public class AnotherSort extends Sort implements SortWay{
    public void orchestration(Hulu []hulu, Grandpa g){
        for (int i=1; i<Hulu.count; ++i)
        {	
            Hulu tmp = hulu[i];
            while (i > 0 && g.cmp(hulu[i - 1],tmp))
            {
                hulu[i] = hulu[i - 1];
                i = i - 1;
            }
            hulu[i] = tmp; 
        }
    }
    public void choreography(Hulu []hulu){
        for (int i=1; i<Hulu.count; ++i)
        {	
            Hulu tmp = hulu[i];
            while (i > 0 && hulu[i - 1].getRank()>tmp.getRank())
            {
                hulu[i] = hulu[i - 1];
                i = i - 1;
            }
            hulu[i] = tmp; 
        }
    }
}
