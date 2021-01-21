import org.junit.Before;
import org.junit.Test;
import ulticalabash.character.impl.Calabash;
import ulticalabash.character.impl.GrandPa;
import ulticalabash.util.CompareFlag;
import ulticalabash.util.Gender;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SortTest {
    private GrandPa grandPa;

    @Before
    public void loadGrandPa() {
        grandPa = new GrandPa();
        ArrayList<Calabash> calabashes = new ArrayList<>();
        String[] names = {"nju", "jun", "nuj", "jnu", "ujn"};
        Gender[] sex = {Gender.BOY, Gender.GIRL, Gender.GIRL, Gender.BOY, Gender.BOY};
        for (int i = 0; i < 5; ++i) calabashes.add(new Calabash(names[i], sex[i]));
        grandPa.setChildren(calabashes);
    }

    @Test
    public void nameSort() {
        grandPa.setFlag(CompareFlag.NAME);
        grandPa.sortChildren();
        assertEquals("jnu jun nju nuj ujn", grandPa.callChildren());

        grandPa.shuffleChildren();
        assertNotEquals("jnu jun nju nuj ujn", grandPa.callChildren());

        grandPa.setFlag(CompareFlag.NAME_REVERSE);
        grandPa.sortChildren();
        assertEquals("ujn nuj nju jun jnu", grandPa.callChildren());
    }

    @Test
    public void sexSort() {
        grandPa.setFlag(CompareFlag.SEX);
        grandPa.sortChildren();
        assertEquals("jnu nju ujn jun nuj", grandPa.callChildren());

        grandPa.shuffleChildren();
        assertNotEquals("jnu nju ujn jun nuj", grandPa.callChildren());

        grandPa.setFlag(CompareFlag.SEX_REVERSE);
        grandPa.sortChildren();
        assertEquals("nuj jun ujn nju jnu", grandPa.callChildren());
    }

    @Test
    public void randomSort() {
        grandPa.setFlag(CompareFlag.RANDOM);
        grandPa.sortChildren();
        assertNotEquals("nju jun nuj jnu ujn", grandPa.callChildren());
    }
}
