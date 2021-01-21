package hsp.java.nju;
public class Hulu extends Human{
    private String color; //葫芦娃是有颜色的
    private int rank;   //排队的位置
    private int id;  //兄弟之间的排行
    public Hulu(String namegiven, int nowrank)
    {
        super(namegiven);
        rank=nowrank;
        switch (namegiven)
        {
            case"老大":id=1;color=new String("red");break;
            case"老二":id=2;color=new String("orange");break;
            case"老三":id=3;color=new String("yellow");break;
            case"老四":id=4;color=new String("green");break;
            case"老五":id=5;color=new String("cyan");break;
            case"老六":id=6;color=new String("blue");break;
            case"老七":id=7;color=new String("purple");break;
            default:System.out.println("可没这个葫芦娃");
        }
    }
    public int getId()
    {
        return id;
    }
    public int getRank()
    {
        return rank;
    }
    public void changeRank(int newrank)
    {
        rank=newrank;
    }

    public void swap(Hulu brother){   //行为上交换位置
        int tmp=brother.getRank();
        brother.changeRank(this.rank);
        this.rank=tmp;
    }

    @Override
    public int communicate(Hulu brother) {
        System.out.println();
        System.out.println("交流开始");
        System.out.println(this.getName()+":兄弟你好，我是"+this.getName());
        System.out.println(brother.getName()+":兄弟你好，我是"+brother.getName());
        if(this.getId()<brother.getId())
        {
            System.out.println(this.getName()+":我比你大我排在你前面，我两排的队没问题");
            System.out.println("交流结束");
            System.out.println();
            return 1;
        }
        else
        {
            System.out.println(this.getName()+":我比你小但我排在你前面，那我们交换个顺序吧");
            swap(brother);
            System.out.println("交换完成");
            System.out.println("交流结束");
            System.out.println();
            return 2;
        }
    }
}
