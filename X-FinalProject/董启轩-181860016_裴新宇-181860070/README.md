# CvM 葫芦娃大战妖精

![sample](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/sample.gif)

## 使用说明

项目使用的是自带 javafx 的 javaSE 8。

### 1、联机对战

- 首先启动服务器，启动命令：`java -jar homework/ServerMain.jar`
- 然后启动客户端，启动命令：`java -jar homework/Main.jar`，需要启动两个，分别代表双方。

![image-20201231174710123](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/img1.png)

- 点击开始游戏，输入服务器 IP 地址进行连接，默认 127.0.0.1 代表本地。

![image-20201231174806874](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/img2.png)

- 双方都连接成功后，游戏开始。

![image-20201231174949924](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/img3.png)



游戏说明：

- 游戏为回合制，在某一方的回合内，可以移动任意角色，并发动攻击或技能，直到行动力与技能值不足以继续游戏时，点击按钮结束回合。
- 鼠标点击我方角色，则视为选中。
- WSAD 分别为上下左右移动。
- 按键1代表普通攻击，按键2代表技能，每回合每个角色仅能发动一次攻击或技能。

- 鼠标点击双方阵营任意角色，左侧会显示该角色相关信息。
- 左下方会实时显示双方对战的细节
- 结束游戏时保存对战log到本地

### 2、回放游戏

- 只需要启动一个客户端即可，`java -jar homework/Main.jar`

- 在主页面上按下 L 键
- 在文件选择器中选取本地某一 log 文件，提供的样例文件为 `homework/sample.log`
- 之后会自动播放

![image-20201231175600964](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/img4.png)

![image-20201231175657090](https://raw.githubusercontent.com/dqx-nju/CvM/main/homework/img5.png)

## 模块介绍

- app 应用模块：整个应用的控制
- view 页面模块：游戏页面
- net 网络模块：服务器与客户端通信
- world 世界模块：游戏数据实体
- input 输入模块：键盘、鼠标等输入
- output 输出模块：战斗数据保存

### 1、应用模块 app

#### Game 类

继承了 javafx 的 Application 类，封装了一些应用生命周期方法： 

- onLaunch() 
- onFinish() 
- onExit()

#### App 类

- 管理窗口、场景和根面板：

- 管理和切换页面：
  - viewMap currentView
  - getView(String)
  - regView(String, View)
  - unregView(String)
  - getCurrentView()
  - gotoView(String)

- 管理引擎的启动和停止：engine

- 提供生命周期对象供框架内部实现

- 提供生命周期方法供框架内部调用

#### View 类

持有面板：pane

页面生命周期方法：

- onLaunch() onFinish()
- onEnter() onLeave()
- onStart() onUpdate() onStop()

#### Engine 类

- 控制游戏主循环

- 设置时间
- 设置 fps



### 2、页面模块 view

-  class HomeView：游戏客户端启动后的主页
  - 连接服务器
  - 开始游戏
  - 结束游戏
  - 按 L 后读取文件回放 
- class PlayView：联机对战的游戏界面
  - 控制角色图片的移动
  - 控制角色血量变化
  - 显示部分对战信息
  - 显示角色技能参数
- class FilePlayView：在 PlayView 的基础上删去交互功能，仅用于回放
- class ServerView：负责服务器端的连接、发送、接收和处理



### 3、世界模块 world

#### Character包(角色设计)

##### Creature 类

实现了对于葫芦娃和妖精共有的特征。

具体包含的内容如下：

- 特征信息：
  - Attack ：攻击力(普通攻击，固定值)
  - Armor ： 护甲值(固定值)
  - CriticalStrike ： 暴击率(以1～100内的整数记录)
  - Missrate ： 闪避率(以1～100内的整数记录)
  - HP ： 当前血量
  - MAXHP ： 血量上限(固定值)
  - attackBuffs ： 当前实体所拥有的攻击力buff/debuff列表
  - armorBuffs ： 当前实体所拥有的护甲值buff/debuff列表

- 对外函数接口：
  - Creature(int Attack,int Armor,int CriticalStrike,int Missrate,int HP)：初始化时必须指定creature的各项数值并初始化列表，此时this.HP=this.MAXHP=HP
  - getxxx()：不同的get函数用于获取creature的不同信息
  - newAttackBuff(int Attackchange, int Attackbufftime)：向攻击buff列表中新添buff项
  - newArmorBuff(int Armorchange,int Armorbufftime)：向护甲buff列表中新添buff项
  - setHP(int HP)：HP变更，若参数HP<0，设置this.HP=0
  - newturn()：每一次到达新的回合，调用非public函数Countdown()将两个buff列表中的各项buff的bufftime减一，然后从中删除已经失效的buff/debuff
  - setAttack(int Attack)：设置攻击力，用于在使用技能时，生成原对象的临时副本，改变attack为技能的攻击力用于计算damage

##### Calabashbrother 类 & Monster 类

虽然葫芦娃类和妖精类具有相似的结构且均为Creature类的子类，出于区分度以及技能的配置需求实现成两个类

具体组成如下：

- 共有的特征信息：
  - posx和posy：存储在5x9(5行9列)的场景内，葫芦娃/怪物的行号(posx:0~4)和列号(posy:0~8)
  - No_x：葫芦娃/怪物在队内的编号
  - skillname：技能名称，暂定为各个人物的名字
  - skilldescription：技能描述
  - field：二维数组，用于存储技能的攻击范围，均是相对于自身位置(x,y)的常数对
  - skillnumber：技能攻击力
  - skillbufftime：技能可能附带buff，存储buff的持续回合数
  - skillcost：技能需要花费一定的团队技能值
  
- 新增对外函数接口:
  - CalabashBrother/Monster (int attack,int armor,int criticalstrike,int missrate,int HP,int number)：葫芦娃/怪物的构造函数，number用于决定其在队伍里的编号，以此决定相应的技能配置
  - getxxx()：获取新增的各项葫芦娃/怪物的数值和技能描述性信息

#### Buff包(规范的buff项)

##### ArmorBuff 类 & AttackBuff 类

包含一个buff/debuff的组成信息

- 特征信息：
  - ArmorChange 和 AttackChange ：buff的具体数值，这个数值小于0即相当于debuff
  - Armorbufftime 和 Attackbufftime ：buff持续的回合数
  
- 函数接口：
  - xxxBuff()/xxxBuff(int xxxChange,int xxxbufftime)：构造函数
  - getxxx()：获取数值
  - xxxbuffoverdue()：判断当前buff是否失效，失效则返回true
  - countdown()：新的回合，bufftime减1
  
#### Algorithm包(具体的攻击算法)

##### Assault 类

该类只是单纯的函数类，提供具体的一次攻击的计算流程，只有唯一的对外接口：

- public <T extends Creature> int DamageCaculate(T attacker,T defenser)

该接口提供具体的计算方式，同时对于是否暴击和是否闪避将由内置的另外两个函数计算完成：

<T extends Creature> boolean ifcritical(T attacker)和<T extends Creature> boolean ifmiss(T defenser)

具体的计算过程如下：

Attack=attacker.getAttack()+Attackbuffnumber
Armor=defenser.getArmor()+Armorbuffnumber

其中buffnumber将由存放的buff列表做加法计算得到。

实际伤害finaldamage=(int)(Attack/(1+(Armor/100)))；

若暴击，finaldamage将乘以1.5并取整，若miss，函数将返回-1表示miss，以和finaldamage=0区别

没有miss则正常返回finaldamage。

#### Team包(双方队伍的实现)

实现葫芦娃队伍和怪物队伍的相关信息和对战用接口，由于队伍具备对称性，仅以葫芦娃队伍为例。

- 特征信息：
  - MaxTeamSkillNumber=10：静态常量，每回合团队技能值初始化上限，允许使用技能使技能值溢出，但每一回合开始前将恢复
  - teamSkillNumber：实际团队技能值
  - MaxTeamAcitonNumber=15：静态常量，每回合团队行动力初始化上限，允许使用技能使行动力溢出，但每一回合开始前将恢复
  - teamActionnumber：实际团队行动力，移动一格以及发动攻击都需要1点行动力
  - ifaction：判断小队成员是否在本回合发动过攻击，1表示未攻击，0表示已攻击，-1及其他可能的异常值表示角色死亡。
  - list：存储小队成员1～7对象的列表，为静态列表
  - a：assault算法模块
  
- 对外接口：
  - CalabashbrotherTeam()：初始化各项数值及7名小队成员对象，为各个人物分配初始的posx和posy
  - isGameOver()：静态函数，用于判断是否队伍成员已经全部死亡，游戏结束
  - getxxx()：获取团队相关信息，对于获取某个特定成员的实例或者位置信息将会需要一些参数
  - TeamNewTurn()：新的回合，重置技能值和行动力，更新各个成员的buff状态和ifaction表单
  - calabashbrotherDead(int No_x)：团队成员No_x死亡，从列表中删除，ifaction中对应位置-1
  - getattack(int No_x,int damage,CalabashBrother c)：静态函数，葫芦娃No_x受到damage，并同步更新c
  - moveup/down/left/right(int No_x)：移动，需要消耗1点行动力以及前往的格子内不存在葫芦娃或者怪物对象
  - haveCreature(int x,int y)：静态函数，判断格子(x,y)内是否有葫芦娃
  - getAttackBuff(int No_x,int attackchange,int attackbufftime)和getArmorBuff(int No_x,int armorchange,int armorbufftime)：静态函数，小队成员No_x获得了某项buff，新增到其buff列表
  - DoAttack(int No_x,boolean is_skill)：小队成员发动攻击，is_skill为true表示为技能攻击，主要在使用assault内部函数时和creature的setattack关联使用，以二维数字表的形式返回攻击前后的变化
  

对应的MonsterTeam也有类似的函数和成员变量，在此不多做赘述。


### 4、网络模块 net

#### Msg 接口

应用层信息接口

- send(DatagramSocket ds, String IP, int UDP_PORT)：发送信息
- parse(DataInputStream dis)：解析信息并处理

#### 服务器向客户端发送的信息

- class START_MSG：每一局的开始向双方发送开局信息

- class S_MOVE_MSG：向双方发送请求移动的结果

- class BLOOD_MSG：向双方发送攻击后血量变化信息
- class INFORM_MSG：用于同步服务器与客户端的对战数据
- class DEAD_MSG：向双方发送游戏结束信息

#### 客户端向服务器发送的信息

- class FINISH_MSG：客户端结束该局后向服务器发送结束信息
- class MOVE_MSG：角色请求移动
- class ATTACK_MSG：角色请求发起攻击

- class NetClient：客户端类，负责连接、发送、接收和处理



### 5、输入模块 input

#### Key 枚举类

包含常用键盘按键的键值

- 数字 0-9
- 字母 A-Z
- 功能键 F1-F12
- 常用按键：上下左右SPACE\ENTER\ESC

#### KeyInput 类

封装了按键按下、保持、释放的监听函数

- boolean isPressed(Key)
- boolean isReleased(Key)
- boolean isHeld(Key)



### 6、输出模块 output

#### PlayFile 类

- List\<String\> list：存储对战信息，实时更新
- addStatement(String)：添加信息到 list
- save_file(String)：保存所有信息到本地文件

## 分工

- 董启轩：world 模块
- 裴新宇：app/view/net/input/output 模块