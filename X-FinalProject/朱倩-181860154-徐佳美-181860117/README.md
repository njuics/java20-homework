# 葫芦娃大战妖精

<p align="right">181860154 朱倩    ；181860117 徐佳美</p>

## 1 项目介绍

### 1.1 项目简介

本项目使用Java语言编程，运用图形框架**JavaFX**，结合网络编程（C/S架构），实现多人联机游戏《葫芦娃大战妖精》。

**游戏规则：**

1. 玩家首先要输入运行服务器的主机IP地址与服务器连接，在成功连接服务器后可以选择

   1）匹配玩家：选择当前已连接服务器的某一玩家id并发送对战邀请，如果对方同意则可以直接进入游戏；相应的，在接受其他玩家发出的对战邀请后也可以直接进入游戏。

   2）战斗回放：选择某一用于记录战局的*.xml文件（文件名为对局时间）可以读取文件内容，并按文件中记录的内容进行战斗回放。

   3）退出游戏

2. 在成功匹配玩家后，游戏在5*9的二维空间战场上进行，分为葫芦娃阵营和妖精阵营。游戏开始时葫芦娃阵营（包含七兄弟、老爷爷和穿山甲）与妖精阵营（包括蛇精、蝎子精和小喽啰等）以特定阵型在左右两侧分列站队。玩家可以用键盘的“1”-“9”键选中对应编号的游戏角色；使用"W", "S", ”A", "D"键控制角色进行上，下，左，右方向的移动；当某一方生物全部死亡时，游戏结束，对局过程将保存到文件中。

   

### 1.2 运行方式

先运行服务器，可以直接运行`CalabashServer`中的main函数，也可以运行target目录下的jar包`CalabashServer.jar`

然后在不同的主机上运行客户端，即运行target目录下的jar包`CalabashWar.jar`。



### 1.3 分工

朱倩：图形界面主体部分，网络通信部分

徐佳美：战斗逻辑，文件保存，回放功能，部分图形界面和少量网络部分



## 2 实现细节

### 2.1 图形界面

采用Javafx框架，相关代码主要在`Main`中，

`startInterface`函数创造开始界面，包括欢迎界面和游戏相关按钮，比如：选择回放，开始游戏或退出。

`decrateStage`函数用来装饰舞台，包括场景大小设置，地图的位置，人物视图的加载等



### 2.2 网络通信

网络通信部分采用C/S架构，所有玩家拥有一个客户端，需要连接服务器与其他玩家进行通信。

**服务器类`CalabashServer`：**

服务器通过如下代码：

```
        while(true){
            Socket clientSocket = null;
            try {
                //处理新连接的用户
                clientSocket = serverSocket.accept();//给客户分配TCP套接字
                System.out.println("A client has connected...");
                ...
        }
```

与客户端相连，

给客户端分配id，与客户端交流各自的UDP端口号后，再将该客户端加入到存储所有与其相连的`Client`列表中。

服务器在UDP线程中收发消息，每当接收到新消息时，转发给所有客户端，消息中会有关于目标客户端id的信息。

为实现通信机制，在`Message.java`中创建了用于传递新玩家加入服务器，对局邀请，回复邀请，人物移动，攻击等各种`Message`。客户端接收到消息后，若确实是发送给自己的，会调用对应函数对其进行解析。

而人物在进行移动，攻击等动作时会将信息打包成特定格式后向服务器发送。

**客户端`CalabashClient`**：

负责玩家方消息的收发，先判断`Message`类型，再交给相应的`Message`派生类处理。



### 2.3 战斗逻辑

​	`Creature&Roles`: 生物类，包括对生物各种属性的赋值，移动，以及技能的使用，如普通攻击，技能攻击，治愈术；

玩家通过在界面按动相应按键调度相应行为，在使用普通攻击时，每达成一次有效攻击，增加一点怒气值，每使用一次技能攻击消耗5点怒气值，

技能攻击可以对攻击方向一行的敌方单位进行攻击；

每次受到攻击或者收到治疗术时，会同步更新血条的情况；血条设置为所有存活角色一直显示，便于玩家直观了解各个角色的当前情况；

```java
 public void useMgcAtk(Direction dir) {
        if (this.MP <= 5)
            return;
        int x = curX.get();
        int y = curY.get();
        if (dir == Direction.RIGHT) {
            for (int i = x + 1; i < Attributes.gridNumX; i++) {
                int atkid = checkEnemy(i, y);
                if (atkid == -1)
                    continue;
                battle.roles.get(atkid).beenAtked(this.mgcAtk);
            }
        }
        else if (dir == Direction.LEFT){
            for (int i = x - 1; i >= 0; i--) {
                int atkid = checkEnemy(i, y);
                if (atkid == -1)
                    continue;
                battle.roles.get(atkid).beenAtked(this.mgcAtk);
            }
        }
        this.MP-=5;
    }
```



```java
public void setBar(Creature role){
        if (role.HP==role.maxHP)
            return;
        float ratio = (float)role.HP/(float)role.maxHP;
        Stop[] stops = new Stop[] { new Stop(0, Color.rgb(255,0,0)), new Stop(ratio,Color.rgb(255, 153, 18,0.5)),
                 new Stop(1, Color.rgb(255,255,255,0)) };
        LinearGradient lg1 = new LinearGradient( 0,0,1,0,true, CycleMethod.NO_CYCLE,stops);
        HPbar.setFill(lg1);
    }
```



 

   `Battle`类：负责对一场战斗的控制，比如初始化人物位置，地图的状态，判断地图格的占用情况，阵营的设置，方向转换，记录死亡人数等，当一方人物全部死亡后，判断游戏结束，并提示相关信息；

```java
	boolean started=false;
    int enemyId;
    int[] map=new int[Attributes.gridNumX*Attributes.gridNumY];//记录地图中每格的角色id
    public ArrayList<Creature> roles = new ArrayList<>();//存储游戏角色
    ArrayList<Info> hpbars =  new ArrayList<>();//角色对应的血条,存储顺序和角色一样
    int[] startPos={9,10,11,20,27,28,29,19,18,17,35,15,16,24,25,26,33,34};
    Camp myCamp=Camp.CALABASH;
    XMLFile gameprogress = new XMLFile();
    int myDeadCount=0;//己方死亡角色个数
    int enemyDeadCount=0;//敌方死亡角色个数
    int selected;//被选中的角色id
```



### 2.4 回放功能

`XMLFile`类负责对文件的保存：

对于玩家采取的每个动作，统一使用writeIn函数进行写入，传入参数后，类会自动对不同的动作进行解析并转化成相应的

语句存入*.xml文件中；对局结束后，调用`saveFile`函数进行保存，文件名为开始对局的时间。

```java
public void writeIn(ActionType atype,String str){
        if(newround == true){
            newround = false;
            NodeList nodelist = battle.getChildNodes();
            if (nodelist.getLength()!=0)
                fileroot.appendChild(battle);
            battle = dcmt.createElement("battle");
        }
        switch(atype){
            case MOVE: writeInMove(str); break;
            case GNRATK: writeInGnrAtk(str); break;
            case MGCATK: writeInMgcAtk(str);break;
            case HEAL: writeInHeal(str); break;
            default:break;
        }
    }
```

`PlayBack`类负责回放：

点击回放按钮后，玩家可以通过file chooser选择一个xml文件，系统将自动读取文件内容并解析，重现当时的对战场面；

每次解析到一个指令，会在图形界面上对应显示，每个指令之间的间隔时间为0.1s；

```java
  void loadProgress() throws InterruptedException {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Xml Files", "*.xml"));
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Playback autoplay = new Playback(file.getPath(), this);
            Thread t1 = new Thread(autoplay);
            t1.start();
            t1.join();
            startInterface();
        }
    }
```







