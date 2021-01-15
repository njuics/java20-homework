# 依赖

## commons-lang3

主要使用其`RandomStringUtils`来为每个葫芦娃随机生成姓名，相关代码在`nju.edu.cn.HuLuWa`中的`getRandomName`中

## commons-collections

`commons`提供的关于容器的工具，主要使用其`CollectionUtils.select()`,来按条件筛选队列中的生物。相关代码在`nju.edu.cn.BattleField.getSpecieArray`中

## juint4

在上一份作业中已经使用过，这里只是将其移动到`maven`中进行自动换构建，并把相关代码放在了`test`文件夹中，从而可以执行`mvn test`指令进行测试

# 插件

## maven-surefire-plugin

为该插件指定了所依赖的`junit`，从而可以执行`mvn test`