public class World {
    final int HULU_NUM=7;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        World w=new World();

        w.Self_intro();
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
}
