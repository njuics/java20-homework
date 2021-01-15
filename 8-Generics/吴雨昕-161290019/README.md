## 泛型使用

### 使用Creature基类
- 新建 Creature基类用于表示一般生物，以Creature为基础派生出CalabashBoy和Monster两种细分生物
- 葫芦娃和妖怪分别有不同的属性


### 使用CreatureList进行集合管理
CreatureList\<T extends Creature\> 使用了泛型进行生物集合管理，任何由Creature派生来的生物子类均可被装入该集合
- 在上次作业的基础上，CreatureList实现了Comparable用于各种类型的排序（名称，性别等）

### 工厂模式
为了向CreatureList中正确添加元素，使用了工厂模式进行对象实例的创建
- 定义了CreatureFactory接口
- 定义了CalabshFactory和 MonsterFacotry 分别实现Factory接口
- 在添加元素时使用各自的 Factory.create() 进行创建

### 使用泛型的优势
- 使得生物这一集合类型可以统一管理不同类型的生物，提供一致性的排序算法，同时保证良好的扩展性
- 同时使用工厂模式可以标准化创建不同类型的生物，而无需改变底层设计
