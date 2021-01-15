import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SortTest{
    @Test
    public void test1(){
        ArrayList<Huluwa> arr=new ArrayList<Huluwa>();
        Ability a1=new Ability("a1", 1);
        Ability a2=new Ability("a2", 2);
        Huluwa<Ability> h1=new Huluwa<Ability>("n1", a1);
        Huluwa<Ability> h2=new Huluwa<Ability>("n2", a2);
        arr.add(h2);
        arr.add(h1);
        ArrayList<Huluwa> res=new ArrayList<Huluwa>();
        res.add(h1);
        res.add(h2);
        Assert.assertEquals(Sort.sort(arr), res);
    }
}