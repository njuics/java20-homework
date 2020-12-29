package hulubattle.game.model;

/**
 * 游戏事件发生时的委托对象
 */
public interface GameDelegate {
    /**
     * 向双方选手发送相同的日志
     * 
     * @param log 日志对象
     */
    public void sendLog(CombatLog log);

    /**
     * 向双方选手发送不同的日志
     * 
     * @param msgA 向选手 A 发送的日志
     * @param msgB 向选手 B 发送的日志
     */
    public void sendLog(CombatLog msgA, CombatLog msgB);
}
