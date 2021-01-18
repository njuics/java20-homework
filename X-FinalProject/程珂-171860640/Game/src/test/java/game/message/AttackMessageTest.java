package game.message;

import advancedjava.finalproj.game.Location;
import advancedjava.finalproj.game.message.AttackMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackMessageTest
{
    static AttackMessage tester1 = new AttackMessage(new Location(1, -1));
    static String ans1 = "{\"loc\":{\"first\":1,\"second\":-1,\"x\":1,\"y\":-1}}";

    @Test
    public void testContent()
    {
        assertEquals(tester1.loc.getX(), 1);
        assertEquals(tester1.loc.getY(), -1);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(AttackMessage.parseAttackMessage(ans1).toString(), ans1);
    }
}
