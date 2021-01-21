package cn.edu.nju.java;

import java.util.ArrayList;

public class SortCommand {
    public void choreography(ArrayList<CalabashBrothers> brothers)
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
                if(brothers.get(j).getRank()==i)
                    brothers.get(j).Sort(brothers);
        }
    }
    public void orchestration(GrandFather grandpa, ArrayList<CalabashBrothers> brothers)
    {
        grandpa.Sort(brothers);
    }

}
