package huluwa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import huluwa.ability.Ability;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class HuluwaTest {
    /**
     * Rigorous Test.
     */
    ArrayList<Huluwa> huluwas=new ArrayList<Huluwa>();
    @Before
    public void before(){
        Ability a1=new Ability("a1",1);
        Ability a2=new Ability("a2",2);
        Ability a3=new Ability("a3",3);
        Ability a4=new Ability("a4",4);
        Huluwa h1=new Huluwa<Ability>("h1",a1);
        Huluwa h2=new Huluwa<Ability>("h2",a2);
        Huluwa h3=new Huluwa<Ability>("h3",a3);
        Huluwa h4=new Huluwa<Ability>("h4",a4);
        huluwas.add(h1);
        huluwas.add(h2);
        huluwas.add(h4);
        huluwas.add(h3);
    }
    @Test
    public void testHuluwa1() {
        Assert.assertEquals(huluwas.get(2),Sort.getMax(huluwas));
    }
    @Test
    public void testHuluwa2() {
        ArrayList<Huluwa> expect=new ArrayList<Huluwa>();
        expect.add(huluwas.get(0));
        expect.add(huluwas.get(1));
        expect.add(huluwas.get(3));
        expect.add(huluwas.get(2));
        Assert.assertEquals(expect, Sort.sort(huluwas));
    }
}
