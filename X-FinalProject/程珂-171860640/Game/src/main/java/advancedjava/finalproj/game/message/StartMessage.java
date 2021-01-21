package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.CampEnum;
import com.alibaba.fastjson.JSON;

//告知客户端所在阵营
public class StartMessage
{

    public CampEnum camp;
    public long seed;

    public StartMessage(CampEnum camp, long seed)
    {
        this.camp = camp;
        this.seed = seed;
    }

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }

    static public StartMessage parseStartMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, StartMessage.class);
    }

}
