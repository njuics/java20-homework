# 更新
1. 添加`Creature`类，`Huluwa`类继承于该类，该类代表生物类，拥有基本的姓名性别等属性
2. `HuluBro`使用泛型进行改写，`public class HuluBro <T extends Creature>`,这样`HuluBro`里就限制了存放的类。容器改为`ArrayList<T> queBro`
3. 添加接口`HuluwaFactory`，拥有方法`create`，类`HFactory`实现`HuluwaFactory`接口的`create`方法，从而实现`new T()`方法，由于我在`HuluBro`的构造函数中进行了`ArrayList`的初始化，所以该方法是十分必要的
4. 更改了`HuluBro`的构造函数参数，多了一个参数`HuluwaFactory<T> factory`用来传递具体的类实例，从而能进行`Huluwa`类的实例创建
5. 更改了`main`函数中的`HuluBro`的实例化，`public static HuluBro<Huluwa> hulu = new HuluBro<>(20,new HFactory());`


