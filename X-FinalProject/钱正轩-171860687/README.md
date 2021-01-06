# 葫芦娃大战妖精

## 游戏介绍

本次设计的游戏借鉴了火焰纹章，文明等系列的回合制策略游戏的思路，采用双方交替操作角色进行战斗的设定，游戏的主界面如下

![image-20201214225608685.png](https://i.loli.net/2020/12/15/C2slIrTDM9RL4vJ.png)

交战双方开启客户端后需要一方作为服务器启动，同时双方均以客户端启动，从而建立起连接，并初始化游戏（默认葫芦娃先手，服务器随机分配交战双方的阵营）

![connect.gif](https://i.loli.net/2020/12/15/iJCULvNG52QTzpH.gif)

双方交替进行回合，每一回合可以移动一名角色，然后释放一次技能，或者只释放技能，或者直接跳过交给对手操作。在选定角色并进行移动和施法等操作时会显示出范围以指示。

![move.gif](https://i.loli.net/2020/12/15/r1t9N5js7zyhIZv.gif)

将鼠标指针置于按钮或人物上即可查看详细信息

![image-20201214230319534.png](https://i.loli.net/2020/12/15/ESfjDtXAiJZlI9z.png)

在操作时如果是合法的操作则会反映在战场上，否则上方的日志界面也会显示出错误信息

![image-20201214230458574.png](https://i.loli.net/2020/12/15/lUDrx3zmWG4fSQE.png)

也可以选择加载战斗过的日志文件从而进行重放

![log.gif](https://i.loli.net/2020/12/15/A9Xupz5hkGixHF3.gif)

![log2.gif](https://i.loli.net/2020/12/15/SK5DIdmN9Z3hHlv.gif)

记录了一局完整的对战，日志文件位于 `src/main/resources/test.json`

## 模块介绍

本次实验大致分为三个模块

* game 模块，主要负责游戏的核心机制，与网络和图形界面无关
* server 模块，主要负责服务器
* client 模块，主要负责客户端以及 GUI 部分

### Game 模块

Game 模块又分为两个子模块，data 模块和 model 模块，前者负责数据，后者负责逻辑

#### data

本次实验中使用的中间数据形式为 JSON，考虑到同时兼顾程序易读以及人类易读，并没有采用字节流和序列化反序列化技术。

data 模块主要用于游戏需要使用的静态数据，由于数据并不是很多于是没有选择使用数据库 + JDBC 的解决方案，而是将数据写在 JSON 文件中直接读入内存。data 模块声明了表示数据的 `Data` 接口，`Data` 支持获取 id 作为数据的唯一标识，同时声明了 `DataSupplier` 接口，支持根据 id 获取一个 Optional 的数据，在此使用 Optional 主要是为了避免判空带来的可能的错误

主要的数据包括角色的数据和技能的数据，分别实现了两个抽象类：`AbstractCharacterData`，`AbstractSkillData`，包括了最基本的数据字段和 get 方法，而 `DataSupplier` 也实现了一个根据 JSON 文件实例化对象的具体类 `JsonDataSupplier`，在初始化该类的时候传入一个继承了数据抽象类的具体类的类型对象即可利用 GSON 这个第三方库和 Java 的反射机制实现对对象的初始化，核心代码段如下

```java
public class JsonDataSupplier<T extends Data> implements DataSupplier<T> {
    private final Class<? extends T> typeClass;
    ...

    public JsonDataSupplier(Class<? extends T> typeClass, String string) {
        this.typeClass = typeClass;
        ...
    }

    private void setDataSource(String string) {
        Type type = TypeToken.getParameterized(ArrayList.class, typeClass).getType();
        map = new HashMap<>();
        List<T> list = gson.fromJson(string, type);
        list.forEach(t -> map.put(t.getId(), t));
    }

    ...
}
```

这里的类型参数即是上文提到的抽象数据类，而构造时传入的参数是一个继承了该抽象类的具体类（不能传入抽象类因为抽象类不能实例化对象），这样便可以从 JSON 文件直接初始化对象

具体类可以重写 get 方法以实现静态层面的扩展（如重载角色的 `getHp` 使得每个角色都变成双倍血量），同时也可以使用装饰器模式，实现运行时动态的扩展，但因为有抽象类本身的限制，并不能扩展出新的属性，只能改变返回现有属性的行为

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

#### model

model 模块主要负责游戏的逻辑部分，这里同样定义了一个代表角色的抽象类 `AbstractCharacter`，便于扩展（通过新的具体类/装饰器扩展的思路和上文相同）。不同之处在于这里的角色信息是动态的（当前生命值，当前位置……）而非静态的（最大生命值，移动力……），这些信息随着游戏对象的创建动态生成动态消亡，并不写入文件。

在本模块中大量使用了委托模式，如角色可以有两种行为（移动至某地，生命值增加或减少），一般思路是执行完行为后调用 get 方法获取信息再更新状态，但使用委托后只需要为每个行为设置一个委托对象，角色的信息改变后调用委托方法更新即可，这样可以保证在不同处调用移动和改变生命时都能正确更新游戏的状态而不需要每次都主动检查状态。

除此之外实现了一个 final 类 `CombatLog` 用于进行游戏交互（不考虑可扩展，而是要各种情况下日志的行为都一致，获取到的数据是一样的），即玩家发出命令是以 `CombatLog` 的形式，而game 给出回应也是以 `CombatLog` 的形式，具体的类型和语义参见 javadoc，在此不再赘述。log 均有一个代表类型的字符串成员和一个代表附带信息的字符串成员，以及附带额外信息的 map 对象，天然适合 JSON 的数据类型，可以方便地与 JSON 字符串互相转换。为了防止在 log 中放入预料外的数据，log 只能通过静态工厂生成。

`Game` 类是主要的游戏逻辑，实现了 `LogConsumer` 接口，该接口定义的方法接受 log 对象，之所以使用这个接口是为了网络通信时能用同样的逻辑处理需要接受 `CombatLog` 对象的 `Game` 对象和 GUI 的控制器，除此之外还可以设置一个 `GameDelegate` 对象，其中定义了接受 `CombatLog` 对象的方法，game 会将执行的结果通过委托对象发送出去，这样也是为了避免调用-返回值形式的逻辑，将控制权交给 `Game` 对象，日志的接受者只需要实现处理返回日志的功能即可

游戏的逻辑是接受玩家发来的日志（操作也以日志的形式体现），然后会进行一系列合法性判断，其中一些关键代码段如下

```java
// 检查角色是否存在
AbstractCharacter srcCharacter = Optional.ofNullable(characters.get(src))
.orElseThrow(() -> new GameException("角色不存在"));
// 检查角色数据是否存在
AbstractCharacterData srcData = charactersData.get(srcCharacter.getDataId())
.orElseThrow(() -> new GameException("角色数据不存在"));
```

由于 Optional 类无法实现类似 swift 中 guard 语句一样的空即返回的功能，于是选择使用抛出自定义异常的方式中断控制流并返回，统一采用异常来表示非法操作，然后在外层捕获并使用错误信息产生错误日志

```java
try {
	tryAct(log);
} catch (GameException e) {
	delegate.ifPresent(d -> d.sendLog(CombatLog.error(e.getMessage())));
}
```

而如果操作合法，便更新游戏状态，然后发送合法的操作，接受到日志的客户端对象可以根据内容渲染画面，因此逻辑和状态只有 `Game` 对象保有，客户端只负责将用户的操作生成日志，以及根据日志渲染画面，不处理日志的语义部分

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

### Server 模块

server 模块主要负责服务器端，本次多人对战采用传统的 c-s 架构，轻客户端重服务端，便于状态同步，其中最核心的类是 `GameServer`，其中封装了一个 `AsynchronousServerSocketChannel`，初始化后调用 `accept` 方法即可为监听事件注册 handler，在实例化 handler 的时候会传入一个线程池，用于游戏对战，在 `GameServer` 中传入是为了在关闭 socket 的同时将线程池也关闭。核心代码段如下

```java
@Override
public void close() throws Exception {
    battleServicePool.shutdown();
    battleServicePool.awaitTermination(2, TimeUnit.SECONDS);
    serverSocket.close();
}
```

处理 accept 的 handler 的工作就是存储传入的连接，当连接数达到两个时便在线程池中提交一个新的任务，令这两名玩家对战，然后开始重新计数，这样一个服务器可以维护多组对战的玩家。`BattleTask` 是一个 Runnable 对象，初始化时接受两个 socket，然后初始化一个 `Game` 对象并将其自身设置为 game 的委托，然后为两个异步 socket 注册读事件的 handler，服务器的异步 IO 采用了异步非阻塞读，异步阻塞写的方式，当读事件来时触发 handler，将字符串解析为 log 对象交给 game 处理，而写是在委托方法的实现中将 game 传入的 log 转为 JSON 字符串，然后调用异步写方法，并直接在其返回的 `Future<Integer>` 对象上调用 get 方法，以实现阻塞写，核心代码段如下

```java
Arrays.asList(str.split(WriteHelper.DELIM)).forEach(s -> {
    if (s.length() > 0) {
        CombatLog log = gson.fromJson(s, CombatLog.class);
        consumer.ifPresent(c -> c.consume(log));
    }
});
socket.read(buffer, null, this);
```

读事件的 handler 实际上保有一个 `LogConsumer` 对象，将读到的 log 传给该对象

运行游戏的线程在注册完读事件后由于是异步 IO，为了保证能继续进行会在 run 方法中运行一个循环，循环条件除了游戏结束以外还会检查当前线程是否被中断，这样在关闭对战线程池之前能进行正常的清理工作（调用线程池的 shutdown 会对每个线程调用 `interrupt`，检查到被中断后线程会尝试关闭 socket，然后退出运行）

除此之外还有一个辅助类，在写多条日志的时候在其中插入分隔符，由于 socket 是流读写，分隔符可以用于分割出合法的 JSON 字符串用于解析

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

### Client 模块

client 主要负责客户端，在这里由于是 GUI 编程，故采用了传统的 MVC 架构，分为 model/controller/view 三个模块

#### model

model 负责网络通信，核心的类型是 `GameClient`，其中封装了一个 `AsynchronousSocketChannel` 对象，在调用 `connect` 方法后会为连接事件注册 handler，如果连接成功，会为新传入的 socket 的读事件注册 handler，这里复用了 server 模块的 `ReadHandler`，不同之处在于客户端的 `ReadHandler` 保有的 `LogConsumer` 是 controller 模块的 `ViewController`，在接受到服务器发来的数据后将其转换为 `CombatLog` 对象并用于渲染画面

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

#### controller

controller 负责将 UI 和网络模型连接在一起，`MainViewController` 类实现了 `LogConsumer` 接口，并将自身注册到 client socket 的 `ReadHandler` 上，本次实验 UI 的框架是 JavaFX，界面使用 FXML 文件定义，而在 FXML 文件中可以为组件设置 `fx:id`，在 controller 中声明同名的组件对象然后加上 `@FXML` annotation 即可在加载 FXML 的同时初始化这些成员，controller 便可以通过引用的组件对象修改 UI 界面，而 UI 的事件反映到 controller 也是通过类似的机制，在 FXML 文件中可以为组件注册 handler，在 controller 中实现同名的方法然后加上 `@FXML` annotation 即可在加载时将事件和 handler 绑定在一起，点击按钮便会调用对应的处理函数，不需要显示声明按钮对象再手动注册 handler

使用 MVC 的好处就是 UI 与模型完全解耦，故更新 UI 时不需要了解 model 的逻辑，因此除了通过网络通信，也可以读取一个本地的 JSON 文件，并将其中的日志内容读取到内存，然后以固定的间隔调用 `consume` 方法即可实现战斗回放（调用 `consume` 方法就根据参数渲染画面，而其本身不关心数据的来源，故战斗的状态同步和战斗回放可以用同一套逻辑处理），核心代码段如下

```java
String str = CharStreams
    .toString(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
List<CombatLog> list = gson.fromJson(str, new TypeToken<List<CombatLog>>() {
    private static final long serialVersionUID = 1L;
}.getType());
reset();
Iterator<CombatLog> it = list.iterator();
Timeline line = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> consume(it.next())));
line.setCycleCount(list.size());
line.play();
```

由于 JavaFX 不能简单地使用 `sleep` 方法实现延迟，故新建一个 `Timeline` 对象来实现序列的操作

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

#### view

view 模块只有一个类 `CharacterGrid`，是一个自定义的组件，用于代表游戏角色，其本质是一个 `VBox` 容器，其中上方是一个 `Button` 用于处理点击事件，下面是一个 `ProgressBar`，设置颜色为绿色后用于表示生命条，实现了两个方法 `attachTo/RemoveFrom` 用于将自身添加或移除自某个父容器，由于其设置位置的方法是设置其本身到父容器的左边上边的距离，故限定父容器为 `AnchorPane`

其余 UI 的创建和管理工作都在 FXML 文件中完成，可以用 JavaFX scene builder 打开 resources 中的文件查看。除了地图大小为了适配素材使用了固定的尺寸，上边的日志栏和右边的操作栏都实现了自适应

其余细节信息可以参见 `mvn site` 生成的 javadoc 文档

## 测试

单元测试采用了 junit 框架，由于大量使用了注册委托对象-等待回调函数被调用的模式，故同时采用了 mockito 框架。mockito 框架可以方便地对指定类型的对象进行模拟，还可以验证对指定方法的调用，如其中一段测试代码

```java
@Mock
private GameDelegate delegate;

@Captor
private ArgumentCaptor<CombatLog> captor;

@Before
public void setup() throws URISyntaxException, IOException {
    closeable = MockitoAnnotations.openMocks(this);
    game = new Game();
    game.setDelegate(delegate);
    game.setUp();
}

@Test
public void testSetUp() {
    verify(delegate, times(4)).sendLog(captor.capture());

    assertEquals("SET", captor.getValue().type);

    verify(delegate).sendLog(captor.capture(), any(CombatLog.class));
    assertEquals(CombatLog.info("A"), captor.getValue());
}
```

这里的 game 是 `Game` 类型的实例，而 delegate 是 mock 出的对象，使用 `verify` 可以验证delegate 的方法被调用了多少次，而使用 `Captor` 可以捕获传入的参数，再验证参数是否与预期的一致

同时还使用了 jacoco 对测试的覆盖率进行了统计，运行 `mvn verify` 便可以在 target 目录下生成覆盖率报告

![image-20201215110141288.png](https://i.loli.net/2020/12/15/mxQAPuljpqIC8tF.png)

可以看出除了 client 的 controller 模块与 view 模块，其余模块都达到了较高的指令覆盖率和分支覆盖率，而这两个模块没有进行单元测试的原因是因为涉及了 GUI 与多用户，故手动进行测试。

## 打包

由于本次实验引入了第三方库，故为了生成可执行的 jar 文件，添加了 `maven-assembly-plugin`，会在 `package` 阶段生成带有全部依赖的 `jar-with-dependencies` jar 包，由于配置了 mainClass，可以直接使用 `java -jar` 运行

## 心得体会

本次实验规模较大，在完成后总结自己踩过的坑，大致有如下几条心得体会

* 架构的设计十分重要，要最先设计各个功能以及模块的划分，然后减少模块间的耦合度，使其在完成工作的前提下了解最少的信息，如负责游戏逻辑的 `Game` 类，传入信息的方法只有初始化的 `setup` 方法和之后的 `consume` 方法，同时 `Game` 并不暴露信息，而是采用设置委托然后调用委托对象的方式来进行通知
* 慎用继承，在没有大量同类型行为不同的对象的情况下不要使用继承，混乱的继承结构只会带来不必要的复杂性。代码复用优先考虑组合或聚合，然后设计良好的接口
* 测试驱动，编写功能模块的同时就编写单元测试，这样可以在改动代码后及时发现隐含的错误，同时检查代码覆盖率报告，观察是否覆盖了各种执行路径
* 使用语言新特性，如使用 java 8 引入的 lambda 表达式代替匿名内部类，使用 `Optional` 类用于处理空值，使用流式编程等

