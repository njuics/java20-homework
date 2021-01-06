# 8-Generics

181860051	李舟俊潇



在葫芦娃类`Brother`的构造函数中实现了姓名和性别的随机生成。葫芦娃默认有20人，姓名默认为10位。

在运用泛型进行改进的过程中，我定义了七个继承自`Brother`的七个子类，分别是`GiantBoy`、`DetectiveBoy`、`DiamondBoy`、`FireBoy`、`WaterBoy`、`CloakingBoy`和`BarathrumBoy`，代表了七种不同的葫芦娃。在初始化各对象时，根据其编号分配其输入哪个类型的葫芦娃。

在父类`Brother`中，我定义了一个纯虚函数`useMagic()`，表示每种葫芦娃使用其拥有的超能力，在各子类中进行实例化。

增加了`<T extends Brother> void useOwnMagic(T bro)`方法，在点名时，每个葫芦娃报数后将该葫芦娃对象作为参数调用该方法，在该方法中调用该葫芦娃的`useMagic()`函数打印其拥有的超能力。

