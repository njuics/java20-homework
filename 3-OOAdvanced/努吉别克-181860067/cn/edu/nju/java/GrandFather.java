package cn.edu.nju.java;

import java.util.ArrayList;

public class GrandFather extends Being{
    Sort_choreography sort_calabash;
    GrandFather()
    {
        name="爷爷";
        sort_calabash=new Sort_choreography();
    }
    public void Sort(ArrayList<CalabashBrothers> brothers)
    {
        sort_calabash.Sort_wisdom(brothers,0);
    }

}
