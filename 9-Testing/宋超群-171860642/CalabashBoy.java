public class CalabashBoy implements  Comparable<CalabashBoy>, SpecialSkills{
    protected int rank;
    protected int HP;
    protected String name;
    protected String skills;

    CalabashBoy(){
        HP = 1000;
    }
    //休息一下，回复HP
    void getWell(){
        if(HP < 990)
            HP += 10;
        else HP = 1000;
    }

    void getAttacked(int damage){
        HP -= damage;
    }

    int getHP(){
        return HP;
    }

    String getName(){
        return name;
    }

    int getRank(){
        return rank;
    }

    public void useSkill(){
        System.out.println(skills);
    }

    @Override
    public String toString(){
        return "我是" + name + "，我的技能是" + skills;
    }
    @Override
    public int compareTo(CalabashBoy boy){
        return rank - boy.getRank();
    }
}

class RedBoy extends CalabashBoy{
    RedBoy(){
        name = "红娃";
        rank = 1;
        skills = "力壮术、巨大化";
    }
}

class OrangeBoy extends CalabashBoy{
    OrangeBoy(){
        name = "橙娃";
        rank = 2;
        skills = "千里眼、顺风耳";
    }
}

class YellowBoy extends CalabashBoy{
    YellowBoy(){
        name = "黄娃";
        rank = 3;
        skills = "刀枪不入";
    }
}

class GreenBoy extends CalabashBoy{
    GreenBoy(){
        name = "绿娃";
        rank = 4;
        skills = "火攻、吸纳火焰、霹雳";
    }
}

class CyanBoy extends CalabashBoy{
    CyanBoy(){
        name = "青娃";
        rank = 5;
        skills = "洪击、蓄水、闪电";
    }
}

class BlueBoy extends CalabashBoy{
    BlueBoy(){
        name = "蓝娃";
        rank = 6;
        skills = "隐形";
    }
}

class PurpleBoy extends CalabashBoy{
    PurpleBoy(){
        name = "紫娃";
        rank = 7;
        skills = "神葫芦";
    }
}