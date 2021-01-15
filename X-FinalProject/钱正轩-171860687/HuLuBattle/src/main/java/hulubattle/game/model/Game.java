package hulubattle.game.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import hulubattle.game.data.AbstractCharacterData;
import hulubattle.game.data.AbstractSkillData;
import hulubattle.game.data.DataSupplier;
import hulubattle.game.data.JsonDataSupplier;
import hulubattle.game.data.SimpleCharacterData;
import hulubattle.game.data.SimpleSkillData;
import hulubattle.game.model.AbstractCharacter.CharacterHurtHandler;
import hulubattle.game.model.AbstractCharacter.CharacterMoveHandler;

/**
 * 代表游戏逻辑的类
 */
public class Game implements LogConsumer {
    public static final int MAP_SIZE = 10;
    public static final int SKILL_NUM = 4;
    public static final int CHARACTER_NUM = 4;
    public static final int MAX_CHARACTER = 10;
    public static final int A = 0;
    public static final int B = 1;

    private static class GameException extends Exception {
        private static final long serialVersionUID = 1L;

        /**
         * @param message 错误信息
         */
        public GameException(String message) {
            super(message);
        }
    }

    private static Gson gson = new Gson();

    private DataSupplier<AbstractCharacterData> charactersData;
    private DataSupplier<AbstractSkillData> skillsData;
    private List<Map<String, Integer>> initData;
    private Map<Integer, AbstractCharacter> characters = new HashMap<>();
    private BiMap<Integer, Integer> map = HashBiMap.create();
    private Optional<GameDelegate> delegate = Optional.empty();

    private GameState state = GameState.END;
    private int currentCamp = A;
    private int campANum = 0;
    private int campBNum = 0;

    private CharacterMoveHandler moveHandler = (src, x, y) -> {
        map.forcePut(src, x * MAP_SIZE + y);
        delegate.ifPresent(d -> d.sendLog(CombatLog.move(src, x, y)));
    };
    private CharacterHurtHandler hurtHandler = (src, hp) -> {
        delegate.ifPresent(d -> d.sendLog(CombatLog.hurt(src, hp)));
        if (hp == 0) {
            removeCharacter(src);
        }
    };

    /**
     * 计算指定技能作用在指定目标上得到的伤害
     *
     * @param skill  技能数据
     * @param target 角色数据
     * @return 伤害值（正值为治疗负值为伤害）
     */
    public static int calcDamage(AbstractSkillData skill, AbstractCharacterData target) {
        if (skill.isHarm()) {
            return (skill.getAtk() - target.getDef()) * skill.getAtkNum();
        } else {
            return skill.getAtk() * skill.getAtkNum() * -1;
        }
    }

    /**
     * 无参构造器，直接读取配置好的 JSON 文件，如果文件不存在或读取错误则抛出异常
     *
     * @throws URISyntaxException 路径错误
     * @throws IOException        读取文件错误
     */
    public Game() throws URISyntaxException, IOException {
        URL characterURL = getClass().getClassLoader().getResource("config/characters.json");
        URL skillURL = getClass().getClassLoader().getResource("config/skills.json");
        URL initURL = getClass().getClassLoader().getResource("config/init.json");
        charactersData = new JsonDataSupplier<>(SimpleCharacterData.class, characterURL);
        skillsData = new JsonDataSupplier<>(SimpleSkillData.class, skillURL);
        initData = gson.fromJson(CharStreams.toString(new InputStreamReader(initURL.openStream(), StandardCharsets.UTF_8)),
                new TypeToken<List<Map<String, Integer>>>() {
                }.getType());
    }

    /**
     * 设置委托对象
     *
     * @param delegate 委托对象
     */
    public void setDelegate(GameDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate);
    }

    /**
     * 根据 JSON 配置文件设置起始战场
     */
    public void setUp() {
        if (state != GameState.END) {
            return;
        }

        map.clear();
        characters.clear();
        campANum = 0;
        campBNum = 0;
        currentCamp = A;

        delegate.ifPresent(d -> d.sendLog(CombatLog.info("A"), CombatLog.info("B")));
        IntStream.range(0, initData.size()).forEach(i -> {
            Map<String, Integer> config = initData.get(i);

            // 获取数据
            AbstractCharacterData data = charactersData.get(config.get("id")).get();
            int x = config.get("x");
            int y = config.get("y");
            int camp = config.get("camp");

            // 初始化角色
            AbstractCharacter character = AbstractCharacter.getDefault(i, data, x, y, camp);
            character.setMoveHandler(moveHandler);
            character.setHurtHandler(hurtHandler);

            map.put(i, x * MAP_SIZE + y);
            characters.put(i, character);
            if (character.getCamp() == A) {
                campANum += 1;
            } else {
                campBNum += 1;
            }
            delegate.ifPresent(d -> d.sendLog(CombatLog.set(i, data.getId(), x, y, camp)));
        });
        state = GameState.MOVE;

    }

    private synchronized void act(CombatLog log) {
        if (state == GameState.END) {
            return;
        }
        LogType type = LogType.valueOf(log.type);
        if (type == LogType.SKIP) {
            if (log.get("camp") == currentCamp) {
                currentCamp = currentCamp == A ? B : A;
                state = GameState.MOVE;
                delegate.ifPresent(d -> d.sendLog(CombatLog.skip(log.get("camp"))));
            } else {
                delegate.ifPresent(d -> d.sendLog(CombatLog.error("日志参数非法")));
            }
            return;
        }
        try {
            tryAct(log);
        } catch (GameException e) {
            delegate.ifPresent(d -> d.sendLog(CombatLog.error(e.getMessage())));
        }
    }

    private void tryAct(CombatLog log) throws GameException {

        checkLogType(log);
        int src = log.get("src");
        // 检查角色是否存在
        AbstractCharacter srcCharacter = Optional.ofNullable(characters.get(src))
                .orElseThrow(() -> new GameException("角色不存在"));
        // 检查角色数据是否存在
        AbstractCharacterData srcData = charactersData.get(srcCharacter.getDataId())
                .orElseThrow(() -> new GameException("角色数据不存在"));
        // 检查是否可操控
        if (srcCharacter.getCamp() != currentCamp) {
            throw new GameException("角色不可操控");
        }

        switch (state) {
            case MOVE:
                int x = log.get("x");
                int y = log.get("y");
                move(srcCharacter, srcData, x, y);
                break;
            case CAST:
                int dest = log.get("dest");
                int skill = log.get("skill");

                // 检查角色是否存在
                AbstractCharacter destCharacter = Optional.ofNullable(characters.get(dest))
                        .orElseThrow(() -> new GameException("角色不存在"));
                // 检查角色数据是否存在
                AbstractCharacterData destData = charactersData.get(destCharacter.getDataId())
                        .orElseThrow(() -> new GameException("角色数据不存在"));
                // 检查技能数据是否存在
                AbstractSkillData skillData = skillsData.get(skill).orElseThrow(() -> new GameException("技能数据不存在"));
                cast(srcCharacter, srcData, destCharacter, destData, skillData);
                break;
            default:
                // do nothing
                break;
        }
    }

    private void checkLogType(CombatLog log) throws GameException {
        LogType type = LogType.valueOf(log.type);
        // 检查日志类型
        switch (state) {
            case MOVE:
                if (type == LogType.CAST) {
                    state = GameState.CAST;
                } else if (type != LogType.MOVE) {
                    throw new GameException("日志类型非法");
                }
                break;
            case CAST:
                if (type != LogType.CAST) {
                    throw new GameException("日志类型非法");
                }
                break;
            default:
                // do nothing
                break;
        }
    }

    private void move(AbstractCharacter src, AbstractCharacterData srcData, int x, int y) throws GameException {
        // 检查目标地点是否合法
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) {
            throw new GameException("移动目标非法");
        }
        // 检查目标地点是否已经有角色
        if (map.containsValue(x * MAP_SIZE + y)) {
            throw new GameException("移动目标已有角色");
        }
        int mobility = srcData.getMobility();
        // 检查移动力
        if (src.distance(x, y) > mobility) {
            throw new GameException("移动力不足");
        }
        src.moveTo(x, y);
        state = GameState.CAST;
    }

    private void cast(AbstractCharacter src, AbstractCharacterData srcData, AbstractCharacter dest,
            AbstractCharacterData destData, AbstractSkillData skill) throws GameException {
        // 检查该角色是否能释放该技能
        if (!Arrays.stream(srcData.getSkillList()).anyMatch(a -> a == skill.getId())) {
            throw new GameException("技能不可用");
        }
        // 检查技能目标是否合法
        if ((src.isHarm(dest) && !skill.isHarm()) || (!src.isHarm(dest) && skill.isHarm())) {
            throw new GameException("技能目标非法");
        }
        // 检查是否进入射程
        if (src.distance(dest) > skill.getRange()) {
            throw new GameException("技能超出射程");
        }
        delegate.ifPresent(d -> d.sendLog(CombatLog.cast(src.getId(), dest.getId(), skill.getId())));
        int damage = calcDamage(skill, destData);
        dest.hurt(damage);
        if (state == GameState.CAST) {
            currentCamp = currentCamp == A ? B : A;
            state = GameState.MOVE;
        }
    }

    private void removeCharacter(int id) {
        AbstractCharacter character = characters.get(id);
        if (character.getCamp() == A) {
            campANum -= 1;
        } else {
            campBNum -= 1;
        }
        characters.remove(id);
        map.remove(id);
        delegate.ifPresent(d -> d.sendLog(CombatLog.destroy(id)));
        if (campANum == 0 || campBNum == 0) {
            CombatLog win = CombatLog.info("游戏胜利");
            CombatLog lose = CombatLog.info("游戏失败");
            if (campBNum == 0) {
                delegate.ifPresent(d -> d.sendLog(win, lose));
            } else {
                delegate.ifPresent(d -> d.sendLog(lose, win));
            }
            state = GameState.END;

        }
    }

    @Override
    public void consume(CombatLog log) {
        act(log);
    }
}
