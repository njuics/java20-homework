package game.message;

import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.message.Message;
import advancedjava.finalproj.game.message.MessageType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MessageTest
{
    static Message tester1 = new Message(CampEnum.SERVER, MessageType.GAME_OVER, "testing1");
    static String ans1 = "{\"content\":\"testing1\",\"senderCamp\":\"SERVER\",\"type\":\"GAME_OVER\"}";

    @Test
    public void testContent()
    {
        assertEquals(tester1.content, "testing1");
        assertEquals(tester1.senderCamp, CampEnum.SERVER);
        assertEquals(tester1.type, MessageType.GAME_OVER);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(Message.parseMessage(ans1).toString(), ans1);
    }
}

