package game.message;

import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.message.GameOverMessage;
import advancedjava.finalproj.game.message.OverReasonEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOverMessageTest
{
    static GameOverMessage tester1 = new GameOverMessage(CampEnum.HULUBRO, OverReasonEnum.LOSE);
    static String ans1 = "{\"loserCamp\":\"HULUBRO\",\"reason\":\"LOSE\"}";
    static GameOverMessage tester2 = new GameOverMessage(CampEnum.MONSTER, OverReasonEnum.GIVE_UP);
    static String ans2 = "{\"loserCamp\":\"MONSTER\",\"reason\":\"GIVE_UP\"}";


    @Test
    public void testContent()
    {
        assertEquals(tester1.loserCamp, CampEnum.HULUBRO);
        assertEquals(tester1.reason, OverReasonEnum.LOSE);
        assertEquals(tester2.loserCamp, CampEnum.MONSTER);
        assertEquals(tester2.reason, OverReasonEnum.GIVE_UP);
    }

    @Test
    public void testToString()
    {
        assertEquals(tester1.toString(), ans1);
        assertEquals(tester2.toString(), ans2);
    }

    @Test
    public void testParseMessage()
    {
        assertEquals(GameOverMessage.parseGameOverMessage(ans1).toString(), ans1);
        assertEquals(GameOverMessage.parseGameOverMessage(ans2).toString(), ans2);
    }
}
