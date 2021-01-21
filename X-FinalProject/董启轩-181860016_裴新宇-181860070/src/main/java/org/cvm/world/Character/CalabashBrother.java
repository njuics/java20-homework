package org.cvm.world.Character;

public class CalabashBrother extends Creature{
    public int posx;
    public int posy;
    private int No_x;
    private String skillname;
    private String skilldescription;
    private int[][] field;
    private int skillnumber;
    private int skillcost;
    private int skillbufftime;
    public CalabashBrother(int attack,int armor,int criticalstrike,int missrate,int HP,int number){
        super(attack,armor,criticalstrike,missrate,HP);
        No_x=number;
        posx=-1;
        posy=-1;
        switch (number){
            case 1:{
                skillname="大娃";//前方一格高伤攻击
                skilldescription="前方一格高伤攻击";
                field=new int[1][2];
                field[0][0]=0;
                field[0][1]=1;
                this.skillnumber=(int)(attack*2);
                skillcost=3;
                skillbufftime=0;
                break;
            }
            case 2:{
                skillname="二娃";//进行正前方攻击并为我方单位提供加攻buff
                skilldescription="进行正前方攻击并为我方单位提供加攻buff";
                field=new int[][]{{0,1}};
                skillnumber=attack;
                skillbufftime=3;
                skillcost=2;
                break;
            }
            case 3:{
                skillname="三娃";//以单次攻击力的减少，换取一回合的护甲提升，提升倍率为0.3
                skilldescription="以单次攻击力的减少，换取一回合的护甲提升，提升倍率为0.3";
                field=new int[][]{{0,1}};
                skillnumber=(int)(attack*0.7);
                skillbufftime=1;
                skillcost=2;
                break;
            }
            case 4:{
                skillname="四娃";//范围aoe伤害
                skilldescription="范围aoe伤害";
                field=new int[][]{{0,1},{0,2},{0,3},{1,2},{-1,2},{-1,3},{1,3}};
                skillnumber=(int)(attack*1.4);
                skillbufftime=0;
                skillcost=3;
                break;
            }
            case 5:{
                skillname="五娃";//范围aoe伤害，并带有一回合小额减甲,减甲倍率为0.2
                skilldescription="范围aoe伤害，并带有一回合小额减甲,减甲倍率为0.2";

                field=new int[][]{{-1,1},{1,1},{0,1},{-1,2},{0,2},{1,2}};
                skillnumber=(int)(attack*1.2);
                skillbufftime=1;
                skillcost=3;
                break;
            }
            case 6:{
                skillname="六娃";//常规攻击，并小幅度提升我方护甲值，持续2回合
                skilldescription="常规攻击，并小幅度提升我方护甲值，持续2回合";
                field=new int[][]{{0,1}};
                skillnumber=attack;
                skillbufftime=1;
                skillcost=2;
                break;
            }
            case 7:{
                skillname="七娃";//对正前方三格进行攻击，并在攻击之后对敌方随机两名角色进行一回合中幅度减甲,减甲倍率为0.5
                skilldescription="对正前方三格进行攻击，并在攻击之后对敌方随机两名角色进行一回合中幅度减甲,减甲倍率为0.5";
                field=new int[][]{{0,1},{0,2},{0,3}};
                skillnumber=(int)(attack*0.8);
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
