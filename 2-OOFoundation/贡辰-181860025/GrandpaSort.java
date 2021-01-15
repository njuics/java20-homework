import java.util.Scanner;

class HuLuWa
{
    int color;
    int index;

    public HuLuWa(int color,int index)
    {
        this.color=color;
        this.index=index;
    }
    public boolean right()
    {
        return (this.color==this.index);
    }

}
class Grandpa
{
    public void gsort(HuLuWa hulu,HuLuWa[] queue)
    {
        System.out.println(hulu.color+' '+hulu.index);
        if (hulu.color!=hulu.index)
        {
            HuLuWa tmp=queue[hulu.color];
            queue[hulu.color]=hulu;
            queue[hulu.index]=tmp;
            queue[hulu.index].index=hulu.index;
            hulu.index=hulu.color;
        }
    }
}
public class GrandpaSort
{
    HuLuWa[] HuLuQueue;
    int size;
    Grandpa g;
    public GrandpaSort(int size,int[] seed)
    {
        g=new Grandpa();
        this.size=size;
        HuLuQueue=new HuLuWa[size];
        for (int i=0;i<size;i++)
            HuLuQueue[i]=new HuLuWa(seed[i], i);
    }

    public void sort()
    {
        for (int times=0;times<size;times++)
        {
            for (int i = 0; i < size; i++)
                if (!(HuLuQueue[i].right()))
                {
                    System.out.print(i+":"+HuLuQueue[i].color+','+HuLuQueue[i].index+'!');
                    g.gsort(HuLuQueue[i],HuLuQueue);
                    break;
                }
            //this.print();
        }
    }

    public void print()
    {
        String[] str={"老大","老二","老三","老四","老五","老六","老七"};
        for (int i=0;i<size;i++)
            System.out.print(str[HuLuQueue[i].color]+' ');
        System.out.println();
    }

    public static void main(String args[])
    {
        int size=7;
        int[] mylist=new int[size];
        System.out.println("Please input seed:");
        Scanner input = new Scanner(System.in);
        for (int i=0;i<size;i++)
            mylist[i]=input.nextInt();
        GrandpaSort task=new GrandpaSort(size,mylist);
        System.out.println("Initial queue:");
        task.print();
        task.sort();
        System.out.println("Sorted queue:");
        task.print();
        //System.out.println(1);
    }
}


