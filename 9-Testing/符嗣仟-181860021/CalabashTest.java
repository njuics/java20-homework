import java.util.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


public class CalabashTest{
    CreatureList<Calabash> huluwas = new CreatureList<>();
    @Before
    public void Setup(){
        huluwas.add(new Calabash("a",Sexual.MALE));
        huluwas.add(new Calabash("c",Sexual.FEMALE));
        huluwas.add(new Calabash("d",Sexual.MALE));
        huluwas.add(new Calabash("b",Sexual.FEMALE));
        huluwas.add(new Calabash("f",Sexual.MALE));
        huluwas.add(new Calabash("e",Sexual.FEMALE));
        huluwas.add(new Calabash("g",Sexual.MALE));
    }

    @After
    public void Finish(){
        huluwas = null;
    }
    //v1:类似oj,自己给出输入输出进行测试
    @Test

    public void Possorttest1(){
        huluwas.Possort();
        Iterator<Calabash> iter = huluwas.iterator();
        assertEquals(iter.next().getname(), "a");
        assertEquals(iter.next().getname(), "b");
        assertEquals(iter.next().getname(), "c");
        assertEquals(iter.next().getname(), "d");
        assertEquals(iter.next().getname(), "e");
        assertEquals(iter.next().getname(), "f");
        assertEquals(iter.next().getname(), "g");
        assertFalse(iter.hasNext());
    }
    @Test
    public void Negsorttest1(){
        huluwas.Negsort();
        Iterator<Calabash> iter = huluwas.iterator();
        assertEquals(iter.next().getname(), "g");
        assertEquals(iter.next().getname(), "f");
        assertEquals(iter.next().getname(), "e");
        assertEquals(iter.next().getname(), "d");
        assertEquals(iter.next().getname(), "c");
        assertEquals(iter.next().getname(), "b");
        assertEquals(iter.next().getname(), "a");
        assertFalse(iter.hasNext());
    }
    @Test
    public void Possorttest2(){
        huluwas.Possort();
        for(int i=0;i<6;i++){
            if(huluwas.get(i).getname().compareTo(huluwas.get(i+1).getname())>0)
                assertTrue(false);
        }
    }

    @Test
    public void Negsorttest2(){
        huluwas.Negsort();
        for(int i=0;i<6;i++){
            if(huluwas.get(i).getname().compareTo(huluwas.get(i+1).getname())<0)
                assertTrue(false);
        }
    }

    @Test
    public void Randsorttest(){
        boolean flag = false;
        for(int i=0;i<10;i++){
            huluwas.Randsort();
            for(int j=0;j<6;j++){
                if(huluwas.get(i).getname().compareTo(huluwas.get(i+1).getname())!=0){
                    flag = true;
                    break;
                }
            }
            if(flag)break;
        }
        //证明随机打乱成功，除非10次测试均通过这种极小概率事件发生
        assertTrue(flag);
    }
}