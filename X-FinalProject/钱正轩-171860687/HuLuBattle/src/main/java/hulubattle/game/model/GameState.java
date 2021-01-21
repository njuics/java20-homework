package hulubattle.game.model;

/**
 * 游戏的状态机
 *
 * 默认为 END，开始后进入 MOVE，在此阶段当前玩家可移动角色，然后进入 CAST，在此阶段可释放技能
 */
public enum GameState {
    END, MOVE, CAST
}
