import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Scanner;


public class choreographyTest { 

@Before
public void before() throws Exception
{
    System.out.println("Start test choreography");
} 

@After
public void after() throws Exception
{
    System.out.println("Stop test choreography");
} 

/** 
* 
* Method: sort() 
* 
*/ 
@Test(expected = Exception.class)
public void testSort() throws Exception
{
//TODO: Test goes here...
    int size=7;
    int[] mylist={0,5,6,5,4,-1,0};

    choreography task2=new choreography(size,mylist);
    System.out.println("choreography");
    System.out.println("Initial queue:");
    task2.print();
    task2.sort();
    System.out.println("Sorted queue:");
    task2.print();
}


} 
