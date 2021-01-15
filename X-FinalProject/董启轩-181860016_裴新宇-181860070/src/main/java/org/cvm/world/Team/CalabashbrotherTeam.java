package org.cvm.world.Team;
import org.cvm.world.Buff.*;
import org.cvm.world.Character.*;
import org.cvm.world.Algorithm.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalabashbrotherTeam {
    static final int MaxTeamSkillNumber=10;
    private int teamSkillNumber;
    static final int MaxTeamAcitonNumber=15;
    private int teamActionnumber;
    static private int[] ifaction;
    static List<CalabashBrother> list;
    private Assault a;
    public CalabashbrotherTeam(){
        list=new ArrayList<CalabashBrother>();
        a=new Assault();
        ifaction=new int[7];
        for(int i=0;i<7;i++)
            ifaction[i]=1;//1=notdoattack 0=alreadyattack -1/othernumber=error
        CalabashBrother c1=new CalabashBrother(80,50,5,3,400,1);
        CalabashBrother c2=new CalabashBrother(40,40,5,7,300,2);
        CalabashBrother c3=new CalabashBrother(60,100,5,1,500,3);
        CalabashBrother c4=new CalabashBrother(70,60,5,3,350,4);
        CalabashBrother c5=new CalabashBrother(70,60,5,3,350,5);
        CalabashBrother c6=new CalabashBrother(55,55,5,10,350,6);
        CalabashBrother c7=new CalabashBrother(60,60,5,5,300,7);
        c1.posx=0;c1.posy=0;
        c2.posx=1;c2.posy=0;
        c3.posx=2;c3.posy=0;
        c4.posx=3;c4.posy=0;
        c5.posx=4;c5.posy=0;
        c6.posx=1;c6.posy=1;
        c7.posx=3;c7.posy=1;
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        teamActionnumber=MaxTeamAcitonNumber;
        teamSkillNumber=MaxTeamSkillNumber;
    }
    public static boolean isGameOver() {
        return (list.size() == 0) ? true : false;
    }

    public static int getMaxTeamAcitonNumber() {
        return MaxTeamAcitonNumber;
    }

    public static int getMaxTeamSkillNumber() {
        return MaxTeamSkillNumber;
    }

    public int getTeamActionnumber() {
        return teamActionnumber;
    }

    public int getTeamSkillNumber() {
        return teamSkillNumber;
    }

    public void TeamNewTurn(){
        for(CalabashBrother c:list){
            c.newturn();
        }
        for(int i=0;i<7;i++)
            if (ifaction[i]==0) ifaction[i]=1;//1=notdoattack 0=alreadyattack -1/othernumber=error
        teamSkillNumber=MaxTeamSkillNumber;
        teamActionnumber=MaxTeamAcitonNumber;
    }

    public int getNo(int num){//返回葫芦娃参数No_X,范围1~7
        int x=num/9;//行
        int y=num%9;//列
        for(int i=0;i<list.size();i++){
            if(list.get(i).posx==x && list.get(i).posy==y){
                return list.get(i).getNo_x();
            }
        }
        return -1;
    }

    public static CalabashBrother getCal(int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).posx == x && list.get(i).posy == y) {
                CalabashBrother c = list.get(i);
                return c;
            }
        }
        CalabashBrother m=new CalabashBrother(0,0,0,0,0,0);
        return m;
    }

    public int[] getallpostion(){
        int[] pos=new int[7];
        for(int i=0;i<list.size();i++){
            pos[i]=list.get(i).posx*9+list.get(i).posy;
        }
        return pos;
    }

    static void calabashbrotherDead(int No_x){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                list.remove(i);
                ifaction[No_x-1]=-1;
                break;
            }
        }
    }

    public String getSkillName(int No_x) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                CalabashBrother c = list.get(i);
                return c.getSkillname();
            }
        }
        return "";
    }

    public List<String> getinformation(int No_x){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                CalabashBrother c=list.get(i);
                List<String> output=new ArrayList<String>();
                output.add("角色名称：" + c.getSkillname());
                output.add("总血量：" + c.getMAXHP());
                output.add("普攻伤害："+c.getAttack());
                output.add("技能伤害："+c.getSkillnumber());
                output.add("技能描述："+ c.getSkilldescription());
                output.add("技能消耗：" + c.getSkillcost());
                return output;
                }
            }
        List<String> output=new ArrayList<String>();
        return output;
    }

    public static void getattack(int No_x,int damage,CalabashBrother c){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                int HP=list.get(i).getHP();
                list.get(i).setHP(HP-damage);
                c=list.get(i);
                break;
            }
        }
    }

    public int[] moveup(int No_x){
        int[] a=new int[1];
        a[0]=-1;
        if(teamActionnumber<=0) return a;
        int i=0;
        CalabashBrother c=list.get(i);
        for(i=0;i< list.size();i++){
            if(list.get(i).getNo_x()==No_x) {
                c=list.get(i);
                break;
            }
        }
        if(i>=list.size()) return a;
        int x=c.posx;
        int y=c.posy;
        int pos0=x*9+y;
        if(x-1<0) return a;
        if(CalabashbrotherTeam.haveCreature(x-1,y)||MonsterTeam.haveCreature(x-1,y)) return a;
        list.get(i).posx=x-1;
        teamActionnumber--;
        int[] arr=new int[4];
        arr[0]=1;//Team
        arr[1]=No_x;//brother number
        arr[2]=pos0;//origin position
        arr[3]=list.get(i).posx*9+list.get(i).posy;//new position
        return arr;
    }
    public int[] movedown(int No_x){
        int[] a=new int[1];
        a[0]=-1;
        if(teamActionnumber<=0) return a;
        int i=0;
        CalabashBrother c=list.get(i);
        for(i=0;i< list.size();i++){
            if(list.get(i).getNo_x()==No_x) {
                c=list.get(i);
                break;
            }
        }
        if(i>=list.size()) return a;
        int x=c.posx;
        int y=c.posy;
        int pos0=x*9+y;
        if(x+1>4) return a;
        if(CalabashbrotherTeam.haveCreature(x+1,y)||MonsterTeam.haveCreature(x+1,y)) return a;
        list.get(i).posx=x+1;
        teamActionnumber--;
        int[] arr=new int[4];
        arr[0]=1;//Team
        arr[1]=No_x;//brother number
        arr[2]=pos0;//origin position
        arr[3]=list.get(i).posx*9+list.get(i).posy;//new position
        return arr;
    }
    public int[] moveleft(int No_x){
        int[] a=new int[1];
        a[0]=-1;
        if(teamActionnumber<=0) return a;
        int i=0;
        CalabashBrother c=list.get(i);
        for(i=0;i< list.size();i++){
            if(list.get(i).getNo_x()==No_x) {
                c=list.get(i);
                break;
            }
        }
        if(i>=list.size()) return a;
        int x=c.posx;
        int y=c.posy;
        int pos0=x*9+y;
        if(y-1<0) return a;
        if(CalabashbrotherTeam.haveCreature(x,y-1)||MonsterTeam.haveCreature(x,y-1)) return a;
        list.get(i).posy=y-1;
        teamActionnumber--;
        int[] arr=new int[4];
        arr[0]=1;//Team
        arr[1]=No_x;//brother number
        arr[2]=pos0;//origin position
        arr[3]=list.get(i).posx*9+list.get(i).posy;//new position
        return arr;
    }
    public int[] moveright(int No_x){
        int[] a=new int[1];
        a[0]=-1;
        if(teamActionnumber<=0) return a;
        int i=0;
        CalabashBrother c=list.get(i);
        for(i=0;i< list.size();i++){
            if(list.get(i).getNo_x()==No_x) {
                c=list.get(i);
                break;
            }
        }
        if(i>=list.size()) return a;
        int x=c.posx;
        int y=c.posy;
        int pos0=x*9+y;
        if(y+1>8) return a;
        if(CalabashbrotherTeam.haveCreature(x,y+1)||MonsterTeam.haveCreature(x,y+1)) return a;
        list.get(i).posy=y+1;
        teamActionnumber--;
        int[] arr=new int[4];
        arr[0]=1;//Team
        arr[1]=No_x;//brother number
        arr[2]=pos0;//origin position
        arr[3]=list.get(i).posx*9+list.get(i).posy;//new position
        return arr;
    }
    public static boolean haveCreature(int x,int y){
        for(int i=0;i<list.size();i++){
            if(list.get(i).posx==x && list.get(i).posy==y){
                return true;
            }
        }
        return false;
    }
    public static String getAttackBuff(int No_x,int attackchange,int attackbufftime){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                list.get(i).newAttackBuff(attackchange, attackbufftime);
                return "CalabashBrother "+No_x+" get Attack buff : change:"+ attackchange +" time:"+attackbufftime;
            }
        }
        return "";
    }
    public static String getArmorBuff(int No_x,int armorchange,int armorbufftime){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getNo_x()==No_x){
                list.get(i).newArmorBuff(armorchange, armorbufftime);
                return "CalabashBrother "+No_x+" get Armor buff : change:"+ armorchange +" time:"+armorbufftime;
            }
        }
        return "";
    }
    public List<List<Integer>> Doattack(int No_x,boolean is_skill) {
        List<List<Integer>> A=new ArrayList<List<Integer>>();
        List<Integer> A_in=new ArrayList<Integer>();
        A_in.add(-1);
        A.add(A_in);
        List<List<Integer>> array=new ArrayList<List<Integer>>();
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getNo_x() == No_x) break;
        }
        if (i >= list.size()) return A;
        if(ifaction[No_x-1]!=1) return A;
        if(teamActionnumber<=0) return A;
        CalabashBrother c=list.get(i);
        if(is_skill && c.getSkillcost()>teamSkillNumber) return A;
        int x=c.posx;
        int y=c.posy;
        int[][] f=c.getField();
        List<Integer> entry=new ArrayList<Integer>();
        entry.add(1);//Team
        entry.add(No_x);//brother number
        if(is_skill) entry.add(2);
        else entry.add(1);//skill choice
        array.add(entry);
        teamActionnumber--;
        ifaction[No_x-1]=0;
        if(is_skill) {
            teamSkillNumber-=list.get(i).getSkillcost();
            if(teamSkillNumber<=0) teamSkillNumber=0;
            for (int j = 0; j < f.length; j++) {
                if (MonsterTeam.haveCreature(x + f[j][0], y + f[j][1])) {
                    Monster m = MonsterTeam.getMon(x + f[j][0], y + f[j][1]);
                    CalabashBrother tmp=c;
                    tmp.setAttack(c.getSkillnumber());
                    int damage = a.DamageCaculate(tmp, m);
                    if (damage == -1){
                        entry=new ArrayList<Integer>();
                        entry.add(1);//mean attack
                        entry.add(m.getNo_x());//monster number
                        entry.add(damage);//damage,-1 equals miss;
                    }
                    else{
                        MonsterTeam.getattack(m.getNo_x(),damage,m);
                        entry=new ArrayList<Integer>();
                        entry.add(1);//mean attack
                        entry.add(m.getNo_x());//monster number
                        entry.add(damage);//damage
                        entry.add(m.getHP());//HP after damage
                        entry.add(m.getMAXHP());//Max HP
                        array.add(entry);
                        if(m.getHP()<=0) MonsterTeam.monsterDead(m.getNo_x());
                    }
                }
            }
            switch (No_x) {
                case 1:break;
                case 2: {
                    int attackchange=60;
                    for(int j=0;j<list.size();j++){
                        list.get(j).newAttackBuff(attackchange,c.getSkillbufftime());
                        entry=new ArrayList<Integer>();
                        entry.add(2);//mean buff
                        entry.add(1);//mean team
                        entry.add(list.get(j).getNo_x());//creature number
                        entry.add(1);//mean attack(1)/armor(2) buff
                        entry.add(attackchange);
                        entry.add(c.getSkillbufftime());
                        array.add(entry);
                    }
                    break;
                }
                case 3: {
                    int armorchange=(int)(c.getArmor()*0.3);
                    list.get(i).newArmorBuff((int)(c.getArmor()*0.3),c.getSkillbufftime());
                    entry=new ArrayList<Integer>();
                    entry.add(2);//mean buff
                    entry.add(1);//mean team
                    entry.add(list.get(i).getNo_x());//creature number
                    entry.add(2);//mean attack(1)/armor(2) buff
                    entry.add(armorchange);
                    entry.add(c.getSkillbufftime());
                    array.add(entry);
                    break;
                }
                case 4: break;
                case 5: {
                    int armorchange=-(int)(c.getArmor()*0.2);
                    for (int j = 0; j < f.length; j++) {
                        if (MonsterTeam.haveCreature(x + f[j][0], y + f[j][1])) {
                            Monster m = MonsterTeam.getMon(x + f[j][0], y + f[j][1]);
                            MonsterTeam.getArmorBuff(m.getNo_x(),-(int)(c.getArmor()*0.2),c.getSkillbufftime());
                            entry=new ArrayList<Integer>();
                            entry.add(2);//mean buff
                            entry.add(2);//mean team
                            entry.add(list.get(i).getNo_x());//creature number
                            entry.add(2);//mean attack(1)/armor(2) buff
                            entry.add(armorchange);
                            entry.add(c.getSkillbufftime());
                            array.add(entry);
                        }

                    }
                }
                case 6: {
                    int armorchange=15;
                    for(int j=0;j<list.size();j++){
                        list.get(j).newArmorBuff(armorchange,c.getSkillbufftime());
                        entry=new ArrayList<Integer>();
                        entry.add(2);//mean buff
                        entry.add(1);//mean team
                        entry.add(list.get(j).getNo_x());//creature number
                        entry.add(2);//mean attack(1)/armor(2) buff
                        entry.add(armorchange);
                        entry.add(c.getSkillbufftime());
                        array.add(entry);
                    }
                    break;
                }
                case 7: {
                    int armorchange=-(int)(c.getArmor()*0.7);
                    List<Integer> arr=new ArrayList<Integer>();
                    for(int j=1;j<=MonsterTeam.list.size();j++)
                        arr.add(j);
                    Collections.shuffle(arr);
                    for(int j=0;j<2&j<arr.size();j++)
                    {
                        MonsterTeam.getArmorBuff(arr.get(j),-(int)(c.getArmor()*0.7),c.getSkillbufftime());
                        entry=new ArrayList<Integer>();
                        entry.add(2);//mean buff
                        entry.add(2);//mean team
                        entry.add(list.get(arr.get(j)-1).getNo_x());//creature number
                        entry.add(2);//mean attack(1)/armor(2) buff
                        entry.add(armorchange);
                        entry.add(c.getSkillbufftime());
                        array.add(entry);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        else {
            if(MonsterTeam.haveCreature(c.posx,c.posy+1)){
                Monster m=MonsterTeam.getMon(c.posx,c.posy+1);
                int damage=a.DamageCaculate(c,m);
                if (damage == -1){
                    entry=new ArrayList<Integer>();
                    entry.add(1);//mean attack
                    entry.add(m.getNo_x());//monster number
                    entry.add(damage);//damage,-1 equals miss;
                }
                else{
                    MonsterTeam.getattack(m.getNo_x(),damage,m);
                    entry=new ArrayList<Integer>();
                    entry.add(1);//mean attack
                    entry.add(m.getNo_x());//monster number
                    entry.add(damage);//damage
                    entry.add(m.getHP());//HP after damage
                    entry.add(m.getMAXHP());//Max HP
                    array.add(entry);
                    if(m.getHP()<=0) MonsterTeam.monsterDead(m.getNo_x());
                }
            }
        }
        return array;
    }
}
