package cn.edu.xiaoyu;

import java.util.ArrayList;

public class SortMethod2 extends SortMethod{
    public void choreography(ArrayList<Calabash> list){
        for(int i=0;i<SortMethod.NUM-1;i++){
            int prioIndex=i;
            for(int j=i+1;j<SortMethod.NUM;j++){
                if(list.get(prioIndex).observe(list.get(j)))
                    prioIndex=j;
            }
            if(prioIndex!=i){
                list.get(i).exchange(list.get(prioIndex));
                Calabash temp=list.get(i);
                list.set(i,list.get(prioIndex));
                list.set(prioIndex,temp);
            }
        }
    }

    public void orchestration(Grandpa g,ArrayList<Calabash> list){
        for(int i=0;i<SortMethod.NUM-1;i++){
            int prioIndex=i;
            for(int j=i+1;j<SortMethod.NUM;j++){
                if(g.observe(list.get(prioIndex),list.get(j)))
                    prioIndex=j;
            }
            if(prioIndex!=i){
                g.exchange(list.get(i),list.get(prioIndex));
                Calabash temp=list.get(i);
                list.set(i,list.get(prioIndex));
                list.set(prioIndex,temp);
            }
        }
    }
}
