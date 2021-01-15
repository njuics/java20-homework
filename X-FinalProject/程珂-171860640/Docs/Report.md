## 项目报告

- [项目基本信息](#BasicInfo)
- [面向对象实例](#OOP)
- [设计模式实例](#DesignPattern)
- [异常处理实例](#Exception)
- [集合类型实例](#Set)
- [泛型实例](#Generic)
- [网络通信实例](#Socket)
- [输入输出实例](#IO)
- [多线程 & Lambda表达式实例](#Threads)

### <span id="BasicInfo">项目基本信息</span>

- 项目文件结构

  ```
  D:.
  │  pom.xml
  ├─logs
  │      2020-12-18-20-20-48
  │
  └─src
      ├─main
      │  ├─java
      │  │  └─advancedjava
      │  │      └─finalproj
      │  │          │  Pair.java
      │  │          │
      │  │          ├─connection
      │  │          │  ├─client
      │  │          │  │      Client.java
      │  │          │  │
      │  │          │  ├─helper
      │  │          │  │      ConnectHelper.java
      │  │          │  │      Receiver.java
      │  │          │  │      ReceiveThread.java
      │  │          │  │      Sender.java
      │  │          │  │
      │  │          │  └─server
      │  │          │          Match.java
      │  │          │          Server.java
      │  │          │
      │  │          ├─game
      │  │          │  │  CampEnum.java
      │  │          │  │  DirectionEnum.java
      │  │          │  │  Location.java
      │  │          │  │
      │  │          │  ├─creature
      │  │          │  │      Creature.java
      │  │          │  │      HuluBro.java
      │  │          │  │      Monster.java
      │  │          │  │      Utils.java
      │  │          │  │
      │  │          │  ├─handler
      │  │          │  │      GameHandler.java
      │  │          │  │
      │  │          │  ├─main
      │  │          │  │      testGame1.java
      │  │          │  │      testGame2.java
      │  │          │  │      testGame3.java
      │  │          │  │      testGame4.java
      │  │          │  │      testServer.java
      │  │          │  │
      │  │          │  └─message
      │  │          │          AttackMessage.java
      │  │          │          DefenseMessage.java
      │  │          │          GameOverMessage.java
      │  │          │          Message.java
      │  │          │          MessageType.java
      │  │          │          MoveMessage.java
      │  │          │          OverReasonEnum.java
      │  │          │          StartMessage.java
      │  │          │
      │  │          ├─logger
      │  │          │      LogDir.java
      │  │          │      Logger.java
      │  │          │
      │  │          └─stage
      │  │                  GameStage.java
      │  │                  HistoryStage.java
      │  │                  LogInStage.java
      │  │                  MyStage.java
      │  │
      │  └─resources
      │          action_attack_bro.gif
      │          action_attack_monster .gif
      │          action_defend_bro.gif
      │          action_defend_monster.gif
      │          background.png
      │          Bro1.png
      │          Bro2.png
      │          Bro3.png
      │          Bro4.png
      │          Bro5.png
      │          Bro6.png
      │          Bro7.png
      │          LogInBackGround.png
      │          LogInCenter.png
      │          Monster1.png
      │          Monster2.png
      │          Monster3.png
      │          Monster4.png
      │          Monster5.png
      │          Monster6.png
      │          Monster7.png
      │
      └─test
          └─java
              ├─connection
              │      ConnectHelperTest.java
              │
              └─game
                  ├─creature
                  │      CreatureTest.java
                  │
                  ├─handler
                  │      GameHandlerTest.java
                  │
                  └─message
                          AttackMessageTest.java
                          DefenseMessageTest.java
                          GameOverMessageTest.java
                          MessageTest.java
                          MoveMessageTest.java
                          StartMessageTest.java
  ```

- 项目总代码行数 : **2069** 行，具体情况如下

  <img src=".\DocPics\image-20210103123611047.png" alt="image-20210103123611047"  /><img src=".\DocPics\image-20210103123637660.png" alt="image-20210103123637660"  />

#### <span id="OOP">面向对象实例</span>

(源码位置 : `advancedjava.finalproj.game.creature.Creature`)

- **Creature**类 **HuluBro**类与 **Monster**类是项目中使用面向对象**继承**特性的一个例子

  <img src=".\DocPics\image-20210103125329010.png" alt="image-20210103125329010" style="zoom:50%;" />

  其中 **HuluBro** 和 **Monster**  继承了 **Creature** ，并且它们在属性上有不同的初始设置

#### <span id="DesignPattern">设计模式实例</span>

(源码位置 : `advancedjava.finalproj.game.creature.HuluBro`)

- HuluBro 和 Monter的类实例(对象)均采用工厂模式进行构建，以 **HuluBro** 为例

  ```java
  //私有构造函数，只能通过方法创建对象实例
  private HuluBro(double hpValue, double damageValue,
                      double damageRangeValue, double defenseValue, double critPropValue)
      {
          super(hpValue, damageValue, damageRangeValue, defenseValue, critPropValue, CAMP);
      }
  //创建默认实例
   static public HuluBro getInstance()
      {
          return new HuluBro(BASE_HP, BASE_DAMAGE,
                  BASE_DAMAGE_RANGE, BASE_DEFENSE, BASE_CRIT_PROP);
      }
  //创建随机实例
  static public HuluBro getInstance(Random rand)
      {
          double hp = BASE_HP + limitRandomRange(rand.nextDouble());
          double damage = BASE_DAMAGE + limitRandomRange(rand.nextDouble());
          double defense = BASE_DEFENSE + limitRandomRange(rand.nextDouble());
          return new HuluBro(formatDouble(hp), formatDouble(damage),
                  BASE_DAMAGE_RANGE, formatDouble(defense), BASE_CRIT_PROP);
      }
  ```

#### <span id="Exception">异常处理实例</span>

(源码位置 : `advancedjava.finalproj.connection.helper.Receiver`)

```java
/*
以数据接收为例
其中in为BufferedReader,当在线对战时由Socket提供输入流,当读取历史时由logger提供输入流
*/
public Message getMessage()
    {
        Message msg = null;
        try
        {
            String msgStr = in.readLine();
            //Output Test Information
            System.out.println("receiver:" + msgStr);
            if (msgStr != null)
            {
                msg = Message.parseMessage(msgStr);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
        finally
        {
            return msg;
        }
    }
```

#### <span id="Set">集合类型实例</span>

(源码位置 : `advancedjava.finalproj.connection.helper.ReceiveThread`)

在**ReceiveThread** 类中使用了 `ConcurrentLinkedQueue<Message>` 类型的成员变量 `msgChannel` 来存储收到的消息

在服务器端中使用，用来对客户端发来的消息按照服务器接收到的先后顺序进行排序

#### <span id="Generic">泛型实例</span>

(源码位置 : `advancedjava.finalproj.Pair`)

在项目中编写了 **Pair** 类模板

- 通过 **Pair<Socket,Socket>** 保存每一局两个对战玩家与服务器相连接的Socket(源码位置 : `advancedjava.finalproj.connection.server.Server`)

- `public class Location extends Pair<Integer>` ，通过继承 `Pair<Interger>` 得到保存位置的数据结构 `Location` (源码位置 : `advancedjava.finalproj.game.Location`)

```java
//Pair
public class Pair<T>
{
    protected T first;
    protected T second;

    public Pair(T first, T second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return this.first;
    }

    public T getSecond()
    {
        return this.second;
    }
}
```

#### <span id="Socket">网络通信实例</span>

 (源码位置 : `advancedjava.finalproj.connection.client.Client`)

以 **Client** 类为例

```java
ServerSocket clientServer = new ServerSocket();
        clientServer.bind(ConnectHelper.getSocketAddr(this.addr, CLIENT_RECEIVER_PORT));
        senderSocket = new Socket();
        senderSocket.bind(ConnectHelper.getSocketAddr(this.addr, CLIENT_SENDER_PORT));
        senderSocket.connect(ConnectHelper.getSocketAddr(ConnectHelper.getInetAddrFromStr(SERVER_ADDR),
                Server.SERVER_RECEIVER_PORT));
        receiverSocket = clientServer.accept();
```

#### <span id="IO">输入输出实例</span>

(源码位置 : `advancedjava.finalproj.logger.Logger`)

以 **Logger** 为例，下图为 logger向文件中逐行写入游戏记录的函数

```java
//out = new BufferedWriter(new FileWriter(addr));
public void writeLine(String line)
    {
        try
        {
            out.write(line);
            out.newLine();
            out.flush();
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
```

#### <span id="Threads">多线程 & Lambda表达式实例</span>

(源码位置 : `advancedjava.finalproj.game.handler.GameHandler.handleGameStart()`)

客户端游戏流程如下

```java
//Start Game
new Thread(() ->
{
	Logger logger = new Logger();
	Message msg;
	while (!isGameOver)
	{
		msg = client.recvMsg();
		if (msg != null)
		{
			process(msg);
			logger.writeLine(msg.toString());
		}
	}
	client.close();
	logger.close();
	//Output Test Information
	System.out.println("Controller Exit");
}).start();
```
