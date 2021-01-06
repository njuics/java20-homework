public class Grandpa {
    final int HULU_NUM=7;
    void Sort(World w)
    {
        for(int i=0;i<HULU_NUM-1;i++)
        {
            for(int j=0;j<HULU_NUM-1-i;j++)
            {
                if(w.hulu[j].rank>w.hulu[j+1].rank){
                     HuluBrother temp= w.hulu[j];
                     w.hulu[j]=w.hulu[j+1];
                     w.hulu[j+1]=temp;
                }
            }
        }
    }
}
