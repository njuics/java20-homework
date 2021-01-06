# 作业 3 提交说明 by 张福翔-171840514
### 设计思路
在本次提交中, 我们引入`package`的概念, 将项目中所有的类划分到了 creature, environment, utils 三个 package 中, 以便于进行项目管理与分别实现. 其中 creature 目录包含项目中的所有生物信息 (目前包括`HuluBaby`, `Grandpa`), 这些生物继承自`Creature`类; environment 目录包含项目中存在的环境组件 (目前仅包括`PlayGround`类), 这些环境组件继承自`EnvComponent`类; utils 目录包含了一些用到的辅助工具, 如我们本次作业用到的`ArraySorter`类. 此外还有一个包含`main`函数的独立的`Runner`类.

我们使用 PlantUML 生成的类图如下所示.

![UMLPicture](http://www.plantuml.com/plantuml/png/bLB1Rgim4Bpp5JwIzyGVH56Q52KzfMfwYwB8m0QimfgkxQY8vjzhGp6aoYKdnCxCpknwbqfpqgOgWxJaIh4r0TU6WBK1Or5hKItIAnEe6PfgG1tcIY8Bhi6lScjAi-99qod_WsLtfVUcxkXxJG9pXhpgVYD7kaYHiPm0T3WR6ss8OrPprdgAagHtb1QWDDay4aFNER5cXsFHsmfGNGkVOluTHSpd7NhUL0V362zhMTKI0VNzkQUCUxE_bhpPa3IOzVeXnU78ndmE67Ba_TUMJYS_fgFk9Ubdg6Guy-NKnOMjx_E2Eyg09WnLcFEvd50csEY_SOiMc4zt_KJ46-S9n5gVPXup-DA0cM8Euqa9ytYnOFunLiswa0JIZb4NJHWVZfnezaVgDiRfLlnfHFhXUZwWgO1oU52JcCJ-JqLkvl6P-aEOFkjuEVyiCZA7JRqPHBUauNZxQ5nWs5-sSycx6rm2PgOgVm00)

此外,我们也通过 IntelliJ 导出了一张类图, 其显示了更为详尽的信息.

<img src="assets/diagram.png" alt="diagram" style="zoom: 50%;" />

### 调用说明

作业中通过`Runner`类的主函数, 调用`PlayGround`中的`huluSortDemo`函数, 调用本次作业的执行流程.

1. 在`PlayGround`中创建包含7个葫芦娃的数组以及爷爷`Grandpa`对象，并将葫芦娃随机打乱，让葫芦娃进行报数。
2. 将葫芦娃在`ORCHESTRATION`模式下，通过爷爷为葫芦娃们进行排序，排序后让葫芦娃进行报数。
3. 打乱葫芦娃的顺序，并在`CHOREOGRAPHY`模式下重新排序，排序前后让葫芦娃进行报数。

### 实现情况

- 封装, 继承, 多态: 我们在 creature 和 environment 两个 package 下分别实现了 Creature 和 EnvComponent 类, 并让场景中使用到的各个类继承自这两个类, 将类的内部属性设为`private`, 以达到封装, 继承, 多态的目的.
- 接口: 实现了`Sortable`接口, 其中`HuluBaby`类实现了这个接口, 使得其可以自协同地进行排序.
- 构造器: 如`HuluBaby`类需要根据每个葫芦娃的位次和名字进行构造.
- 静态变量和静态块: 如`Creature`和`EnvComponent`类分别拥有一个静态的计数器属性, 为每个创建出的生物和环境组件赋予`ID`. 在本次实现中, 静态块由于可以直接写在静态属性的赋值中, 以减少代码量和提高代码可读性, 因此被省略.
- 包: 初步使用了 creature, environment 和 utils 三个包囊括不同的类的实现.
- 修饰符: 包括 static, private, public 等等, 上文已有介绍.

### 排序算法
在`ArraySorter`类中, 在`ORCHESTRATION`方法下提供了多种排序算法, 算法名作为`AbstractSorter`类的一种方法提供. 已经实现的算法包括：

- 快速排序算法`quickSort`
- 归并排序算法`mergeSort`
- 冒泡排序算法`bubbleSort`

如果想要替换排序算法，我们只需在主函数中对应的排序代码里进行修改，替换对应的方法名即可. 如果想要自定义新的排序算法，仅需在`AbstractSorter`类中添加新的方法即可.

对于`CHOREOGRAPHY`方法的排序, 要求排序的数组元素类型实现`Sortable`接口, `Sortable`接口需要实现`moveTo`功能, 即让每个数组元素判断, 在一个给定的数组中, 自己需要站在哪个位置, 并根据获取到的位置进行移动. 

### 附录

生成 PlantUML 中的类图的代码 (可见作业目录下的`diagram.uml`文件中: 

```
@startuml
class Creature {
  -{static} int numCreature
  -int id
}

class HuluBaby {
  +enum HuluType
  -String name
  --
  +void greet()
}

class Grandpa {
  +void sortOrchestration(Hulubaby[]huluBabies)
}

HuluBaby <|-- Creature
Grandpa <|-- Creature

class EnvComponent {
  -{static} int numEnvComponent
  -int id
}

class PlayGround {
  -HuluBaby[] huluBabies
  -Grandpa grandpa
  __
  +void huluSortDemo()
  +void createHuluBabiesInOrder()
  +void shuffleHuluBabies()
  +void huluBabiesGreeting()
}

class ArraySorter {
  __
  +<E extends Sortable<E>> void sortByChoreography(E[]arr)
  +<E extends Comparable<E>> void quickSort(E[]arr)
  +<E extends Comparable<E>> void mergeSort(E[]arr)
  +<E extends Comparable<E>> void bubbleSort(E[]arr)
}

PlayGround <|-- EnvComponent
HuluBaby *-- PlayGround

class Runner {
  --
  void main(String[]args)
}
@enduml
```

