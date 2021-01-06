package huluwa.characters;

/**
 * 角色类，是所有角色的基类，目前具有名称和性别两个属性，能够对它们进行获取和设置
 */
public abstract class Character {
    protected String name;
    protected Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
