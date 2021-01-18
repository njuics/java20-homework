import BattleControl.Controller;
import BattleControl.GameMap;
import BattleControl.NetPacket;
import BattleControl.NetThread;
import Creature.Creature;
import javafx.scene.image.Image;
import org.junit.*;
import Creature.Type;

import java.net.MalformedURLException;
import java.net.URL;

public class FinalTest {
    private Creature creature;
    public FinalTest(){
        creature = new Creature(100, 1, 1, 0, 0, null, Type.EVIL, "Snake");
    }
    @BeforeClass
    public static void beforeAllTest(){
        System.out.println("Start All Test!");
    }
    @AfterClass
    public static void afterALLTest(){
        System.out.println("End All Test!");
    }
    @Before
    public void beforeOneTest(){
        System.out.println("Start One Test!");
    }
    @After
    public void afterOneTest(){
        System.out.println("End One Test!");
    }
    @Test
    public void testSetHp(){
        creature.setHp(400);
    }
    @Test
    public void testGetHp(){
        double tempHp=creature.getHp();
    }
    @Test
    public void testSetMaxHp(){
        creature.setMaxHp(500);
    }
    @Test
    public void testIsAlive(){
        boolean isAlive=creature.isAlive();
        if(isAlive){
            System.out.println("isAlive!");
        }
        else{
            System.out.println("isDead!");
        }
    }
    @Test
    public void testInMap(){
        boolean isInMap=creature.getPosX()>=0&&creature.getPosX()<16&&creature.getPosY()>=0&&creature.getPosY()<12;
        if(isInMap){
            System.out.println("isInMap!");
        }
        else{
            System.out.println("outMap!");
        }
    }
    @Test
    public void testNetProcess(){
        NetPacket testPacket=new NetPacket(true,creature.getName(),3,3,100);
        byte[] buffer= Controller.convertToByte(testPacket);
        NetThread thread=new NetThread(8090,8091,"172.27.140.72");
        NetPacket resPacket=thread.convertToNetPacket(buffer);
        boolean testEqual=ifEqual(testPacket,resPacket);
        if(!testEqual){
            System.out.println("error in testNetProcess()");
            System.exit(-1);
        }
    }
    private boolean ifEqual(NetPacket src,NetPacket res){
        if(!src.getName().equals(res.getName()))return false;
        if(src.getType()!=res.getType())return false;
        if(src.getNewPosX()!=res.getNewPosX())return false;
        if(src.getNewPosY()!=res.getNewPosY())return false;
        if(src.getHp()!=res.getHp())return false;
        return true;
    }
}
