/*
基类：生物类
    属性：
        基本属性：阵营，姓名，是否治愈者，移速，是否存活，资源图片
        空间属性：
        战斗属性：最大血量，当前血量，最大魔法，当前魔法,普通攻击，技能攻击，技能攻击消耗魔法值,治愈术，治愈消耗魔法值
    构造器：

    方法：
        战斗模块：
            获取属性；get_xxx()
            设置初始位置；
            移动；
            计算释放攻击/技能后属性改变
            计算受伤后属性改变
            计算治愈后属性改变
        控制模块：
            运行；
            指令解析；



*/


package sample;

import java.util.concurrent.atomic.*;

public class Creature implements Runnable{

    //属性-------------------------------------------//
    //--------------基本属性----------------
    Camp camp;
    String cname;
    int id;
    Battle battle;
    boolean healer;
    int speed = 1;
    boolean alive = true;
    String rscname;
    //--------------空间属性--------------
    public AtomicInteger curX=new AtomicInteger(0);
    public AtomicInteger curY=new AtomicInteger(0);
    protected int dstX; //目的位置好像也没用到
    protected int dstY;
    public AtomicBoolean avaliable=new AtomicBoolean(true);
    public AtomicInteger cmd=new AtomicInteger(0);
    public AtomicBoolean visible=new AtomicBoolean(false);
    //---------------战斗属性-------------
    final int maxHP=50;//TODO
    int HP;
    final int maxMP=50;//TODO
    int MP;
    int gnrAtk=5;//普通攻击值？
    int mgcAtk;
    int mgcCost;
    int healing;
    int healCost;

//构造器-----------------------------------------//
    Creature(int id,String name,Battle battle,Camp camp){
        this.id=id;
        this.cname=name;
        this.battle=battle;
        this.camp=camp;
        HP=maxHP;
        MP=maxMP;
    }

    //方法------------------------------------------//
    //-----------------战斗模块-------------
    public void initpos(){

    }

    public void move(Direction dir){//根据方向移动
        switch(dir){
            case UP: move(curX.get(),curY.get()-1);break;
            case DOWN:move(curX.get(),curY.get()+1);break;
            case LEFT:move(curX.get()-1,curY.get());break;
            case RIGHT:move(curX.get()+1,curY.get());break;
            default:;
        }
    }
    public boolean move(int x,int y){//移动到[x,y]
        //TODO:加上只能移到相邻格子的限制？
        if (x>=0 && x<Attributes.gridNumX && y>=0 && y<Attributes.gridNumY
                && !battle.isOccupied(x,y)){
            //移动条件：不超边界且无其他角色占用
            //TODO:对地图的访问控制
            battle.map[Attributes.gridNumX*curY.get()+curX.get()]=-1;//空出原位置
            battle.map[Attributes.gridNumX*y+x]=id;//标记新位置
            curX.set(x);
            curY.set(y);
            return true;
        }
        else
            return  false;
    }
    /*
     * parm:指向方向 解释：只能向一个格子内的友方使用治愈术 附加：后期加绿色向上数字表示加血效果
     */
    public int useHealing(Direction dir) {
        if (this.MP <= 0)
            return -1;
        int heelx = curX.get(), heely = curY.get();
        switch (dir) {
            case UP:
                heely--;
                break;
            case DOWN:
                heely++;
                break;
            case LEFT:
                heelx--;
                break;
            case RIGHT:
                heelx++;
                break;
            default:
                return -1;
        }
        if (battle.isOccupied(heelx, heely) == false)
            return -1;
        ;
        int heelid = battle.map[Attributes.gridNumX * heely + heelx];
        if (this.camp != battle.roles.get(heelid).camp)
            return -1;
        if (battle.roles.get(heelid).alive == false)
            return -1;
        battle.roles.get(heelid).beenHealed(this.healing);
        this.MP -= this.healCost;
        return heelid;
    }

    /*
    parm:攻击方向
    解释：只能朝一个格子内的敌人发起攻击
    附加：后期可加红色数字图标展示失血效果
*/
    public int useGnrAtk(Direction dir){
        int atkx = curX.get(),atky = curY.get();
        switch(dir){
            case UP: atky--;break;
            case DOWN: atky++;break;
            case LEFT:atkx--;break;
            case RIGHT:atkx++;break;
            default: return -1;
        }
        if (battle.isOccupied(atkx,atky) == false)
            return -1;
        int atkid = battle.map[Attributes.gridNumX*atky+atkx];
        if (this.camp == battle.roles.get(atkid).camp)
            return -1;
        battle.roles.get(atkid).beenAtked(this.gnrAtk);
        return atkid;
    }
    /*
        暂时不写
        parm:释放技能方向
        解释：先得出在攻击方向上的格子,然后依次检测，飞过空格显示对应子弹,遇到敌人子弹消亡，敌人扣血，停止检测
    */
    /*
    public void useMgcAtk(Direction dir){
        if (this.MP<=0)
            return;
        int pos = curY.get()*Attributes.gridNumX + curX.get();
        ArrayList<Integer> atkRoute = new ArrayList<Integer>();
        Bullet bullet = new Bullet(img);

    }*/
    /*
        parm:指向方向
        解释：只能向一个格子内的友方使用治愈术
        附加：后期加绿色向上数字表示加血效果
    */
    /*
    public void useHealing(Direction dir){
        if (this.MP<=0)
            return;
        int heelx = curX.get(),heely = curY.get();
        switch(dir){
            case UP: heely--;break;
            case DOWN: heely++;break;
            case LEFT:heelx--;break;
            case RIGHT:heelx++;break;
            default: return;
        }
        if (battle.isOccupied(heelx,heely) == false)
            return;
        int heelid = battle.map[Attributes.gridNumX*heely+heelx];
        if (this.camp != battle.roles.get(heelid).camp)
            return;
        battle.roles.get(heelid).beenHealed(this.healing);
        this.MP-=this.healCost;
    }*/
    /*
        parm:损失血量
    */

    public void beenAtked(int lost){
        this.HP-=lost;
        battle.hpbars.get(this.id).setBar(battle.roles.get(this.id));
        System.out.println(this.id + "被攻击" + this.HP);
        if (HP<=0){ //死亡后，地图上格子设为空，！！！确定人物已经消失不再展示了吗？要不要放置墓碑？）
            this.alive = false;
            battle.map[curY.get() * Attributes.gridNumX + curX.get()] = -1;
            System.out.println("todo:人物死亡移除图片成墓碑");

        }
    }
    public void beenHealed(int inc){
        this.HP = Math.min(HP + inc,maxHP);
    }
    //------------------控制模块-------------
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cmdHandler();
        }
    }
    protected void cmdHandler() {

    }

}