import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SortTest {

    @Test(timeout = 1000)
    public void sortbyway() {
        List<Hulu> hulutestlist=new ArrayList<Hulu>();
        int num = 50000;
        for (int i = 0; i < num; i++) {
            hulutestlist.add(new Hulu(new Integer(new Random().nextInt(10)).toString(),false));
        }
        Hulu.sortway=0;
        try {
            Sort.sortbyway(hulutestlist, Hulu.sortway);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //测试是否满足升序
        int flag = 0;
        for(int i=0;i<num-1;i++){
            if(hulutestlist.get(i).getName().compareTo(hulutestlist.get(i+1).getName())>0)
                flag = 1;
        }
        assertEquals(0, flag);

        Hulu.sortway=1;
        try{
            Sort.sortbyway(hulutestlist,Hulu.sortway);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //测试是否满足降序
        flag=0;
        for(int i=num-1;i>0;i--){
            if(hulutestlist.get(i).getName().compareTo(hulutestlist.get(i-1).getName())>0)
                flag = 1;
        }
        assertEquals(0, flag);
    }
    @Test(expected = Exception.class)
    public void testSortbywayException() throws Exception
    {
        List<Hulu> hulutestlist=new ArrayList<Hulu>();
        int num = 5;
        for (int i = 0; i < num; i++) {
            hulutestlist.add(new Hulu(new Integer(new Random().nextInt(10)).toString(),false));
        }
        Hulu.sortway=3;
        Sort.sortbyway(hulutestlist,Hulu.sortway);
        fail("sortbyway参数不为0或1或2时没有抛出异常");
    }

    @Test
    public void hulusort() {
        //预设一下输入，排序为升序
        String input = "0\n0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setIn(System.in);
        //葫芦娃数量
        int num=10;
        Sort.hulusort(num);
        //hulu娃队伍是否达到排序要求这个事情通过测试sortbyway()函数可以测试了，那么还需要测试男女生是否被正确的分组
        int flag=0;
        for(Hulu hulu:Sort.malehulu){
            if(hulu.getGender()==false)
                flag=1;
        }
        for(Hulu hulu:Sort.femalehulu)
        {
            if(hulu.getGender())
                flag=1;
        }
        assertEquals(0,flag);

    }
}