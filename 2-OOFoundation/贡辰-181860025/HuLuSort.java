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
    public void hulusort(HuLuWa[] queue)
    {
        //System.out.print('!');
        if (this.index!=this.color)
        {
            //System.out.print('?');
            HuLuWa tmp=queue[this.color];
            queue[this.color]=this;
            queue[this.index]=tmp;
            queue[this.index].index=this.index;
            this.index=this.color;
        }
    }
}
public class HuLuSort
{
    HuLuWa[] HuLuQueue;
    int size;

    public HuLuSort(int size,int[] seed)
    {
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
                    //System.out.print(i+":"+HuLuQueue[i].color+','+HuLuQueue[i].index+'!');
                    HuLuQueue[i].hulusort(HuLuQueue);
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
        HuLuSort task=new HuLuSort(size,mylist);
        System.out.println("Initial queue:");
        task.print();
        task.sort();
        System.out.println("Sorted queue:");
        task.print();
        //System.out.println(1);
    }
}


