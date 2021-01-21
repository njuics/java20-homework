package org.cvm.world.Character;

public class Monster extends Creature{
    public int posx;
    public int posy;
    private int No_x;
    private String skillname;
    private String skilldescription;
    private int[][] field;
    private int skillnumber;
    private int skillcost;
    private int skillbufftime;
    public Monster(int attack,int armor,int criticalstrike,int missrate,int HP,int number){
        super(attack,armor,criticalstrike,missrate,HP);
        No_x=number;
        posx=-1;
        posy=-1;
        switch (number){
            case 1:{
                skillname="蛇精";//对正前方三格内的角色造成伤害并大幅度削弱正前方三格内所有敌方的护甲，持续一回合,减甲倍率0.7
                skilldescription="对前方一名角色造成伤害并大幅度削弱正前方三格内所有敌方的护甲，持续一回合,减甲倍率0.7";
                field=new int[][]{{0,1},{0,2},{0,3}};
                this.skillnumber=(int)(attack*1.3);
                skillbufftime=1;
                skillcost=3;
                break;
            }
            case 2:{
                skillname="蝎子精";//随机中幅度削弱敌方3人的物理攻击力一回合，减攻倍率为0.4
                skilldescription="随机中幅度削弱敌方3人的物理攻击力一回合，减攻倍率为0.4";
                field=new int[][]{{-1,1},{0,1},{1,1},{-1,2},{0,2},{1,2}};
                skillnumber=60;
                skillbufftime=1;
                skillcost=2;
                break;
            }
            case 3:{
                skillname="鳄鱼精";//小幅度削弱单体的攻击力，并小幅度提升自身防御力，持续两回合,倍率为0.2
                skilldescription="本次单体攻击的攻击力降低，并小幅度提升自身防御力，持续两回合,倍率为0.2";
                field=new int[][]{{0,1}};
                skillnumber=(int)(attack*0.8);
                skillbufftime=2;
                skillcost=2;
                break;
            }
            case 4:{
                skillname="金刚大王";//范围aoe伤害
                skilldescription="范围aoe伤害";
                field=new int[][]{{1,1},{-1,1},{0,1},{0,2},{1,2},{-1,2}};
                skillnumber=(int)(attack*1.3);
                skillbufftime=0;
                skillcost=3;
                break;
            }
            case 5:{
                skillname="蜈蚣精";//范围aoe伤害，并中幅度提升自身攻击力，持续2回合
                skilldescription="范围aoe伤害，并中幅度提升自身攻击力，持续2回合";
                field=new int[][]{{1,1},{-1,1},{0,1},{0,2},{1,2},{-1,2}};
                skillnumber=(int)(attack*1.2);
                skillbufftime=1;
                skillcost=3;
                break;
            }
            case 6:{
                skillname="蝙蝠精";//常规攻击，我方所有角色护甲小幅度提升，持续两回合
                skilldescription="常规攻击，我方所有角色护甲小幅度提升，持续两回合";
                field=new int[][]{{0,1}};
                skillnumber=(int)(attack*1.2);
                skillbufftime=2;
                skillcost=2;
                break;
            }
            case 7:{
                skillname="蛤蟆精";//使用技能后，我方恢复3点行动力
                skilldescription="使用技能后，我方恢复3点行动力";
                field=new int[][]{{0,1}};
                skillnumber=(int)(attack*1.2);
                skillbufftime=1;
                skillcost=5;
                break;
            }
            default:break;
        }
    }

    public int getNo_x() {
        return No_x;
    }
    public int[][] getField() {
        return field;
    }
    public String getSkillname() {
        return skillname;
    }

    public int getSkillbufftime() {
        return skillbufftime;
    }

    public int getSkillcost() {
        return skillcost;
    }

    public int getSkillnumber() {
        return skillnumber;
    }

    public String getSkilldescription() {
        return skilldescription;
    }
}
