package sample;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.transform.TransformerException;

import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

public class Main extends Application {
    // connect
    int myID;// 自己的id
    int matchPlayerID = -1;// 想匹配的玩家ID
    int enemyID = -1;//
    boolean started = false;
    String serverIP;// 服务器ip地址
    List<Player> players = new ArrayList<>();// 当前与服务器连接的可匹配玩家
    // UI
    Pane canvas = new Pane();
    Stage stage = new Stage();
    Scene scene = new Scene(canvas, Attributes.width, Attributes.height);
    double mouseX;
    double mouseY;
    CalabashClient calabashClient;
    Battle battle = new Battle();
    List<ImageView> picsList;
    ArrayList<ImageView> pics = new ArrayList<>();
    ArrayList<ImageView> picsDead = new ArrayList<>();
    ArrayList<Label> labels = new ArrayList<>();
    AtomicBoolean playing = new AtomicBoolean(false);

    @Override
    public void init() throws Exception {
        Attributes.init();
    }

    // step1:连接服务器
    void connectServer(int flag) {
        TextInputDialog dialog = new TextInputDialog(Attributes.localServerIP);
        dialog.setTitle("连接服务器");
        if (flag == 0) {
            dialog.setHeaderText("输入服务器IP地址后，按“确定”键连接服务器");
        } else {
            dialog.setHeaderText("服务器连接失败! 请检查服务器是否正在运行及服务器IP地址是否正确后重新输入");
        }
        dialog.setContentText("服务器IP地址：");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            serverIP = result.get();
            calabashClient = new CalabashClient(this);
            if (calabashClient.connect(serverIP)) {
                startInterface();
            } else {
                connectServer(1);
            }
        }
    }

    // step2：选择开始游戏or回放or退出
    public void startInterface() {
        // 背景
        ImageView start = new ImageView(Attributes.images.get(Attributes.START));
        start.setFitHeight(Attributes.height);
        start.setFitWidth(Attributes.width);
        canvas.getChildren().add(start);
        //开始游戏按钮
        ImageView startGame = new ImageView(Attributes.images.get(Attributes.STARTICON));
        startGame.setFitHeight(54);
        startGame.setFitWidth(175);
        Label startLabel = new Label("",startGame);
        startLabel.setLayoutX(350);
        startLabel.setLayoutY(550);
        startLabel.setOnMouseClicked((MouseEvent e)->{ matchPlayer(); });
        canvas.getChildren().add(startLabel);

        //退出按钮
        ImageView exitImage = new ImageView(Attributes.images.get(Attributes.EXITICON));
        exitImage.setFitHeight(54);
        exitImage.setFitWidth(175);
        Label exitLabel = new Label("",exitImage);
        exitLabel.setMaxSize(350,109);
        exitLabel.setLayoutX(950);
        exitLabel.setLayoutY(550);
        exitLabel.setOnMouseClicked((MouseEvent e)->{ System.exit(0); });
        canvas.getChildren().add(exitLabel);

        // 读取进度按钮
        ImageView loadfile = new ImageView(Attributes.images.get(Attributes.LOADICON));
        loadfile.setFitHeight(54);
        loadfile.setFitWidth(175);
        Label loadLabel = new Label("", loadfile);
        loadLabel.setLayoutX(650);
        loadLabel.setLayoutY(550);
        loadLabel.setOnMouseClicked((MouseEvent e) -> {
            try {
                loadProgress();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        canvas.getChildren().add(loadLabel);

    }

    // step3-1：选择开始游戏后匹配玩家
    void matchPlayer() {
        List<String> choices = new ArrayList<>();
        for (Player p : players) {
            System.out.println(p.id);
            choices.add(Integer.toString(p.id));
        }
        String defaultPlayer;
        if (choices.size() > 0)
            defaultPlayer = choices.get(0);
        else
            defaultPlayer = "--";
        ChoiceDialog<String> dialog = new ChoiceDialog<>(defaultPlayer, choices);
        dialog.setTitle("匹配玩家");
        dialog.setHeaderText("选择当前在线玩家进行战斗吧！若想刷新新玩家请点击“取消”后再按“START“");
        dialog.setContentText("请选择想匹配的玩家id：");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent() && result.get() != "--") {
            matchPlayerID = Integer.parseInt(result.get());
            InviteMessage message = new InviteMessage(myID, matchPlayerID);
            calabashClient.send(message);
            /*
             * enemyID=matchPlayerID; started=true;
             */
        }
        if (started == true)
            enterBattle();

        // The Java 8 way to get the response value (with lambda expression).
        // result.ifPresent(letter -> System.out.println("Your choice: " + letter));

    }

    //
    void processInvitation(int playerID) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("玩家邀请");
        alert.setHeaderText("玩家" + Integer.toString(playerID) + "邀请您加入战斗");
        alert.setContentText("是否同意邀请？");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            enemyID = playerID;
            battle = new Battle();
            battle.setCamp(Camp.MONSTER);
            started = true;
            enterBattle();
            ReplyMessage r = new ReplyMessage(myID, playerID, 1);
            calabashClient.send(r);
        } else {
            ReplyMessage r = new ReplyMessage(myID, playerID, 0);
            calabashClient.send(r);
        }

    }

    void invitationRefused() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("匹配失败");
        alert.setHeaderText(null);
        alert.setContentText("玩家" + Integer.toString(matchPlayerID) + "拒绝了您的邀请，请重新匹配！");
        alert.showAndWait();
    }

    int xToPixel(int x) {// 地图格X坐标转换为像素横坐标
        return Attributes.mapLeft + x * Attributes.gridWidth;
    }

    int yToPixel(int y) {// 地图格Y坐标转换为像素纵坐标
        return Attributes.mapTop + y * Attributes.gridHeight;
    }

    void moveRole(int id,int x,int y){
        //角色图片
        labels.get(id).setLayoutX(xToPixel(x));
        labels.get(id).setLayoutY(yToPixel(y));
        //血量
        labels.get(id + Attributes.hpoffset).setLayoutX(xToPixel(x));
        labels.get(id + Attributes.hpoffset).setLayoutY(yToPixel(y)-3);

        //本地记录移动动作
        battle.gameprogress.writeIn(ActionType.MOVE, id + " " + x + " " + y);
    }

    void waitStart() {// 等待其他玩家进入后开局
        ImageView start = new ImageView(Attributes.images.get(Attributes.START));
        start.setFitHeight(Attributes.height);
        start.setFitWidth(Attributes.width);
        canvas.getChildren().add(start);
        // calabashClient.connect(Attributes.serverIP);
        enterBattle();
    }

    ///////////////////////
    /**
     * Runs the specified {@link Runnable} on the JavaFX application thread and
     * waits for completion.
     *
     * @param action the {@link Runnable} to run
     * @throws NullPointerException if {@code action} is {@code null}
     */
    static void runAndWait(Runnable action) {
        if (action == null)
            throw new NullPointerException("action");

        // run synchronously on JavaFX thread
        if (Platform.isFxApplicationThread()) {
            action.run();
            return;
        }

        // queue on JavaFX thread and wait for completion
        final CountDownLatch doneLatch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                action.run();
                // new Thread(action).start();
            } finally {
                doneLatch.countDown();
            }
        });

        try {
            doneLatch.await();
        } catch (InterruptedException e) {
            // ignore exception
        }
    }

    /////////////////////
    void loadProgress() throws InterruptedException {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Xml Files", "*.xml"));
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Playback autoplay = new Playback(file.getPath(), this);
            // autoplay.run();

            //A版本：
            Thread t1 = new Thread(autoplay);
            t1.start();
            // t1.join();
            // startInterface();
            System.out.println("回退");

            // runAndWait(autoplay);
            // final CountDownLatch doneLatch = new CountDownLatch(1);
            // try {
            // new Thread(autoplay).start();
            // } finally {
            // doneLatch.countDown();
            // startInterface();
            // System.out.println("回到主界面");
            // }

        }
        // while (true) {
        //     if (playing.get() == false) {
        //         startInterface();
        //         System.out.println("回到主界面");
        //         break;
        //     }
        // }

    }

    void decorateStage() {
        labels.clear();
        pics.clear();
        picsDead.clear();

        // 显示地图
        ImageView map = new ImageView(Attributes.images.get(Attributes.MAP));
        map.setFitHeight(Attributes.height);
        map.setFitWidth(Attributes.width);
        canvas.getChildren().add(map);

        // 加载角色图片
        picsList = Arrays.asList(new ImageView(Attributes.images.get(Attributes.CALABASH1)),
                new ImageView(Attributes.images.get(Attributes.CALABASH2)),
                new ImageView(Attributes.images.get(Attributes.CALABASH3)),
                new ImageView(Attributes.images.get(Attributes.CALABASH4)),
                new ImageView(Attributes.images.get(Attributes.CALABASH5)),
                new ImageView(Attributes.images.get(Attributes.CALABASH6)),
                new ImageView(Attributes.images.get(Attributes.CALABASH7)),
                new ImageView(Attributes.images.get(Attributes.GRANDPA)),
                new ImageView(Attributes.images.get(Attributes.PANGOLIN)),
                new ImageView(Attributes.images.get(Attributes.SCORPION)),
                new ImageView(Attributes.images.get(Attributes.SNAKE)),
                new ImageView(Attributes.images.get(Attributes.MINION3)),
                new ImageView(Attributes.images.get(Attributes.MINION4)),
                new ImageView(Attributes.images.get(Attributes.MINION5)),
                new ImageView(Attributes.images.get(Attributes.MINION6)),
                new ImageView(Attributes.images.get(Attributes.MINION7)),
                new ImageView(Attributes.images.get(Attributes.MINION8)),
                new ImageView(Attributes.images.get(Attributes.MINION9)));

        pics.addAll(picsList);
        ///////////
        List<ImageView> picsListDead = Arrays.asList(new ImageView(Attributes.images.get(Attributes.CALABASH1_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH2_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH3_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH4_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH5_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH6_DEAD)),
                new ImageView(Attributes.images.get(Attributes.CALABASH7_DEAD)),
                new ImageView(Attributes.images.get(Attributes.GRANDPA_DEAD)),
                new ImageView(Attributes.images.get(Attributes.PANGOLIN_DEAD)),
                new ImageView(Attributes.images.get(Attributes.SCORPION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.SNAKE_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)),
                new ImageView(Attributes.images.get(Attributes.MINION_DEAD)));
        // ArrayList<ImageView> picsDead=new ArrayList<>();
        picsDead.addAll(picsListDead);
        ////////////
        for (int i = 0; i < 2 * Attributes.rolesNum; i++) {
            pics.get(i).setFitWidth(100);
            pics.get(i).setFitHeight(100);
            picsDead.get(i).setFitHeight(100);
            picsDead.get(i).setFitWidth(100);
        }
        // 人物的显示
        for (int i = 0; i < 2 * Attributes.rolesNum; i++) {
            Label label = new Label("", pics.get(i));
            label.setLayoutX(Attributes.mapLeft + battle.roles.get(i).curX.get() * Attributes.gridWidth);
            label.setLayoutY(Attributes.mapTop + battle.roles.get(i).curY.get() * Attributes.gridHeight);
            labels.add(label);
            canvas.getChildren().add(label);
        }
        // 血量条的显示
        for (int i = 0; i < 2 * Attributes.rolesNum; i++) {
            battle.hpbars.get(i).setBar(battle.roles.get(i));
            Label labelbar = new Label("", battle.hpbars.get(i));
            labelbar.setLayoutX(Attributes.mapLeft + battle.roles.get(i).curX.get() * Attributes.gridWidth);
            labelbar.setLayoutY(Attributes.mapTop + battle.roles.get(i).curY.get() * Attributes.gridHeight - 3);
            labels.add(labelbar);
            canvas.getChildren().add(labelbar);
        }
        System.out.println("show 地图");
    }

    public void enterBattle() {
        decorateStage();
        battle.enemyId = enemyID;
        if (battle.myCamp == Camp.MONSTER)
            battle.selected = 9;
        else
            battle.selected = 0;

        // 响应键盘，控制角色移动和攻击
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int selected = battle.selected;
                String key = event.getText();
                if (key.length() > 0 && key.charAt(0) >= '1' && key.charAt(0) <= '9') {
                    selected = key.charAt(0) - '1';
                    if (battle.myCamp == Camp.MONSTER)
                        selected += 9;
                    battle.selected = selected;
                    System.out.println(selected);
                }
                if (battle.roles.get(selected).alive == false)
                    return;
                if (key.equals("a")) {
                    battle.roles.get(selected).move(Direction.LEFT);
                } else if (key.equals("d")) {
                    battle.roles.get(selected).move(Direction.RIGHT);
                } else if (key.equals("w")) {
                    battle.roles.get(selected).move(Direction.UP);
                } else if (key.equals("s")) {
                    battle.roles.get(selected).move(Direction.DOWN);

                } else if (key.equals("j")) {
                    Direction dir = Direction.RIGHT;
                    if (battle.roles.get(selected).camp == Camp.MONSTER)
                        dir = Direction.LEFT;
                    if (battle.roles.get(selected).healer == false) {
                        int atkid = battle.roles.get(selected).useGnrAtk(dir);
                        AttackMessage message = new AttackMessage(enemyID, selected, dir);
                        battle.gameprogress.writeIn(ActionType.GNRATK, selected + " " + battle.dir2str(dir));
                        calabashClient.send(message);
                        if (atkid != -1) {
                            System.out.println("攻击" + atkid + "血量为" + battle.roles.get(atkid).HP);
                            if (battle.roles.get(atkid).alive == false) {
                                battle.enemyDeadCount++;
                                setDead(atkid);
                                if (battle.enemyDeadCount == Attributes.rolesNum) {
                                    gameOver(true);
                                }
                            }
                        }
                    } else {// 治愈者无攻击能力，按j使用的是治愈术
                        int healid = battle.roles.get(selected).useHealing(dir);
                        AttackMessage message = new AttackMessage(enemyID, selected, dir);
                        battle.gameprogress.writeIn(ActionType.HEAL, selected + " " + battle.dir2str(dir));
                        calabashClient.send(message);
                        if (healid != -1) {
                            System.out.println("治愈" + healid + "血量为" + battle.roles.get(healid).HP);
                        }
                    }
                }
                int x = battle.roles.get(selected).curX.get();
                int y = battle.roles.get(selected).curY.get();
                moveRole(selected, x, y);
                //向服务器发送移动消息
                RoleMoveMessage message=new RoleMoveMessage(enemyID,selected,x,y);
                calabashClient.send(message);
            }
        });

    }

    // step3-3:游戏结束
    void gameOver(boolean winFlag) {
        try {
            battle.gameprogress.saveFile();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("对战结果");
        alert.setHeaderText(null);
        if (winFlag) {
            alert.setContentText("恭喜您，取得胜利!");
        } else {
            alert.setContentText("很遗憾，对局失败...");
        }

        labels.clear();
        pics.clear();
        picsDead.clear();

        started = false;
        alert.showAndWait();
        startInterface();
    }

    void setDead(int roleID) {
        // labels.get(roleID).setGraphic(picsDead.get(roleID));
        labels.get(roleID).setVisible(false);
        labels.get(roleID).setManaged(false);
        labels.get(roleID + Attributes.hpoffset).setVisible(false);
        labels.get(roleID + Attributes.hpoffset).setManaged(false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calabash VS Monster");

        primaryStage.setScene(scene);
        primaryStage.show();

        this.stage = primaryStage;
        canvas.setOnMousePressed((MouseEvent e) -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        canvas.setOnMouseDragged((MouseEvent e) -> {
            primaryStage.setX(e.getScreenX() - mouseX);
            primaryStage.setY(e.getScreenY() - mouseY);

        });

        startInterface();
        connectServer(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
