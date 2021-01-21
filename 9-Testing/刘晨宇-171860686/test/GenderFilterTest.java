import huluwa.characters.Gender;
import huluwa.tools.GenderFilter;
import huluwa.characters.CalabashBrother;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class GenderFilterTest {
    @Test
    public void testFilter() {
        int nCalabashBrothers = 1000;
        ArrayList<CalabashBrother> queue = new ArrayList<>();
        for(int i = 0; i < nCalabashBrothers; i++) {
            queue.add(new CalabashBrother());
        }

        List<CalabashBrother> maleQueue = GenderFilter.filter(queue, Gender.MALE);
        List<CalabashBrother> femaleQueue = GenderFilter.filter(queue, Gender.FEMALE);
        maleQueue.forEach(x -> assertSame(x.getGender(), Gender.MALE));
        femaleQueue.forEach(x -> assertSame(x.getGender(), Gender.FEMALE));
    }
}
