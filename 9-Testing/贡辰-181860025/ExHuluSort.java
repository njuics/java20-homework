import java.util.Scanner;

import hulupacket.*;

abstract class hulusort
{

    int size;
    HuluColor[] trans={HuluColor.Red,HuluColor.Orange,HuluColor.Yellow,
            HuluColor.Green,HuluColor.Cyan,HuluColor.Blue,HuluColor.Purple};
    posqueue<HuLuWa> HuLuQueue;
    public hulusort()
    { }
    public hulusort(int size,int[] seed)
    {
        this.size=size;
        HuLuQueue=new posqueue(size);
        for (int i=0;i<size;i++)
            HuLuQueue.modify(i,new HuLuWa(trans[seed[i]]));
    }
    public abstract void sort();

    public final void print()
    {
        for (int i=0;i<size;i++)
            System.out.print(HuLuQueue.get(i).getname()+' ');
        System.out.println();
    }
}

class orchestration extends hulusort
{
    public orchestration(int size,int[] seed)
    {
        this.size=size;
        System.out.println("1");
        HuLuQueue=new posqueue(size);
        System.out.println("1");
        for (int i=0;i<size;i++)
            HuLuQueue.modify(i,new HuLuWa(trans[seed[i]]));
    }
    public void sort()
    {
        for (int times=0;times<size;times++)
        {
            for (int i = 0; i < size; i++)
                if (!(HuLuQueue.get(i).right(HuLuQueue)))
                {
                    HuLuQueue.get(i).getright(i,HuLuQueue);
                    break;
                }
        }
    }
}


class choreography extends hulusort
{
    private Grandpa g;
    public choreography(int size,int[] seed)
    {
        this.size=size;
        HuLuQueue=new posqueue(size);
        for (int i=0;i<size;i++)
            HuLuQueue.modify(i,new HuLuWa(trans[seed[i]]));
        g=new Grandpa();
    }
    public void sort()
    {
        g.gsort(HuLuQueue);
    }
}


public class ExHuluSort
{
    public static void main(String args[])
    {
        int size=7;
        int[] mylist=new int[size];
        System.out.println("Please input seed:");
        Scanner input = new Scanner(System.in);
        for (int i=0;i<size;i++)
            mylist[i]=input.nextInt();


        orchestration task1=new orchestration(size,mylist);
        System.out.println("Orchestration");
        System.out.println("Initial queue:");
        task1.print();
        task1.sort();
        System.out.println("Sorted queue:");
        task1.print();
        System.out.println("=============================");

        choreography task2=new choreography(size,mylist);
        System.out.println("choreography");
        System.out.println("Initial queue:");
        task2.print();
        task2.sort();
        System.out.println("Sorted queue:");
        task2.print();

        //System.out.println(1);
    }
}


