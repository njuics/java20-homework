package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Battle{
    boolean started=false;
    int enemyId;
    int[] map=new int[Attributes.gridNumX*Attributes.gridNumY];//记录地图中每格的角色id
    ArrayList<Creature> roles=new ArrayList<>();//存储游戏角色
    ArrayList<Info> hpbars =  new ArrayList<>();//角色对应的血条,存储顺序和角色一样
    //Map<String,Integer> roleId=new HashMap<>();
    int[] startPos={9,10,11,20,27,28,29,19,18,17,35,15,16,24,25,26,33,34};//游戏开始角色布局
    Camp myCamp=Camp.CALABASH;//TODO
    int myDeadCount=0;//己方死亡角色个数
    int enemyDeadCount=0;//敌方死亡角色个数
    int selected;//被选中的角色id
    XMLFile gameprogress = new XMLFile();//记录战局的文件
    Battle(){
        //游戏开始时角色在地图上的排列情况
        for(int i=0;i<map.length;i++){
            map[i]=-1;
        }
        for(int i=0;i<startPos.length;i++){
            map[startPos[i]]=i;
        }
        //添加角色
        Camp c=Camp.CALABASH;
        Camp m=Camp.MONSTER;
        List<Creature> rolesList = Arrays.asList(
                new Creature(0,"calabash1",this,c),
                new Creature(1,"calabash2",this,c),
                new Creature(2,"calabash3",this,c),
                new Creature(3,"calabash4",this,c),
                new Creature(4,"calabash5",this,c),
                new Creature(5,"calabash6",this,c),
                new Creature(6,"calabash7",this,c),
                new Creature(7,"grandpa",this,c),
                new Creature(8,"pangolin",this,c),
                new Creature(9,"scorpion",this,m),
                new Creature(10,"snake",this,m),
                new Creature(11,"minion",this,m),
                new Creature(12,"minion",this,m),
                new Creature(13,"minion",this,m),
                new Creature(14,"minion",this,m),
                new Creature(15,"minion",this,m),
                new Creature(16,"minion",this,m),
                new Creature(17,"minion",this,m)
        );
        for(int i=0;i<rolesList.size();i++){
            rolesList.get(i).curX.set(startPos[i]%9);
            rolesList.get(i).curY.set(startPos[i]/9);
            Info tempbar = new Info();
            tempbar.setBar(rolesList.get(i));
            hpbars.add(tempbar);
        }
        roles.addAll(rolesList);
        //
        //roleId.put("bro1",0);
        //roleId.put("bro1",0);
    }
    /*
    public Creature getRole(int x,int y){
        return roles.get(map[x*Attributes.gridNumX+y]);
    }
    public int getRoleId(int x,int y){
        return map[x*Attributes.gridNumX+y];
    }
     */
    public void setCamp(Camp c){
        myCamp=c;
    }
    public boolean isOccupied(int x,int y){//判断地图[x,y]位置是否被角色占用
        return map[y*Attributes.gridNumX+x]!=-1;
    }

    public String dir2str(Direction dir){
        switch(dir){
            case LEFT: return "LEFT";
            case RIGHT: return "RIGHT";
            case UP: return "UP";
            case DOWN: return "DOWN";
            default:return "";
        }
    }

}