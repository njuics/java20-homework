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
        String[] hulu_names={"文件","编辑","选择","查看","转到","运行","终端"};
        hulu=new HuluBrother[HULU_NUM];
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i]=new HuluBrother(hulu_names[i],i);

        }
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
