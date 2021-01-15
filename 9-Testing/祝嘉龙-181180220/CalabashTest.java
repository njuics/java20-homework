import org.junit.Test;
import static org.junit.Assert.*;

public class CalabashTest{
    @Test
    public void genCalabashTest(){
        Calabash cb1 = new Calabash();
        Calabash cb2 = new Calabash();
        assertTrue(cb1.getName() != cb2.getName());
    }

    @Test
    public void genCalabashArrayTest(){
        Calabash[] array = Calabash.calabashArray(12);
        assertEquals(array.length, 12);
    }
}
