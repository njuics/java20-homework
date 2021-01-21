# 葫芦娃排队：

## 封装：

![2](picture\2.png)

用Huluwa类将其名字、优先级、当前位置设置为私有类型进行了封装。

![3](picture\3.png)

使用以上三个函数作为类与外界的接口，使其能够提供自己的数据，但又不保证其不被修改。

## 继承：

![4](picture\4.png)

用huluwaSort作为Huluwa的子类，提供了排序、比较等方法，以此来执行让葫芦娃自己排序的操作。

![5](picture\5.png)

同时，grandFather作为Huluwa的另一个子类，提供了一种全新的排序方法，以此让爷爷来帮助葫芦娃排队。

## 多态：

![6](picture\6.png)

![7](picture\7.png)

![8](picture\8.png)

sortByHuluwa和sort函数中的申明传入的变量均为Huluwa类型，但实际操作中我们传入的是huluwaSort类型，可见多态使得代码结构更加简单、逻辑更加清晰。

### 构造器：

![9](picture\9.png)

Huluwa使用了重载的两个构造函数分别来显示地和默认地构造新成员。

![10](picture\10.png)

而由于因为处于安全考虑Huluwa的数据均为private无法在子类中修改，我们使用super来在HuluwaSort中对成员进行初始化。

### 修饰符：

default、private、public、protected等四种修饰词均有使用。



## 数据结构类图：

![11](picture\11.png)