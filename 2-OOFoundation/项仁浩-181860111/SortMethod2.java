import java.util.ArrayList;

public class SortMethod2 extends SortMethod1{
    @Override
    public void selfSort(ArrayList<Calabash> list){
        for(int i=0;i<6;i++){
            int prioIndex=i;
            for(int j=i+1;j<7;j++){
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

    @Override
    public void grandpaSort(ArrayList<Calabash> list){
        for(int i=0;i<6;i++){
            int prioIndex=i;
            for(int j=i+1;j<7;j++){
                if(Grandpa.observe(list.get(prioIndex),list.get(j)))
                    prioIndex=j;
            }
            if(prioIndex!=i){
                Grandpa.exchange(list.get(i),list.get(prioIndex));
                Calabash temp=list.get(i);
                list.set(i,list.get(prioIndex));
                list.set(prioIndex,temp);
            }
        }
    }
}
