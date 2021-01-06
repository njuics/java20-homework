package mycode.hw7;
import java.util.*;

//import javax.swing.text.Style;
public class HuluBrother extends Human implements Comparable<HuluBrother> {
    
    private int rank;
    String skill1="haven't learned anything";
    String skill2="haven't learned anything";

    @Override
    public int compareTo(HuluBrother h)
    {
        return rank;
    }

    int get_rank()
    {
        return rank;
    }
    HuluBrother(String s,int i)
    {
        name=s;
        rank=i;
        gender=Gender.unknown;
    }

    HuluBrother(String s,int i,Gender g)
    {
        name=s;
        rank=i;
        gender = g;
    }


    public void intro()
    {
        Speaksth("My name is "+name+" rank "+rank);
    }

    public void Self_sort(World w,int i)
    {
        //向队伍前侧交换直到左侧没人或者小于自身
        if(i==0)
            return;
        else if(w.hulu.get(i-1).rank>w.hulu.get(i).rank)
        {
            w.Swap2boy(i-1, i);
            Self_sort(w,i-1);
        }
    }

    public void Self_sort_alphabet_new(World w,int i)
    {
        if(i==0)
            return;
        else 
        {
            String name1=w.hulu.get(i-1).name;

            String name2=w.hulu.get(i).name;
          //  System.out.println(name1+"  "+name2);

            List<String> list=new ArrayList<>();
            list.add(name1);
            
            list.add(name2);
           // System.out.println(list);
            Collections.sort(list);
            //System.out.println(list);
            Boolean bigger=(name1==list.get(0));
         //   System.out.println(bigger==false);
            if(!bigger){
            w.Swap2boy(i-1, i);
            Self_sort_alphabet_new(w,i-1);
            }
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
