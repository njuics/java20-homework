package hulubattle.game.model;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;

import org.junit.Test;

public class CombatLogTest {
    private static Gson gson = new Gson();
    private static String logJson = "{\"type\":\"SET\",\"msg\":\"\",\"payload\":{\"src\":1,\"data\":1,\"x\":3,\"y\":4,\"camp\":0}}";

    @Test
    public void testSerialize() {
        CombatLog log = CombatLog.set(1, 1, 3, 4, 0);
        String str = gson.toJson(log);
        CombatLog newLog = gson.fromJson(str, CombatLog.class);
        assertEquals(log, newLog);
    }

    @Test
    public void testDeserialize() {
        CombatLog log = gson.fromJson(logJson, CombatLog.class);
        assertEquals("SET", log.type);
        assertEquals(4, log.get("y"));
    }
}
