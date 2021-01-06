import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class BoyList {
    private List<CalabashBoy> boyList;
    private List<CalabashBoy> maleBoyList;
    private List<CalabashBoy> femaleBoyList;
    public BoyList(){
        boyList = new ArrayList<CalabashBoy>();
        maleBoyList = new ArrayList<CalabashBoy>();
        femaleBoyList = new ArrayList<CalabashBoy>();
        for(int i=0;i<20;i++){
            boyList.add(new CalabashBoy());
        }
        Iterator<CalabashBoy> i = boyList.iterator();
        while(i.hasNext()){
            CalabashBoy b=i.next();
            if(b.getGender()){
                maleBoyList.add(b);
            }
            else{
                femaleBoyList.add(b);
            }
        }
    }
    public void PrintList(){
        for(CalabashBoy b:boyList){
            System.out.println(b.toString());
        }
    }
    public void PrintMaleList(){
        for(CalabashBoy b:maleBoyList){
            System.out.println(b.toString());
        }
    }
    public void PrintFemaleList(){
        for(CalabashBoy b:femaleBoyList){
            System.out.println(b.toString());
        }
    }
    public void sortWithComparable(boolean order){
        Collections.sort(boyList);
        if(!order)
            Collections.reverse(boyList);
    }
    public void shuffleWithComparable(){
        Collections.shuffle(boyList);
    }
    public void sortWithComparator(boolean order){
        if(order){
            Collections.sort(boyList,new Comparator<CalabashBoy>(){
                @Override
                public int compare(CalabashBoy a,CalabashBoy b){
                    return a.compareTo(b);
                }
            });
        }
        else{
            Collections.sort(boyList,new Comparator<CalabashBoy>(){
                @Override
                public int compare(CalabashBoy a,CalabashBoy b){
                    return -a.compareTo(b);
                }
            });
        }
    }
    public void sortByGender(){
        Collections.sort(maleBoyList);
        Collections.sort(femaleBoyList);
    }
}