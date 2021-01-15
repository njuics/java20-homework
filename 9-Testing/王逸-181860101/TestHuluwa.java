import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestHuluwa {
    @Before
    public void before() throws Exception{}
    @After
    public void after() throws Exception{}
    @Test()
    public void testSort() throws Exception{
        int num = 10;
        collection a = new collection();
        a.build_hulut(num);
        System.out.println("\n######一起排队######");
        a.my_sort();

        sex _female = sex.female,_male = sex.male;
        collection male = a.linebysex(_male),female = a.linebysex(_female);
        System.out.println("\n######男生排队######");
        male.my_sort();
        System.out.println("\n######女生排队######");
        female.my_sort();
    }
}
