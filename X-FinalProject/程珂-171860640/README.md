# Nju-Java-2020Fall

#### 项目结构简介

南京大学高级Java程序设计(22010300)期末项目

本项目主要由以下4个文件夹组成

- DemoVideo : 运行游戏的示例视频，时长 23 秒
- Docs : 其中包含 `Report.md`，`DesignDoc.md` 和 `UserManual.md` 三个文件
  - **Report** : 项目报告，其中介绍了项目代码量等基本信息，面向对象编程方法和设计模式在项目中的使用实例，以及课上所讲的异常处理、集合类型、泛型、注解、网络通信、输入输出、多线程等机制在项目中的使用实例
  - **DesignDoc** : 设计文档，其中介绍了项目主要类的设计思路和具体实现方法
  - **UserManual** : 用户手册，其中介绍了从源码构建项目的方法，以及游戏设定和玩法
- Game：项目源代码
- Jars : 项目打包生成的 **jar** 文件

#### 项目功能测试

打开 `Jars` 文件夹

仅测试读取历史 : 执行 `java -jar client1.jar`  命令并按照 `UserManual.md` 中的介绍操作即可

测试连接对战 : 
- 打开一个Shell , 执行 `java -jar server.jar `  
- 打开一个Shell , 执行 `java -jar client1.jar `  
- 打开一个Shell , 执行 `java -jar client2.jar `
- 按照 `UserManual.md` 中的介绍即可测试联机对战
- 如果想要同时进行多局游戏，还可以继续打开两个shell分别执行  `java -jar client3.jar `  和 `java -jar client4.jar `

