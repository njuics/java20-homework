package game.message;

import advancedjava.finalproj.game.DirectionEnum;
import advancedjava.finalproj.game.Location;
import advancedjava.finalproj.game.message.MoveMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveMessageTest
{
    static MoveMessage tester1 = new MoveMessage(new Location(-10, 17), DirectionEnum.UP);
    static String ans1 = "{\"direction\":\"UP\",\"loc\":{\"first\":-10,\"second\":17,\"x\":-10,\"y\":17}}";

    @Test
    public void testContent()
    {
        assertEquals(tester1.loc.getX(), -10);
        assertEquals(tester1.loc.getY(), 17);
        assertEquals(tester1.direction, DirectionEnum.UP);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(MoveMessage.parseMoveMessage(ans1).toString(), ans1);
    }
}
