# 葫芦娃妖精翻转棋介绍
## 游戏玩法
游戏开始时，葫芦娃爷爷和青蛇精对峙于场地两侧。每方拥有九枚棋子，每个棋子具有两种状态：  
  （1）浅色。该状态下棋子可以向周围八个方向任意移动一格；  
  （2）深色。该状态下棋子可以跳过八个方向内所有相邻棋子，但是若没有相邻的棋子则不能移动。  
双方轮流行动，每次行动移动一枚本方棋子，棋子移动过后会切换状态。
让所有棋子到达对方区域初始三列内获得胜利。  
本游戏的玩法出自于桌游，融合了跳棋、翻转棋等玩法，属于简单的益智小游戏，适合休闲娱乐。
## 设计亮点
### GameObject系统
笔者试图在javafx系统中引入Unity等专业游戏引擎中组件的概念，设计了GameObject系统。核心系统如下：  
```java
public abstract class GameObject{  
  //基本属性
  public int width, height;
  ...
  
  //绘制方法
  protected GameObject parent;
  protected List<GameObject> children;
  abstract void draw(GraphicsContext gc);
}
```   
游戏中所有对象（除ui）均为一个GameObject。每个GameObject具有唯一的父对象和一个子对象的列表（二者均可以为空）。
每一个继承GameObject的具体实现类需要实现draw方法，该方法是用来绘制对象的。draw方法中应当调用所有子对象的draw方法，这样有层次地递归绘制所有对象。  
```java
public class GameScreen extends Canvas{
  List<GameObject> mObjects;

  void draw(GraphicsContext gc){
    for(GameObject obj: mObjects){
      obj.draw(gc);
    }
  }
}
```
所有GameObject最终将被加入一个继承于Canvas的类中。这套系统非常便于游戏对象的添加、删除、改变、绘制，同时其绘制遵循层次关系。
同时在实际操作中，笔者发现屏幕坐标是个较为困难的问题，于是对GameObject系统做了增添：  
```java
public abstract class GameObject{  
  Vec2d localPosition, worldPosition;
  
  public Vec2d localPositionToWorld(Vec2d lPos){...}
  
  public Vec2d worldPositionToLocal(Vec2d wPos){...}
}
```
在改变一个对象的坐标时，其子对象的坐标也会同时被修改，便于物体整体移动、变换坐标等操作。
## 场景切换
javafx程序中的场景分为Stage、Scene、Parent、Node等多个层级，而要切换场景则比较复杂。笔者设计了一个控制类专门负责主窗口场景切换：
```java
public class ScreenController{
  Scene mScene;
  
  Map<String, Pane> map;
  
  public void addScreen(String name, Pane pane){...}
  
  public void activate(String name){...}
}
```
切换场景时，不改变Scene，而是改变mScene的根节点root。第一次加载过的场景数据会保存在一个Map中，提高了重复加载的速度。该类使用了单例模式，使用getInstance()方法即可获得它的唯一实例。
## 游戏进程控制
对于游戏的创建房间、进入游戏、退出游戏等众多方法，笔者设计了一个控制类统筹管理这些操作：
```java
public class MainController{
  
  public enum GameState { Game_Menu, Game_Connet, Game_Start};
  public GameState mState;
  
  public void createRoom(String name, int port){...}
  
  public void enterRoom(String name, String ip, int port){...}
  
  public void startGame(){...}
  
}
```
该类同样使用单例模式，可用getInstance()方法获得其唯一实例。它的生命周期是程序运行的全过程。
