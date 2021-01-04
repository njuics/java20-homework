# 葫芦娃大战妖精

## 游戏介绍

由于本人水平有限，所以只实现了一个简易的葫芦娃大战妖精的游戏，并没有实现联网功能，相当于是一个单机的游戏。

1. 这里分为妖精一方和葫芦娃一方，由于我没有实现联机版，所以我只在葫芦娃一方设置了可以通过鼠标和键盘的wasd键来控制人物在背景上的移动。

2. 当葫芦娃上下左右任意方向上有敌人时，会自动攻击敌人，同时也会受到敌人的攻击，但可以通过方向键进行闪避。

3. 由于没有设置敌方的手动控制，所以我在设定时将蛇精设定为了一个大boss，需要在一定时间内将蛇精尽快杀死，否则蛇精会有50%的概率来释放她的魔法来剿灭全图上的葫芦娃们和爷爷。

4. 任意一方全灭时，判定为某一方的胜利。

5. 按空格开始游戏。


## 模块介绍

本次实验大致分为以下部分：

* app 模块，提供Main类，作为入口
* action 模块，主要负责键盘、鼠标以及技能的动作
* creature 模块，以Creature为基类，创建包括CalabashMan,GrandFather,SnakeWoman等子类作为葫芦娃、爷爷、蛇精等。
* field 模块，战场类
* io 模块，用于对记录的读写
* UI 模块， 用于实现用户界面

### app 模块

1. app 模块里面最主要的就是一个Main类，所谓游戏开始的入口。

部分核心代码段如下

```java
public class Main extends Application {
    public static final int WIDTH_UNIT = 13;
    public static final int HEIGHT_UNIT = 11;
    public static final int UNIT_LENGTH = 60;

    private static UpperNotificationController unc = new UpperNotificationController();
    private static MainNotificationController mnc = new MainNotificationController();

    private BattleField bf = new BattleField(WIDTH_UNIT,HEIGHT_UNIT);

    private List<Creature> creatures = new ArrayList<>();
    private SnakeWoman snakeWoman = SnakeWoman.getInstance();

    private static List<Action> actions = new ArrayList<>();
    private static long recordStartTime;

    public enum GameType {NOT_BEGIN,PLAY,REPLAY, FINISH}
    private static GameType type = GameType.NOT_BEGIN;

public void start(Stage primaryStage) throws Exception {}
public static UpperNotificationController getUnc(){}
public static MainNotificationController getMnc(){}
public void setType(GameType type,boolean save);
public synchronized static GameType getType();
private void actionMouseClickedHandle(int x,int y);
...
```



### 控制 模块

1. 这里面最关键的是定义了一个抽象类`Action`，然后分别是定义了键盘的动作、鼠标的动作以及技能释放的动作：

```java
package control;

public abstract class Action {
    protected long time;
    public Action(long time){
        this.time = time;
    }
    public long getTime() {
        return time;
    }
    public abstract String getType();
}

public class KeyboardAction extends Action{
    private KeyCode code;
    public KeyboardAction(long time,KeyCode code) {
        super(time);
        this.code = code;
    }
    public KeyCode getCode() {
        return code;
    }
    @Override
    public String getType() {
        return "KEYBOARD";
    }
}
public class MouseAction extends Action{}
public class SkillAction extends Action{}
```



### 生物 模块

1. 首先这里面最重要的就是基类Creature类，在这里面实现了生物们的move功能，而且不同于直接坐标的改变，这里使用AnimationTimer实现了人物的平滑移动。
```java
public abstract class Creature extends Thread{

    class FightingAnimationTimer extends AnimationTimer{
        private boolean running = false;
        @Override
        public void handle(long now) {
            //I Love Math
            Platform.runLater(() -> {
                sprite.getProfileImage().setRotate(Math.sin(now / 100000000) * 20);
            });
        }

        @Override
        public synchronized void start() {
            if(!running){
                running = true;
                super.start();
            }
        }

        @Override
        public synchronized void stop() {
            if(running){
                running = false;
            }
            super.stop();
        }

        public boolean isRunning() {
            return running;
        }
    }

```
2. 然后就是移动（move）动作的实现：部分代码如下
```java
public void moveTo(int newX,int newY)
{
if(moving){
            return;
        }

        boolean successful = false;
        boolean newHere = (this.x<0||this.y<0);
        if(newHere){
            successful = bf.enter(this,newX,newY);
        }else{
            successful = bf.moveTo(this,newX,newY,this.x,this.y);
        }
        if(successful){
            if(!newHere){
...
}
public void moveUp(){
        moveTo(x,y-1);
    }

    public void moveDown(){
        moveTo(x,y+1);
    }

    public void moveLeft(){
        moveTo(x-1,y);
    }

    public void moveRight(){
        moveTo(x+1,y);
    }

```
3. 再根据阵营的好坏定义了好人阵营的类`PlayerCreature`,妖精阵营的类`PCCreature`,两者的基础数据存在着差异，以此来区分不同。
4. 然后这里面定义了葫芦娃类`CalabashMan`,爷爷类`GrandFather`,小喽啰类`Minion`,蝎子精类`ScorpionMan`,蛇精类`SnakeWoman`
例如葫芦娃类的定义如下：
```java
public class CalabashMan extends PlayerCreature{
    private CalabashMan(Image image, String name) {
        super(image, name);
    }
    public static void gotoBattleField(Group root){

    }
    private static List<CalabashMan> brothers = new ArrayList<>();
    static {
        for (int i = 0; i < 7; i++) {
            brothers.add(null);
        }
    }
    public static CalabashMan getInstance(int index){
        if (index < 1 || index > 7) {
            throw new RuntimeException("Invalid CalabashMan index.");
        } else {
            if (brothers.get(index - 1) == null) {
                String name = "";
                switch (index) {
                    case 1:
                        name = "大娃";
                        break;
                    case 2:
                        name = "二娃";
                        break;
                    case 3:
                        name = "三娃";
                        break;
                    case 4:
                        name="四娃";
                        break;
                    case 5:
                        name="五娃";
                        break;
                    case 6:
                        name = "六娃";
                        break;
                    case 7:
                        name="七娃";
                        break;
                }
                brothers.set(index-1,new CalabashMan(ImageLoader.getImage(String.format("Calabash%d",index)),name));
            }
            return brothers.get(index - 1);
        }
    }
}

```
### 战场 模块
1. 通过List容器来定义玩家阵营和妖精阵营，通过建立一个二维数组来存储Creature生物的实例,并设置足够大的宽和高的值
```java
public  class BattleField {
    private BattleFieldSprite bfs;
    private Main app;
    private List<Creature> playerCreatures = new ArrayList<>();
    private List<Creature> pcCreatures = new ArrayList<>();

    private Creature[][] creatures;
    private int width,height;

    private Creature currentSelectCreature;

    public BattleField(int width,int height){
        bfs = new BattleFieldSprite(width,height);
        creatures = new Creature[width][height];
        this.width = width;
        this.height = height;
    }
```
2. 在战场类中还定义了方法来判断附近的生物，判断生物是否跳出了战场的范围，是否是有效的位置，得到当前选取的生物。
```java
    private boolean isValidPosition(int x, int y){
        return x>=0&&x<width&&y>=0&&y<height;
    }
    public Creature getCurrentSelectCreature() {
        return currentSelectCreature;
    }
    public synchronized Creature[] getNearbyCreatures(int x,int y){
        Creature[] nearby = new Creature[4];
        nearby[0] = (isValidPosition(x-1,y)?creatures[x-1][y]:null);
        nearby[1] = (isValidPosition(x+1,y)?creatures[x+1][y]:null);
        nearby[2] = (isValidPosition(x,y-1)?creatures[x][y-1]:null);
        nearby[3] = (isValidPosition(x,y+1)?creatures[x][y+1]:null);
        return nearby;
    }
    public synchronized void getOutOfField(Creature creature,int x,int y);
    ......
```


### 输入输出记录 模块
分为RecordReader.java和RecordWriter.java,实现是主要靠javax.xml.parsers和javax.xml.transform包中的内容。

### 用户界面 模块
主要是将resources中的图片和对应的类、部件对应起来。
例如：
```java
public class ImageLoader {
    private ImageLoader(){}
    private static Map<String, Image>  images = new HashMap<>();
    public static Image getImage(String name){
        if(!images.containsKey(name)){
            String fileName;
            switch (name){
                case "Calabash1":fileName = "1.png";break;
                case "Calabash2":fileName = "2.png";break;
                case "Calabash3":fileName = "3.png";break;
                case "Calabash4":fileName = "4.png";break;
                case "Calabash5":fileName = "5.png";break;
                case "Calabash6":fileName = "6.png";break;
                case "Calabash7":fileName = "7.png";break;
                case "GrandFather":fileName = "grandfather.png";break;
                case "SnakeWoman":fileName = "snake.png";break;
                case "ScorpionMan":fileName = "scorpion.png";break;
                case "Minion":fileName = "minion.png";break;
                case "Fire":fileName = "fire.jpg";break;
                case "DarkGrass":fileName = "grass_dark.png";break;
                case "LightGrass":fileName = "grass_light.png";break;
                case "CreatureSelect":fileName = "select.png";break;
                case "NotificationBackground":fileName = "intro.png";break;
                default:throw new RuntimeException("Invalid image name.");
            }
            images.put(name,new Image(fileName));
        }
        return images.get(name);
    }
}
```


## 心得体会

本次实验由于我的水平限制，我的完成程度较低，好多知识都不太会，都是上网查资料或者是看了网上别人讲解才有所理解，整个实验下来倒是收获了很多新的知识，同时也对学过的java知识进行了很好的复习，让我收获颇丰。

