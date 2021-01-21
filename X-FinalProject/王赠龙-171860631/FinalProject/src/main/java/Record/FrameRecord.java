package Record;

import java.io.Serializable;
import java.util.ArrayList;
import Creature.Type;

/*记录每一帧所有需要记录的信息*/
public class FrameRecord implements Serializable {
    public ArrayList<RecordSample> frameArraylist;
    public boolean isGameEnd;
    public Type winner;
    public FrameRecord(){
        frameArraylist=new ArrayList<>();
        isGameEnd=false;
        winner=null;
    }
}
