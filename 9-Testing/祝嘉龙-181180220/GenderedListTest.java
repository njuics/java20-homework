import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class GenderedListTest {
    class Testobj implements Gendered{
        int id;
        int gender;

        Testobj(int i, int g){
            id = i;
            gender = g;
        }

        @Override
        public int getGender(){
            return gender;
        }
    }

    GenderedList<Testobj> list = new GenderedList<>();

    @Before
    public void randGenList(){
        for(int i = 0; i < 7; i++){
            list.add(new Testobj(i, Gendered.MALE));
        }
        for(int i = 7; i < 10; i++){
            list.add(new Testobj(i, Gendered.FEMALE));
        }
    }

    @Test
    public void maleListTest(){
        GenderedList<Testobj> ml = list.maleList();
        for(Testobj t : ml){
            assertEquals(t.getGender(), Gendered.MALE);
        }
    }

    @Test
    public void femaleListTest(){
        GenderedList<Testobj> ml = list.femaleList();
        for(Testobj t : ml){
            assertEquals(t.getGender(), Gendered.FEMALE);
        }
    }

    @Test
    public void reversedTest(){
        int i = 9;
        for(Testobj t : list.reversed()){
            assertEquals(i--, t.id);
        }
    }
}
