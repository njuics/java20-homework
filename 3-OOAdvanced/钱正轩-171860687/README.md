# HW3

171860687 钱正轩

## 类的设计

本次实验的类图如下：

![classdiagram](http://www.plantuml.com/plantuml/png/dLHTRvim57tdLrprYQv9Va4rDTcaTLBQQAgYF4phT0Ctu1OCkZRRCfJzzc4PQXCJQHeF4PnpxhaVkVQTqiYwAOkenkGLCuAhH2ueRHRofLdaJT5SjL44tODxfHaJ3Kc1Ii6o_togM1Et4VJF_4cpa1b8B2a0awgi2_ebzF6DkXaRnLxu38AmQnVN3WMTu4SbKb1TV6nCS5yG549fApxPyctLdwKY3cg-yU7Oo_7lnbyQaRm6lWxzJzjFZ3AjqH_l4A7w5qUD9mb6GEoozbxnf6m6WV5KmQlZXfESZ84MbOmdIhvlrisAAvqJAw_kLkak93d1GKWiG4WDzzlrThVy_hXzk2WpPZk4rMRx-34KZN91xdquhVLP2wLlhTbxC5ljUfisoqZxt-6_bpU7Gq41NhEGEfuUtOUyOgeonZe_UfBvXKHp6qfwcRvS6lGEs_DMDvmIGsL-pwd9ezcFkA233a0MMUxGFnQDlGmptpFe-YVMSU-KZneGKXCVCA6thVCEJKU24h_xsJhCt0B859jtd1aFs4-c30LzshFDVvxFHnV21OqzsqxYJifjHpfzo3yl5gEjCkm8W7UTWvsGuORZ3bK73ovZ8ipOzMRtuG65R2D_f_kRiUo8uLv5pjJNRzScQl0qNPZOoA_CeT4ToRGfYxy0)

设计了 `HuLuWa` 类抽象葫芦娃，葫芦娃有自己的长幼顺序（用 enum 实现），也有自己的名字，以及两个对 `HuLuWa` 的引用，分别表示左右两侧的葫芦娃。`HuLuWa` 实现了 `swap` 方法用于和某个葫芦娃交换位置。`HuLuWa` 同样实现了 `Comparable` 接口，比较依据是长幼顺序。

基于 `HuLuWa` 类设计了 `HuLuBrothers` 类，代表葫芦兄弟，由于葫芦兄弟是唯一的，故使用了单例模式。葫芦娃的实例存储在 `ArrayList` 中。实现了 `getHuLuBrothers` 静态方法用于获取葫芦兄弟实例，`shuffle` 用于打乱葫芦娃顺序，`print` 让葫芦娃按顺序报出自己的名字。`HuLuBrothers` 还有个 `sortByChoreography` 方法，用于使葫芦娃互相之间协同排序，具体方法和正确性证明见作业 2 的 [README](../../../2-OOFoundation/钱正轩-171860687/README.md)。

定义了 `Sortable` 接口，其中的方法有 `size` 获取排序元素总数，`compare` 比较两个位置的元素，`swap` 交换两个元素的位置。`HuLuBrothers` 实现了这个接口，接口方法委托给 `HuLuWa` 的实例实现。

设计了抽象类 `AbstractSorter` 抽象排序算法，其中有两个字段 `name`，`complexity` 分别表示算法的名称和时间复杂度。`InsertSorter` 和 `QuickSorter` 继承了这个抽象类，重写了其中的 `sort` 方法，分别使用了插入排序和快速排序。`sort` 方法排序一个实现了 `Sortable` 接口的对象。

设计了 `Grandpa` 类，用于指挥葫芦兄弟排序，其两个成员变量分别为 `Sortable` 和 `AbstractSorter`，即不止可以给葫芦兄弟排序，也可以给其他能排序的小朋友们排序。

上述类都在包 `cn.edu.nju.hulu` 内，除此之外还有个驱动类 `Main` 用于展示排序效果。

## 抽象思维

### 封装，继承，多态

只要设计了类并进行了访问控制，就体现了封装。

继承体现在继承了 `AbstractSorter` 的两个类，使用继承是因为 sorter 除了方法还有自己的属性，即算法名和时间复杂度，这是接口无法体现的。

多态体现在 `Grandpa` 类的设计，其两个成员分别是一个实现了 `Sortable` 接口的对象和一个继承了 `AbstractSorter` 抽象类的对象，这使得排序对象和排序方法可以灵活决定，具体调用哪个方法是在运行时通过动态绑定实现的。

### 语言机制

本次将所有葫芦娃和排序相关的部分放在一个包内，而将驱动类 `Main` 放置在包外，这样有效控制了访问权限，如可以在 `Main` 中继承 `AbstractSorter` 类并实现自己的排序算法（因为这是个 `public` 类），但是因为 `HuLuWa` 类的构造器声明为包访问权限，所以不能再创建一个葫芦娃实例（这很符合常识，所有葫芦娃已经在葫芦兄弟里了），这也是使用单例模式确保只有一个葫芦兄弟实例的原因（实现方法为将 `HuLuBrothers` 的构造器声明为 `private`），在其中有一个静态变量存储了指向唯一葫芦兄弟实例的引用，在使用 get 方法时如果引用为空则直接调用构造器创建新对象，否则返回引用。

将 `Sortable` 定义为接口是因为在语义上可排序的性质表现为支持某些**行为**，如基于比较的排序需要元素按下标访问，能够两两比较并交换位置，而将 `AbstractSorter` 定义为抽象类是因为排序器是一个**实体**，能够对可排序的对象排序，也有属性保存使用的排序算法和算法的时间复杂度。排序本身没有通用的实现，所以基类的 `sort` 是抽象方法，`AbstractSorter` 是抽象类。