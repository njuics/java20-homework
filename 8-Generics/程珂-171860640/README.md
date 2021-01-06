#### 泛型

**171860640 程珂**

###### 1. 比较器

新写了`CreatureComparator` 抽象类，Creature的子类如果实现比较器，需要继承该类

```java
abstract class CreatureComparator<T extends Creature> implements Comparator<T> {
     abstract public int compare(T creature1,T creature2);
}
```

葫芦娃的比较器实现：

```java
class BroComparator extends CreatureComparator<HuluBro>{
    @Override
    public int compare(HuluBro bro1,HuluBro bro2){
        return bro1.getName().compareTo(bro2.getName());
    }
}
```

###### 2. 战场

战场中使用了泛型

战场实现了对战场内的生物排序的接口

```java
public class BattleField implements Iterable<Creature>{
    ....
}
```

战场内用 `TreeSet` 创建了一个只存放葫芦兄弟的队列

```java
private TreeSet<HuluBro> creatures=new TreeSet<>( new BroComparator());
```



