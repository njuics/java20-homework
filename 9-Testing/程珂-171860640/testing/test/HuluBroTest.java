package testing.test;

import edu.nju.kecheng.advancedjava2020fall.testing.src.Color;
import edu.nju.kecheng.advancedjava2020fall.testing.src.Gender;
import edu.nju.kecheng.advancedjava2020fall.testing.src.HuluBro;
import org.junit.*;



public class HuluBroTest {
    private static HuluBro bro;
    private static HuluBro maxBro;
    private static HuluBro minBro;

    @BeforeClass
    public static void setUpBeforeClass(){
        bro=HuluBro.getSpecificHuluBro(Color.YELLOW, Gender.MALE);
        maxBro=HuluBro.getSpecificHuluBro(Color.PURPLE, Gender.MALE);
        minBro=HuluBro.getSpecificHuluBro(Color.RED, Gender.FEMALE);
    }

    @Test
    public void testGetHuluBro() {
        int outerLoopNum=100;
        int innerLoopNum=Color.values().length;
        int[] expectedResults=new int[innerLoopNum];
        for(int i=0;i<innerLoopNum;i++)expectedResults[i]=1;

        int[] expectedTotoalResults=new int[innerLoopNum];
        for(int i=0;i<innerLoopNum;i++)expectedTotoalResults[i]=outerLoopNum;

        int[] realResultsTotoalLoop=new int[innerLoopNum];
        for(int i=0;i<innerLoopNum;i++)realResultsTotoalLoop[i]=0;

        for(int i=0;i<outerLoopNum;i++){
            int[] realResultsSingleLoop=new int[innerLoopNum];
            for(int k=0;k<innerLoopNum;k++)realResultsSingleLoop[k]=0;

            for(int j=0;j<innerLoopNum;j++){
                HuluBro bro=HuluBro.getHuluBro();
                Assert.assertNotNull(bro);
                int broOrder=bro.getOrder();
                realResultsSingleLoop[broOrder]++;
                realResultsTotoalLoop[broOrder]++;
            }
            Assert.assertArrayEquals(expectedResults,realResultsSingleLoop);
        }
        Assert.assertArrayEquals(expectedTotoalResults,realResultsTotoalLoop);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(bro.getName(),"YELLOW");
        Assert.assertEquals(minBro.getName(),"RED");
        Assert.assertEquals(maxBro.getName(),"PURPLE");
    }

    @Test
    public void testGetGender() {
        Assert.assertEquals(bro.getGender().toString(),"MALE");
        Assert.assertEquals(minBro.getGender().toString(),"FEMALE");
        Assert.assertEquals(maxBro.getGender().toString(),"MALE");
    }

    @Test
    public void testCompareTo() {
        Assert.assertEquals(1,bro.compareTo(minBro));
        Assert.assertEquals(0,bro.compareTo(HuluBro.getSpecificHuluBro(Color.YELLOW,Gender.FEMALE)));
        Assert.assertEquals(-1,bro.compareTo(maxBro));
        Assert.assertEquals(-1,minBro.compareTo(maxBro));
        Assert.assertEquals(1,maxBro.compareTo(minBro));
    }

    @Test
    public void testToString() {
        Assert.assertEquals(bro.toString(),"HuluBro.name:YELLOW,gender:MALE");
        Assert.assertEquals(maxBro.toString(),"HuluBro.name:PURPLE,gender:MALE");
        Assert.assertEquals(minBro.toString(),"HuluBro.name:RED,gender:FEMALE");
    }
}