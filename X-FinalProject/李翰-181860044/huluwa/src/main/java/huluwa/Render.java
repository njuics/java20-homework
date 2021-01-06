package huluwa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import huluwa.Bullet.Bullet;
import huluwa.Creature.Creature;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;

public class Render extends Application {
    Group root;
    Label label;
    static RandomAccessFile recordFile;
    File file;
    private Game game;
    // variable for storing actual frame
    public Render(Game game){
        this.game = game;
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println(ClassLoader.getSystemResource(""));
        primaryStage.setTitle("HuLu Battle");
        root = new Group();

        Image background = new Image("file:resource//bg.jpg");
        Canvas canvas = new Canvas(992, 558);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        root.getChildren().add(canvas);
        gc.drawImage(background, 0, 0);

        int menuBarHeight = 39;

        for (int i = 0; i <= 19; i++)
            gc.strokeLine(50 * i + 21, 0 + menuBarHeight, 50 * i + 21, 500 + menuBarHeight);
        for (int i = 0; i <= 10; i++)
            gc.strokeLine(21, 50 * i + menuBarHeight, 971, 50 * i + menuBarHeight);

        HBox hbox = new HBox();

        label = new Label("点击左上角菜单选择");
        label.setTextFill(Color.web("#ff0000"));
        label.setPrefSize(992, 558); // 设置标签的推荐宽高
        label.setFont(new Font("Arial", 50));
        label.setAlignment(Pos.CENTER); // 设置标签的对齐方式

        hbox.setSpacing(10);
        hbox.getChildren().add((label));
        root.getChildren().add(hbox);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.getChildren().add(menuBar);
        
        Menu fileMenu = new Menu("File");
        MenuItem startMenuItem = new MenuItem("Start");
        MenuItem replayMenuItem = new MenuItem("Replay");
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(startMenuItem, replayMenuItem, exitMenuItem);
        //startMenuItem.setOnAction(actionEvent -> {game.init(root); label.setText("");});
        startMenuItem.setOnAction(actionEvent -> {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");// 设置日期格式
            String fileName = df.format(new Date()); // 获取当前系统时间
            try {
                recordFile = new RandomAccessFile(".\\record\\" + fileName + ".txt", "rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            game.init(root);
            label.setText("");
            System.out.println(Thread.currentThread().getName());
        });
        //replayMenuItem.setOnAction(actionEvent -> Platform.exit());
        replayMenuItem.setOnAction(actionEvent -> {
            game.init(root);
            label.setText("");
            FileChooser filechooser = new FileChooser();
            file = filechooser.showOpenDialog(primaryStage);
            replayThread.run();
        });
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        menuBar.getMenus().addAll(fileMenu);

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void drawBullet(Creature c, Bullet b, int tmp, int startX, int startY, int endX, int endY) { // 给定起点(发射子弹的生物)和终点(子弹命中目标)(的战场坐标)，绘制子弹运动
        Circle bullet = new Circle(5, Color.rgb(148, 0, 211));
        bullet.setCenterX(50 * startX - 4);
        bullet.setCenterY(50 * startY + 14);
        root.getChildren().add(bullet);

        double flyTime = Math.abs(endX - startX) * 200; // 假定子弹飞行一格需要200ms

        Timeline timeline = new Timeline();
        KeyValue xValue = new KeyValue(bullet.centerXProperty(), 50 * endX - 4);
        KeyValue yValue = new KeyValue(bullet.centerYProperty(), 50 * endY + 14);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(flyTime), xValue, yValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timeline.setOnFinished(event -> {
            bullet.setCenterX(1000); 
            boolean dead = game.updateHp(c, b, tmp);
            if(dead){
                if(c.getGoodOrBad()){
                    removeDead(game.badManGrid.get(tmp));
                }else{
                    removeDead(game.goodManGrid.get(tmp));
                }
            }
            gameIsOver();
        });

    }

    public void removeDead(BattlefieldGrid deadOne){
        root.getChildren().remove(deadOne.getVBox());
    }
    public void gameIsOver(){
        int flag = game.gameOver();
        if(flag==1){  //葫芦娃获胜
            label.setText("葫芦娃获胜！！！");
        }else if(flag==-1){  //蛇精获胜
            label.setText("蛇精获胜！！！");
        }
    }

    private Thread replayThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                try {
                    String data = null;
                    while ((data = br.readLine()) != null) {
                        String name, behave;
                        String[] tmp = data.split(" ");
                        name = tmp[0];
                        behave = tmp[1];
                        System.out.println(data);
                        Platform.runLater(()->{
                            if (behave.equals("move")) {
                                int dir = Integer.parseInt(tmp[2]);
                                boolean flag = false;
                                for (int i = 0; i < game.goodMan.size(); ++i) {
                                    if (game.goodMan.get(i).getName() == name) {
                                        flag = true;
                                        game.goodManGrid.get(i).moveWithoutRecord(dir);
                                        game.goodManGrid.get(i).update();
                                        System.out.println("move successfully");
                                        break;
                                    }
                                }
                                if (!flag) {
                                    for (int i = 0; i < game.badMan.size(); ++i) {
                                        if (game.badMan.get(i).getName() == name) {
                                            game.badManGrid.get(i).moveWithoutRecord(dir);
                                            game.badManGrid.get(i).update();
                                            break;
                                        }
                                    }
                                }
                            } else if (behave.equals("shoot")) {
                                boolean flag = false;
                                for (int i = 0; i < game.goodMan.size(); ++i) {
                                    if (game.goodMan.get(i).getName() == name) {
                                        flag = true;
                                        Game.shoot(game.goodMan.get(i), game.goodMan.get(i).getBullet());
                                        System.out.println("shoot successfully");
                                        break;
                                    }
                                }
                                if (!flag) {
                                    for (int i = 0; i < game.badMan.size(); ++i) {
                                        if (game.badMan.get(i).getName() == name) {
                                            Game.shoot(game.badMan.get(i), game.badMan.get(i).getBullet());
                                        }
                                    }
                                }
                            }
                        });
                        try {
                            Thread.sleep(500);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
		}
    });
}
