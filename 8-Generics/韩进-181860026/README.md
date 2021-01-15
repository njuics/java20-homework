## Generic

### 1.代码修改

#### 1.1

定义了一个名为`Creature`的基类，其中定义了`name`和`isMale`的属性，让`GourdBrother`类继承该类。

#### 1.2

将$GourdFamily$类改写为
```
CreatureFamily<T extends Creature> implements Iterable<T>
```
  
让存储的对象类型可以为任意继承了`Creature`类的对象

#### 1.3

将原先的反向比较器类改写为
```
NegativeComparator<T extends Creature> implements Comparator<T>
```
  
该比较器便可以比较任何继承了`Creature`类的对象

### 2.泛型的好处

#### 2.1

将运行时错误转为编译时错误，通过限制类型为`GourdBrother`，防止以后蛇精、蝎子精等混淆进队列。

#### 2.2

是代码跟据通用性，`CreatureFamily`类既可以存放葫芦娃，也可以存放任何继承`Creature`类的生物。
