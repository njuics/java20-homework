package cf.moegirl.hulu;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class HuluTest {
    @Test
    public void testNotEqualHulu() {
        Hulu aMaleHuluWithNameJohnSmith = new Hulu("John Smith", Hulu.Gender.MALE);
        Hulu aMaleHuluWithNameKyon = new Hulu("Kyon", Hulu.Gender.MALE);
        assertNotEquals(aMaleHuluWithNameJohnSmith, aMaleHuluWithNameKyon);
    }

    @Test
    public void testEqualHuluByChangingName() {
        Hulu aMaleHuluWithNameJohnSmith = new Hulu("John Smith", Hulu.Gender.MALE);
        Hulu aMaleHuluWithNameKyon = new Hulu("Kyon", Hulu.Gender.MALE);
        aMaleHuluWithNameJohnSmith.setName("Kyon");
        assertEquals(aMaleHuluWithNameJohnSmith, aMaleHuluWithNameKyon);
    }

    @Test
    public void testEqualHuluByChangingGender() {
        Hulu aFemaleHuluWithNameKyon = new Hulu("Kyon", Hulu.Gender.FEMAIL);
        Hulu aMaleHuluWithNameKyon = new Hulu("Kyon", Hulu.Gender.MALE);
        aMaleHuluWithNameKyon.setGender(Hulu.Gender.FEMAIL);
        assertEquals(aFemaleHuluWithNameKyon, aMaleHuluWithNameKyon);
    }
}