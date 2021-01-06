package hulubattle.game.data;

/**
 * 角色数据的抽象类，可以实现并重写 get 方法以定制化
 */
public abstract class AbstractCharacterData implements Data {
    private final int id;
    private final String name;
    private final int hp;
    private final int def;
    private final int mobility;
    private final int[] skillList;

    @Override
    public final int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @return the mobility
     */
    public int getMobility() {
        return mobility;
    }

    /**
     * @return the def
     */
    public int getDef() {
        return def;
    }

    /**
     * @return the skillList
     */
    public int[] getSkillList() {
        return skillList;
    }

    /**
     * 无参构造器
     */
    protected AbstractCharacterData() {
        id = hp = def = mobility = 0;
        name = null;
        skillList = null;
    }

    /**
     * 成员构造器
     *
     * @param id        角色数据 ID
     * @param name      角色姓名
     * @param hp        角色最大生命值
     * @param def       角色防御力
     * @param mobility  角色行动力
     * @param skillList 角色技能列表
     */
    protected AbstractCharacterData(int id, String name, int hp, int def, int mobility, int[] skillList) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.mobility = mobility;
        this.skillList = skillList;
    }
}
