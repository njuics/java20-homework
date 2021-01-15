package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.DirectionEnum;
import advancedjava.finalproj.game.Location;
import com.alibaba.fastjson.JSON;

//游戏人物移动
public class MoveMessage
{
    public Location loc;
    public DirectionEnum direction;

    public MoveMessage(Location loc, DirectionEnum direction)
    {
        this.loc = loc;
        this.direction = direction;
    }

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }

    static public MoveMessage parseMoveMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, MoveMessage.class);
    }
}
