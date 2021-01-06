import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HuluRanksTest {

    @Test
    public void iterator() {
        //用一个名字依次为0、1、2、3、4的葫芦娃list来测试正向的迭代是否正确
        List<Hulu> hulutestlist=new ArrayList<Hulu>();
        for (int i = 0; i < 5; i++) {
            hulutestlist.add(new Hulu(new Integer(i).toString(),false));
        }
        Iterable<Hulu> testit = new HuluRanks<Hulu>(hulutestlist);
        int i=0;
        for(Hulu hulu:testit){
            assertEquals(new Integer(i).toString(),hulu.getName());
            i++;
        }

    }
}