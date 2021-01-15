## 类型改动

### BattleField

将该类变为参数类`BattleField<T extends Creature>`增加了可读性。表示该类实际上可以存储Creature及其各个子类。同时增加了`Battlefield`的可拓展性。

并且，将存储各个Creature的容器变更为`ArrayList <ArrayList<T>> `

以及`BattleField`类中对容器进行更改的各个函数也被做出了相应的修改

### Creature | HuLuWa | OldMan

将传入的`BattleField`参数改为`BattleField<Creature>`

### Main

将`BattleField`类声明为

```java
private static final BattleField<Creature> battleField = new BattleField<>(Creature.class); 
```

其余操作无需改变



