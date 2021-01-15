package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.CampEnum;
import com.alibaba.fastjson.JSON;

public class GameOverMessage
{
    public CampEnum loserCamp;
    public OverReasonEnum reason;

    public GameOverMessage(CampEnum loserCamp, OverReasonEnum reason)
    {
        this.loserCamp = loserCamp;
        this.reason = reason;
    }

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }

    public static GameOverMessage parseGameOverMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, GameOverMessage.class);
    }
}
