package game.message;

import advancedjava.finalproj.game.Location;
import advancedjava.finalproj.game.message.DefenseMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefenseMessageTest
{
    static DefenseMessage tester1 = new DefenseMessage(new Location(1, 100));
    static String ans1 = "{\"loc\":{\"first\":1,\"second\":100,\"x\":1,\"y\":100}}";

    @Test
    public void testContent()
    {
        assertEquals(tester1.loc.getX(), 1);
        assertEquals(tester1.loc.getY(), 100);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(DefenseMessage.parseDefenseMessage(ans1).toString(), ans1);
    }
}
