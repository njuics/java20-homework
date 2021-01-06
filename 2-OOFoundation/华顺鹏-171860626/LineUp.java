import java.util.Scanner;

class HuLu{
    private String color;
    private int rank;
    private int id;
    HuLu(){}
    void initialize(String s,int nowrank)
    {
        switch (s)
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
        rank=nowrank;
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

    public String tellId(){
        switch (id)
        {
            case 1:return new String("老大");
            case 2:return new String("老二");
            case 3:return new String("老三");
            case 4:return new String("老四");
            case 5:return new String("老五");
            case 6:return new String("老六");
            case 7:return new String("老七");
            default:return new String("可没这个葫芦娃");
        }
    }
    public int communicate(HuLu brother){
        System.out.println();
        System.out.println("交流开始");
        System.out.println(this.tellId()+":兄弟你好，我是"+this.tellId());
        System.out.println(brother.tellId()+":兄弟你好，我是"+brother.tellId());
        if(this.getId()<brother.getId())
        {
            System.out.println(this.tellId()+":我比你大我排在你前面，我两排的队没问题");
            System.out.println("交流结束");
            System.out.println();
            return 1;
        }
        else
        {
            System.out.println(this.tellId()+":我比你小但我排在你前面，那我们交换个顺序吧");
            swap(brother);
            System.out.println("交换完成");
            System.out.println("交流结束");
            System.out.println();
            return 2;
        }
    }
    public void swap(HuLu brother){   //行为上交换位置
        int tmp=brother.getRank();
        brother.changeRank(this.rank);
        this.rank=tmp;
    }

}

class Grandpa {
    private String name;
    Grandpa()
    {
        name=new String("爷爷");
    }
    public String getName() {
        return name;
    }
    public int arrange(HuLu hulu1,HuLu hulu2)
    {
        System.out.println();
        System.out.println(this.getName()+":我是爷爷，我开始调整队伍");
        if(hulu1.getId()<hulu2.getId())
        {
            System.out.println(this.getName()+":"+hulu1.tellId()+"和"+hulu2.tellId()+"你们两兄弟的站位很好，暂时不需要调整");
            System.out.println("本次调整完成");
            System.out.println();
            return 1;
        }
        else
        {
            System.out.println(this.getName()+":"+hulu1.tellId()+"和"+hulu2.tellId()+"你们两兄弟的站位错了，你们交换一下顺序吧");
            hulu1.swap(hulu2);
            System.out.println("交换完成");
            System.out.println("本次调整完成");
            System.out.println();
            return 2;
        }
    }

}
public class LineUp {
    public static void main(String[] args)
    {
        System.out.println("请输入葫芦七兄弟的初始队形,形式：老大 老二 ...");
        Scanner input=new Scanner(System.in);
        String str=new String();
        str=input.nextLine();
        String[] huluranks=str.split("\\s+");
        HuLu[] hulubro=new HuLu[huluranks.length];
        Grandpa grandpa=new Grandpa();
        for(int i=0;i<huluranks.length;i++)
        {
            hulubro[i]=new HuLu();
            hulubro[i].initialize(huluranks[i],i+1);
        }
        for(int i=0;i<hulubro.length-1;i++)
        {
            for(int j=hulubro.length-2;j>=i;j--)
            {
                //sort 1,orchestration
                int ret=grandpa.arrange(hulubro[j],hulubro[j+1]);

                //sort 2 ,choreography
                //int ret=hulubro[j].communicate(hulubro[j+1]);
                if(ret==2)
                {
                    HuLu tmp=hulubro[j];
                    hulubro[j]=hulubro[j+1];
                    hulubro[j+1]=tmp;
                }
            }
        }
        System.out.println();
        System.out.println("队伍整理结束,开始报数：");
        for(int i=0;i<hulubro.length;i++) {
            System.out.print(hulubro[i].tellId());
            System.out.print(" ");
        }
    }

}


