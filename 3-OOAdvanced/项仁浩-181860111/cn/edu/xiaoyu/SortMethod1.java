package cn.edu.xiaoyu;

import java.util.ArrayList;

public class SortMethod1 extends SortMethod{
    public void choreography(ArrayList<Calabash> list){
        for(int i=0;i<SortMethod.NUM-1;i++){
            for(int j=i+1;j<SortMethod.NUM;j++){
                if(list.get(i).observe(list.get(j))){
                    list.get(i).exchange(list.get(j));
                    Calabash temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }

    public void orchestration(Grandpa g,ArrayList<Calabash> list){
        for(int i=0;i<SortMethod.NUM-1;i++){
            for(int j=i+1;j<SortMethod.NUM;j++){
                if(g.observe(list.get(i),list.get(j))){
                    g.exchange(list.get(i),list.get(j));
                    Calabash temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
}
