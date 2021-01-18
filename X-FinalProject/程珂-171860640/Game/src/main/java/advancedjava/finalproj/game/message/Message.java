package advancedjava.finalproj.game.message;

import advancedjava.finalproj.game.CampEnum;
import com.alibaba.fastjson.JSON;

public class Message
{
    public CampEnum senderCamp;
    public MessageType type;
    public String content;

    public Message(CampEnum senderCamp, MessageType type, String content)
    {
        this.content = content;
        this.type = type;
        this.senderCamp = senderCamp;
    }

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }

    static public Message parseMessage(String msgStr)
    {
        return JSON.parseObject(msgStr, Message.class);
    }

}
