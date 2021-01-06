## 葫芦娃大战妖精

### 1. 设计思路

参照[4399小游戏海盗兵团抢宝藏](http://www.4399.com/flash/18173_1.htm)，为回合制游戏，对战双方初始布局固定，每次可选择一个生物进行行动（移动、攻击），攻击方式有多种子弹可选，小喽啰、葫芦娃武器较弱，蛇精、爷爷等有较强武器；但为了平衡各生物的攻击和生存能力，小喽啰和葫芦娃血量会比较高，而蛇精和爷爷等血量较低。某方生物全部阵亡时游戏结束，对方获胜。

部分游戏截图：

![image-20210103233712993](.\image\image-20210103233712993.png)

![image-20210103233744146](.\image\image-20210103233744146.png)



### 2. 操作说明

点击左上角菜单栏`File`选择 **start** 即可开始游戏，鼠标点击可选择生物，停留在生物上可显示该生物当前状态（满HP值，当前HP值等），用 *W、A、S、D* 操作选中的生物进行上下左右移动，*j、k*进行攻击，分别发射不同威力的子弹。



### 3. 设计说明

#### 3.1 主要的类

##### 3.1.1 生物类

定义生物基类`Creature`，其主要属性如下：*name*名字，*fullHP*总HP值，*curHP*当前HP值，*defence*防御力，*bullet*子弹类型，*posX*和*posY*分别表示在战场上的坐标，*alive*是否存活，*goodOrBad*属于哪一个阵营，并用方法*beAttacked*对受到攻击进行处理（修改当前HP值并判断是否死亡）。

由该类继承得到游戏中的所有生物——葫芦娃、穿山甲、爷爷、蛇精、蝎子精、小喽啰。

##### 3.1.2 子弹类

定义子弹基类`Bullet`，具有属性*power*表示子弹的威力，游戏中各种子弹均可通过继承该类得到。

同时使用了**工厂设计模式**，定义一个工厂类，进一步将生物类和子弹类进行解耦，每个生物只知道自己有生产子弹的能力，而生产的过程由工厂负责。

##### 3.1.3 战场网格类

定义战场网格类`BattlefieldGrid`，将战场上的每一个（有生物体）的格子看成该类的一个对象，实际上是一个*VBox*，每个*VBox*中有一个*Button*（用于选中生物体）和*ProgressBar*（显示生物体血条）。

#### 3.2 架构模式

此次作业采用MVC架构：

* *M*即*model*：存取数据的对象，主要为生物类、子弹类的子类及其对象
* *V*即*view*：游戏视图，由`Render`类负责绘制；部分游戏过程中的视图更新则放在`BattlefieldGrid`类中
* *C*即*controller*：作用于模型和视图，控制数据流向模型对象，并在数据变化时更新视图，由`Game`类充当——该类中存有战场上所有生物*Creature*对象以及有生物存在的网格*BattlefieldGrid*对象，所有生物的数据初始化在此进行，发射子弹、受到攻击后更新HP值也由该类负责

如此一来，游戏过程中操纵一个生物移动时，首先会在数据层面上更新相关生物体的坐标，然后再更新其视图；某一生物发射子弹时，会由*Game*类首先找到最终攻击到的目标，然后对目标*model*即目标生物体的HP值进行更新，最后再由*BattlefieldGrid*类更新视图中该生物的血条；某一生物死亡时，也是现在*Game*类中将相应生物体删除，然后再将其从视图上移除。

#### 3.3 GUI设计

* 采用JavaFx图形化框架，初始时在舞台*primaryStage*上加载背景、并绘制线条形成战场，使用菜单栏控件选择功能（开始游戏、战斗回放、退出游戏）

* 游戏中的每个生物体都是战场上的一个Vbox控件，其中含有以相应生物体的图片为背景的*button*控件，以及表示血条的*ProgressBar*控件，游戏中生物体的移动实际上是*VBox*控件位置的改变

* 关于发射子弹的显示，若是通过使用另一个线程逐帧显示画面，会产生一定的问题——在某一时刻画面会静止不再刷新，而后台程序运行正常，因为JavaFx并非线程安全的（可参考[Concurrency in JavaFX](https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/concurrency.htm)）。所以最终采用时间线动画*timeline*实现：

  ```java
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
  ```

#### 3.4 回放机制

由于初始场景固定，只需记录下每次操作的生物及操作类型即可（如操作大娃发射子弹记录为*“one shoot”*），每条记录在文件中为一行，回放文件保存在`huluwa/record`中，以对战开始时间命名；回放时使用**FileChooser**控件选取记录文件，按序读取文件中的记录并进行相应操作。

#### 3.5 网络联机

采用*C/S架构*，首先启动服务器，然后两个客户端连接到服务器。

##### 3.5.1 类设计

* `PlayerClient`类：客户端类，主要任务是自己启动一个线程然后连接到服务器
* `NetClient`类：网络接口类，将客户端需要进行的网络操作（与服务器进行连接等）进行封装，定义发送消息和接收并解析消息的方法
* `PlayerServer`类：服务器类，监听客户端连接，为客户端分配专属TCP套接字以及ID号（用于指定属于葫芦娃阵营或妖精阵营）

##### 3.5.2 应用层协议

为了使各个客户端之间游戏保持同步，需要定义网络游戏的应用层协议——当一个客户端对生物进行操作后，将向服务器发送相应的游戏消息报文，服务器将其转发给另一个客户端，后者收到后进行解析并相应的更新自己的游戏进程，从而保持两个客户端的同步。

本项目中应用层协议较为简单，只需要两个字段：消息类型和消息数据（有效载荷）；具体协议如下：

|    消息类型     |               消息数据               |      说明      |
| :-------------: | :----------------------------------: | :------------: |
| PLAYER_JOIN_MSG |             所操作的阵营             |  玩家加入游戏  |
|    MOVE_MSG     |      生物体，所属阵营，移动方向      |   生物体移动   |
|    SHOOT_MSG    | 发射子弹的生物体，所属阵营，子弹类型 |    发射子弹    |
|    DEAD_MSG     |                生物体                | 某个生物体死亡 |
|  GAME_OVER_MSG  |                获胜方                |  束，一方获胜  |



### 4. 总结

此次大实验对个人来说有些难度，但编码过程也是十分有趣，在娱乐中对本学期所学纸面知识点进行实践，对知识有了进一步的了解和体会。不足之处便是因个人能力、时间有限，葫芦娃大战妖精小游戏仅实现到[单机版本](https://github.com/Eternity-AIBN/FinalProj-of-Java/tree/acacedc736ca39f3172ffc89b9dc49a5cee2fa9f)，而联机版本尚有bug，无法正常运行，课程结束之后若有空将尝试继续开发。总之，感谢两位老师本学期的辛勤教导！