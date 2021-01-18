package game.message;

import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.message.StartMessage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StartMessageTest
{
    static StartMessage tester1 = new StartMessage(CampEnum.HULUBRO, 187654398);
    static String ans1 = "{\"camp\":\"HULUBRO\",\"seed\":187654398}";

    @Test
    public void testContent()
    {
        assertEquals(tester1.camp, CampEnum.HULUBRO);
        assertEquals(tester1.seed, 187654398);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(StartMessage.parseStartMessage(ans1).toString(), ans1);
    }
}

