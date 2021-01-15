package hulubattle.game.data;

/**
 * 技能数据的抽象类，可以实现并重写 get 方法以定制化
 */
public abstract class AbstractSkillData implements Data {
    private final int id;
    private final String name;
    private final boolean harm;
    private final int range;
    private final int atk;
    private final int atkNum;

    @Override
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the harm
     */
    public boolean isHarm() {
        return harm;
    }

    /**
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * @return the atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * @return the atkNum
     */
    public int getAtkNum() {
        return atkNum;
    }

    /**
     * 成员构造器
     *
     * @param id     技能数据 ID
     * @param name   技能名称
     * @param harm   目标是否为敌方
     * @param range  技能射程
     * @param atk    技能攻击力
     * @param atkNum 技能攻击次数
     */
    protected AbstractSkillData(int id, String name, boolean harm, int range, int atk, int atkNum) {
        this.id = id;
        this.name = name;
        this.harm = harm;
        this.range = range;
        this.atk = atk;
        this.atkNum = atkNum;
    }

    /**
     * 无参构造器
     */
    protected AbstractSkillData() {
        id = range = atk = atkNum = 0;
        harm = false;
        name = null;
    }
}
