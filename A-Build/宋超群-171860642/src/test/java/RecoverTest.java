import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

public class RecoverTest{
    BoysSequence sequence = new BoysSequence();
    GrandFather gf = new GrandFather();
    Random rand = new Random();

    @Before
    public void outInitSequence(){
        System.out.println("\n开始测试爷爷的安抚技能：");


        //将葫芦娃们加入队列
        sequence.add(new RedBoy());
        sequence.add(new OrangeBoy());
        sequence.add(new YellowBoy());
        sequence.add(new GreenBoy());
        sequence.add(new CyanBoy());
        sequence.add(new BlueBoy());
        sequence.add(new PurpleBoy());

        System.out.println("初始葫芦娃序列：");
        sequence.outputNameList();

        System.out.println("\n初始葫芦娃血量：");
        Iterator<CalabashBoy> it=sequence.boysList.iterator();
        while(it.hasNext()){
            CalabashBoy nextBoy =  it.next();
            System.out.println(nextBoy.getHP());
            nextBoy.getAttacked(rand.nextInt(200));
        }

        System.out.println("\n葫芦娃受伤后血量：");
        Iterator<CalabashBoy> it1=sequence.boysList.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next().getHP());
        }
    }

    @Test
    public void recoverTest(){

        Iterator<CalabashBoy> it = sequence.boysList.iterator();
        while(it.hasNext()){
            CalabashBoy boy = it.next();
            gf.recover(boy);
            assertEquals(1000,boy.getHP());
        }
    }

    @After
    public void outEndSequence(){
        System.out.println("\n爷爷安抚后葫芦娃的血量：");
        Iterator<CalabashBoy> it=sequence.boysList.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getHP());
        }
        System.out.println("\n测试完毕\n");
    }
}
