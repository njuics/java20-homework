package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.Location;
import com.alibaba.fastjson.JSON;

public class AttackMessage
{
    public Location loc;

    public AttackMessage(Location loc)
    {
        this.loc = loc;
    }

    public String toString()
    {
        return JSON.toJSONString(this);
    }

    public static AttackMessage parseAttackMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, AttackMessage.class);
    }
}


