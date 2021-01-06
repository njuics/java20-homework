package homework9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class UnitTest {
    static HuluWaQueue<HuluWa> queue;
    @BeforeClass
    public static void beforeTests(){
        System.out.println("---------Tests start----------");
    }
    @AfterClass
    public static void afterTests(){
        System.out.println("---------Tests finished----------");
    }
    @Before
    public void initQueue(){
        queue = new HuluWaQueue<>();
        for(int i = 0; i < 1000; ++i){
            queue.add(new HuluWa(i+1, HuluWa.genRandomName(), i, Gender.get()));
        }
    }
    @After
    public void delQueue(){
        queue = null;
    }
    @Test
    public void testSepByGender(){
        HuluWaQueue<HuluWa> males = queue.sepByGender(Gender.MALE);
        HuluWaQueue<HuluWa> females = queue.sepByGender(Gender.FEMALE);
        for(HuluWa male : males){
            Assert.assertTrue(male.getGender() == Gender.MALE);
        }
        for(HuluWa female: females){
            Assert.assertTrue(female.getGender() == Gender.FEMALE);
        }
        Assert.assertEquals(queue.size(), males.size() + females.size());
        System.out.println("passed testSepByGender");
    }
    @Test
    public void testSortHuluWas(){
        new GrandFather().sortHuluWas(queue.getArr(), new NameComparator());
        HuluWa prev = null;
        for(HuluWa cur : queue){
            if(prev != null){
                Assert.assertTrue(prev.compareTo(cur) <= 0);
                prev = cur;
            }
        }
        System.out.println("passed testSortHuluWas");
    }
    @Test(timeout = 10)
    public void testSortHuluWasTime(){
        new GrandFather().sortHuluWas(queue.getArr(), new NameComparator());
        System.out.println("passed testSortHuluWasTime");
    }
}
