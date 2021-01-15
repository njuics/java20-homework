import org.junit.Test;

import static org.junit.Assert.*;

public class HuluTest {

    @Test
    public void getName(){
        Hulu hulu1 = new Hulu("007", false);
        assertEquals("007",hulu1.getName());
    }
    @Test
    public void getGender(){
        Hulu hulu1 = new Hulu("007", false);
        assertEquals(false,hulu1.getGender());
    }
    @Test
    public void compareTo() {
        Hulu hulu1 = new Hulu();
        Hulu hulu2 = new Hulu();
        Hulu.sortway=0;
        assertEquals(hulu1.getName().compareTo(hulu2.getName()),hulu1.compareTo(hulu2));
        hulu1.sortway=1;
        assertEquals(-hulu1.getName().compareTo(hulu2.getName()), hulu1.compareTo(hulu2));
    }
}