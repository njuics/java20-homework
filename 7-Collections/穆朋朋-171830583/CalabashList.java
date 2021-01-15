import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CalabashList {
    ArrayList<Calabash> cbList=new ArrayList<>(); // 泛型，防止队伍中混入蝎子精等异类

    public void add(Calabash cb) {
        cbList.add(cb);
    }

    public void outputList() 
    {
        System.out.println("性别\t姓名");
        Iterator<Calabash> it = cbList.iterator();
        while (it.hasNext()) {
            Calabash c= it.next();
            String ganderString="male";
            if(c.getGander()==1) {
                ganderString="female";
            }

            System.out.println(ganderString+"\t"+c.getName());
        }
        System.out.println();
    }

    public void sortByName() {
        Collections.sort(cbList);
    }
    public void sortByNameReverse() {
        ComparatorReverse c=new ComparatorReverse();
        Collections.sort(cbList, c);
    }
    public void sortByNameShuffle() {
        Collections.shuffle(cbList);
    }

    public CalabashList getMaleList() {
        CalabashList maleList=new CalabashList();
        Iterator<Calabash> it=cbList.iterator();
        while (it.hasNext()) {
            Calabash cb=it.next();
            if(cb.getGander()==0) {
                maleList.add(cb);
            }
        }
        return maleList;
    }
    public CalabashList getFemaleList() {
        CalabashList femaleList=new CalabashList();
        Iterator<Calabash> it=cbList.iterator();
        while (it.hasNext()) {
            Calabash cb=it.next();
            if(cb.getGander()==1) {
                femaleList.add(cb);
            }
        }
        return femaleList;
    }
}