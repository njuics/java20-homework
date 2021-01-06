import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author q
 * @create 2020-09-19 17:23
 */
public class TestSort {
    @Test
    public void testGrandpaSort(){
        List<HuLuWa> hlws = new ArrayList<>();
        hlws.add(new HuLuWa("娃1",1));
        hlws.add(new HuLuWa("娃5",5));
        hlws.add(new HuLuWa("娃7",7));
        hlws.add(new HuLuWa("娃3",3));
        hlws.add(new HuLuWa("娃2",2));

        Grandpa grandpa = new Grandpa(hlws);
        grandpa.sortHuLuWa();

        for (HuLuWa temp : hlws){
            System.out.println(temp);
        }

    }

    @Test
    public void testGroupSort(){
        HuLuWa[] hlws = new HuLuWa[5];
        hlws[0] = (new HuLuWa("娃1",1));
        hlws[1] = (new HuLuWa("娃5",5));
        hlws[2] = (new HuLuWa("娃7",7));
        hlws[3] = (new HuLuWa("娃3",3));
        hlws[4] = (new HuLuWa("娃4",4));

        HLWGroup hlwGroup = new HLWGroup(hlws);
        hlwGroup.groupSort();
        System.out.println(hlwGroup);
    }
}
