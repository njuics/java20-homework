import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Testing {
    public static void main(String[] args){
        Result runResult = JUnitCore.runClasses(BoysSortTest.class, RecoverTest.class);
        for (Failure failure : runResult.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(runResult.wasSuccessful());
    }
}
