package hulubattle.game.data;

import java.util.Optional;

/**
 * 静态数据的提供者接口
 */
public interface DataSupplier<T extends Data> {
    /**
     * 根据 ID 获取数据对象，返回为 Optional，因为传入的 ID 可能不存在
     *
     * @param id 数据对象的 ID
     * @return 一个 Optional 值
     */
    Optional<T> get(int id);
}
