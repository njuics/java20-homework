# CalabashVsSnake

## 游戏指南
### 运行环境
本游戏是在`JavaSE-14`的环境下开发的，运行时请确保运行环境下有`jre-14`或更高的版本。

### 运行方法
执行`mvn clean package`命令，从target目录下提取`cvs-1.0-jar-with-dependencies.jar`文件，双击或执行命令`java -jar cvs-1.0-jar-with-dependencies.jar`均可运行游戏。

### 游戏说明
进入游戏后，点击"New Game"按钮将连接服务器并匹配玩家，匹配成功后，游戏将会自动开始并且右侧消息区将会显示你的阵营。
![](https://github.com/Hoyyyywolf/Images/raw/master/CalabashVsSnake/new%20game.gif)

游戏开始后，点击游戏场景中同阵营的人物可对其进行选中，选中后再点击空格可进行移动，点击敌军可进行攻击，当攻击距离不够时会自动移动到攻击距离以内。若不对人物进行操作，它们将自动选取攻击距离内的敌军并攻击。
![](https://github.com/Hoyyyywolf/Images/raw/master/CalabashVsSnake/operation.gif)

游戏中的子弹主要有四种类型。葫芦娃阵营的子弹是直线弹和穿透弹，前者沿直线飞行并伤害第一个命中的敌军，后者沿直线飞行但伤害途中的每一个敌军。妖精阵营的子弹是追踪弹和弹射弹，前者自动追踪并伤害目标，后者在命中目标后会弹射附近两格内最近的敌军上，最多弹射两次。

当一方的生物全部死亡后，游戏结束，对局记录会自动保存在当前目录下，名为"xxx.record"，点击"Load Record"按钮可以加载记录文件重新观看对局。
![](https://github.com/Hoyyyywolf/Images/raw/master/CalabashVsSnake/load%20record.gif)


## 代码设计
### 设计思想
#### 联机同步
游戏的联机同步采用帧同步的方式实现，原理是相同的程序在同样的输入下应该得到同样的结果，当然这需要确保程序中的一些随机步骤相同，以及浮点数的计算精度等等。

具体实现时，客户端将玩家的输入发送给服务端，由服务端负责维护一个统一的逻辑时钟，每个tick时将这期间接受到的操作序列推送给所有客户端，各个客户端再按照服务端的统一逻辑时钟以及操作序列计算，这样就能得到一致的运行结果。

#### 线程安排
考虑到游戏中有很多地方需要阻塞等待输入，如客户端接受服务端发来的操作包，界面等待玩家的操作等等，这些都需要划分为单独线程以保证游戏的运行。游戏逻辑和显示也分离开来以便于进行游戏逻辑的测试。游戏实际运行时共划分为了四个线程：
+ gameController：负责游戏的逻辑运算，推进游戏的进行，以30帧的帧率计算游戏逻辑。但会由于接受不到逻辑帧而暂停游戏的进行，直到逻辑帧到来为止。
+ DrawController：负责游戏场景的绘制，以30帧的帧率绘制画面。
+ GameOperator：负责接受服务端的数据包（逻辑帧）。
+ GUI：界面主线程，接受玩家的操作，向服务端发送操作。

#### 战斗场景
战斗场景的绘制与交互是本次实验设计中最令人头疼的地方了。权衡良久后，我选择通过`javafx.scene.canvas.Canvas`来实现绘制，即将游戏中的所有物体都绘制在以张画布上，每一帧时都清空重新绘制以实现动态显示。背景等前后关系则可以通过多层画布的叠加来实现。而交互则是将鼠标落点转换成生物的坐标来判断是对谁进行操控的。

### 模块划分
本游戏一共划分为了三个模块进行开发：
+ game：负责游戏本体逻辑的运行，以及提供游戏中可见物体的绘制方法。
+ client：客户端，负责GUI界面的运行。
+ server：服务器，在远程主机上持续运行等待客户端连接。

#### game
首先考虑游戏中涉及到的物体，基本可分为两类：生物和影响因子。这里影响因子是指能对生物产生影响（伤害、治疗、减速等等）的物体，例如子弹，技能等等。

生物是玩家可以直接操作的对象，能够接受指令，移动或攻击。由于游戏设计得较简单，各生物的行为逻辑基本一致，区别只在于他们的攻击产生的子弹不同，这里只用一个类`Creature`来实现生物，攻击的特殊之处可以放到子弹中实现。对于生物可以通过调用`update`来对其状态进行一次更新，更新时会根据当前自身的指令，来自动选择移动还是攻击。部分代码如下：
```java
public class Creature implements Drawable {
    public Creature(Camp camp, int pos, int maxHp, int atk, int atkRange, BulletSupplier bullet, String imgName){
        ...
    }

    public void update(ItemManager items){
        ...
        switch(inst.action){
            case NULL:
                autoAttack(items);
                break;
            case MOVE: 
                moveTo(inst.pos, items, 0);
                break;
            case ATTACK:
                attack(inst.target, items);
                break;
            default:
                break;
        }
    }
    ...
}
```
其中`ItemManager`类是一个物体管理类，它持有了游戏中所有生物和影响因子的引用，并能根据不同的方式获取指定生物或影响因子的引用，用于提供全局信息。`BulletSupplier`类是一个函数式接口，用于确定生物产生的具体子弹类型。

影响因子是生物对生物造成影响的间接对象，所有生物想要对其他生物造成伤害、治疗等，都只能通过产生影响因子来实现。影响因子对外提供的接口只有一个`void update(ItemManager items)`，该接口负责更新自身的状态，并造成影响。

子弹就是影响因子的一种，子弹能够移动并伤害命中的目标。游戏中主要有两种子弹类型：追踪弹和直线弹，为便于对子弹的命中效果做扩展，这里采用模板方法的设计模式，将命中目标后的操作抽象为`void hit(Creature t, ItemManager items)`方法，基类提供默认实现，派生类可通过重写该方法来改变子弹的命中效果。弹射弹和穿透弹都是通过该方法实现的。部分代码如下：
```java
public class GuidedBullet implements Affector, Drawable {
    @Override
    public void update(ItemManager items){
        Creature ct = items.getCreatureById(target);
        if(ct == null){ //攻击对象已死亡，删除该子弹
            items.removeAffector(this);
            return;
        }
        int[] dest = Constants.creaturePos2BulletPos(ct.getPos()); //获取攻击对象位置
        moveTo(dest[0], dest[1]); 
        ...
        if(Math.abs(x - dest[0]) <= 25 && Math.abs(y - dest[1]) <= 25){ //命中目标
            hit(ct, items);
        }
    }

    protected void hit(Creature t, ItemManager items){ //默认实现，命中目标后就消失
        boolean dead = t.hurt(damage);
        if(dead){
            items.removeCreature(t.getId());
        }
        items.removeAffector(this);
    }
}

```

有了游戏中的物体，就可以运行游戏了，但我们还需要一个总控类来做刷新调用，指令赋予等工作。这个类实现为`GameController`，它实现了`Runnable`接口。运行时，每隔一段时间对游戏逻辑进行一次更新，当该次更新与逻辑帧重合时还会去向`Operator`请求逻辑帧，若成功获取，则进行指令赋予然后继续更新；否则的话，不进行更新，而是将该次更新计数储存起来，等到有逻辑帧后再一并更新。这是为联机运行时网络延迟所造成逻辑帧滞后提供支持。其中`Operator`是一个接口`Operation[] getLogicFrames(int logicFrame)`。部分代码如下：
```java
public class GameController implements Runnable {
    public GameController(ItemManager items, Operator operator, Consumer<Camp> gameEnd){
        ...
    }

    @Override
    public void run() {
        //isGameOver()用于判断游戏逻辑是否结束，gameOver用于判断是否被其他线程中断执行
        while(!isGameOver() && !gameOver){
            ... //睡眠100ms
            times++; //times是更新帧的计数器，代表有多少帧需要更新
            update();
        }
        ...
        //游戏结束，调用回调函数告知主线程游戏已结束
        gameEnd.accept(items.getCreatures()[0].getCamp());
    }

    protected void update(){
        while(times > 0){
            if(logicTimer <= 0){ //需要更新逻辑帧
                Operation[] ops = operator.getLogicFrames(logicFrame);
                if(ops == null){ //获取逻辑帧失败
                    return;
                }
                for(Operation op : ops){ //赋予指令
                    ...
                }
                ...
            }
            //更新生物和影响因子的状态
            ...
        }
    }
    ...
}
```

到此游戏模块就可以正式运行了，但注意到由于所有生物都由一个`Creature`类实现，这导致`Creature`类的构造函数比较复杂，这里采用简单的工厂模式来进行简化：
```java
public class CreatureFactory {
    public static Creature generateCalabash(int x, int y, String name){
        switch(name){
            ...
        }
    }
    ...
}
```
对于影响因子也可以采用工厂模式来简化生成，在此不再赘述。

最后要提到的一点就是`Drawable`接口，该接口对外提供了`void draw(GraphicsContext gc)`方法用于绘制游戏中的物体，但游戏本体逻辑并不会使用该接口，只是提供给`client`模块的绘制支持。

#### client
客户端所需要实现的功能是gui，联机战斗以及战斗回放。战斗回放部分是最为简单的了，由于采用帧同步的联机同步方式，联机游戏时将所有逻辑帧保存下来，回放时再加载即可实现。gui部分并没有实现较为精美的界面，考虑到游戏操作、功能等较为单一，也没有采用MVC等设计模式，直接简单地初始化场景并注册事件处理器就结束了，在此略过不讲。

对于联机战斗而言，由于游戏模块已经实现了对帧同步机制的支持，这里我们只负责发送操作与接受逻辑帧。这些功能都在`GameOperator`中实现，它实现了`Operator`接口和`Runnable`接口，并提供了连接服务器与保存战斗记录的功能。由于服务端是部署在云端服务器上的，UDP协议容易被拦截且传输不可靠，运输层协议采用的是TCP。`GameOperator`自身会维护一个逻辑帧的数组，运行时，会循环阻塞地等待服务端逻辑帧并将其添加到数组中。


#### server
服务端主线程`MainServer`将会循环地阻塞等待玩家的连接请求，当有两个玩家请求连接后，将会新开一个线程`GameServer`专门负责这两个玩家的游戏对局。`Gameserver`的功能就是接收玩家的操作，并定时发送逻辑帧。

客户端与服务端的通信逻辑如下所示：
![](https://github.com/Hoyyyywolf/Images/raw/master/CalabashVsSnake/client-server.png)


### 注意细节
#### 线程安全
游戏运行中会涉及到多线程同时运行。
+ 一方面，在上述设计中大多数线程都是在`while`循环下持续运行的，需要其他线程来终止循环。这里一般采用标志位的方式来终止循环，例如：
```java
public class DrawController implements Runnable{
    @Override
    public void run(){
        while(!gameOver){
            ...
        }
    }

    public void terminate(){
        gameOver = true;
    }
    ...
}
```
主线程可以通过调用`terminate()`方法来安全地结束线程的循环。
+ 另一方面，多线程运行时会涉及到资源的竞争问题，特别需要注意临界区所带来的一系列问题。这里主要通过两种途径来解决：
  + 对于`Map`，`List`等容器的存取，可以采用它们的线程安全版解决，如`ConcurrentHashMap`等。
  + 而对于普通变量的访问与修改带来的问题，可以通过`synchronized`语法加锁来手动控制，例如：
```java
synchronized(lock){
    if(logicFrame >= operationsList.size()){
        return null;
    }
    else{
        return operationsList.get(logicFrame);
    }
}
```        

## 心得体会
+ 程序开发时，最重要的部分在于架构的设计。一个好的架构，能让后续的代码复用，错误查找等事半功倍。所以在刚开始设计程序时，不要害怕重构，一旦发现架构设计会导致大量代码的冗余或者逻辑混乱等，赶快重构。
+ 网络编程部分涉及到了大量的异常处理以及异常导致的执行流跳转，这其中一定要十分注意执行流究竟到了哪里，以及异常处理完后会回到哪里执行。
