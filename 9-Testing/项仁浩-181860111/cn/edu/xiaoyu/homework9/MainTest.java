package cn.edu.xiaoyu.homework9;

import org.junit.*;
import org.junit.Assert;


public class MainTest {
    static int i = 1;
    @Before
    public void printMsgBefore(){
        System.out.println("Start Test"+ Integer.toString(i) +":");
    }
    @After
    public void printMsgAfter(){
        System.out.println("Finish Test"+Integer.toString(i)+":");
        i++;
    }
    static Gender[] change(int[] x,int amount){
        Gender[] genders =new Gender[amount];
        for(int i=0;i<amount;i++)
            if(x[i]==0)
                genders[i]=Gender.FEMALE;
            else
                genders[i]=Gender.MALE;
        return  genders;
    }

    static final String[] init_str1 = {"ZC","ZA","ZB","AA","BB","CC"};
    static final Gender[] init_genders1 = change(new int[]{0,0,0,1,1,1},6);
    static final int NUM1 = 6;
    static String[] expected11 ={"AA","BB","CC","ZA","ZB","ZC"};
    static String[] expected12 ={"ZC","ZB","ZA","CC","BB","AA"};
    static String[] expected13 ={"AA","BB","CC"};
    static String[] expected14 ={"ZC","ZA","ZB"};

    static final String[] init_str2 = {
            "Z", "Y", "X", "W", "V", "U", "T",
            "S", "R", "Q", "P", "O", "N", "M",
            "L", "K", "J", "I", "H", "G", "F",
            "E", "D", "C", "B", "A"
    };
    static final Gender[] init_genders2 = change(new int[]{
            1, 0, 1, 0, 1, 0, 1, 0,
            1, 0, 1, 0, 1, 0, 1, 0,
            1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
    },26);
    static final int NUM2 =26;
    static String[] expected21 ={
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",
    };
    static String[] expected22 ={
            "Z", "Y", "X", "W", "V", "U", "T",
            "S", "R", "Q", "P", "O", "N", "M",
            "L", "K", "J", "I", "H", "G", "F",
            "E", "D", "C", "B", "A"
    };
    static String[] expected23 ={"Z", "X", "V", "T", "R", "P", "N", "L", "J", "H", "F", "D", "B"};
    static String[] expected24 ={"Y", "W", "U", "S", "Q", "O", "M", "K", "I", "G", "E", "C", "A"};

    @Test
    public void test1(){
        Main<Calabash> calabashMain = new Main<>();
        calabashMain.addSomeCalabashes(NUM1,init_str1,init_genders1,Calabash.class);

        calabashMain.sort(true);
        Assert.assertArrayEquals(expected11,calabashMain.list.getName().toArray(new String[0]));
    }
    @Test
    public void test2(){
        Main<CalabashFire> calabashFireMain=new Main<>();
        calabashFireMain.addSomeCalabashes(NUM1,init_str1,init_genders1,CalabashFire.class);

        calabashFireMain.sort(false);
        Assert.assertArrayEquals(expected12,calabashFireMain.list.getName().toArray(new String[0]));
    }
    @Test
    public void test3(){
        Main<CalabashWater> calabashWaterMain = new Main<>();
        calabashWaterMain.addSomeCalabashes(NUM1,init_str1,init_genders1,CalabashWater.class);

        Assert.assertArrayEquals(expected13, calabashWaterMain.divideByGender(calabashWaterMain.list,
                Gender.MALE).getName().toArray(new String[0]));
    }

    @Test
    public void test4(){
        Main<Calabash> calabashMain =new Main<>();
        calabashMain.addSomeCalabashes(NUM1,init_str1,init_genders1,Calabash.class);

        Assert.assertArrayEquals(expected14,calabashMain.divideByGender(calabashMain.list,
                Gender.FEMALE).getName().toArray(new String[0]));
    }

    @Test
    public void test5(){
        Main<Calabash> calabashMain = new Main<>();
        calabashMain.addSomeCalabashes(NUM2,init_str2,init_genders2,Calabash.class);

        calabashMain.sort(true);
        Assert.assertArrayEquals(expected21,calabashMain.list.getName().toArray(new String[0]));
    }
    @Test
    public void test6(){
        Main<CalabashFire> calabashFireMain=new Main<>();
        calabashFireMain.addSomeCalabashes(NUM2,init_str2,init_genders2,CalabashFire.class);

        calabashFireMain.sort(false);
        Assert.assertArrayEquals(expected22,calabashFireMain.list.getName().toArray(new String[0]));
    }
    @Test
    public void test7(){
        Main<CalabashWater> calabashWaterMain = new Main<>();
        calabashWaterMain.addSomeCalabashes(NUM2,init_str2,init_genders2,CalabashWater.class);

        Assert.assertArrayEquals(expected23, calabashWaterMain.divideByGender(calabashWaterMain.list,
                Gender.MALE).getName().toArray(new String[0]));
    }

    @Test
    public void test8(){
        Main<Calabash> calabashMain =new Main<>();
        calabashMain.addSomeCalabashes(NUM2,init_str2,init_genders2,Calabash.class);

        Assert.assertArrayEquals(expected24,calabashMain.divideByGender(calabashMain.list,
                Gender.FEMALE).getName().toArray(new String[0]));
    }

}
