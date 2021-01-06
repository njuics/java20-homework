import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;
import java.io.File;
import Package.JavaCreature.HuLuWa;
import Package.JavaCreature.GrandFather;
import Package.MyComparator.*;
import org.junit.*;

import static org.junit.Assert.*;

public class HuLuWaTest {
    static HuLuWa firstHuLuWa=new HuLuWa(1,"TheFirst",1);
    static HuLuWa secondHuLuWa=new HuLuWa(2,"TheSecond",1);
    static ArrayList<HuLuWa> huLuWa;
    static GrandFather grandFather;
    static{
        firstHuLuWa.setPosition(0);
        secondHuLuWa.setPosition(1);
        huLuWa=new ArrayList<HuLuWa>();
        huLuWa.add(new HuLuWa(1,"TheFirst",1));
        huLuWa.add(new HuLuWa(2,"TheSecond",1));
        huLuWa.add(new HuLuWa(3,"TheThird",1));
        huLuWa.add(new HuLuWa(4,"TheFourth",1));
        huLuWa.add(new HuLuWa(5,"TheFifth",1));
        huLuWa.add(new HuLuWa(6,"TheSixth",1));
        huLuWa.add(new HuLuWa(7,"TheSeventh",1));
        grandFather=new GrandFather(huLuWa);
    }

    @BeforeClass
    public void beforeAllTest(){
        System.out.println("Start All Test!");
    }

    @AfterClass
    public void afterALLTest(){
        System.out.println("End All Test!");
    }

    @Before
    public void beforeOneTest(){
        System.out.println("Start One Test!");
    }

    @After
    public void afterOneTest(){
        System.out.println("End One Test!");
    }

    @Test
    public void testSetPosition(){
        firstHuLuWa.setPosition(3);
        secondHuLuWa.setPosition(4);
    }

    @Test
    public void testSwap(){
        firstHuLuWa.swap(secondHuLuWa);
    }

    @Test
    public void testSort(){
        grandFather.shuffle();
        grandFather.sort(0);
    }
}
