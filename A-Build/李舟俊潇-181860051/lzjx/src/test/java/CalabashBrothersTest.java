import org.junit.*;
import java.util.*;

public class CalabashBrothersTest {
    ArrayList<Brother> bro;
    int num=20;

    public CalabashBrothersTest(){
        System.out.println("构造方法");
        bro=CalabashBrothersSort.initialBros();
    }
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("BeginTest");
    }
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("FinishTest");
    }
    @Before
    public void setUp() {
        System.out.println("Before");
    }
    @After
    public void tearDown() {
        System.out.println("After");
    }
    @Test
    public void ascendingSequenceTest(){
        System.out.println("ascendingSequenceTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,1);
        Collections.sort(bro);
        Assert.assertEquals(result,bro);
    }
    @Test
    public void descendingSequenceTest(){
        System.out.println("descendingSequenceTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,2);
        Collections.sort(bro);
        Collections.reverse(bro);
        Assert.assertEquals(result,bro);
    }
    @Test
    public void maleTest(){
        System.out.println("maleTest");
        ArrayList<Brother> boy=CalabashBrothersSort.findMale(bro);
        Iterator<Brother> it=boy.iterator();
        if(it.hasNext())
            Assert.assertEquals(it.next().gender,true);
    }
    @Test
    public void femaleTest(){
        System.out.println("femaleTest");
        ArrayList<Brother> girl=CalabashBrothersSort.findFemale(bro);
        Iterator<Brother> it=girl.iterator();
        if(it.hasNext())
            Assert.assertEquals(it.next().gender,false);
    }
    @Ignore
    public void outOfOrderTest(){
        System.out.println("outOfOrderTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,3);
        Assert.assertNotEquals(result,bro);
        Collections.sort(bro);
        Assert.assertNotEquals(result,bro);
        Collections.reverse(bro);
        Assert.assertNotEquals(result,bro);
    }
    @Test
    public void repetitiveNameTest(){
        System.out.println("repetitiveNameTest");
        for(int i=0;i<num;++i){
            for(int j=i+1;j<num;++j){
                Assert.assertNotEquals(bro.get(i),bro.get(j));
            }
        }
    }
}
