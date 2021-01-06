# java20 作业说明

本文为从`A-Build`作业开始所有`README.md`的集合。

## A-BUILD

引用第三方类

- `lombok.Getter`
- `lombok.Setter`
- `org.apache.commons.lang3.tuple.Pair`
- `org.apache.commons.lang3.tuple.Triple`

### lombok

`lombok.Getter`和`lombok.Setter`是手动编写`getxxx`和`setxxx`的绝佳替代方案，懒人必备。

### apache

`org.apache.commons.lang3.tuple.Pair`用于完善`GrandPa`中`classify`的实现方式。

通过将自己持有的`children`分为两个队列，一个是所有`boy`，一个是所有`girl`，然后用`Pair`打包返回。

`org.apache.commons.lang3.tuple.Triple`的作用与`org.apache.commons.lang3.tuple.Pair`类似。

它用于实现`classify`的一个增强版本，传入比较标准`CompareFlag`和边界`edge`，将队列分为三组，小于的，等于的和大于边界的。用`Triple`打包返回。

内部比较用字典序，可以满足字符串比较和数值比较。

### 测试

编写了`nameClassify()`，用于测试`classify()`的正确性。

初始队列为`"nju", "jun", "nuj", "jnu", "ujn"`，以`"nju"`为边界，分为三组，分别为`"jnu jun"`，`"nju"`，`"nuj ujn"`。

### 自动构建

使用`maven`自动构建，通过`pom.xml`导入即可。
