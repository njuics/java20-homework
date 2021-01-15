package hulubattle.game.data;

/**
 * 代表静态数据的接口，数据必须有一个用于唯一标识的 ID
 */
public interface Data {
    /**
     * 获取数据对象的 ID
     *
     * @return ID
     */
    public int getId();
}
