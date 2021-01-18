package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.Location;
import com.alibaba.fastjson.JSON;

public class DefenseMessage
{
    public Location loc;

    public DefenseMessage(Location loc)
    {
        this.loc = loc;
    }

    public String toString()
    {
        return JSON.toJSONString(this);
    }

    public static DefenseMessage parseDefenseMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, DefenseMessage.class);
    }
}
