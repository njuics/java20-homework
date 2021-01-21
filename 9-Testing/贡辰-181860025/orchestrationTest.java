import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import java.util.Scanner;

public class orchestrationTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sort() 
* 
*/ 
@Test()
public void testSort() throws Exception
{
//TODO: Test goes here...
    int size=7;
    int[] mylist={1,0,2,6,5,4,3};

    orchestration task1=new orchestration(size,mylist);
    System.out.println("Orchestration");
    System.out.println("Initial queue:");
    task1.print();
    task1.sort();
    System.out.println("Sorted queue:");
    task1.print();
    System.out.println("=============================");
} 


} 
