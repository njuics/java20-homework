package cn.edu.nju.hw3;
public class HuluBrother extends Human {
    private int rank;
    String skill1="haven't learned anything";
    String skill2="haven't learned anything";


    int get_rank()
    {
        return rank;
    }
    HuluBrother(String s,int i)
    {
        name=s;
        rank=i;
    }

    public void intro()
    {
        Speaksth("My name is "+name);
    }

    public void Self_sort(World w,int i)
    {
        //向队伍前侧交换直到左侧没人或者小于自身
        if(i==0)
            return;
        else if(w.hulu[i-1].rank>w.hulu[i].rank)
        {
            w.Swap2boy(i-1, i);
            Self_sort(w,i-1);
        }
    }

    void Learn(String a,String b)
    {
        skill1=a;
        skill2=b;
    }

    @Override
    public void Attack()
    {
       if(skill1=="haven't learned anything")
            System.out.println(name+" "+skill1);
        else
            System.out.println(name+" uses a normal attack "+skill1);

    }

    @Override
    public void Ultra()
    {
       if(skill2=="haven't learned anything")
            System.out.println(name+" "+skill2);
        else
            System.out.println(name+" uses an ultra attack "+skill2);

    }

    @Override
    public void Attack(Human h)
    {
       if(skill1=="haven't learned anything")
            System.out.println(name+" "+skill1);
        else
            System.out.println(name+" uses a normal attack "+skill1+" to "+h.get_name());

    }

    @Override
    public void Ultra(Human h)
    {
       if(skill2=="haven't learned anything")
            System.out.println(name+" "+skill2);
        else
            System.out.println(name+" uses an ultra attack "+skill2+" to "+h.get_name());
            
    }

}
