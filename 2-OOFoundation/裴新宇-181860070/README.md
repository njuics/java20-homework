# 面向葫芦娃编程

学号：181860070

姓名：裴新宇



### Huluwa 类

- int color：从 0 到 7
- String name：从「老大」到「老七」
- answer()：报到，输出自己的名字
- int find_and_preempt(arr)：
  - 在 arr 中找到自己的目标位置，并与该位置原兄弟交换。
  - 返回值为自己原位置。
  - 如果目标位置与原位置相同，则返回 -1。



### GrandFather 类

- sort(arr)：对 arr 中的 7 个成员对象进行冒泡排序



### 方法 1 的过程：

- 创建七个 Huluwa 对象，随机分配位置，形成队列 arr
- 创建一个 GrandFather 对象 gf
- 调用 gf 的排序函数，该函数负责给 arr 中的七个 Huluwa 对象排序
- 输出排队结果



### 方法 2 的过程：

- 创建七个 Huluwa 对象，随机分配位置，形成队列 arr
- 对于下标为 current 的对象进行如下操作：
  - 调用该对象的 find_and_preempt() 函数
  - 若交换位置成功，则返回原 current
  - 否则，返回 -1 表示该对象已到达正确位置，后续则寻找下一个位置不正确的对象作为新的 current
- 上面的操作重复 7 次
- 输出排队结果