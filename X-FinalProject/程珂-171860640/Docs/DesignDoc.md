## 设计文档

- [概述](#Introduction)

- [网络通信功能设计](#Communication)
- [游戏处理流程设计](#Process)
- [不足之处](#Disadvantage)

### <span id="Introduction">概述</span>

本项目采用 “胖客户端，瘦服务器” 模式来进行设计，其中服务器的功能仅仅为**初始化游戏**和**消息排序**，由客户端进行消息处理

- 初始化游戏：服务器匹配两个玩家，为玩家分配角色（**HuluBro** / **Monster**），并且初始化化该局游戏中的随机种子(该种子用来生成游戏人物的随机化参数)
- 消息排序：
  - 在游戏中，每个客户端触发动作后不会在本地直接处理
  - 而是会生成一条对应的消息发送给服务器
  - 服务器排序后会将消息转发给对战的双方玩家
  - 服务器排序的依据为收到消息的先后顺序，排序的过程就是接收并转发
  - 客户端收到服务器排序后的消息才会在本地进行处理

### <span id="Communication">网络通信功能设计</span>

<img src=".\DocPics\image-20210103194212554.png" alt="image-20210103194212554" style="zoom:80%;" />

游戏的通信采用TCP协议，因此对于发送消息的双方需要维护一组socket，其中一个用来收(r_socket)，一个用来发(s_socket)，否则只能轮流发送和接收数据(发一条，收一条，再发一条...)，不能并行发送和接收数据

具体连接过程如上图所示

- 服务器端绑定特定的IP地址和端口接收客户端的连接
- 客户端1请求连接(图中1)
- 客户端1开启一个socket来用来接收服务器端的连接
- 客户端2请求连接(图中2)
- 客户端2开启一个socket来用来接收服务器端的连接
- 服务器向两个客户端分别请求连接(图中3和4)
- 服务器将接收客户端消息的两个 r_socket 和向客户端发送消息的两个 s_socket 打包成两个 Pair
- 服务器创建一个match线程并传入这两个Pair用来处理该局游戏
- 服务器继续接收其他玩家的连接

### <span id="Process">游戏处理流程设计</span>

以移动为例

<img src=".\DocPics\image-20210103200137579.png" alt="image-20210103200137579" style="zoom:50%;" />

用户点击 `上移/左行/右行/下移` 按钮后会触发 `GameHandler` 的 `handleMove` 方法，之后方法调用时序图如下

`handleMove()` 方法并未对 `GameStage` 做任何操作，仅仅在进行简单的检查后向服务器发送了一条`Type`字段为 `Move` 的消息。

<img src=".\DocPics\image-20210103201112213.png" alt="image-20210103201112213"  />

当客户端接收到由服务器排序后再转发的该条消息后才会调用 `GameHandler` 的 `processMoveMsg()` 方法进行处理，改变 `GmaeStage` 中控件的位置

<img src=".\DocPics\image-20210103201422810.png" alt="image-20210103201422810"  />

### <span id="Disadvantage">不足之处</span>

- 没有完全按照MVC的架构进行设计，与控制逻辑相关的数据直接放在了`GameHandler`(Controller)中，与游戏布局相关的数据直接放在了`GmaeStage`(View)里，没有对 Model 进行单独封装
- 部分`handle`方法(接收用户操作并发送消息) 和 对应的`process`方法(接收服务器消息并处理)的功能划分模糊
- 项目源代码可能会进行重构并发布在我的`gitee` 的仓库中 `https://gitee.com/ChengKer/nju-java-2020-fall`