package BattleControl;

import Creature.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.util.Pair;


import java.io.*;
import java.net.URL;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable,BattleConfig {
    private static Stage stage = null;
    private GraphicsContext gc;//在canvas上的绘图工具
    private GameState gameState;//描述游戏状态
    private static GameMap gameMap;//描述战场信息
    private ExecutorService pool;//线程池
    private Timeline timeLine;//用于控制画面的刷新

    private static ArrayList<HuLuWa> huLuWas = null;//葫芦娃
    private static ArrayList<Centipede> centipedes = null;//蜈蚣小兵
    private static Grandpa grandpa = null;//爷爷
    private static Snake snake = null;//蛇精
    private static Scorpion scorpion = null;//蝎子精
    private ArrayList<Creature> initCreatureArray = null;//用于创建gameMap时初始化其中的creatureArray(根据生物的初始位置)
    private ArrayList<Controllable> controllableJusticeArrayList = null;//所有正义都可以被操控
    private ArrayList<Controllable> controllableEvilArrayList = null;
    private int controlJusticeIndex = -1;
    private int controlEvilIndex = -1;
    private Thread listener;
    private ObjectOutputStream logWriter;//每次刷新就向文件写
    private ObjectInputStream logReader;
    private NetThread netThread;//监听线程，监听接受套接字传递的信息
    private static Boolean isConnectinReady=false;
    private static Boolean isCampRight=false;
    private static DatagramSocket sendSocket;//传输信息的套接字
    private static int otherPort = 8090;//对方端口
    private static int receivePort = 8091;//本地端口
    private static String otherIp = "114.212.132.208";
    private static Player player=Player.JUSTICEPLAYER;
    @FXML
    private BorderPane pane;//pane、canvas自动与FXML文件中单元对应
    @FXML
    private Canvas canvas;

    @FXML
    public void initialize(URL location, ResourceBundle resourceBundle) {
        //只能对pane、canvas操作，执行此方法时stage仍为null
        pane.setVisible(true);
        pane.setOpaqueInsets(new Insets(0, 0, 0, 0));
        Platform.runLater(new Runnable() {//为pane添加焦点才能获取键盘事件，并且对UI界面的修改应该利用runLater方法交由javafx application线程完成来保证线程安全
            @Override
            public void run() {
                pane.requestFocus();
            }
        });
        pane.addEventFilter(KeyEvent.KEY_PRESSED, new BattleKeyEventHandler());

        canvas.setHeight(CANVAS_HEIGHT);
        canvas.setWidth(CANVAS_WIDTH);
        gc = canvas.getGraphicsContext2D();
        gameState = new GameState();

        huLuWas = new ArrayList<HuLuWa>();
        centipedes = new ArrayList<Centipede>();
        initCreatureArray = new ArrayList<Creature>();
        controllableJusticeArrayList = new ArrayList<Controllable>();
        controllableEvilArrayList = new ArrayList<Controllable>();

        // System.out.print(gameMap);

        gameMap = new GameMap(gc, gameState);
        initCreatures();
        gameMap.initCreatureArray(initCreatureArray);
        Creature.setStaticFileds(gameMap, gameState);
       // setConnection();
        //System.out.println(gameMap==grandpa.getGameMap());
        //System.out.println(gameMap.equals(grandpa.getGameMap()));
    }

    private void initCreatures() {
        //System.out.println("init creatures");
        URL url;
        url = this.getClass().getClassLoader().getResource("picture/creature/Grandpa.png");
        grandpa = new Grandpa(DEFAULT_HP, DEFAULT_DAMAGE, DEFAULT_DEFENSE, 0, 5, new Image(url.toString()));//老爷爷的攻击力和防御力都很低，为默认值
        grandpa.setMaxHp(DEFAULT_HP);
        /*
        if (player.equals(Player.JUSTICEPLAYER)) {
            grandpa.setControlled(true);//初始情况下玩家1操控老爷爷
        }*/
        initCreatureArray.add(grandpa);
        controllableJusticeArrayList.add(grandpa);
        controlJusticeIndex = 0;
        for (int i = 1; i <= 7; i++) {
            url = this.getClass().getClassLoader().getResource("picture/creature/No" + i + ".png");
            HuLuWa huLuWa = new HuLuWa(DEFAULT_HP, DEFAULT_DAMAGE, DEFAULT_DEFENSE, 1, 1 + i, new Image(url.toString()), i);
            switch (i) {
                case 1:
                    huLuWa.setDamage(BattleConfig.HULUWA1_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA1_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA1_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA1_HP);
                    break;
                case 2:
                    huLuWa.setDamage(BattleConfig.HULUWA2_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA2_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA2_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA2_HP);
                    break;
                case 3:
                    huLuWa.setDamage(BattleConfig.HULUWA3_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA3_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA3_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA3_HP);
                    break;
                case 4:
                case 5:
                    huLuWa.setDamage(BattleConfig.HULUWA4_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA4_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA4_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA4_HP);
                    break;
                case 6:
                    huLuWa.setDamage(BattleConfig.HULUWA6_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA6_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA6_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA6_HP);
                    break;
                case 7:
                    huLuWa.setDamage(BattleConfig.HULUWA7_DAMAGE);
                    huLuWa.setDefense(BattleConfig.HULUWA7_DEFENSE);
                    huLuWa.setHp(BattleConfig.HULUWA7_HP);
                    huLuWa.setMaxHp(BattleConfig.HULUWA7_HP);
                    break;
                default:
                    break;
            }
            huLuWas.add(huLuWa);
            initCreatureArray.add(huLuWa);
            controllableJusticeArrayList.add(huLuWa);
        }
        url = this.getClass().getClassLoader().getResource("picture/creature/Snake.png");
        snake = new Snake(BattleConfig.SNAKE_HP, BattleConfig.SNAKE_DAMAGE, BattleConfig.SNAKE_DEFENSE, 10, 5, new Image(url.toString()));
        snake.setMaxHp(BattleConfig.SNAKE_HP);
        //snake.setDamage(1);
       // snake.setDefense(1);
        /*
        if (player.equals(Player.EVILPLAYER)) {
            snake.setControlled(true);
        }*/
        initCreatureArray.add(snake);
        controllableEvilArrayList.add(snake);
        controlEvilIndex = 0;
        url = this.getClass().getClassLoader().getResource("picture/creature/Scorpion.png");
        scorpion = new Scorpion(BattleConfig.SCORPION_HP, BattleConfig.SCORPION_DAMAGE, BattleConfig.SCORPION_DEFENSE, 10, 6, new Image(url.toString()));
        scorpion.setMaxHp(BattleConfig.SCORPION_HP);
        //scorpion.setDamage(1);
        //scorpion.setDefense(1);
        initCreatureArray.add(scorpion);
        controllableEvilArrayList.add(scorpion);
        for (int i = 0; i < 5; i++) {
            url = this.getClass().getClassLoader().getResource("picture/creature/Centipede" + (i + 1) + ".png");
            Centipede centipede = new Centipede(BattleConfig.CENTIPEDE_HP, BattleConfig.CENTIPEDE_DAMAGE, BattleConfig.CENTIPEDE_DEFENSE, 15 - i, i, new Image(url.toString()), i + 1);
            //centipede.setDamage(3);
            //centipede.setDefense(3);
            centipede.setMaxHp(BattleConfig.CENTIPEDE_HP);
            centipedes.add(centipede);
            initCreatureArray.add(centipede);
            controllableEvilArrayList.add(centipede);
        }
        for (int i = 0; i < 5; i++) {
            url = this.getClass().getClassLoader().getResource("picture/creature/Centipede" + (i + 6) + ".png");
            Centipede centipede = new Centipede(BattleConfig.CENTIPEDE_HP, BattleConfig.CENTIPEDE_DAMAGE, BattleConfig.CENTIPEDE_DEFENSE, 11 + i, 7 + i, new Image(url.toString()), i + 6);
            //centipede.setDamage(3);
            //centipede.setDefense(3);
            centipede.setMaxHp(BattleConfig.CENTIPEDE_HP);
            centipedes.add(centipede);
            initCreatureArray.add(centipede);
            controllableEvilArrayList.add(centipede);
        }
        //System.out.println("init creatures over");
    }

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }//执行此方法时类被加载,initialize()自动执行

    public void setConnection() {
        netThread = new NetThread(otherPort, receivePort, otherIp);
        netThread.start();
        try {
            sendSocket = new DatagramSocket();
            //TimeUnit.MILLISECONDS.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        for(int i=0;i<10;i++){
            send("hello");
        }*/
    }

    class BattleKeyEventHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e) {
            //  synchronized (gameState) {
            if (e.getCode() == KeyCode.SPACE) {
                if (gameState.isNotLaunched()) {
                    System.out.println("Start game!");
                    startGame();//start game;
                } else if (gameState.getIsStart()) {
                    //  synchronized (gameState) {//为了防止修改时被其他线程读到错误的状态
                    if (!gameState.getIsPaused()) {
                        //pause game
                        System.out.println("Pause game!");
                        gameState.setIsPaused(true);
                    } else if (gameState.getIsPaused()) {
                        //continue game
                        System.out.println("Continue game!");
                        gameState.setIsPaused(false);
                        synchronized (gameState) {
                            gameState.notifyAll();
                        }
                    }
                    //   }
                } else {
                    if (!gameState.getIsPaused()) {
                        //pause review
                    } else if (gameState.getIsPaused()) {
                        //continue review
                    }
                }
            } else if (e.getCode() == KeyCode.L && gameState.isNotLaunched()) {
                //review game
                System.out.println("Review game!");
                startReview();//start game;

            } else if (e.getCode() == KeyCode.UP && gameState.getIsStart() && player.equals(Player.EVILPLAYER)) {
                controllableEvilArrayList.get(controlEvilIndex).controlledMove(Direction.UP);
            } else if (e.getCode() == KeyCode.DOWN && gameState.getIsStart() && player.equals(Player.EVILPLAYER)) {
                controllableEvilArrayList.get(controlEvilIndex).controlledMove(Direction.DOWN);
            } else if (e.getCode() == KeyCode.RIGHT && gameState.getIsStart() && player.equals(Player.EVILPLAYER)) {
                controllableEvilArrayList.get(controlEvilIndex).controlledMove(Direction.RIGHT);
            } else if (e.getCode() == KeyCode.LEFT && gameState.getIsStart() && player.equals(Player.EVILPLAYER)) {
                controllableEvilArrayList.get(controlEvilIndex).controlledMove(Direction.LEFT);
            } else if (e.getCode() == KeyCode.W && gameState.getIsStart() && player.equals(Player.JUSTICEPLAYER)) {
                controllableJusticeArrayList.get(controlJusticeIndex).controlledMove(Direction.UP);
            } else if (e.getCode() == KeyCode.S && gameState.getIsStart() && player.equals(Player.JUSTICEPLAYER)) {
                controllableJusticeArrayList.get(controlJusticeIndex).controlledMove(Direction.DOWN);
            } else if (e.getCode() == KeyCode.D && gameState.getIsStart() && player.equals(Player.JUSTICEPLAYER)) {
                controllableJusticeArrayList.get(controlJusticeIndex).controlledMove(Direction.RIGHT);
            } else if (e.getCode() == KeyCode.A && gameState.getIsStart() && player.equals(Player.JUSTICEPLAYER)) {
                controllableJusticeArrayList.get(controlJusticeIndex).controlledMove(Direction.LEFT);
            } else if (e.getCode() == KeyCode.TAB && gameState.getIsStart()&& player.equals(Player.JUSTICEPLAYER)) {
                //切换控制
                int listSize = controllableJusticeArrayList.size();
                for (int i = (controlJusticeIndex + 1) % listSize; ; i = (i + 1) % listSize) {
                    if (controllableJusticeArrayList.get(i).canBeControlled()) {
                        controllableJusticeArrayList.get(controlJusticeIndex).setControlled(false);
                        controlJusticeIndex = i;
                        controllableJusticeArrayList.get(controlJusticeIndex).setControlled(true);
                        break;
                    }
                }
            } else if (e.getCode() == KeyCode.J && gameState.getIsStart()&& player.equals(Player.EVILPLAYER)) {
                //切换控制
                int listSize = controllableEvilArrayList.size();
                for (int i = (controlEvilIndex + 1) % listSize; ; i = (i + 1) % listSize) {
                    if (controllableEvilArrayList.get(i).canBeControlled()) {
                        controllableEvilArrayList.get(controlEvilIndex).setControlled(false);
                        controlEvilIndex = i;
                        controllableEvilArrayList.get(controlEvilIndex).setControlled(true);
                        break;
                    }
                }
            } else {
                System.out.println("unused key or battle is busy");
            }
            //   }
        }
    }

    public void startGame() {
        try {
            //弹出文件对话框让用户选择保存文件，否则无法开始游戏
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("."));
            fileChooser.setTitle("选择游戏记录保存文件");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("游戏记录保存文件", "*.gamelog"));
            File gameLog = fileChooser.showSaveDialog(stage);
            if (gameLog == null) {//不选择则无法开始
                System.out.println("未选择游戏记录保存文件,无法开始游戏!");
                return;
            }
            logWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(gameLog.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Connection Setting Dialog");
            dialog.setHeaderText("Setting the connection");

            // Set the icon (must be included in the project).
            //dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

            // Set the button types.
            ButtonType loginButtonType = new ButtonType("Confirm", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

            // Create the username and password labels and fields.
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(20, 150, 10, 10));

            TextField ipAddress = new TextField();
            //ipAddress.setPromptText("");
            TextField myPort = new TextField();
            TextField enemyPort = new TextField();

            grid.add(new Label("Ip:"), 0, 0);
            grid.add(ipAddress, 1, 0);
            grid.add(new Label("MyPort:"), 0, 1);
            grid.add(myPort, 1, 1);
            grid.add(new Label("OtherPort:"), 0, 2);
            grid.add(enemyPort, 1, 2);

            // Enable/Disable login button depending on whether a username was entered.
            Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
            loginButton.setDisable(true);

            // Do some validation (using the Java 8 lambda syntax).
            ipAddress.textProperty().addListener((observable, oldValue, newValue) -> {
                loginButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.getDialogPane().setContent(grid);

            // Request focus on the username field by default.
            Platform.runLater(() -> ipAddress.requestFocus());

            // Convert the result to a username-password-pair when the login button is clicked.
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == loginButtonType) {
                    System.out.println(ipAddress.getText()+" "+myPort.getText()+" "+enemyPort.getText());
                    if(ipAddress.getText()!=null&&enemyPort.getText()!=null&&myPort.getText()!=null) {
                        otherIp = ipAddress.getText();
                        otherPort = Integer.parseInt(enemyPort.getText());
                        receivePort = Integer.parseInt(myPort.getText());
                    }
                }
                return null;
            });

            Optional<Pair<String, String>> result = dialog.showAndWait();

            result.ifPresent(usernamePassword -> {
                System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<String> choices = new ArrayList<>();
            choices.add("Justice");
            choices.add("Evil");

            ChoiceDialog<String> dialog = new ChoiceDialog<>("Justice", choices);
            dialog.setTitle("Choice Dialog");
            dialog.setHeaderText("Look, a Choice Dialog");
            dialog.setContentText("Choose your camp:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                System.out.println("Your choice: " + result.get());
                if(result.get().equals("Justice"))player=Player.JUSTICEPLAYER;
                else player=Player.EVILPLAYER;
            }

            result.ifPresent(letter -> System.out.println("Your choice: " + letter));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Creature.setPlayer(player);
        if (player.equals(Player.JUSTICEPLAYER)) {
            grandpa.setControlled(true);//初始情况下玩家1操控老爷爷
        }
        if (player.equals(Player.EVILPLAYER)) {
            snake.setControlled(true);
        }
        setConnection();
        //在此之前程序都是单线程运行

        /*
        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        }
        catch(Exception e){
            e.printStackTrace();
        }*/

        while(!isConnectinReady){
            NetPacket conPacket=new NetPacket(false,null,-1,-1,-1);
            send(conPacket);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<10;i++){
            NetPacket conPacket=new NetPacket(false,null,-1,-1,-1);
            send(conPacket);
        }
        System.out.println("Connection established");

        while(!isCampRight){
            boolean myCamp=true;
            if(player.equals(Player.EVILPLAYER))myCamp=false;
            NetPacket conPacket=new NetPacket(myCamp);
            send(conPacket);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }


        gameState.setIsStarted(true);
        gameMap.setLogWriter(logWriter);

        pool = Executors.newCachedThreadPool();
        if (player.equals(Player.JUSTICEPLAYER)) {
            for (HuLuWa huLuWa : huLuWas) {
                pool.execute(huLuWa);
            }
            pool.execute(grandpa);
        }
        if (player.equals(Player.EVILPLAYER)) {
            for (Centipede centipede : centipedes) {
                pool.execute(centipede);
            }
            pool.execute(scorpion);
            pool.execute(snake);
        }

        timeLine = new Timeline(
                new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (gameState.getIsStart()) {
                            gameMap.display();
                        }
                    }
                }), new KeyFrame(Duration.millis(1000 / REFRESH_RATE))
        );
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();

        listener = new Thread() {
            @Override
            public void run() {
                synchronized (gameState) {
                    while (gameState.getIsStart()) {//监听游戏状态
                        try {
                            gameState.wait();//若游戏未结束，则监听线程阻塞;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameOver();//监听线程被唤醒，执行资源释放工作
            }
        };
        listener.start();

        /*
        NetPacket testPacket1=new NetPacket("Snake",11,0,40);
        byte[] tempByte=convertToByte(testPacket1);
        NetPacket testPacket2=netThread.convertToNetPacket(tempByte);
        processNetPacket(testPacket2);
        NetPacket testPacket2=new NetPacket("Scorpion",12,0,20);
        processNetPacket(testPacket2);
        NetPacket testPacket3=new NetPacket("Centipede1",15,0,30);
        processNetPacket(testPacket3);*/
    }

    public void startReview() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("."));
        chooser.setTitle("选择回放记录文件");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("游戏记录文件", "*.gamelog"));
        File file = chooser.showOpenDialog(stage);
        if (file == null) {//如果没有选择，就不能回放
            System.out.println("没有选择记录文件，回放不能进行");
            return;
        }
        try {
            //sendSocket.close();
            //netThread.stop();
            System.out.println("成功选择回放文件" + file.getName());
            logReader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            gameMap.setLogReader(logReader);
            gameState.setIsReviewed(true);//回放状态的关闭在submit的call线程中
            gameMap.startReview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameOver() {
        try {
            logWriter.close();
            sendSocket.close();//关闭发送信息的套接字
            netThread.stop();
            System.out.println("writer closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Game Over!");
        pool.shutdown();
        System.out.println("pool shutdown!");
        while (((ThreadPoolExecutor) pool).getActiveCount() != 0) ;
        timeLine.stop();
        System.out.println("timeline stop!");
        //listener.stop();
        System.out.println("Game Over!");
    }

    public static void send(NetPacket netPacket) {
        //System.out.println(str);
        if(!sendSocket.isClosed()) {
            byte[] buffer = convertToByte(netPacket);
            if (buffer != null) {
                try {
//			InetAddress ia = InetAddress.getLocalHost();//获取本机地址
                    InetAddress ia = InetAddress.getByName(otherIp);//获取目标地址
                    // System.out.println("请求连接的ip是"+otherIp);
                    DatagramPacket dgp = new DatagramPacket(buffer, buffer.length, ia, otherPort);
                    synchronized (sendSocket) {
                        sendSocket.send(dgp);
                    }
                    //  System.out.println("发送信息:"+str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] convertToByte(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();
            return baos.toByteArray();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void processNetPacket(NetPacket netPacket) {
        if (netPacket.getType()&&isCampRight&&isConnectinReady) {
            Creature tempCreature = null;
            if(netPacket.getName()!=null) {
                switch (netPacket.getName()) {
                    case "Grandpa":
                        tempCreature = grandpa;
                        break;
                    case "Scorpion":
                        tempCreature = scorpion;
                        break;
                    case "Snake":
                        tempCreature = snake;
                        break;
                    case "No1":
                        tempCreature = huLuWas.get(0);
                        break;
                    case "No2":
                        tempCreature = huLuWas.get(1);
                        break;
                    case "No3":
                        tempCreature = huLuWas.get(2);
                        break;
                    case "No4":
                        tempCreature = huLuWas.get(3);
                        break;
                    case "No5":
                        tempCreature = huLuWas.get(4);
                        break;
                    case "No6":
                        tempCreature = huLuWas.get(5);
                        break;
                    case "No7":
                        tempCreature = huLuWas.get(6);
                        break;
                    case "Centipede1":
                        tempCreature = centipedes.get(0);
                        break;
                    case "Centipede2":
                        tempCreature = centipedes.get(1);
                        break;
                    case "Centipede3":
                        tempCreature = centipedes.get(2);
                        break;
                    case "Centipede4":
                        tempCreature = centipedes.get(3);
                        break;
                    case "Centipede5":
                        tempCreature = centipedes.get(4);
                        break;
                    case "Centipede6":
                        tempCreature = centipedes.get(5);
                        break;
                    case "Centipede7":
                        tempCreature = centipedes.get(6);
                        break;
                    case "Centipede8":
                        tempCreature = centipedes.get(7);
                        break;
                    case "Centipede9":
                        tempCreature = centipedes.get(8);
                        break;
                    case "Centipede10":
                        tempCreature = centipedes.get(9);
                        break;
                    default:
                        break;
                }
                //System.out.println(tempCreature.getName());
                int oldX = gameMap.posXByName(tempCreature.getName());
                int oldY = gameMap.posYByName(tempCreature.getName());
                int newX = netPacket.getNewPosX();
                int newY = netPacket.getNewPosY();
                tempCreature.setPosX(newX);
                tempCreature.setPosY(newY);
                tempCreature.setHp(netPacket.getHp());
                synchronized (gameMap) {
                    gameMap.removeCreature(oldX, oldY);
                    gameMap.setCreature(newX, newY, tempCreature);
                }
            }
        }

        else if(!isConnectinReady&&!netPacket.getType()){
                synchronized (isConnectinReady){
                    isConnectinReady=true;
                }
        }
        else if(isConnectinReady&&!isCampRight&&netPacket.getType()){
            boolean enemyCamp=netPacket.getCamp();
            if((player.equals(Player.JUSTICEPLAYER)&&!enemyCamp)||(player.equals(Player.EVILPLAYER)&&enemyCamp)){
                synchronized (isCampRight){
                    isCampRight=true;
                }
            }
            else{
                for(int i=0;i<10;i++) {
                    boolean myCamp = true;
                    if (player.equals(Player.EVILPLAYER)) myCamp = false;
                    NetPacket conPacket = new NetPacket(myCamp);
                    send(conPacket);
                }
                System.out.println("你的阵营选择与对手相同,游戏无法开始!");
                System.exit(-1);
            }
        }

    }
}




