# 葫芦娃大战妖精

<p align="right">181860154 朱倩    ；181860117 徐佳美</p>

[TOC]

## 1 项目介绍

### 1.1 项目简介

本项目使用Java语言编程，运用图形框架JavaFX，结合网络编程（C/S架构），实现可供多名玩家在线匹配的1v1联机游戏《葫芦娃大战妖精》。

**游戏规则：**

1. 玩家首先要输入运行服务器的主机IP地址与服务器连接，在成功连接服务器后可以通过鼠标点击选择：

   1）匹配玩家：选择当前已连接服务器的某一玩家id（最小为0）并发送对战邀请，如果对方同意则可以直接进入游戏；相应的，在接受其他玩家发出的对战邀请后也可以直接进入游戏。

   2）战斗回放：选择某一用于记录战局的*.xml文件（文件名为对局时间）可以读取文件内容，并按文件中记录的内容进行战斗回放。

   3）退出游戏

2. 在成功匹配玩家后，游戏在5*9的二维空间战场上进行，分为葫芦娃阵营和妖精阵营。游戏开始时葫芦娃阵营（包含七兄弟、老爷爷和穿山甲）与妖精阵营（包括蛇精、蝎子精和小喽啰等）以特定阵型在左右两侧分列站队。玩家可以用键盘的“1”-“9”键选中对应编号的游戏角色；使用"W", "S", ”A", "D"键控制角色进行上，下，左，右方向的移动；使用“J”键进行攻击（仅能攻击人物朝向的相邻位置的角色），使敌方角色掉血；人物上方的红色血条显示人物剩余血量，血量为0时角色死亡，当某一方生物全部死亡时，游戏结束，对局过程将保存到文件中，同时有弹窗提示对局结果。

3. 在进行战斗回放时，会跳出文件选择对话框，选择记录对局过程的\*.xml文件即可进行战斗回放。\*.xml文件通常以时间命名，如提交版本中录制的对局：target/2021-01-02 11_34_46.xml

   <span style="text-decoration: underline">注：需要使用鼠标进行功能选择，并没有添加使用按键的空格键开始对局，"L"键进行战斗回放的交互方式。 </span>
   
   

### 1.2 运行方式

Tip：`CalabashServer`类和`Main`类中都有main函数，分别是服务器和客户端的入口。

先运行服务器，可以直接运行`CalabashServer`中的main函数，也可以将`pom.xml`文件中的`artifactId`改为`CalabashServer`,将`mainClass`修改为`sample.CalabashServer`后打包成`CalabashServer-1.0.jar`后直接运行target目录下的jar包。即如下修改：

````java
<artifactId>CalabashServer</artifactId>
    ...
			<configuration>
                    <archive>
                        <manifest>
                            <mainClass>sample.CalabashServer</mainClass>
                        </manifest>
                    </archive>
                </configuration>
    ...
````

成功运行服务器后，可以在不同的主机上运行客户端，即运行target目录下的jar包`CalabashWar-1.0.jar`。

（生成`CalabashWar-1.0.jar`：将`pom.xml`文件中的`artifactId`改为`CalabashWar`,将`mainClass`修改为`sample.Main`后执行`mvn package`指令）

（因为`pom.xml`文件的后期修改失误，提交版本中target目录下名字为`CalabashServer-1.0.jar`和`CalabashWar-1.0.jar`其实对应的都是客户端的jar包，即指定主类为Main的jar包）



### 1.3 实现效果

开始界面

(https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110851.png)

![](https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110851.png)



之后会自动弹出连接服务器窗口，连接成功后命令行界面会提示：connect to server successfully...

(https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110921.png)

![](https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110921.png)

连接之后点击匹配玩家在下拉列表选择玩家可以发送邀请

(https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110932.png)

![](https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107110932.png)

匹配成功后进入游戏

（https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107005424.png)

![](https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107005424.png)



对局结束后显示提示信息

(https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107111045.png)

![](https://cdn.jsdelivr.net/gh/sevenxqq/pics/20210107111045.png)

### 1.4 分工

朱倩：图形界面主体部分，网络通信，游戏流程控制，用户交互

徐佳美：战斗逻辑，文件保存，回放功能，部分图形界面和少量网络部分



## 2 设计思想

### 2.1 类的设计

在开发过程中，将用到的主要概念抽象成以下几个类：

| 类                  | 功能                                                         |
| :------------------ | :----------------------------------------------------------- |
| `Attributes`        | 用于存储所有游戏相关的属性，是一经设定不会再改变的值，如地图宽高等。 |
| `Creature`          | 生物类，表示葫芦娃妖精等生物体，有生命值等属性               |
| `Battle`            | 表示一场对局，包含对局中存在的`Creature`数组等属性           |
| `Message`及其派生类 | 用于将玩家间通信的信息打包成数据包并对接收到的数据包进行解析 |
| `CalabashServer`    | 服务器类，是玩家间通信的中转站                               |
| `CalabashClient`    | 客户端类，用于玩家方对于消息的收发                           |
| `Info`              | 用于角色血量条的显示                                         |
| `PlayBack`          | 用于实现回放机制                                             |
| `Player`            | 表示玩家，包含玩家id等属性                                   |
| `Main`              | 主类，包含程序入口main函数，用于客户端的启动和图形界面的显示 |
| `ActionType`        | enum类型，表示动作类型，包含移动和攻击                       |
| `Camp`              | enum类型，表示阵营，包含葫芦娃阵营和妖怪阵营                 |
| `Direction`         | enum类型，表示移动方向，包含上、下、左、右                   |



## 3 实现细节

### 3.1 图形界面

采用Javafx框架，相关代码主要在`Main`类中。

有关图形界面的参数，如地图高度宽度、加载图片路径等，全部放在`Attributes`类中。

`Main`类继承自`Application`，对`init()`和`start()`进行重写，在`init()`对应的线程中完成图片加载等初始化工作，在`start()`中调用`connectServer()`函数连接服务器，即玩家可进行的第一步操作。

使用如下代码创建画布和场景，用于图形界面的显示：

```java
public void start(Stage primaryStage) throws Exception {
        Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, Attributes.width, Attributes.height);
        primaryStage.setTitle("Calabash VS Monster");
        primaryStage.setScene(scene);
        primaryStage.show();
    	...
}
```

此后需要添加某一图元`item`时只需调用`canvas.getChildren().add(item);`即可。这里的图元可以是`ImageView`型，用于添加地图这样的全局图片；也可以是`Label`型，用于添加需要移动的角色图片和作按钮功用的控件图片等。

在进行人物移动时只需将`label`进行位置重设，如：

```java
label.setLayoutX(650);
label.setLayoutY(550);
```

而在用于与用户沟通的图形界面部分，多采用对话框形式，使用的是对话框类，如：用于输入服务器IP地址的`TextInputDialog`类；用于选择匹配玩家的`ChoiceDialog`类；用于回应对局邀请和通知战局结果的`Alert`类等。



### 3.2 网络通信

网络通信部分采用C/S架构，所有玩家拥有一个客户端，需要连接服务器与其他玩家客户端进行通信，主要代码在`CalabashServer`类（服务器），`CalabashClient`类（客户端）和`Message.java`（包含`Message`类及其派生类，用于打包和解析消息）中。

**服务器类`CalabashServer`：**

服务器通过如下代码创建`ServerSocket`：

```java
        try {
            serverSocket = new ServerSocket(TCP_PORT);
            System.out.println("CalabashServer has started...");
        } catch (IOException e) {
            e.printStackTrace();
        }
```

再通过如下代码：

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

与客户端相连。在给客户端分配id，与客户端交流各自的UDP端口号后，将该客户端加入到`Client`列表中（服务器用此存储所有与其之相连的客户端信息，包括客户端的id、IP地址和UDP端口号）。

服务器在UDP线程中收发数据包（即`DatagramPacket`），每当接收到数据包就转发给所有客户端，但数据包中会有关于目标客户端id的信息，客户端接收到后会首先检查是不是发给自己的消息，再选择是否对其解析。



**客户端类`CalabashClient`**：

客户端通过如下代码与服务器相连：

```java
        Socket s = null;
        try {
            ds = new DatagramSocket(UDP_PORT);//创建UDP套接字
            try {
                s = new Socket(ip, CalabashServer.TCP_PORT);//创建TCP套接字
            }catch (Exception e1){
                ds.close();
            }
            ...
        } catch (IOException e) {
            e.printStackTrace();
```

在UDP线程中通过如下代码进行数据包的接收并调用解析函数`parse(dp);`对其进行解析：

```java
        public void run() {
            while(ds!=null){
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                try{
                    ds.receive(dp);
                    parse(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

在`parse(dp)`函数中解析数据包时，会先通过

```java
byte[] buffer = new byte[1024];
ByteArrayInputStream bin = new ByteArrayInputStream(buffer, 0, dp.getLength());
DataInputStream in = new DataInputStream(bin);
```

获取数据，再读取消息类型（客户端发送消息时也会附加消息类型），再创建对应的消息类，调用该消息类的parse函数对数据流进行解析。如接收到角色移动消息时：

```java
Message message = null;
switch (messageType){//根据消息的类型调用对应消息的解析方法
    case  Message.ROLE_MOVE :
        message = new RoleMoveMessage(player);//player表示玩家
        message.parse(in);
        break;
        ...
}
```

而在玩家执行某一动作（如移动角色，攻击等）后想要发送消息时，调用`CalabashClient`函数中的send函数即可：

```java
public void send(Message message){
    message.send(ds, serverIP, serverUDPPort);
}
```



**消息类`Message`：**

为实现信息的打包和数据包的解析，创建`Message`接口，包含发送和解析方法：

```java
public void send(DatagramSocket ds, String ip, int udpPort);//发送消息
public void parse(DataInputStream in);//解析消息
```

并创建一系列继承自`Message`接口的各种消息类用于不同种类消息的发送和解析。如：

`InviteMessage`：邀请玩家进行对局

`ReplyMessage`：回复邀请

`NewPlayerMessage`：有新玩家连接服务器，提示客户端当前可匹配玩家列表需要更新

`RoleMoveMessage`：角色移动

`AttackMessage`：对对手造成攻击

因为不同消息传递的信息数量和格式不同，所以不同消息类会对`Message`接口中的发送和解析方法进行复写，以一致的方法进行信息的发送和解析。

成功解析消息后，会根据消息内容调用相关函数采取一定动作，如接收到敌方角色移动消息后会将己方游戏界面中相应的敌方角色图片进行移动。

而玩家在进行一些操作（如人物移动，攻击等）时也会通过消息类将信息打包成特定格式后向服务器发送。



### 3.3 游戏流程控制和用户交互

**游戏流程控制：**

主要代码在`Main`类中，通过适时调用如下函数实现对游戏流程的控制。

```java
    // step1:连接服务器
    void connectServer(int flag) ;
    // step2：选择开始游戏or回放or退出
    public void startInterface() ;
    // step3-1：选择开始游戏后匹配玩家
    void matchPlayer() ;
    // step3-2:接受邀请后进入战斗
    public void enterBattle() ;
    // step3-3:游戏结束
    void gameOver(boolean winFlag) ;
    //处理邀请
    void processInvitation(int playerID);
    //邀请被拒绝
    void invitationRefused() ;
	//进行战斗回放
	void loadProgress() ；
```

**用户交互：**

主要是对鼠标和键盘事件的响应，通过复写相关方法即可:

```java
        //响应键盘
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	...
            }
        }
        //响应鼠标单击
       	scene.setOnMouseClicked((MouseEvent e) -> {
            ...
        });
```



### 3.4 战斗逻辑

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



### 3.5 回放功能

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



## 4 总结

### 4.1 一点优点

目前的游戏机制还是比较用户友好的。玩家匹配机制比较符合日常游戏的体验；游戏过程中仅用键盘就可以实现所有操作避免了鼠标和键盘切换造成的操作不流畅；而游戏未开始时对于一些功能的选择用鼠标点击icon实现，各种提示、选择的对话框也比较符合日常体验。

### 4.2 一点反思

由于前期低估了项目的工程量，没有预留足够的时间，导致最后时间来不及，很多设想都没有来得及实现。

### 4.3 可改进的地方

- 增加攻击方式：目前只有普通攻击，缺少游戏趣味性。可以增加一些特殊的攻击方式，如每到达5次有效攻击可以释放一次大招（使整行敌人掉血）等，增加游戏的挑战度和可玩性。
- 美化游戏界面：攻击时没有特效，只有血量条的减少作为攻击有效的提示，可以增加攻击时的图片显示和定时消失；对局过程中可以增加一些提示信息：如目前存活的角色数量等
- 增加音效：游戏时的背景音乐和攻击音效
- 录制更精彩的对局回放





