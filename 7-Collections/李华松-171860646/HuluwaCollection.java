import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class HuluwaCollection implements Iterable<Huluwa> {
    private ArrayList<Huluwa> huluwas = new ArrayList<>();
    private int huluwaLength = 30;


    HuluwaCollection() {
        for (int i = 0; i < huluwaLength; i++) {
            huluwas.add(new Huluwa());
        }
    }

    public int size() {
        return huluwaLength;
    }
    //
    public Iterator<Huluwa> iterator() {
        return huluwas.iterator();
    }
    //降序排列
    public void sortByDes() {
        Collections.sort(huluwas);
    }
    //乱序
    public void shffule(){
        Collections.shuffle(huluwas);
    }
    //升序
    public void sortByAsc() {
        Collections.sort(huluwas, new Comparator<Huluwa>(){
            @Override
            public int compare(Huluwa a,Huluwa b){
                return b.getName().compareTo(a.getName());
            }
        });
    }
    //按照性别分成两列后升序
    public void sortByGender(){
        Collections.sort(huluwas, new Comparator<Huluwa>(){
            @Override
            public int compare(Huluwa a,Huluwa b){
                return a.getGender().compareTo(b.getGender()) | a.getName().compareTo(b.getName());
          
            }
        });
    }
}
