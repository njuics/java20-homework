import java.util.ArrayList;

public class SortMethod1 {
    public void selfSort(ArrayList<Calabash> list){
        for(int i=0;i<6;i++){
            for(int j=i+1;j<7;j++){
                if(list.get(i).observe(list.get(j))){
                    list.get(i).exchange(list.get(j));
                    Calabash temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }

    public void grandpaSort(ArrayList<Calabash> list){
        for(int i=0;i<6;i++){
            for(int j=i+1;j<7;j++){
                if(Grandpa.observe(list.get(i),list.get(j))){
                    Grandpa.exchange(list.get(i),list.get(j));
                    Calabash temp=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
}
