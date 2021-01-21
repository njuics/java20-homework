import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
public class BoysSortTest {
    BoysSequence sequence = new BoysSequence();
    GrandFather gf = new GrandFather();
    ArrayList<CalabashBoy> correctList;

    @Before
    public void outInitSequence(){
        System.out.println("开始测试爷爷的排序技能：");

        //将葫芦娃们加入队列
        sequence.add(new RedBoy());
        sequence.add(new OrangeBoy());
        sequence.add(new YellowBoy());
        sequence.add(new GreenBoy());
        sequence.add(new CyanBoy());
        sequence.add(new BlueBoy());
        sequence.add(new PurpleBoy());

        correctList = sequence.boysList;

        System.out.println("初始葫芦娃序列：");
        sequence.outputNameList();
        System.out.println("\n葫芦娃自我介绍：");
        sequence.outputSequence();

        //打乱队列
        gf.shuffle(sequence);
        System.out.println("\n当前葫芦娃序列：");
        sequence.outputSequence();
    }


    @Test
    public void sortTest(){
        //队列排序
        gf.sort(sequence);
        assertEquals(correctList,sequence.boysList);

    }

    @After
    public void outEndSequence(){
        System.out.println("\n排序后葫芦娃序列：");
        sequence.outputNameList();
        System.out.println("\n葫芦娃自我介绍：");
        sequence.outputSequence();
        System.out.println("\n测试完毕\n");
    }
}
