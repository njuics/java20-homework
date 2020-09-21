import java.util.Random;


public class World {
    final int HULU_NUM=7;
    public static void main(String[] args) throws Exception {
      

        World w=new World();

        w.Shuffle();
        System.out.println("Orchestration...");
        w.Orchestration();
        w.Self_intro();
        System.out.println("Sorted by grandpa.");

        w.Shuffle();      
        System.out.println("Choreography...");
        w.Choreography();
        w.Self_intro();
        System.out.println("Sorted by themselves.");
    }
    Grandpa gp;
    HuluBrother[] hulu;
    String[] names={"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    World()
    {
        gp=new Grandpa();
        hulu=new HuluBrother[HULU_NUM];
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i]=new HuluBrother(names[i],i);
        }
    }
    void Self_intro()
    {
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i].intro();
        }
    }

    void Swap2boy(int a,int b)
    {
        if (a==b) return;
        HuluBrother temp= hulu[a];
        hulu[a]=hulu[b];
        hulu[b]=temp;
    }

    void Shuffle()
    {
        for(int i=0;i<100;i++)
        {
          Random r1=new Random();
          int a=r1.nextInt(7);
          int b=r1.nextInt(7);
          Swap2boy(a, b);
        }
        System.out.println("HuluBrothers shuffled. Number off!");
        Self_intro();
    }

    void Orchestration()
    {
        gp.Sort(this);
    }

    void Choreography()
    {
        //sort by themselves
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i].Self_sort(this, i);
        }
    }
}
