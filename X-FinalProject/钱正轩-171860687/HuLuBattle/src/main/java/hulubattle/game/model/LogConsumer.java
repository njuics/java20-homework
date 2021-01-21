package hulubattle.game.model;

/**
 * 函数接口，代表能够接受一个 CombatLog 对象
 */
@FunctionalInterface
public interface LogConsumer {
    /**
     * 接受一个 CombatLog 对象
     *
     * @param log 日志对象
     */
    public void consume(CombatLog log);
}
