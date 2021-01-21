# 泛型

## 类
Creature: 基本的生物类，各种生物都由其衍生而来，实现了comparable接口。

CalabashBoy: 葫芦娃类，继承自Creature。

Monster: 怪物类继承自Creature。

QLine: 只由葫芦娃或者怪物排成的队伍，最大数量为15，实现了iterable接口.

Main: main函数入口。

## 设计泛型
    public class QLine< T extends Creature>
QLine设计成这种泛型形式，故既可以表示仅由葫芦娃组成的队伍，也可以表示仅由怪物组成的队伍，使得排序队伍中仅存在一种生物。

