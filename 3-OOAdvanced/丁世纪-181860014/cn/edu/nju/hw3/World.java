package cn.edu.nju.hw3;

public class World {
    public static final int HULU_NUM=7;
    public static void main(String[] args) throws Exception {
      

        World w=new World();

        w.test();
    }

    void test()
    {
        this.Shuffle();
        System.out.println("Orchestration...");
        this.Orchestration();
        this.Self_intro();

        this.Shuffle();      
        System.out.println("Choreography...");
        this.Choreography();
        this.Self_intro();
        System.out.println("Sorted by themselves.");

        System.out.println("total population is "+this.gp.population());

       
    }

    void test_attack()
    {
        hulu[0].Attack();
        hulu[0].Learn("亢龙有悔", "飞龙在天");
        hulu[0].Attack();
        hulu[0].Ultra();
        hulu[1].Learn("见龙在田", "潜龙勿用");
        hulu[0].Ultra(hulu[1]);
    }
    Grandpa gp;
    HuluBrother[] hulu;
    String[] names={"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    World()
    {
        gp=new Grandpa(HULU_NUM);
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
        gp.Shuffle(this);
    }

    void Orchestration()
    {
        gp.Sort(this);
        
        gp.Speaksth("Sorted");
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
