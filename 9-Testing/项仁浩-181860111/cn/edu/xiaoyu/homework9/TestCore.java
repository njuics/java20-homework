package cn.edu.xiaoyu.homework9;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class TestCore {
    public static void main(String[] args){
        Result res = JUnitCore.runClasses(MainTest.class);
        for(Failure failure: res.getFailures())
            System.out.println(failure.toString());
        System.out.println("ALL TEST PASS?"+res.wasSuccessful());
    }
}
