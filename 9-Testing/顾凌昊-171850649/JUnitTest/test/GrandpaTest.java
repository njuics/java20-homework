package JUnitTest.test;

import JUnitTest.characters.Grandpa;
import JUnitTest.characters.Huluwa;
import JUnitTest.main.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GrandpaTest {

    private Grandpa grandpa = null;

    @Before
    public void loadObjects(){
        grandpa = Grandpa.getInstance();
    }

    @Test
    public void testInstance(){
        Assert.assertNotNull(grandpa);
    }

    @Test
    public void testAdd(){
        List<Huluwa> list = Main.createHuluwa();
        grandpa.addAll(list);
        for(int i = 0 ;i<list.size();i++){
            Assert.assertEquals(list.get(i), grandpa.getList().get(i));
        }
        
    }

    @Test
    public void testCompare(){
        Huluwa a = new Huluwa("a",true);
        Huluwa b = new Huluwa("b",false);

        Assert.assertTrue(grandpa.compare(a,b)<0);
    }

    @Test
    public void testSwap(){
        Huluwa a = new Huluwa("a",true);
        Huluwa b = new Huluwa("b",false);

        grandpa.swap(a,b);

        Assert.assertEquals(a.name,"b");
        Assert.assertEquals(b.name,"a");

    }

    @Test
    public void testSort(){
        List<Huluwa> list = Main.createHuluwa();
        grandpa.addAll(list);
        grandpa.sort(false);

        boolean correct = true;
        int count = list.size();

        for(int i = 0 ;i<count-1;i++){
            if(grandpa.getList().get(i).name.compareTo(grandpa.getList().get(i+1).name)>0){
                correct = false;
                break;
            }
        }

        Assert.assertTrue(correct);
    }
}
