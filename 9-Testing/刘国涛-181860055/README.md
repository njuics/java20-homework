# 测试

## 说明

> 基于`8-Generics`进行测试
>
> 在[test](./test)下有两个测试文件`CalabashTest`和`GroupTest`分别对葫芦娃类和葫芦娃组类进行测试

### CalabashTest

用于测试`Calabash`类及其子类的创建过程和属性、方法

测试单元有：

- `testFactoryCreate`：测试工厂类的创建方法及Calabash子类的属性
- `testCalabashProperty`：测试Calabash构造函数和属性
- `testEqualsMethod`：测试Calabash的`equals`方法

### GroupTest

用于测试`CalabashGroup`的方法

测试单元有：

- `testGroupInsert`：测试`insert`方法
- `testGroupSortByRAN`：测试乱序sort
- `testGroupSortByASC`：测试升序sort
- `testGroupSortByDEC`：测试降序sort
- `testGroupGenderDivide`：测试性别划分

## 结果

### CalabashTest

![QQ截图20201116205947](https://i.loli.net/2020/11/16/2sxlKfvVY3kgcJZ.png)

### GroupTest

![QQ截图20201116205117](https://i.loli.net/2020/11/16/JLVmx9h5I4oNFRn.png)

