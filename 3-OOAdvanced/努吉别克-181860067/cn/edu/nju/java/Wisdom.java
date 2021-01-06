package cn.edu.nju.java;

import java.util.ArrayList;

 interface Wisdom {
    public abstract void Sort_wisdom(ArrayList<CalabashBrothers> brothers,int pos);
}

//grandpa
class Sort_orchestration implements Wisdom{
   @Override
    public void Sort_wisdom(ArrayList<CalabashBrothers> brothers,int pos)
   {
       int position=0;
       for(int i=0;i<7;i++)
       {
           int tmp_rank= brothers.get(i).getRank();
           if(tmp_rank==pos)
           {
               position=i;
               break;
           }
       }
            for(int i=0;i<7;i++)
            {
                int tmp_rank= brothers.get(i).getRank();
                if(tmp_rank!=pos)
                {
                    boolean big=brothers.get(position).compare(brothers.get(i));
                    if(big==true)
                        brothers.get(position).swap(brothers,position,i);
                }
            }
    }
}

//calabash
class Sort_choreography implements Wisdom{
    @Override
    public void Sort_wisdom(ArrayList<CalabashBrothers> brothers,int pos)
    {
        for(int i=0;i<7;i++)
        {
            for(int j=i;j<7;j++)
            {
                boolean big=brothers.get(i).compare(brothers.get(j));
                if(big!=true)
                    brothers.get(i).swap(brothers,i,j);
            }
        }
    }
}



