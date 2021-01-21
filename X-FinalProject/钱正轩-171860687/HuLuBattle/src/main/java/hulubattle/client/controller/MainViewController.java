package hulubattle.client.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.CharStreams;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import hulubattle.client.model.GameClient;
import hulubattle.client.view.CharacterGrid;
import hulubattle.game.data.AbstractCharacterData;
import hulubattle.game.data.AbstractSkillData;
import hulubattle.game.data.DataSupplier;
import hulubattle.game.data.JsonDataSupplier;
import hulubattle.game.data.SimpleCharacterData;
import hulubattle.game.data.SimpleSkillData;
import hulubattle.game.model.CombatLog;
import hulubattle.game.model.LogConsumer;
import hulubattle.game.model.LogType;
import hulubattle.server.GameServer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

/**
 * 控制游戏 UI 的逻辑
 */
public class MainViewController implements LogConsumer {
    public static final double GRID_WIDTH = 60.0;
    public static final double GRID_HEIGHT = 60.0;
    public static final int GRID_SIZE = 10;
    private static Gson gson = new Gson();

    private enum State {
        INIT_1, INIT_2, MOVE_1, MOVE_2, CAST_1, CAST_2
    }

    private Logger logger = Logger.getLogger("hulubattle.client.controller.MainViewController");

    @FXML
    private Button cancelBtn;

    @FXML
    private Tooltip moveTip;
    @FXML
    private Group skillGroup;
    @FXML
    private Group shapeGroup;
    @FXML
    private VBox controlBox;

    @FXML
    private ScrollPane logPane;
    @FXML
    private Label logLabel;

    @FXML
    private AnchorPane mapPane;

    private Stage mainStage;

    private Optional<GameClient> client = Optional.empty();
    private Optional<GameServer> server = Optional.empty();

    private DataSupplier<AbstractCharacterData> charactersData;
    private DataSupplier<AbstractSkillData> skillsData;
    private Map<Integer, CharacterGrid> cMap = new HashMap<>();
    private Map<String, String> nMap = ImmutableMap.<String, String>builder().put("00", "三娃").put("01", "二娃")
            .put("02", "四娃").put("03", "五娃").put("10", "蟾蜍精").put("11", "蝎子精").put("12", "蜈蚣精").put("13", "蛇精").build();

    private List<CombatLog> logList = new ArrayList<>();

    private State state = State.INIT_1;
    private StringBuilder stringBuilder = new StringBuilder();
    private int camp;
    private int source;
    private int target;
    private int x;
    private int y;
    private int skill;

    /**
     * 构造器
     *
     * @param mainStage 此 scene 所处的 stage
     * @throws IOException 打开配置文件失败
     */
    public MainViewController(Stage mainStage) throws IOException {
        URL characterURL = getClass().getClassLoader().getResource("config/characters.json");
        URL skillURL = getClass().getClassLoader().getResource("config/skills.json");
        charactersData = new JsonDataSupplier<>(SimpleCharacterData.class, characterURL);
        skillsData = new JsonDataSupplier<>(SimpleSkillData.class, skillURL);
        this.mainStage = mainStage;
    }

    /**
     * 进行一些程序的初始化工作
     */
    public void initialize() {
        IntStream.range(0, 11).forEach(i -> {
            Line hLine = new Line();
            hLine.setEndX(GRID_SIZE * GRID_WIDTH);
            Line vLine = new Line();
            vLine.setEndY(GRID_SIZE * GRID_HEIGHT);
            AnchorPane.setTopAnchor(hLine, GRID_HEIGHT * i);
            AnchorPane.setLeftAnchor(hLine, 0.0);
            AnchorPane.setTopAnchor(vLine, 0.0);
            AnchorPane.setLeftAnchor(vLine, GRID_WIDTH * i);
            mapPane.getChildren().addAll(hLine, vLine);
        });

        mapPane.setOnMouseClicked(e -> {
            if (state == State.MOVE_1) {
                this.x = (int) (e.getX() / GRID_WIDTH);
                this.y = (int) (e.getY() / GRID_HEIGHT);
                updateState(State.MOVE_2);
            }
        });

        logPane.vvalueProperty().bind(logLabel.heightProperty());
    }

    private void reset() {
        cMap.forEach((i, c) -> c.removeFrom(mapPane));
        cMap.clear();
        logList.clear();
        logLabel.setText("");
        stringBuilder = new StringBuilder();
        updateState(State.INIT_1);
    }

    private void setupCharacter(int id, int dataId, int x, int y, int camp) {
        charactersData.get(dataId).ifPresent(data -> {
            CharacterGrid character = new CharacterGrid(id, data, camp);
            character.move(x, y);
            character.setHp(data.getHp());
            character.setOnAction(e -> {
                switch (state) {
                    case INIT_1:
                    case INIT_2:
                        source = id;
                        controlBox.setVisible(true);
                        setupControlBox(dataId);
                        updateState(State.INIT_2);
                        break;
                    case CAST_1:
                    case CAST_2:
                        target = id;
                        updateState(State.CAST_2);
                        break;
                    default:
                        // do-nothing
                        break;
                }
            });
            character.appendTo(mapPane);
            cMap.put(id, character);
        });
    }

    private void setupControlBox(int id) {
        charactersData.get(id).ifPresent(cd -> {
            moveTip.setText(String.format("将角色移动 %d 格", cd.getMobility()));
            skillGroup.getChildren().clear();
            Arrays.stream(cd.getSkillList()).forEach(i -> {
                skillsData.get(i).ifPresent(sd -> {
                    Button btn = new Button(sd.getName());
                    String desc = String.format("对 %d 格内的目标", sd.getRange());
                    if (sd.isHarm()) {
                        desc = desc + String.format("造成 %d 点伤害 %d 次", sd.getAtk(), sd.getAtkNum());
                    } else {
                        desc = desc + String.format("恢复 %d 点生命 %d 次", sd.getAtk(), sd.getAtkNum());
                    }
                    btn.setTooltip(new Tooltip(desc));
                    btn.setFocusTraversable(false);
                    btn.setOnAction(e -> {
                        skill = sd.getId();
                        updateState(State.CAST_1);
                    });
                    skillGroup.getChildren().add(btn);
                });
            });
        });
    }

    private void updateState(State s) {
        CharacterGrid grid;
        switch (s) {
            case INIT_1:
                shapeGroup.getChildren().clear();
                break;
            case INIT_2:
                grid = cMap.get(source);
                drawRange(grid.getX(), grid.getY(), 0);
                break;
            case MOVE_1:
                grid = cMap.get(source);
                charactersData.get(grid.getDataId())
                        .ifPresent(cd -> drawRange(grid.getX(), grid.getY(), cd.getMobility()));
                break;
            case MOVE_2:
                drawRange(x, y, 0);
                break;
            case CAST_1:
                grid = cMap.get(source);
                skillsData.get(skill).ifPresent(sd -> drawRange(grid.getX(), grid.getY(), sd.getRange()));
                break;
            case CAST_2:
                grid = cMap.get(target);
                drawRange(grid.getX(), grid.getY(), 0);
                break;
        }
        state = s;
    }

    private void drawRange(int x, int y, int range) {
        shapeGroup.getChildren().clear();
        IntStream.range(0, GRID_SIZE * GRID_SIZE).filter(i -> (Math.abs(i / 10 - x) + Math.abs(i % 10 - y)) <= range)
                .forEach(i -> {
                    int nx = i / 10;
                    int ny = i % 10;
                    Rectangle rect = new Rectangle(nx * GRID_WIDTH, ny * GRID_HEIGHT, GRID_WIDTH, GRID_HEIGHT);
                    rect.setFill(Paint.valueOf("rgba(30, 144, 255, 0.3)"));
                    rect.setStroke(Paint.valueOf("rgba(0, 0, 0, 0)"));
                    shapeGroup.getChildren().add(rect);
                });
    }

    private void updateLog(String str) {
        stringBuilder.append(String.format("%s%n", str));
        logLabel.setText(stringBuilder.toString());
    }

    private String formatLog(CombatLog log) {
        LogType type = LogType.valueOf(log.type);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s: ", log.type));
        switch (type) {
            case INFO:
                if (log.msg.equals("A") || log.msg.equals("B")) {
                    builder.append(String.format("你的阵营是 %s", log.msg.equals("A") ? "葫芦娃" : "妖怪"));
                    camp = log.msg.equals("A") ? 0 : 1;
                } else {
                    builder.append(log.msg);
                }
                break;
            case ERROR:
                builder.append(log.msg);
                break;
            case SET:
                builder.append(String.format("在 (%d, %d) 召唤了 %s", log.get("x"), log.get("y"),
                        getName(log.get("data"), log.get("camp"))));
                break;
            case MOVE:
                builder.append(String.format("%s 移动至 (%d, %d)", getName(log.get("src")), log.get("x"), log.get("y")));
                break;
            case CAST:
                builder.append(String.format("%s 对 %s 释放 %s", getName(log.get("src")), getName(log.get("dest")),
                        getSkill(log.get("skill"))));
                break;
            case HURT:
                builder.append(String.format("%s 的生命值变化为 %d", getName(log.get("src")), log.get("hp")));
                break;
            case DESTROY:
                builder.append(String.format("%s 被消灭了", getName(log.get("src"))));
                break;
            case SKIP:
                builder.append("跳过回合");
                break;
        }
        return builder.toString();
    }

    private String getName(int id) {
        CharacterGrid grid = cMap.get(id);
        return getName(grid.getDataId(), grid.getCamp());
    }

    private String getName(int id, int camp) {
        return nMap.get(String.format("%d%d", camp, id));
    }

    private String getSkill(int id) {
        Optional<AbstractSkillData> data = skillsData.get(id);
        if (data.isPresent()) {
            return data.get().getName();
        } else {
            return "";
        }
    }

    @Override
    public void consume(CombatLog log) {
        logList.add(log);
        Platform.runLater(() -> {
            updateLog(formatLog(log));
            LogType type = LogType.valueOf(log.type);
            switch (type) {
                case SET:
                    setupCharacter(log.get("src"), log.get("data"), log.get("x"), log.get("y"), log.get("camp"));
                    break;
                case MOVE:
                    cMap.get(log.get("src")).move(log.get("x"), log.get("y"));
                    break;
                case HURT:
                    cMap.get(log.get("src")).setHp(log.get("hp"));
                    break;
                case DESTROY:
                    cMap.remove(log.get("src")).removeFrom(mapPane);
                    break;
                default:
                    // do nothing
                    break;
            }
        });

    }

    @FXML
    protected void moveBtnHandler() {
        updateState(State.MOVE_1);
    }

    @FXML
    protected void cancelBtnHandler() {
        controlBox.setVisible(false);
        updateState(State.INIT_1);
    }

    @FXML
    protected void submitBtnHandler() {
        Optional.ofNullable(cMap.get(source)).ifPresent(grid -> {
            if (grid.getCamp() != camp) {
                Alert alert = new Alert(AlertType.WARNING, "你只能操作自己的角色");
                alert.show();
                return;
            }
            switch (state) {
                case CAST_2:
                    client.ifPresent(c -> c.write(CombatLog.cast(source, target, skill)));
                    cancelBtn.fire();
                    break;
                case MOVE_2:
                    client.ifPresent(c -> c.write(CombatLog.move(source, x, y)));
                    cancelBtn.fire();
                    break;
                default:
                    // do nothing
            }
        });
    }

    @FXML
    protected void skipBtnHandler() {
        client.ifPresent(c -> c.write(CombatLog.skip(camp)));
        cancelBtn.fire();
    }

    @FXML
    protected void loadLogBtnHandler() {
        FileChooser fc = new FileChooser();
        fc.setTitle("选择日志文件");
        fc.getExtensionFilters().add(new ExtensionFilter("json", "*.json"));
        fc.setInitialDirectory(new File("."));
        Optional.ofNullable(fc.showOpenDialog(mainStage)).ifPresent(file -> {
            try {
                String str = CharStreams
                        .toString(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                List<CombatLog> list = gson.fromJson(str, new TypeToken<List<CombatLog>>() {
                    private static final long serialVersionUID = 1L;
                }.getType());
                reset();
                Iterator<CombatLog> it = list.iterator();
                Timeline line = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> consume(it.next())));
                line.setCycleCount(list.size());
                line.play();
            } catch (Exception e) {
                logger.warning("Load log failed");
            }
        });
    }

    @FXML
    protected void saveLogBtnHandler() {
        FileChooser fc = new FileChooser();
        fc.setTitle("保存日志文件");
        fc.getExtensionFilters().add(new ExtensionFilter("json", "*.json"));
        fc.setInitialDirectory(new File("."));
        Optional.ofNullable(fc.showSaveDialog(mainStage)).ifPresent(file -> {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
                out.write(gson.toJson(logList).getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                logger.warning("Write log failed");
            }
        });
    }

    @FXML
    protected void openServerBtnHandler() {
        try {
            server = Optional.of(new GameServer());
        } catch (IOException e) {
            logger.warning("Create server failed");
        }
        server.ifPresent(GameServer::accept);
    }

    @FXML
    protected void closeServerBtnHandler() {
        server.ifPresent(t -> {
            try {
                t.close();
            } catch (Exception e) {
                logger.warning("Close Server Failed");
            }
        });
        server = Optional.empty();
    }

    @FXML
    protected void openClientBtnHandler() {
        try {
            client = Optional.of(new GameClient(this));
        } catch (IOException e) {
            logger.warning("Create client failed");
        }
        client.ifPresent(GameClient::connect);
        reset();
    }

    @FXML
    protected void closeClientBtnHandler() {
        client.ifPresent(c -> {
            try {
                c.close();
            } catch (Exception e) {
                logger.warning("Close client failed");
            }
        });
        client = Optional.empty();
    }
}
