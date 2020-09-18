

public class World {
    final int HULU_NUM=7;

    HuluBrother[] hulu;
    Grandpa gp;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        World w=new World();
        w.Init();
        w.shuffle();
        w.orch();   //sorted by grandpa
        w.choreo(); //by themselves



    }

    void Init()
    {
        System.out.println("hello!");
        String[] hulu_names={"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
        hulu=new HuluBrother[HULU_NUM];
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i]=new HuluBrother(hulu_names[i],i);

        }
        System.out.println("World Initialized. Let the boys introduce themselves.");
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i].Self_intro();
        }
    }
    void Swap2Boys(int a,int b)
    {
        if(a<0||a>=HULU_NUM)
            return;
        if(b<0||b>=HULU_NUM)
            return;
        HuluBrother temp=hulu[a];
        hulu[a]=hulu[b];
    }
    void shuffle()
    {

    }
    void orch()
    {

    }
    void choreo()
    {

    }

}
