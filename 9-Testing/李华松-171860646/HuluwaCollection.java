import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class HuluwaCollection implements Iterable<Huluwa> {
    private ArrayList<Huluwa> huluses = new ArrayList<>();
    private int huluwaLength = 30;


    HuluwaCollection() {
        for (int i = 0; i < huluwaLength; i++) {
            huluses.add(new Huluwa());
        }
    }

    public int size() {
        return huluwaLength;
    }
    //
    public Iterator<Huluwa> iterator() {
        return huluses.iterator();
    }
    //降序排列
    public void sortByDes() {
        Collections.sort(huluses);
    }
    //乱序
    public void shuffle(){
        Collections.shuffle(huluses);
    }
    //升序
    public void sortByAsc() {
        Collections.sort(huluses, new Comparator<Huluwa>(){
            @Override
            public int compare(Huluwa a, Huluwa b){
                return b.getName().compareTo(a.getName());
            }
        });
    }
    //按照性别分成两列后升序
    public void sortByGender(){
        Collections.sort(huluses, new Comparator<Huluwa>(){
            @Override
            public int compare(Huluwa a, Huluwa b){
                return a.getGender().compareTo(b.getGender()) | a.getName().compareTo(b.getName());
          
            }
        });
    }
}
