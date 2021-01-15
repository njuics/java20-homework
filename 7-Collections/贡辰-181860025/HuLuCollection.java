//import sun.net.www.http.Hurryable;

import java.util.*;

enum HuLuSex
{
    male(0),
    female(1);
    private int value;
    private HuLuSex(int x)
    {
        value=x;
    }
    @Override
    public String toString()
    {
        if (value==0) return "♂";
        else return "♀";
    }
}



class HuLuWa implements Comparable<HuLuWa>
{
    String name;
    HuLuSex sex;
    private String initname()
    {
        Random rand=new Random();
        int length=rand.nextInt(5)+1;
        String str="abcdefghijklnmopqrstuvwxyz" +
                   "ABCDEFGHIJKLNMOPQRSTUVWXYZ" +
                   "0123456789";
        StringBuffer name=new StringBuffer();
        for (int i=0;i<length;i++)
        {
            name.append(str.charAt(rand.nextInt(62)));
        }
        return name.toString();
    }
    private HuLuSex initsex()
    {
        HuLuSex trans[]={HuLuSex.male, HuLuSex.female};
        Random rand=new Random();
        return trans[rand.nextInt(2)];
    }
    public String getname()
    {
        return name;
    }
    public HuLuSex getsex() {return sex;}

    @Override
    public int compareTo(HuLuWa h)
    {
        int tmpcompare=this.name.compareTo(h.name);
        if (tmpcompare<0) return -1;
        if (tmpcompare>0) return 1;
        return 0;
    }

    @Override
    public String toString()
    {
        return this.name+"("+this.sex.toString()+")";
    }

    HuLuWa()
    {
        name=initname();
        sex=initsex();
    }
}

class huluRcomparator implements Comparator<HuLuWa>
{
    @Override
    public int compare(HuLuWa h1,HuLuWa h2)
    {
        int tmpcompare=h1.name.compareTo(h2.name);
        if (tmpcompare<0) return 1;
        if (tmpcompare>0) return -1;
        return 0;
    }
}

public class HuLuCollection
{
    private ArrayList<HuLuWa> hululist=new ArrayList<HuLuWa>();
    /*
    private ArrayList<HuLuWa> malehululist=new ArrayList<HuLuWa>();
    private ArrayList<HuLuWa> femalehululist=new ArrayList<HuLuWa>();
    */

    public void insert(HuLuWa newhulu)
    {
        hululist.add(newhulu);
    }

    HuLuCollection dividebysex(HuLuSex s)
    {
        HuLuCollection tmp=new HuLuCollection();
        for (int i=0;i<hululist.size();i++)
        {
            HuLuWa h=(HuLuWa)hululist.get(i);
            if (h.getsex()==s)
                tmp.insert(h);
        }
        return tmp;
    }

    public void sort(String method)
    {
        System.out.println(method+":");
        if (method == "inverted order")
        {
            huluRcomparator comparator=new huluRcomparator();
            hululist.sort(comparator);
            return;
        }

        if (method == "order")
        {
            Collections.sort(hululist);
            return;
        }

        if (method == "disorder")
        {
            Collections.shuffle(hululist);
            return;
        }
    }

    public void showsort()
    {
        this.Print();
        this.sort("order");
        this.Print();
        this.sort("inverted order");
        this.Print();
        this.sort("disorder");
        this.Print();
        System.out.println();
    }

    public void Print()
    {
        for (int i=0;i<hululist.size();i++)
        {
            HuLuWa h=(HuLuWa)hululist.get(i);
            System.out.print(h.toString()+" ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        HuLuCollection tmpc=new HuLuCollection();
        for (int i=0;i<10;i++)
        {
            HuLuWa tmp=new HuLuWa();
            tmpc.insert(tmp);
        }
        tmpc.showsort();

        HuLuCollection femalec=tmpc.dividebysex(HuLuSex.female);
        System.out.println("divided by female");
        femalec.showsort();

        HuLuCollection malec=tmpc.dividebysex(HuLuSex.male);
        System.out.println("divided by male");
        malec.showsort();
    }



}
