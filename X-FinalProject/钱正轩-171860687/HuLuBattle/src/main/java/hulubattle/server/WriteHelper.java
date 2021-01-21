package hulubattle.server;

import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import hulubattle.game.model.CombatLog;

/**
 * 用于编码发送的 log
 */
public class WriteHelper {
    private static Gson gson = new Gson();
    public static final String DELIM = "%";

    /**
     * 将 log 转换为字节数组
     * @param log 日志对象
     * @return 用 UTF-8 编码后的字节数组
     */
    public static byte[] format(CombatLog log) {
        return (gson.toJson(log) + DELIM).getBytes(StandardCharsets.UTF_8);
    }

    private WriteHelper() {
        // hide
    }
}
