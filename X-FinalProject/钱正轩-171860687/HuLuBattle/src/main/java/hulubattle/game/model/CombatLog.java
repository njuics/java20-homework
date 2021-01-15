package hulubattle.game.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 战斗日志
 */
public final class CombatLog {
    public final String type;
    public final String msg;
    private Map<String, Integer> payload = new HashMap<>();

    /**
     * 获取 SET 类型的日志，将 src 角色设置在 x y 处，生命值设置为最大生命值
     *
     * @param src  角色 ID
     * @param data 角色数据 ID
     * @param x    横坐标
     * @param y    纵坐标
     * @param camp 角色阵营
     * @return 日志对象
     */
    public static CombatLog set(int src, int data, int x, int y, int camp) {
        CombatLog log = new CombatLog(LogType.SET.name(), "");
        log.payload.put("src", src);
        log.payload.put("data", data);
        log.payload.put("x", x);
        log.payload.put("y", y);
        log.payload.put("camp", camp);
        return log;
    }

    /**
     * 获取 MOVE 类型的日志，将 src 角色移动到 x y 处
     *
     * @param src 角色 ID
     * @param x   横坐标
     * @param y   纵坐标
     * @return 日志对象
     */
    public static CombatLog move(int src, int x, int y) {
        CombatLog log = new CombatLog(LogType.MOVE.name(), "");
        log.payload.put("src", src);
        log.payload.put("x", x);
        log.payload.put("y", y);
        return log;
    }

    /**
     * 获取 CAST 类型的日志，src 角色对 dest 角色释放 skill 技能
     *
     * @param src   源角色 ID
     * @param dest  目标角色 ID
     * @param skill 技能 ID
     * @return 日志对象
     */
    public static CombatLog cast(int src, int dest, int skill) {
        CombatLog log = new CombatLog(LogType.CAST.name(), "");
        log.payload.put("src", src);
        log.payload.put("dest", dest);
        log.payload.put("skill", skill);
        return log;
    }

    /**
     * 获取 HURT 类型的日志，src 角色受到伤害，生命值更新为 hp
     *
     * @param src 角色 ID
     * @param hp  更新后的生命值
     * @return 日志对象
     */
    public static CombatLog hurt(int src, int hp) {
        CombatLog log = new CombatLog(LogType.HURT.name(), "");
        log.payload.put("src", src);
        log.payload.put("hp", hp);
        return log;
    }

    /**
     * 获取 DESTROY 类型的日志，将 src 角色移除战场
     *
     * @param src 角色 ID
     * @return 日志对象
     */
    public static CombatLog destroy(int src) {
        CombatLog log = new CombatLog(LogType.DESTROY.name(), "");
        log.payload.put("src", src);
        return log;
    }

    /**
     * 获取 SKIP 类型的日志，跳过当前回合
     *
     * @param camp 发送者的阵营
     * @return 日志对象
     */
    public static CombatLog skip(int camp) {
        CombatLog log = new CombatLog(LogType.SKIP.name(), "");
        log.payload.put("camp", camp);
        return log;
    }

    /**
     * 获取 INFO 类型的日志
     *
     * @param msg 通知信息
     * @return 日志对象
     */
    public static CombatLog info(String msg) {
        return new CombatLog(LogType.INFO.name(), msg);
    }

    /**
     * 获取 ERROR 类型的日志
     *
     * @param msg 错误信息
     * @return 日志对象
     */
    public static CombatLog error(String msg) {
        return new CombatLog(LogType.ERROR.name(), msg);
    }

    /**
     * @param type
     * @param msg
     */
    private CombatLog(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    /**
     * @param key 关键字
     * @return payload 中的值
     * @see java.util.Map#get(java.lang.Object)
     */
    public int get(String key) {
        return payload.get(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(type, msg, payload);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CombatLog)) {
            return false;
        }
        CombatLog other = (CombatLog) obj;
        return Objects.equals(type, other.type) && Objects.equals(msg, other.msg)
                && Objects.equals(payload, other.payload);
    }
}
