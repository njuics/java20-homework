import java.util.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SortTest {
    static List<Hulu> huluList;
    static MySort mySort;

    @BeforeClass
    public static void init(){
        mySort = new MySort();
        Random random = new Random();
        int num = random.nextInt(10)+15;

        huluList = new ArrayList<>();
        for(int i=0; i<num; ++i){
            huluList.add(new Hulu());
        }
    }

    @Before
    public void outOfOrder(){
        mySort.outOfOrder(huluList);
    }

    @Test
    public void testPositiveOrder() throws Exception {
        List<Hulu> tmp = new ArrayList<>(huluList);
        mySort.positiveOrder(huluList);
        Collections.sort(tmp);
        
        assertEquals(huluList, tmp);
    }

    @Test
    public void testNegativeOrder() throws Exception {
        List<Hulu> tmp = new ArrayList<>(huluList);
        mySort.negativeOrder(huluList);
        Collections.sort(tmp,new Comparator<Hulu>() {
            @Override
            public int compare(Hulu h1, Hulu h2) {
                if (h1.getName().compareTo(h2.getName())<0)
                    return 1;
                else if (h1.getName().compareTo(h2.getName())==0)
                    return 0;
                else
                    return -1;
            }
        });
        assertEquals(huluList, tmp);
    }

    @Test
    public void testGenderPositive(){
        List<Hulu> tmp = new ArrayList<>(huluList);
        List<Hulu> male= new ArrayList<>();
        List<Hulu> female = new ArrayList<>();
        for(int i=0;i<tmp.size();++i){
            if(tmp.get(i).getGender()==true){
                male.add(tmp.get(i));
            }
            else{
                female.add(tmp.get(i));
            }
        }

        mySort.genderSort(huluList,false);
        Collections.sort(male);
        Collections.sort(female);

        tmp.clear();
        tmp.addAll(male);
        tmp.addAll(female);
        assertEquals(huluList, tmp);
    }

    @Test
    public void testGenderNegative(){
        List<Hulu> tmp = new ArrayList<>(huluList);
        List<Hulu> male= new ArrayList<>();
        List<Hulu> female = new ArrayList<>();
        for(int i=0;i<tmp.size();++i){
            if(tmp.get(i).getGender()==true){
                male.add(tmp.get(i));
            }
            else{
                female.add(tmp.get(i));
            }
        }

        mySort.genderSort(huluList,true);
        Collections.sort(male,new Comparator<Hulu>() {
            @Override
            public int compare(Hulu h1, Hulu h2) {
                if (h1.getName().compareTo(h2.getName())<0)
                    return 1;
                else if (h1.getName().compareTo(h2.getName())==0)
                    return 0;
                else
                    return -1;
            }
        });
        Collections.sort(female,new Comparator<Hulu>() {
            @Override
            public int compare(Hulu h1, Hulu h2) {
                if (h1.getName().compareTo(h2.getName())<0)
                    return 1;
                else if (h1.getName().compareTo(h2.getName())==0)
                    return 0;
                else
                    return -1;
            }
        });
        
        tmp.clear();
        tmp.addAll(male);
        tmp.addAll(female);
        assertEquals(huluList, tmp);
    }
}
