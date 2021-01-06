import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Set set=new HashSet<>();
        for(int i=0;i<10;++i){
            set.add(new Huluwa());
        }
        ArrayList<Huluwa> huluwas=new ArrayList<Huluwa>();
        ArrayList<Huluwa> male=new ArrayList<Huluwa>();
        ArrayList<Huluwa> female=new ArrayList<Huluwa>();
        Iterator it=set.iterator();
        while(it.hasNext()){
            Object obj=it.next();
            if(obj.getClass().equals(Huluwa.class)){
                Huluwa h=(Huluwa)obj;
                huluwas.add(h);
                if(h.getSex()){
                    male.add(h);
                }
                else{
                    female.add(h);
                }
            }
        }
        Sort sort=new Sort();
        Main m=new Main();
        sort.sort(huluwas);
        m.print(huluwas);
        /*其余的排序都在这里，是类似的
        sort.reverseSort(huluwas);
        m.print(huluwas);
        sort.sort(male);
        m.print(male);
        sort.sort(female);
        m.print(female);
        */
    }
    public void print(ArrayList<Huluwa> huluwas){
        Iterator<Huluwa> it=huluwas.iterator();
        while(it.hasNext()){
            Huluwa h=it.next();
            System.out.println(h.getName()+" "+(h.getSex()?"male":"female"));
        }
    }
}
