import java.util.Random;


public class World {
    final int HULU_NUM=7;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        World w=new World();

        w.Self_intro();


        w.Shuffle();
        System.out.println("Shuffle() done!");
        w.Self_intro();

        System.out.println("Self_intro done!");
        w.Orchestration();
        w.Self_intro();
        System.out.println("Sorted by grandpa");
    }

    Grandpa gp;
    HuluBrother[] hulu;
    String[] names={"dawa","erwa","sanwa","siwa","wuwa","liuwa","qiwa"};
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
    }

    void Orchestration()
    {
        gp.Sort(this);
    }

    void Choreography()
    {
        //sort by themselves
    }
}
