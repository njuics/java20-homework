package cn.edu.nju.java;

import java.util.ArrayList;

public class CalabashBrothers extends Being{
    static int count;
    int rank;
    Sort_orchestration sorting;
    static {
        count=0;
    }
    CalabashBrothers()
    {
        rank=0;
        this.name="";
        sorting=new Sort_orchestration();
        count++;
    }
    CalabashBrothers(String name,int age)
    {
        this.name=name;
        this.rank=age;
        sorting=new Sort_orchestration();
        count++;
        System.out.println("count="+count);
    }
    String get_name()
    {
        return this.name;
    }
    public void Sort(ArrayList<CalabashBrothers> brothers)
    {
        sorting.Sort_wisdom(brothers,rank);
    }
   public int getRank()
    {
        return rank;
    }
    public boolean compare(CalabashBrothers a)
    {
        if(a.getRank()>this.rank)
            return true;
        return false;
    }
    void swap(ArrayList<CalabashBrothers> brothers,int my,int position)
    {
        CalabashBrothers tmp= brothers.get(position);
        brothers.set(position, this);
        brothers.set(my,tmp);
    }
}
