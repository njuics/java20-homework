import org.junit.*;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SortTest{
    Family new_family=new Family<Calabash>();
    @BeforeClass
    public static void test_normal()throws Exception{
        /*new_family.add_member(Calabash.class,"a","女");
        new_family.add_member(Calabash.class,"aaa","女");
        new_family.add_member(Calabash.class,"abc","男");
        new_family.add_member(Calabash.class,"bd","女");
        new_family.add_member(Calabash.class,"bc","女");
        new_family.add_member(Calabash.class,"ae","男");
        new_family.add_member(Calabash.class,"c","女");
        new_family.add_member(Calabash.class,"cd","女");
        new_family.add_member(Calabash.class,"e","男");
        new_family.add_member(Calabash.class,"f","女");
        new_family.add_member(Calabash.class,"d","男");*/
        System.out.println("BeforeClass:");
    }
    @AfterClass
    public static void AfterClass()
    {
        System.out.println("AfterClass");
    }
    @Before
    public void Setup()
    {
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
        new_family.add_member(Calabash.class);
    }
    @After
    public void reset()
    {
        new_family.clear_family();
    }
    @Test
    public void test1() throws Exception
    {
        System.out.println("正序排序");
        new_family.display_well(new_family.iterator());
        Iterator<Calabash> it= new_family.iterator();
        Calabash previous=it.next();
        while(it.hasNext())
        {
            Calabash now=it.next();
            assertTrue(previous.get_name().compareTo(now.get_name())<=0);
            previous=now;
        }
    }
    @Test
    public void test2() throws Exception
    {
        System.out.println("逆序排序");
        new_family.display_comparator(new_family.iterator());
        Iterator<Calabash> it= new_family.iterator();
        Calabash previous=it.next();
        while(it.hasNext())
        {
            Calabash now=it.next();
            assertTrue(previous.get_name().compareTo(now.get_name())>=0);
            previous=now;
        }
    }

    @Test
    public void test3() throws Exception
    {
        System.out.println("正序排序");
        new_family.display_reverse(new_family);
        Iterator<Calabash> it= new_family.iterator();
        Calabash previous=it.next();
        while(it.hasNext())
        {
            Calabash now=it.next();
            assertTrue(previous.get_name().compareTo(now.get_name())<=0);
            previous=now;
        }
    }
    @Test(timeout = 0)
    public void testSort() throws Exception {
        System.out.println("逆序排序");
        new_family.display_comparator(new_family.iterator());
    }
    @Test(timeout = 10)
    public void testSort_team_girl() throws Exception {
        new_family.team(new_family.iterator());
        int girl_length=new_family.team_list_girl.size();
        for(int i=0;i<girl_length;i++)
        {
            assertTrue(new_family.girl_list_gender(i).compareTo("女")==0);
        }
    }
    @Test(timeout = 100)
    public void testSort_team_boy() throws Exception {
        new_family.team(new_family.iterator());
        int girl_length=new_family.team_list_boy.size();
        for(int i=0;i<girl_length;i++)
        {
            assertTrue(new_family.boy_list_gender(i).compareTo("男")==0);
        }
    }


}