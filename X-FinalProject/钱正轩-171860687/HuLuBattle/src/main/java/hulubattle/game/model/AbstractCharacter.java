package hulubattle.game.model;

import java.util.Optional;

import hulubattle.game.data.AbstractCharacterData;

/**
 * 抽象的角色信息，用于游戏运行时（区分于静态的角色数据），可以重写方法以定制化
 */
public abstract class AbstractCharacter {
    /**
     * 函数接口，用于处理角色生命值变化时的操作
     */
    @FunctionalInterface
    public interface CharacterHurtHandler {
        /**
         * 角色生命变化时会调用该函数
         *
         * @param id 角色的 id
         * @param hp 角色受伤后的 hp
         */
        public void handle(int id, int hp);
    }

    /**
     * 函数接口，用于处理角色移动时的操作
     */
    @FunctionalInterface
    public interface CharacterMoveHandler {
        /**
         * 角色移动后会调用该函数
         *
         * @param id 角色 id
         * @param x  移动后的横坐标
         * @param y  移动后的纵坐标
         */
        public void handle(int id, int x, int y);
    }

    private final int id;
    private final int dataId;
    private final int maxHp;

    private int x = 0;
    private int y = 0;
    private int hp;
    private int camp;
    private Optional<CharacterHurtHandler> hurtHandler = Optional.empty();
    private Optional<CharacterMoveHandler> moveHandler = Optional.empty();

    /**
     * 静态工厂方法，屏蔽获取实例背后的实现
     *
     * @param id   角色 ID
     * @param data 角色数据
     * @param x    位置横坐标
     * @param y    位置纵坐标
     * @param camp 阵营
     * @return 生成的角色实例
     */
    public static AbstractCharacter getDefault(int id, AbstractCharacterData data, int x, int y, int camp) {
        int dataId = data.getId();
        int hp = data.getHp();
        AbstractCharacter character = new SimpleCharacter(id, dataId, hp, camp);
        character.moveTo(x, y);
        return character;
    }

    protected AbstractCharacter(int id, int data, int hp, int camp) {
        this.id = id;
        this.maxHp = this.hp = hp;
        this.dataId = data;
        this.camp = camp;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the dataId
     */
    public int getDataId() {
        return dataId;
    }

    /**
     * @return the camp
     */
    public int getCamp() {
        return camp;
    }

    /**
     * @param hurtHandler the hurtHandler to set
     */
    public void setHurtHandler(CharacterHurtHandler hurtHandler) {
        this.hurtHandler = Optional.ofNullable(hurtHandler);
    }

    /**
     * @param moveHandler the moveHandler to set
     */
    public void setMoveHandler(CharacterMoveHandler moveHandler) {
        this.moveHandler = Optional.ofNullable(moveHandler);
    }

    /**
     * 返回两个角色之间的距离
     *
     * @param character 另一个角色
     * @return 曼哈顿距离
     */
    public int distance(AbstractCharacter character) {
        return Math.abs(character.x - x) + Math.abs(character.y - y);
    }

    /**
     * 返回角色和目标地点的距离
     *
     * @param x 横坐标
     * @param y 纵坐标
     * @return 曼哈顿距离
     */
    public int distance(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }

    /**
     * 将角色移动到指定位置
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        moveHandler.ifPresent(h -> h.handle(id, x, y));
    }

    /**
     * 角色受到伤害
     *
     * @param damage 伤害值
     */
    public void hurt(int damage) {
        hp -= damage;
        if (hp >= maxHp) {
            hp = maxHp;
        } else if (hp < 0) {
            hp = 0;
        }
        hurtHandler.ifPresent(h -> h.handle(id, hp));
    }

    /**
     * 判断角色是否是敌方
     *
     * @param character 对方角色
     * @return 是否为敌方
     */
    public boolean isHarm(AbstractCharacter character) {
        return character.camp != camp;
    }
}
