package mycode.hw7;
import java.util.Random;

//import sortmethod.*;

public class Grandpa extends Human {

   int HULU_NUM;
    Grandpa(int i)
    {
        name ="爷爷";
        HULU_NUM=i;
    }
    

    @Override
    public void Speaksth(String str)
    {
        System.out.println(name+":"+str);

    }


    void Sort(World w)
    {
        for(int i=0;i<HULU_NUM-1;i++)
        {
            for(int j=0;j<HULU_NUM-1-i;j++)
            {
                if(w.hulu.get(j).get_rank()>w.hulu.get(j+1).get_rank()){
                     w.Swap2boy(j, j+1);
                }
            }
        }
    }

    public void Shuffle(World w)
    {
        for(int i=0;i<100;i++)
        {
          Random r1=new Random();
          int a=r1.nextInt(7);
          int b=r1.nextInt(7);
          w.Swap2boy(a, b);
        }
        Speaksth("打乱葫芦娃顺序.下面报数.");
        w.Self_intro();
    }
}
