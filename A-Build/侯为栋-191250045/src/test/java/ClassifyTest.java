import org.junit.Before;
import org.junit.Test;
import ulticalabash.character.impl.Calabash;
import ulticalabash.character.impl.GrandPa;
import ulticalabash.util.CompareFlag;
import ulticalabash.util.Gender;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClassifyTest {
    private GrandPa grandPa;

    @Before
    public void loadGrandPa() {
        grandPa = new GrandPa();
        ArrayList<Calabash> calabashes = new ArrayList<>();
        String[] names = {"nju", "jnu", "nuj", "jun", "ujn"};
        Gender[] sex = {Gender.BOY, Gender.GIRL, Gender.GIRL, Gender.BOY, Gender.BOY};
        for (int i = 0; i < 5; ++i) calabashes.add(new Calabash(names[i], sex[i]));
        grandPa.setChildren(calabashes);
    }

    @Test
    public void nameClassify() {
        var res = grandPa.classify(CompareFlag.NAME, "nju");
        assertEquals("jnu jun", grandPa.callChildren(res.getLeft()));
        assertEquals("nju", grandPa.callChildren(res.getMiddle()));
        assertEquals("nuj ujn", grandPa.callChildren(res.getRight()));
    }

}
